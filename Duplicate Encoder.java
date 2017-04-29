/* The goal of this exercise is to convert a string to a new string where each character in the new string is '(' if that character appears only once in the original string, or ')' if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples:

"din" => "((("

"recede" => "()()()"

"Success" => ")())())"

"(( @" => "))((" */

public class DuplicateEncoder {
	static String encode(String word){
    StringBuilder sb = new StringBuilder(word.toLowerCase());
    int dup[] = new int[sb.length()];
    int duc = 0;
    
    for (int i = 0; i < sb.length(); i++) {
      for (int j = 0; j < sb.length(); j++) {
        if (sb.charAt(i) == sb.charAt(j)) {
          duc++; 
        }
      }
      if (duc == 1) {
        dup[i] = 1;
      }
      else {
        dup[i] = 0;
      }
      duc = 0;
    }
    
    for (int i = 0; i < dup.length; i++) {
      if (dup[i] == 1) {
        sb.setCharAt(i, '(');
      }
      else {
        sb.setCharAt(i, ')');
      }
    }
    return sb.toString();
  }
}
