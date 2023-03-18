package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
       
    	StringBuilder newS = new StringBuilder(str);
    	newS.append(characters);
    	return newS.toString();
    }
    
    public static String reverse(String str) {
    	StringBuilder newS = new StringBuilder(str);
    	newS.reverse();
    	return newS.toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder newS = new StringBuilder(str);
    	newS.insert(index, newChar);
    	return newS.toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder newS = new StringBuilder(str);
    	newS.delete(startIndex, endIndex);
    	return newS.toString();
    }
}