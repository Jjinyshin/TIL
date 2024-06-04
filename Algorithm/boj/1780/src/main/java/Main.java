import java.util.Scanner;

public class Main {

    // -1,0,1을 저장하기 위한 클래스
    public static class Count {
        public final int minusone;
        public final int zero;
        public final int plusone;

        public Count(int minusone, int zero, int plusone) {
            this.minusone = minusone;
            this.zero = zero;
            this.plusone = plusone;
        }

        public Count add(Count other) {
            return new Count(this.minusone + other.minusone, this.zero + other.zero, this.plusone + other.plusone);
        }
    }

    // x좌표, y좌표, 한 변의 길이, 그 사각형 배열
    public Count solution(int x, int y, int size, int[][] arr){
        // 상태: 각 종이의 (-1의 개수, 0의 개수, 1의 개수)
        // 종료 조건: (1,0,0), (0,1,0), (0,0,1) -> 하나의 수로만 이루어져 잇을때
        // 점화식: 각 종이의 수들을 검사해서 비교. 서로 다른 수 섞여있으면 -> 재귀, 아니면 -> 종료
        /// 구하는 것: -1, 0, 1로만 채워진 종이의 개수

        int h = size / 3;
        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++){
                if (arr[i][j] != arr[x][y]){
                    // 원소가 섞여있는 경우의 반환값.
                    return solution(x,y,h,arr)
                            .add(solution(x+h,y,h,arr))
                            .add(solution(x+2*h,y,h,arr))
                            .add(solution(x,y+h,h,arr))
                            .add(solution(x,y+2*h,h,arr))
                            .add(solution(x+h,y+h,h,arr))
                            .add(solution(x+2*h,y+h,h,arr))
                            .add(solution(x+h,y+2*h,h,arr))
                            .add(solution(x+2*h,y+2*h,h,arr));
                }
            }
        }

        if (arr[x][y] == -1) {
            return new Count(1,0,0);
        } else if (arr[x][y] == 0){
            return new Count(0,1,0);
        } else{
            return new Count(0,0,1);
        }
    }

    public void printSolution(Count cnt) {
        System.out.println(cnt.minusone);
        System.out.println(cnt.zero);
        System.out.println(cnt.plusone);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        Main sol = new Main();

        Count count = sol.solution(0,0,n,matrix);
        sol.printSolution(count);
    }
}
