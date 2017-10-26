import java.util.LinkedList;

public class Q3_Cache {

    private int findRuntime(String[] cities, int size) {
        int runtime = 0;
        LinkedList<String> cache = new LinkedList<String>();

        if (size == 0) {
            runtime = cities.length * 5;
            return runtime;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                runtime += 1;
                cache.remove(city);
                cache.addLast(city);
            } else {
                runtime += 5;
                if (!cache.isEmpty() && cache.size() == size) {
                    cache.remove(0);
                }
                cache.addLast(city);
            }
        }
        return runtime;
    }

    public static void main(String[] args) {
        // Setup test cases
        String[][] test = new String[][] {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
                                          {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
                                          {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                                          {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                                          {"Jeju", "Pangyo", "NewYork", "newyork"},
                                          {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};

        int[] testsize = new int[] {3, 3, 2, 5, 2, 0};

        // Initialize solver
        Q3_Cache solver = new Q3_Cache();

        // Test solution
        for (int i = 0; i < test.length; i++) {
            System.out.println(solver.findRuntime(test[i], testsize[i]));
        }
    }
}
