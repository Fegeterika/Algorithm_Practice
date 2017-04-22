/* Description:

Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.


Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
spinWords( "This is a test") => returns "This is a test" 
spinWords( "This is another test" )=> returns "This is rehtona test" */

public class SpinWords {

  public String spinWords(String sentence) {
    String[] parts = sentence.split(" ");
    int i = 0;
    String reverse_name = "";
    String result = "";
          
    while (i < parts.length) {
      if (parts[i].length() > 4) {
        for (int j = 0; j < parts[i].length(); j++) {
          reverse_name = reverse_name + parts[i].charAt(parts[i].length() - 1 - j);
        }
        parts[i] = reverse_name;
        reverse_name = "";
      }
    i++;
    }
    result = result + parts[0];
    for (int k = 1; k < parts.length; k++) {
      result = result + " " + parts[k];
    }
    return result; 
  }
}
