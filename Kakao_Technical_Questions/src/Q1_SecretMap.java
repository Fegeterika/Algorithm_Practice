public class Q1_SecretMap {

    private String[] appendToRes(int n, int[] arr1, int[] arr2) {
        String[] res = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String temp = Integer.toString((arr1[i] | arr2[i]), 2);
            if (temp.length() < n) {
                for (int j = 0; j < n - temp.length(); j++) {
                    temp = '0' + temp;
                }
            }
            res[i] = temp.replace('1', '#').replace('0', ' ');
        }
        return res;
    }

    public static void main (String[] args) {
        // Setup test cases
        int n1 = 5;
        int[] arr11 = {9, 20, 28, 18, 11};
        int[] arr12 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr21 = {46, 33, 33, 22, 31, 50};
        int[] arr22 = {27, 56, 19, 14, 14, 10};

        // Initialize solver
        Q1_SecretMap solver = new Q1_SecretMap();

        // Test solution
        String[] solution1 = solver.appendToRes(n1, arr11, arr12);
        for (String item : solution1) {
            System.out.println(item);
        }

        String[] solution2 = solver.appendToRes(n2, arr21, arr22);
        for (String item : solution2) {
            System.out.println(item);
        }
    }
}
