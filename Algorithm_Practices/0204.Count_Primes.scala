/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/
object Solution {
    def countPrimes(n: Int): Int = {
        val notPrime = Array.fill(n)(false)
        var count = 0
        for (i <- 2 until n) {
            if (!notPrime(i)) {
                count += 1
                var j = 1
                while (i * j < n) {
                    notPrime(i * j) = true
                    j += 1
                }
            }
        }
        count
    }
}
