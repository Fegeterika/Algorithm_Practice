/*
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000

*/

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode root = buildTrie(dict);

        StringBuilder res = new StringBuilder();

        for (String token : tokens) {
            res.append(replaceWord(root, token));
            res.append(" ");
        }
        return res.toString().trim();
    }

    private String replaceWord(TrieNode root, String token) {
        StringBuilder sb = new StringBuilder();
        TrieNode temp = root;
        for (Character c : token.toCharArray()) {
            sb.append(c);
            if (temp != null) {
                temp = temp.children[c - 'a'];
                if (temp != null && temp.isWord) return sb.toString();
            }
        }
        return sb.toString();
    }

    private TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            TrieNode temp = root;
            for (Character c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    private class TrieNode {
        char val;
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(char c) {
            val = c;
        }
    }
}

/*
This is a slower solution checking using cache
This could have been a little faster by using HashMap

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (dict.contains(word.substring(0, i))) {
                    sb.append(word.substring(0, i));
                    break;
                }
                if (i == word.length() - 1) {
                    sb.append(word);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
*/
}
