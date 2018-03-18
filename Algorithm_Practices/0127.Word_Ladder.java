/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;
        
        Queue<String> wordQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        int ladderLen = 1;
        wordQueue.offer(beginWord);
        visited.add(beginWord);
        
        while (!wordQueue.isEmpty()) {
            int initSize = wordQueue.size();
            ladderLen++;
            while (initSize-- > 0) {
                String currentWord = wordQueue.poll();
                for (String targetWord : wordList) {
                    if (!visited.contains(targetWord) && isOneLetterAway(currentWord, targetWord)) {
                        if (targetWord.equals(endWord)) return ladderLen;
                        visited.add(targetWord);
                        wordQueue.offer(targetWord);
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean isOneLetterAway(String beginWord, String targetWord) {
        boolean diffFound = false;
        for (int i = 0, j = 0; i < beginWord.length(); i++, j++) {
            if (beginWord.charAt(i) != targetWord.charAt(j)) {
                if (diffFound) return false;
                diffFound = true;
            }
        }
        return true;
    }
}
