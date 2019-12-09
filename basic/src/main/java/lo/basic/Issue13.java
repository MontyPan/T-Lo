package lo.basic;

import java.util.Arrays;

public class Issue13 {
	public static void main(String[] args) {
		int[] data = { 5, 5, 6, 6, 78, 78, 78, 9487, 9487, 9487, 9487, 65535 };
		int[] result = longest(data);
		int[] result_v4 = longest_v4(data);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result_v4));

	}

	/**
	 * @param data 已經排序過的 array
	 * @return result[0] 是最長平台的數字，result[1] 是長度
	 */

	private static int[] longest(int[] data) {
		int counter = 1;
		int max_counter = 0;
		int number = data[0];
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == data[i + 1]) {
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

	private static int[] longest_v4(int[] data) {
		int i = 0;
		int number = 0;
		int max_counter = 0;
		for (int ii = 1; ii < data.length; ii++) {
			if (ii - i + 1 > max_counter) {
				max_counter = ii - i;
				number = data[i];
				if (data[i] == data[data.length - 1]) {
					max_counter += 1;
					number = data[ii];
				}
			}
			if (data[i] != data[ii]) {
				i = ii;
			}
		}
		return new int[] { number, max_counter };
	}
}