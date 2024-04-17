import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // 좌표 표현을 위한 클래스
    private static class Point {
        final long x, y; // 데이터니까 불변하도록 final 사용
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        // 모든 직선 쌍에 대해 반복하며 정수인 교점 좌표 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 교점의 좌표를 구한다. -> 별도의 메서드로 분리
                Point p = getIntersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);
                if (p != null) {
                    points.add(p);
                }
            }
        }
        // 저장된 정수 교점들에 대해 x, y 좌표의 최대, 최솟값 구하기
        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);

        // 주의!!!: 2차원 배열의 행, 열의 크기를 구하기 위해서는 각 좌표간의 너비와 높이에 1씩 더해줘야 한다.
        int h = (int) (maxPoint.y - minPoint.y + 1);
        int w = (int) (maxPoint.x - minPoint.x + 1);
        // 2차원 배열 선언 및 초기화
        char[][] arr = new char[h][w];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 2차원 배열에 별 표시
        for (Point p : points) {
            // 주의!!: 일반 좌표평면의 좌표와 2차원 배열의 좌표는 다르기 때문에 변환이 필요함.
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            arr[y][x] = '*';
        }

        // 문자열 배열로 변환한 후 반환
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    private Point getIntersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        // 교점이 정수인 경우에만 반환
        return new Point((long) x, (long) y);
    }

    private Point getMinPoint(List<Point> points) {
        // 최소 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaxPoint(List<Point> points) {
        // 최대 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

}
