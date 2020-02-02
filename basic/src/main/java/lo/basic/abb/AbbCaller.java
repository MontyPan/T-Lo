package lo.basic.abb;

public class AbbCaller {


	public static void main(String[] args) {
		
		Abb test = new Abb();
		
		double num1 = 234632346;
		double num2 = 1312312312312312.1241454353d;
		double num3 = 0.23562d;
		double num4 = 1000;
		double num5 = -1000;
		double num6 = -999.99d;
		
		System.out.println(test.main(num1));
		System.out.println(test.main(num2));
		System.out.println(test.main(num3));
		System.out.println(test.main(num4));
		System.out.println(test.main(num5));
		System.out.println(test.main(num6));
	}
}
