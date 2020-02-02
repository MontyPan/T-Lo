package lo.basic.abb;

public class AbbCaller {


	public static void main(String[] args) {
		
		Abb test = new Abb();
		double[] testArray = new double[9];
		double y = 1000000000000000000000000d;
		
		testArray[0] = Integer.MAX_VALUE * y;
		testArray[1] = Integer.MIN_VALUE * y * 10;
		testArray[2] = 888888888888888888888888888888888888888888888888888888888888888888888888888888d;
		testArray[3] = testArray[0] + y;
		testArray[4] = testArray[0] - y;
		testArray[5] = 999;
		testArray[6] = 999.9d;
		testArray[7] = 999.99999999999999999999999999d;
		testArray[8] = Double.MAX_VALUE;
		
		
		for (int i = 0; i < testArray.length; i++) {
			System.out.println("Num" + i + ": " + test.abb(testArray[i]));
		}
	}
}
