package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
       int l1 = s1.length();
       int l2 = s2.length();
       if (l1>l2) {
    	   return s1;
       } else {
    	   return s2;
       }
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String news = s;
    	if (s.contains("underscores")) {
    		for(int i = 0; i < s.length(); i++) {
    		news = s.replace(" ","_");
    	}
    	}

    	return news;
	}

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    		String newS1 = s1.trim();
    		String newS2 = s2.trim();
    		String newS3 = s3.trim();
    		Character c1 = newS1.charAt(newS1.length()-1);
    		Character c2 = newS2.charAt(newS2.length()-1);
    		Character c3 = newS3.charAt(newS3.length()-1);
    		if (c1.compareTo(c2) < 0 && c1.compareTo(c3) < 0) {
    			return newS1;
    		} else if (c2.compareTo(c1) < 0 && c2.compareTo(c3) < 0) {
    			return newS2;
    		} else { 
    			return newS3;
    		}
    	
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
      int sum = 0;
      Character character;
      for(int i = 0; i < s.length(); i++) {
      character = s.charAt(i);
      if (Character.isDigit(character)) {
    	 int number = Integer.parseInt(character+"");
    	 sum = sum+number;
      }
      }
    	return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int num = 0;
        int index = s.indexOf(substring);
        while (index!=-1) {
        	num++;
        	index = s.indexOf(substring, index + substring.length());
        	
        }
    	
    	
    	return num;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	String encrypted = Utilities.encrypt(s.getBytes(), (byte) key);
    	return encrypted;
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	String decrypted = Utilities.decrypt(s, (byte) key);
    	return decrypted;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int num = 0;
    	String[] words = s.split(" ");
    	for(int i = 0; i < words.length; i++) {
    		if (words[i].endsWith(substring)) {
    			num+=1;
    		}
    	}
    	return num;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	System.out.println(s);
    	System.out.println(substring);
    	int start = s.indexOf(substring) + substring.length();
    	System.out.println(start);
    	int end = s.lastIndexOf(substring);
    	System.out.println(end);
        int num = end-start;
    	return num;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        
    	String newS = s;
    	newS = newS.replace(" ", "");
    	newS = newS.replace(".", "");
    	newS = newS.replace("?", "");
    	newS = newS.replace("-", "");
    	newS = newS.replace(",", "");
    	newS = newS.replace(":", "");
    	String backwardS = "";
    	
    	for(int i = newS.length()-1; i > -1; i--) {
    		backwardS+=newS.charAt(i);
    	}
    	System.out.println(backwardS);
    	System.out.println(newS);
    	if (backwardS.equalsIgnoreCase(newS)) {
    		return true;
    	} else {
    		return false;	
    	}
    	
    }
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
