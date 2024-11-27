/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "tomrr";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		for (int i = 0; i < str1.length(); i++) {if (str1.charAt(i) == 32) {str1 = str1.replace(Character.toString(str1.charAt(i)), "");i--;}}
		for (int i = 0; i < str2.length(); i++) {if (str2.charAt(i) == 32) {str2 = str2.replace(Character.toString(str2.charAt(i)), "");i--;}}
		if (str1.length() != str2.length()) {return false;}
		int count = str1.length();
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {count--; break;}
			}
		}
		return count == 0;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (((str.charAt(i) < 'a') || (str.charAt(i) > 'z')) && (str.charAt(i) != 32)) {
				str = str.replace(Character.toString(str.charAt(i)), "");
				i--;
			}
		}
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";
		int random;
		String result = "";
		while (str.length()>0) {
			random = (int)((str.length()) * Math.random());
			newStr += Character.toString(str.charAt(random));
			for (int i = 0; i < str.length(); i++) {if (i != random) {result += str.charAt(i);}}
			str = result;
			result = "";
		}
		return newStr;
	}
}

