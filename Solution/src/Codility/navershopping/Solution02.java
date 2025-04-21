package Codility.navershopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
	1. 3개 사면 가장싼게 무료 - 주문당 1번만 가능
	2. 5개 구매시 100원! - 주문당 1번
	3. L피자 한 판을 주문하면 S피자 한 판 무료 - 여러번 사용 가능
	4. L 3개 구매하면 M 3개 가격 - 주문당 1번
 */
public class Solution02 {
	private static final String SIZE_L = "Large";
	private static final String SIZE_M = "Medium";
	private static final String SIZE_S = "Small";

	public static void main(String[] args) {
		Solution02 s = new Solution02();

		Pizza[] menu = {
			new Pizza("margherita", 90, 80, 100), new Pizza("hawaii", 80, 90, 120),
			new Pizza("capricciosa", 50, 70, 130), new Pizza("greek", 50, 70, 130)
		};

		OrderItem[] order = {
			new OrderItem("greek", "Small", 5), new OrderItem("margherita", "Small", 4),
			new OrderItem("hawaii", "Large", 1), new OrderItem("margherita", "Medium", 2),
			new OrderItem("capricciosa", "Small", 7)
		};

		s.solution(menu, order);
	}

	public int solution(Pizza[] menu, OrderItem[] order) {
		Map<String, Pizza> menuMap = Arrays.stream(menu)
			.collect(Collectors.toMap(pizza -> pizza.name, pizza -> pizza));

		int totalQuantity = getTotalQuantity(order);
		int price = 0;

		for(OrderItem item : order) {
			price += getPizzaPrice(menuMap, item) * item.quantity;
		}

		if (totalQuantity >= 3) {
			price = Math.min(price, calculateDiscount1(menuMap, order));
			price = Math.min(price, calculateDiscount4(menuMap, order));
		}

		if (totalQuantity >= 5) {
			price = Math.min(price, calculateDiscount2(menuMap, order));
		}

		if (order.length >= 2) {
			price = Math.min(price, calculateDiscount3(menuMap, order));
		}

		return price;
	}

	private int getTotalQuantity(OrderItem[] order) {
		int total = 0;

		for(int i = 0; i < order.length; i++) {
			total += order[i].quantity;
		}

		return total;
	}

	private int getPizzaPrice(Map<String, Pizza> menuMap, OrderItem orderItem) {
		Pizza pizza = menuMap.get(orderItem.name);

		switch (orderItem.size) {
			case SIZE_L:
				return pizza.price_L;
			case SIZE_M:
				return pizza.price_M;
			default:
				return pizza.price_S;
		}
	}

	private int calculateDiscount1(Map<String, Pizza> menuMap, OrderItem[] order) {
		List<Integer> priceList = new ArrayList<>();

		for (OrderItem item : order) {
			int pricePerItem = getPizzaPrice(menuMap, item);

			for (int i = 0; i < item.quantity; i++) {
				priceList.add(pricePerItem);
			}
		}

		// 가격 비싼 순으로 정렬
		priceList.sort(Comparator.reverseOrder());

		int total = priceList.stream().mapToInt(Integer::intValue).sum();
		total -= priceList.get(2);

		return total;
	}

	private int calculateDiscount2(Map<String, Pizza> menuMap, OrderItem[] order) {
		Map<String, List<Integer>> pizzaMap = new HashMap<>();


		for (OrderItem item : order) {
			List<Integer> priceList = pizzaMap.getOrDefault(item.name, new ArrayList<>());

			int pricePerItem = getPizzaPrice(menuMap, item);
			for (int i = 0; i < item.quantity; i++) {
				priceList.add(pricePerItem);
			}

			pizzaMap.put(item.name, priceList);
		}

		// 가장 비싼 5개는 100달러로 구매
		int total = 0;
		int maxDiscountPrice = 0;

		for(String name: pizzaMap.keySet()) {
			List<Integer> priceList = pizzaMap.get(name);

			total += priceList.stream().mapToInt(Integer::intValue).sum();

			if(priceList.size() >= 5) {
				priceList.sort(Comparator.reverseOrder());
				int discountPrice = 0;

				for(int i = 0; i < 5; i++) {
					discountPrice += priceList.get(i);
				}

				maxDiscountPrice = Math.max(maxDiscountPrice, discountPrice - 100);
			}

		}

		total -= maxDiscountPrice;

		return total;
	}
	private int calculateDiscount3(Map<String, Pizza> menuMap, OrderItem[] order) {
		// 라지 수량 -> 스몰 무료쿠폰
		Map<String, Integer> freeCouponMap = Arrays.stream(order)
			.filter(item -> SIZE_L.equals(item.size))
			.collect(Collectors.toMap(pizza -> pizza.name, pizza -> pizza.quantity));

		int total = 0;

		for(OrderItem item : order) {
			int quantity = item.quantity;

			if(SIZE_S.equals(item.size) && freeCouponMap.containsKey(item.name)) {
				quantity -= freeCouponMap.get(item.name);

				// 음수 대응
				quantity = Math.max(0, quantity);
			}

			total += getPizzaPrice(menuMap, item) * quantity;

		}

		return total;
	}
	private int calculateDiscount4(Map<String, Pizza> menuMap, OrderItem[] order) {
		int total = 0;

		for (OrderItem item : order) {
			total += getPizzaPrice(menuMap, item) * item.quantity;
		}

		List<OrderItem> largeOrder = Arrays.stream(order)
			.filter(item -> SIZE_L.equals(item.size))
			.collect(Collectors.toList());

		// 라지 사이즈가 3개 미만인 경우
		if(largeOrder.size() < 3) {
			return total;
		}

		List<Integer> discountPriceList = new ArrayList<>();

		for (OrderItem item : largeOrder) {
			int pricePerItem = getPizzaPrice(menuMap, item);
			int discountPrice = pricePerItem - menuMap.get(item.name).price_M;

			for (int i = 0; i < item.quantity; i++) {
				discountPriceList.add(discountPrice);
			}
		}

		// 미디움 사이즈와 가격차이가 가장 큰 3개
		discountPriceList.sort(Comparator.reverseOrder());

		for(int i = 0; i < 3; i++) {
			total -= discountPriceList.get(i);
		}

		return total;
	}


	public static class Pizza {
		public String name;
		public int price_S;
		public int price_M;
		public int price_L;

		public Pizza(String name, int price_S, int price_M, int price_L) {
			this.name = name;
			this.price_S = price_S;
			this.price_M = price_M;
			this.price_L = price_L;
		}
	}

	public static class OrderItem {
		public String name;
		public String size;
		public int quantity;

		public OrderItem(String name, String size, int quantity) {
			this.name = name;
			this.size = size;
			this.quantity = quantity;
		}
	}
}
