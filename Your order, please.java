/* Description:

Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.

For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est" */

public class Order {
  public static String order(String words) {
    String[] parts = words.split(" ");
    String[] orderedParts = new String[parts.length];
    StringBuilder sb = new StringBuilder();

    if (words == "") { 
      return ""; 
    }
      
    for (int i = 0; i < parts.length; i++) {
      for (int j = 0; j < parts[i].length(); j++) {
        int newIndex = Character.getNumericValue(parts[i].charAt(j));
        if (newIndex <= 9) {
          orderedParts[newIndex - 1] = parts[i];
        }
      }
    }
    
    for (int i = 0; i < orderedParts.length; i++) {
      sb.append(orderedParts[i]);
      if (i < orderedParts.length - 1) {
        sb.append(" ");
      }
    }
    
    return sb.toString();
  }
}
