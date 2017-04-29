/* Write a function that takes an (unsigned) integer as input, and returns the number of bits that are equal to one in the binary representation of that number.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case */

public class BitCounting { 

	public static int countBits(int n){
		int cnt = 0;
    
    while (n > 0) {
      int rem = n % 2;
      if (rem == 1) { cnt++; }
      n = n/2;      
    }
    
    return cnt;
	}
}
