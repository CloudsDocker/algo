import java.util.HashSet;
import java.util.Set;

//Even simpler with Java 8 (in my opinion):

public class removeDup {

	public static String removeDuplicatesJ8(String word) {
		if (word == null || word.length() < 2) {
			return word;
		}
		StringBuilder sb = new StringBuilder(word.length());
		word.chars().distinct().mapToObj(ch -> (char) ch).forEach((ch) -> sb.append(ch));
		return sb.toString();
	}

	public static String removeDuplicates(String word) {
		if (word == null || word.length() <= 1) {
			return word;
		}

		Set<Character> unduplicate = new HashSet<>(word.length());
		for (int i = 0; i < word.length(); i++) {
			unduplicate.add(word.charAt(i));
		}
		StringBuilder ret = new StringBuilder(unduplicate.size());
		for (Character c : unduplicate) {
			ret.append(c);
		}
		return ret.toString();
	}

	// =====================
//Ashish Agarwal said...
//In removeDuplicates method,
//	pos variable
//	is not required

	public static String removeDuplicates2(String word) {
		if (word == null || word.length() < 2) {
			return word;
		}
		char[] characters = word.toCharArray();
		for (int i = 1; i < word.length(); i++) {
			int j;
			for (j = 0; j < i; ++j) {
				if (characters[i] == characters[j]) {
					break;
				}
			}
			if (j != i) {
				characters[i] = 0;
			}
		}
		return new String(characters);
	}

	// ===============

	/**
	 * Java Program to remove duplicate characters from String.
	 *
	 * @author Javin Paul
	 */
//	public class RemoveDuplicateCharacters {

		public static void main(String args[]) {

			System.out.println("Call removeDuplicates(String word) method ....");
			String[] testdata = { "aabscs", "abcd", "aaaa", null, "", "aaabbb", "abababa" };

			for (String input : testdata) {
				System.out.printf("Input : %s  Output: %s %n", input, removeDuplicates(input));
			}

			System.out.println("Calling removeDuplicatesFromString(String str).");
			for (String input : testdata) {
				System.out.printf("Input : %s  Output: %s %n", input, removeDuplicatesFromString(input));
			}
		}

		/*
		 * This algorithm goes through each character of String to check if its
		 * a duplicate of already found character. It skip the duplicate
		 * character by inserting 0, which is later used to filter those
		 * characters and update the non-duplicate character. Time Complexity of
		 * this solution is O(n^2), excluded to UniqueString() method, which
		 * creates String from character array. This method will work even if
		 * String contains more than one duplicate character.
		 */
		public static String removeDuplicates3(String word) {
			if (word == null || word.length() < 2) {
				return word;
			}

			int pos = 1; // possible position of duplicate character
			char[] characters = word.toCharArray();

			for (int i = 1; i < word.length(); i++) {
				int j;
				for (j = 0; j < pos; ++j) {
					if (characters[i] == characters[j]) {
						break;
					}
				}
				if (j == pos) {
					characters[pos] = characters[i];
					++pos;
				} else {
					characters[pos] = 0;
					++pos;
				}
			}

			return toUniqueString(characters);
		}

		/*
		 * This solution assumes that given input String only contains ASCII
		 * characters. You should ask this question to your Interviewer, if he
		 * says ASCII then this solution is Ok. This Algorithm uses additional
		 * memory of constant size.
		 */
	public static String removeDuplicatesFromString(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        boolean[] ASCII = new boolean[256];
        char[] characters = input.toCharArray();
        ASCII[input.charAt(0)] = true;

        int dupIndex = 1;
        for (int i = 1; i<input.length(); i++) {
            if (!ASCII[input.charAt(i)]) {
                characters[dupIndex] = characters[i];
                ++dupIndex;
                ASCII[characters[i]] = true;

            } else {
                characters[dupIndex] = 0;
                ++dupIndex;
            }
        }

        return toUniqueString(characters);
    }

		/*
		 * Utility method to convert Character array to String, omitting NUL
		 * character, ASCII value 0.
		 */
		public static String toUniqueString(char[] letters) {
			StringBuilder sb = new StringBuilder(letters.length);
			for (char c : letters) {
				if (c != 0) {
					sb.append(c);
				}
			}
			return sb.toString();
		}
	}

	/*
	 * Output Call removeDuplicates(String word) method .... Input : aabscs
	 * Output: absc Input : abcd Output: abcd Input : aaaa Output: a Input :
	 * null Output: null Input : Output: Input : aaabbb Output: ab Input :
	 * abababa Output: ab
	 * 
	 * Calling removeDuplicatesFromString(String str) method .... Input : aabscs
	 * Output: absc Input : abcd Output: abcd Input : aaaa Output: a Input :
	 * null Output: null Input : Output: Input : aaabbb Output: ab Input :
	 * abababa Output: ab
	 */
//}
