package array1;
import java.math.BigInteger;

public class Hello {
	public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1,r-1);
	}
	public static void main(String[] args) {
	
		System.out.println(nCr(5,3));
	}

}
