package lo.basic.abb;

public class AbbCaller {


	public static void main(String[] args) {
		
		Abbreviation test = new Abbreviation();
		double[] testArray = new double[10];
		double y = 1000000000000000000000000D;
		
		System.out.println(y);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MAX_VALUE * y);
		System.out.println(Long.MAX_VALUE * y + 1);
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MAX_VALUE - 1);
		System.out.println( 1 - Double.MAX_VALUE );
		
		
		testArray[0] = Long.MAX_VALUE;
		testArray[1] = Long.MAX_VALUE * y / test.k;
		testArray[2] = Long.MAX_VALUE * y;
		testArray[3] = Long.MAX_VALUE  + 1;
		testArray[4] = Integer.MAX_VALUE;
		testArray[5] = 999;
		testArray[6] = 9999999999999.999 * y;
		testArray[7] = Double.MIN_VALUE;
		testArray[8] = Double.MAX_VALUE;
		testArray[9] = -Double.MAX_VALUE;
		
		for (int i = 0; i < testArray.length; i++) {
			System.out.println("Num" + i + " : 原數值 = " + testArray[i] + " 輸出 = " + test.abridgeChop(testArray[i]));
		}
		
		for (int i = 0; i < testArray.length; i++) {
			System.out.println("Num" + i + " : 原數值 = " + testArray[i] + " 輸出 = " + test.abridgeRound(testArray[i]));
		}
	}
}
