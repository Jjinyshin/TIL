class Solution {
    public int[] solution(int n) {

        // 2차원 배열 선언 n * n
        int[][] triangle = new int[n][n];
        int value = 1;

        // 첫 번째 숫자 위치
        int x = 0;
        int y = 0;

        // 방향에 따라 숫자 채우기: 아래->오른쪽->왼쪽 위
        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = value++;
                if (y + 1 == n || triangle[y + 1][x] != 0) break; // 더 이상 아래로 이동할 수 없는 경우
                y += 1;
            }
            // 주의!!!: 그 다음에 오른쪽으로도 이동할 수 없는 경우도 있다.
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = value++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = value++;
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        // 각 행별로 1차원 배열로 변환하여 반환
        int[] answer = new int[value - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}