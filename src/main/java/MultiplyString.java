import java.util.Arrays;

// MultiplyString.java
class MultiplyString {
	public static void main(String... args) {
		System.out.println("===MultiplyString====");
//		String num1 = "15";
//		String num2 = "20";
//		System.out.println(multiply(num1, num2));
	}

	// assume each numbers in String is between 0-9
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1+len2];	// [!] len1 + len2 would be fine, no need "+1"

		for(int c1 = len1-1;c1>=0;c1--){
			for(int c2 = len2-1;c2>=0;c2--) {
				// result[i+j+1] += num1[c1] * num2[c2]; // multiply each digits, from right to left
				int tempMulti = (num1.charAt(c1) - '0') * (num2.charAt(c2) - '0') ; // [!] (1) use charAt to get char (2) can't multiply them directly, use "-'0'"
				int posIdx1 = c1 + c2;
				int posIdx2 = posIdx1 + 1;
				int sum = tempMulti + result[posIdx2];
				int carry = sum / 10;
				int reminder = sum % 10;
				result[posIdx1] += carry;
				result[posIdx2] = reminder;
			}
		}

		StringBuffer sb = new StringBuffer();
		for(int number:result) {
			if(sb.length()==0 && number==0) {
				continue;
			}
			sb.append(number);
		}

		return sb.toString();
	}
}