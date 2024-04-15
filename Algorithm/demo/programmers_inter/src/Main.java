public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };

        String[] result = solution.solution(line);

        for (String row : result) {
            System.out.println(row);
        }
    }
}
