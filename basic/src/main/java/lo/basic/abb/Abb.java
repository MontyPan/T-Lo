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

	public static void main(String[] args) {
		
		Abb test = new Abb();
		
		double num1 = 234632346;
		double num2 = 1312312312312312.1241454353d;
		double num3 = 0.23562d;
	}
	
	/**
	 * 呼叫其他 method
	 * @param double
	 * @return String
	 */
	public void main() {
		
	}
	
	/**
	 * 除以 1000，傳回 count 次數
	 */
	public void divideBy() {
		
	}
	/**
	 * 去除小數點後面的數字
	 */
	public void remove() {
			
	}
	/**
	 * 數值轉成 String
	 */
	public void transfer() {
		
	}
	/**
	 * 依據 count 加上 prefix
	 */
	public void whichPrefix() {
		
	}
	/**
	 * 檢查那些數值不能縮寫
	 * <ol>
	 * 	<li>
	 * 
	 */
	public void checkout() {
		
	}
	/**
	 * String 轉 double
	 */
	public void toDouble() {
		
	}
}
