package lo.basic.abb;

/**
 * 支援的 prefix 為 k、M、G、T、P、E、Z、Y ，分別代表
 * 10^3、10^6、10^9、10^12、10^15、10^18、10^21、10^24。
 * 若無法縮寫則傳回 String 原數值，依照使用的 method
 * 作四捨五入 / 無條件捨去。 
 * {@link #abridgeRouund(double)} 四捨五入後傳回 String
 * 
 */
public class Abbreviation {
	final int k = 1000;
	final String[] METRIC_PREFIX = { "k", "M", "G", "T", "P", "E", "Z", "Y" };
	private int index;
	private String prefix;

	/**
	 * 無條件捨去，傳回縮寫字串，若無法縮寫則無條件捨去後傳回數值字串。
	 * 
	 * @param num
	 * @return String
	 */
	public String abridgeChop(double num) {
		index = -1;
		num = chop(abb(num));
		String result = doubleToString(num);
		if (index == -1) {
			return result;
		} else {
			return result + prefix;
		}

	}

	/**
	 * 四捨五入，傳回縮寫字串，若無法縮寫則四捨五入後傳回數值字串。
	 * 
	 * @param num
	 * @return String
	 */
	public String abridgeRound(double num) {
		index = -1;
		num = Math.rint(abb(num));
		String result = doubleToString(num);
		if (index == -1) {
			return result;
		} else {
			return result + prefix;
		}
	}

	/**
	 * 將 double 值，轉成 String 如果 num 是在 long 的範圍內，以強制轉型來消除 ".0" 反之則直接以 double 轉
	 * String（因為小數點後數字不會顯示）
	 * 
	 * @param num
	 * @return String
	 */
	private String doubleToString(double num) {
		if (Math.abs(num) >= Long.MAX_VALUE) {
			return String.valueOf(num);
		} else {
			return String.valueOf((long) num);
		}

	}

	/**
	 * 正負數的無條件捨去
	 * 
	 * @param num
	 * @return double
	 */
	private double chop(double num) {
		if (num >= 0) {
			num = Math.floor(num);
		} else {
			num = Math.ceil(num);
		}
		return num;
	}

	/**
	 * 縮寫的步驟，確認能不能除以 k 、除完之後再次檢查
	 * 
	 * @param num
	 * @return double
	 */
	private double abb(double num) {

		if (check(num)) {
			while (this.index < METRIC_PREFIX.length - 1 && check(num)) {
				num = num / k;
				index++;
			}
			if (this.index != -1) {
				this.prefix = METRIC_PREFIX[this.index];
				;
			}
		}
		return num;
	}

	/**
	 * 檢查傳入數值能不能縮寫，-1000 < num < 1000 不能縮寫
	 * 
	 * @param num
	 * @return boolean
	 */
	private boolean check(double num) {
		if (Math.abs(num) > k) {
			return true;
		} else {
			return false;
		}
	}
}
