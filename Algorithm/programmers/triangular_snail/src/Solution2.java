// dy, dx 활용하기
class Solution2 {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    public int[] solution(int n) {

        // 2차원 배열 선언 n * n
        int[][] triangle = new int[n][n];
        int v = 1;

        // 위치 변수
        int x = 0;
        int y = 0;
        // 방향 변수
        int d = 0;

        while (true) {
            // dy, dx를 사용하면 모든 방향에 동일한 로직이 적용되므로 추가적인 반복문이 필요 없다.
            // 숫자 채우기
            triangle[y][x] = v++;
            // 다음 방향으로 이동 <- 다음 위치 계산
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                // 방향을 변경해주거나 끝내야 하는 경우
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            // 다음 좌푯값으로 갱신
            x = nx;
            y = ny;
        }

        // 각 행별로 1차원 배열로 변환하여 반환
        int[] answer = new int[v - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}