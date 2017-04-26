/* Write simple .camelcase method (camel_case function in PHP) for strings. All words must have their first letter capitalized without spaces.

For instance:

"hello case".camelCase() => HelloCase
"camel case word".camelCase() => CamelCaseWord */

class CamelCaseMethod {
    static String camelCase(final String string) {
        StringBuilder sb = new StringBuilder();
        Boolean sw = true;
        
        for(int i = 0; i < string.length(); i++) {
          if (sw) {
            sb.append(Character.toUpperCase(string.charAt(i)));
            sw = false;
          }
          else if (string.charAt(i) == ' ') {
            sw = true;
          }
          else {
            sb.append(string.charAt(i));
          }
        }
        
        System.out.print(sb.toString());
        return sb.toString();
    }
}
