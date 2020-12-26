package SSAFY.Array1;

import java.util.Arrays;

public class Array1Test {

	public static void main(String[] args) {
		//1.선언
		int[] a;
		//2.생성
		a=new int[3];
		//1+2
		int[] b = new int[3];
		//3.초기화
		b[0]=10;
		b[1]=11;
		b[2]=12;
		//1+2+3
		int[] c = {10,11,12};
		int[] d = new int[]{10,11,12};
		int[] e;
		e = new int[]{10,11,12};
		//4.출력
		for(int i=0;i<d.length;i++) System.out.print(d[i] + " ");
		System.out.println();
		for(int v:e) System.out.print(v+ " ");
		System.out.println();
		System.out.println(Arrays.toString(e)+ " ");
		//5.복제
		int[] f = new int[e.length];
		//System.arraycopy(e,0,f,0,e.length); //e의 0번째를 f의 0번에 e.length만큼 채워넣는다.
		f=Arrays.copyOf(e, e.length); //위에꺼랑 같은애
		e[0]=0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));
		f=e.clone(); //클론을 하면 엮여서 e가 바뀌면 같이 바뀌니까 조심!
		e[0]=0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));
	}

}
