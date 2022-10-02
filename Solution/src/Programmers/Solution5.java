package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5 {
	class Cell {
		String value;
		MergedCell mergedCell;

		void merge(Cell other) {
			if(mergedCell != null) {
				mergedCell.merge(other);
				return;
			}

			if(this.getValue() == null) {
				mergedCell = new MergedCell(other.getValue(), this, other);
				return;
			}
			mergedCell = new MergedCell(this.getValue(), this, other);
		}

		void unmerge() {
			if(mergedCell == null) {
				return;
			}

			String temp = mergedCell.value;

			for(Cell cell : mergedCell.set) {
				cell.mergedCell = null;
			}

			this.value = temp;
		}

		String getValue() {
			if(mergedCell != null) {
				return mergedCell.value;
			}

			return value;
		}

		void update(String value) {
			if(mergedCell != null) {
				mergedCell.value = value;
				return;
			}

			this.value = value;
		}
	}

	class MergedCell{
		String value;
		Set<Cell> set;

		MergedCell(String value, Cell c1, Cell c2) {
			this.value = value;
			set = new HashSet<>();
			addCell(c1);
			addCell(c2);
		}

		void addCell(Cell cell) {
			set.add(cell);
			cell.mergedCell = this;
			cell.value = null;
		}

		void merge(Cell other) {
			if(value == null) {
				value = other.getValue();
			}

			if(other.mergedCell != null) {
				for(Cell c : other.mergedCell.set) {
					addCell(c);
				}
				return;
			}

			addCell(other);
		}
	}

	public String[] solution(String[] commands) {
		List<String> answer = new ArrayList<>();

		Cell[][] cells = new Cell[51][51];

		for (int i = 1; i <= 50; i++) {
			for (int j = 1; j <= 50; j++) {
				cells[i][j] = new Cell();
			}
		}


		for(String command : commands) {
			String[] s = command.split(" ");

			switch(s[0]) {
				case "UPDATE" : {
					if(s.length == 4) {
						int r = Integer.parseInt(s[1]);
						int c = Integer.parseInt(s[2]);

						cells[r][c].update(s[3]);
						break;
					}

					for (int i = 1; i <= 50; i++) {
						for (int j = 1; j <= 50; j++) {
							if(cells[i][j].getValue() != null && cells[i][j].getValue().equals(s[1])) {
								cells[i][j].update(s[2]);
							}
						}
					}
					break;
				}
				case "MERGE" : {
					int r1 = Integer.parseInt(s[1]);
					int c1 = Integer.parseInt(s[2]);

					int r2 = Integer.parseInt(s[3]);
					int c2 = Integer.parseInt(s[4]);

					cells[r1][c1].merge(cells[r2][c2]);
					break;
				}
				case "UNMERGE" : {
					int r = Integer.parseInt(s[1]);
					int c = Integer.parseInt(s[2]);

					cells[r][c].unmerge();
					break;
				}
				case "PRINT":
					int r = Integer.parseInt(s[1]);
					int c = Integer.parseInt(s[2]);

					String value = cells[r][c].getValue();

					if(value == null) {
						answer.add("EMPTY");
						break;
					}
					answer.add(value);
					break;
			}

		}

		return answer.toArray(new String[answer.size()]);
	}

	public static void main(String[] args) {
		// String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2",
		// 	"MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
		String[] commands = {"UPDATE 1 1 a", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 2 2"};

		Solution5 s = new Solution5();
		int[] a = {5,10,10};

		// int max = new ArrayList<Integer>().stream().mapToInt(Integer::intValue).toArray();

		System.out.println(Arrays.toString(s.solution(commands)));
	}
}
