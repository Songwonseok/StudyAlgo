package BlockChain;

import java.util.ArrayList;

public class GetMining {

	public static void main(String[] args) {
		
		ArrayList<Block> BlockChain = new ArrayList<>();
		
		BlockChain.add(new Block());
		
		BlockChain.get(0).setData("Genesis Blcok");
		BlockChain.get(0).setPrevHash("");
		BlockChain.get(0).setHash(BlockChain.get(0).makeHash());
		
		
		
		BlockChain.add(new Block("2nd",BlockChain.get(0).getHash()));
		BlockChain.add(new Block("3rd",BlockChain.get(1).getHash()));
		
		for(Block b : BlockChain) {
			System.out.println("Nonce : "+ b.getNonce());
			System.out.println("Data : "+ b.getData());
			System.out.println("prevHash : "+ b.getPrevHash());
			System.out.println("Hash : "+ b.getHash());
			System.out.println();
		}
	}

}
