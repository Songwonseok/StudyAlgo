package SSAFY.Array2;

public class SubSet1 {
	public static int[] a = {1,2,3,4};
	public static int[] b = new int[4]; //비트배열
	
	public static void main(String[] args) {
		for(int i=0;i<2;i++) {
			b[0] = (i%2==0)? 0:1;
			for(int j=0;j<2;j++) {
				b[1] = (j%2==0)? 0:1;
				for(int k=0;k<2;k++) {
					b[2] = (k%2==0)? 0:1;
					for(int l=0;l<2;l++) {
						b[3] = (l%2==0)? 0:1;
						System.out.print("{");
						System.out.print((b[0]==1) ? a[0] + "," : "");
						System.out.print((b[1]==1) ? a[1] + "," : "");
						System.out.print((b[2]==1) ? a[2] + "," : "");
						System.out.print((b[3]==1) ? a[3] + "," : "");
						System.out.println("}");
					}
				}
			}
		}

	}

}
