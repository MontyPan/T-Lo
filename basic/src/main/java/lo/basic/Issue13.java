package lo.basic;

import java.util.Arrays;

public class Issue13 {
	public static void main(String[] args) {
		int[] data = { 5, 5, 6, 6, 78, 78, 78, 9487, 9487, 9487, 9487, 65535 };
		int[] result = longest(data);
		System.out.println(Arrays.toString(result));
	}

	private static int[] longest(int[] data) {
		int counter = 1;
		int max_counter = 0;
		int number = data[0];
		for (int i = 0, ii = 1; ii < data.length; i++, ii++) {
			if (data[i] == data[ii]) {
				counter += 1;
				if (counter > max_counter) {
					max_counter = counter;
					number = data[i];
				}
			} else {
				counter = 1;
			}
		}
		return new int[] { number, max_counter };
	}
}