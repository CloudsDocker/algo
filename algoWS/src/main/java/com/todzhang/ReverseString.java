import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseString {
	// To reverse a array
	// vanila approach

	public static void main(String[] args) {

		String input = "abcd";
		System.out.println("output of 1:" + reverse(input));
		System.out.println("output of 2:" + reverse2(input));
		System.out.println("output of 3:" + reverse3(input));
		System.out.println("output of 4:" + reverse4(input));
		System.out.println("output of 5:" + reverse5(input));
		System.out.println("output of 6:" + reverse6(input));
		System.out.println("output of 7:" + reverse7(input));
		System.out.println("output of 8:" + reverse8(input));
		System.out.println("output of 9:" + reverse9(input));
	}

	public static String reverse(String input) {
		char[] ary = input.toCharArray();
		int len = ary.length - 1;
		for (int i = 0; i <= (len / 2); i++) {
			char tmp = ary[i];
			ary[i]=ary[len-i];
			ary[len - i] = tmp;
		}
		return new String(ary);
	}

	public static String reverse2(String input) {
		StringBuffer a = new StringBuffer(input);
		return a.reverse().toString();
	}

	public static String reverse3(String input) {
		char[] ary = input.toCharArray();
		int left = 0;
		int right = ary.length - 1;
		char temp;
		while (right > left) {
			temp = ary[left];
			ary[left] = ary[right];
			ary[right] = temp;
			right--;
			left++;
		}
		return new String(ary);
	}

	public static String reverse4(String input) {
		int len = input.length();
		StringBuffer dest = new StringBuffer(len); // if concurrency is not a
													// concern, replace it with
													// StringBuilder after Java
													// 5, as StringBuilder is
													// fatster
		for (int i = (len - 1); i >= 0; i--) {
			dest.append(input.charAt(i));
		}
		return dest.toString();
	}

	// using reverse approach
	public static String reverse5(String input) {
		return reverse0(input, input.length() - 1);
	}

	static String reverse0(String input, int index) {
		if (index == 0) {
			return input.charAt(0) + "";
		}

		char tmp = input.charAt(index);
		return tmp + reverse0(input, index - 1);
	}

	// use stack approach
	public static String reverse6(String input) {
		Stack<Character> queue = new Stack<Character>();
		for (int i = 0; i <= input.length() - 1; i++) {
			queue.push(input.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.pop());
		}
		return sb.toString();
	}

	// using XOR approach, based on
	// (A XOR B) XOR B=A
	// (A XOR B) XOR A=B

public static String reverse7(String input){
	int low=0;
	int high=input.length()-1;
	char[] ary=input.toCharArray();
	
	while(low<high) {
		
		ary[low]=(char)(ary[low]^ary[high]);
		ary[high]=(char)(ary[low]^ary[high]);
		ary[low]=(char)(ary[low]^ary[high]);
		low++;
		high--;
	}
	
	return new String(ary);
}

	// use StringTokenizer approach
	public static String reverse8(String input) {
		StringTokenizer st = new StringTokenizer(input);
		Stack<String> stack = new Stack<>();
		while (st.hasMoreTokens()) {
			stack.push(st.nextToken());
		}

		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	// the last one is logic implemented in AbstractStringBuilder
	public static String reverse9(String input) {
		int n = input.length() - 1;
		char[] value = input.toCharArray();
		for (int i = (n - 1) >> 1; i >= 0; --i) {
			char tmp = value[i];
			char tmp2 = value[n - i];
			value[i] = tmp2;
			value[n - i] = tmp;
		}
		return new String(value);
	}
}
