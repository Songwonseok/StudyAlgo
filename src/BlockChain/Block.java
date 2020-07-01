package BlockChain;

public class Block {
	
	private String hash;
	private String data;
	private String prevHash;
	private long nonce;
	private int targetDepth =5;
	private String target = "00000";
	
	public Block() {}
	
	public Block(String data, String prevHash) {
		this.data = data;
		this.prevHash = prevHash;
		
		mineNewBlock();
	}
	private void mineNewBlock() {
		
		while(hash==null || !makeHash().substring(0,targetDepth).equals(target)) {
			nonce++;
			hash = makeHash();
		}
	}
	
	
	public String makeHash() {
		
		return SHA256.getSha256(prevHash+data+Long.toString(nonce));
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}
	
	public long getNonce() {
		return nonce;
	}
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}

}
