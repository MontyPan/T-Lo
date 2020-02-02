package lo.basic.abb;


public class Abb {
	int k = 1000;
	String[] prefix = { "k", "M", "G", "T", "P", "E", "Z", "Y" };

	/**
	 * 傳入 double 的值，回傳以國際單位制詞頭 (Metric prefix) 簡化表示的 String。 <br>
	 * 支援的 prefix 為 k、M、G、T、P、E、Z、Y <br>
	 * 分別代表 10^3、10^6、10^9、10^12、10^15、10^18、10^21、10^24 <br>
	 * 
	 * 若已經以 Y 作為 prefix、且顯示的數字超過 long.MAX_VALUE，則數字已 double 顯示。
	 *  
	 * @see <a href="https://en.wikipedia.org/wiki/Metric_prefix">國際單位制詞頭 Metric prefix</a>
	 */
	public String abb(double num) {

		if (checkout(num)) {
			int index = -1;
			while (index < prefix.length - 1 && checkout(num)) {
				num = num / k;
				index++;
			}
			if (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
				return prefix(String.valueOf(num), index);
			} else {
				int intNum = (int)num; //去除小數點
				return prefix(String.valueOf(intNum), index);
			}
		} else {
			return String.valueOf(num);
		}
	}
	
	/**
	 * 除以 1000
	 * @param int
	 * @return int
	 */
	private int divideBy(int num) {
		while (checkout(num)) {
			num = num / k;
		}
		return num;
	}
	
	/**
	 * 去除小數點後面的數字
	 * @param double
	 * @return int 
	 */
	private int doubleToInt(double num) {
		int result = (int)num;
		return result;
	}

	/**
	 * 依據 count 加上 prefix
	 * @param String, int
	 * @return String
	 */
	private String prefix(String numString, int count) {
		return numString + prefix[count];
	}
	
	/**
	 * 檢查傳入數值能不能縮寫，（count= -1 超出 array 範圍）
	 * -1000 < num < 1000 不能縮寫
	 */
	private boolean checkout(double num) {
		if (num <= -k || num >= k) {
			return true;
		} else {
			return false; 
		}
	}
}
