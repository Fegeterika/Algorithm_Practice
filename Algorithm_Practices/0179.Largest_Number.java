/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) { return ""; }
        StringBuilder sb = new StringBuilder();
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare (String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        };
        
        String[] sorted = Arrays.stream(nums).mapToObj(String::valueOf).sorted(comp).toArray(String[]::new);
        for (String num : sorted) {
            sb.append(num);
        }
        String result = sb.toString();
        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }
    }
    
}
