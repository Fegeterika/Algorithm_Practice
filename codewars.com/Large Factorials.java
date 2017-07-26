/* 
In mathematics, the factorial of integer 'n' is written as 'n!'. It is equal to the product of n and every integer preceding it. For example: 5! = 1 x 2 x 3 x 4 x 5 = 120

Your mission is simple: write a function that takes an integer 'n' and returns 'n!'.

You are guaranteed an integer argument. For any values outside the positive range, return null, nil or None. In C++, return an empty string. For positive numbers a full length number is expected for example, return 25! = '15511210043330985984000000' as a String!

Note: 0! is always equal to 1. Negative values should return null or an empty string(in C++).

For more on Factorials : http://en.wikipedia.org/wiki/Factorial
*/

import java.math.BigInteger;

public class Kata
{

  public static String Factorial(int n) {
    
    if (n < 0) {
      return null;
    }
    if (n == 0) {
      return "1";
    }
    
    BigInteger res = new BigInteger("1");
    
    while (n > 0) {
      BigInteger num = new BigInteger(Integer.toString(n));
      res = res.multiply(num);
      n--;
    }
    
    return res.toString();
  }

}
