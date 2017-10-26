/* Description:

Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized.

Examples:

// returns "theStealthWarrior"
toCamelCase("the-stealth-warrior") 

// returns "TheStealthWarrior"
toCamelCase("The_Stealth_Warrior") */

import java.lang.StringBuilder;
class Solution{

  static String toCamelCase(String s){
    StringBuilder sb = new StringBuilder();
    boolean sw = false;
    
    for(int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '-' || s.charAt(i) == '_') {
        sw = true;
      }
      else {
        if (sw) {
          sb.append(Character.toUpperCase(s.charAt(i)));
          sw = false;
        }
        else {
          sb.append(s.charAt(i));
        }
      }
    }
    
    return sb.toString();
  }
}
