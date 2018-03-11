/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
object Solution {
    def minDistance(word1: String, word2: String): Int = {
        val dp: Array[Array[Int]] = Array.fill(word1.length + 1)(Array.fill(word2.length + 1)(0))
        for (i <- 0 to word1.length; j <- 0 to word2.length) {
            if (i == 0 && j != 0) {
                dp(i)(j) = dp(i)(j - 1) + 1
            } else if (j == 0 && i != 0) {
                dp(i)(j) = dp(i - 1)(j) + 1
            } else if (i != 0 && j != 0) {
                if (word1(i - 1) == word2(j - 1)) {
                    dp(i)(j) = dp(i - 1)(j - 1)
                } else {
                    dp(i)(j) = math.min(dp(i - 1)(j - 1) + 1, math.min(dp(i - 1)(j), dp(i)(j - 1)) + 1)
                }
            }
        }
        dp(word1.length)(word2.length)
    }
}
