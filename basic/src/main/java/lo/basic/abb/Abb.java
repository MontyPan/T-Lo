package lo.basic.abb;


/**
 * 給定一個以下  primitive type 的值，回傳以國際單位制詞頭 (Metric prefix) 簡化表示的 String。 <br>
 * 支援的 Prefix 為 k、M、G、T、P、E、Z、Y <br>
 * 分別代表 10^3、10^6、10^9、10^12、10^15、10^18、10^21、10^24 <br>
 * @see <a href="https://en.wikipedia.org/wiki/Metric_prefix">國際單位制詞頭 Metric prefix</a>
 */

public class Abb {
	int k = 1000;
	String[] prefix = { "k", "M", "G", "T", "P", "E", "Z", "Y" };

	
	/**
	 * @param double
	 * @return String
	 */
	public String main(double num) {
//		String numString = String.valueOf(doubleToInt(num));
		
		if (checkout(num)) {
			int count = -1;
			int intNum = doubleToInt(num);
			while (checkout(intNum)) {
				intNum = intNum / k;
				count++;
			}
			return prefix(String.valueOf(intNum), count);
		} else {
			return String.valueOf(num);
		}
	}
	
	/**
	 * 除以 1000，傳回 num 商
	 */
	public int divideBy(int num) {
		while (checkout(num)) {
			num = num / k;
		}
		return num;
	}
	
	/**
	 * 去除小數點後面的數字
	 */
	public int doubleToInt(double num) {
		int result = (int)num;
		return result;
	}

	/**
	 * 依據 count 加上 prefix
	 */
	public String prefix(String numString, int count) {
		return numString + prefix[count];
	}
	
	/**
	 * 檢查那些數值不能縮寫
	 * <ul>
	 * 	<li> -1000 < num < 1000，count 沒有 ++，count= -1 超出 array 範圍<li>
	 * <ul> 
	 */
	public boolean checkout(double num) {
		if (num <= -k || num >= k) {
			return true;
		} else {
			return false; 
		}
	}
}
