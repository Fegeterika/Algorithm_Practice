/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/
class Solution {
    public List<Integer> diffWaysToCompute(String input) {        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperator(input.charAt(i))) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                
                for (Integer numL : left) {
                    for (Integer numR : right) {
                        res.add(useOperator(input.charAt(i), numL, numR));
                    }
                }
            }
        }
        
        if (res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        
        return res;
    }
    
    private boolean isOperator(char x) {
        if (x == '-' || x == '+' || x == '*') return true;
        return false;
    }
    
    private Integer useOperator(char x, Integer left, Integer right) {
        switch(x) {
            case('-'): return left - right;
            case('+'): return left + right;
            case('*'): return left * right;
        }
        return null;
    }
}
