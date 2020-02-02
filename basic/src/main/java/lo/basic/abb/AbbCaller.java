package lo.basic.abb;

public class AbbCaller {


	public static void main(String[] args) {
		
		Abb test = new Abb();
		
		double num1 = 234632346;
		double num2 = 23123123145343636346454555555555555555555555555555555555555555555555555552312312.1241454352342342235355658769876543567654565434563d;
		double num3 = 0.23562d;
		double num4 = 1000;
		double num5 = -1000;
		double num6 = -999.99d;
		double num7 = -13463654747655686585.353455464765878556534114325436544767d;
		
		System.out.println(test.main(num1));
		System.out.println(test.main(num2));
		System.out.println(test.main(num3));
		System.out.println(test.main(num4));
		System.out.println(test.main(num5));
		System.out.println(test.main(num6));
		System.out.println(test.main(num7));
	}
}
