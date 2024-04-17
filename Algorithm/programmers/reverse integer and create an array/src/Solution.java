class Solution {
    public int[] solution(long n) {
        // 자연수를 문자열로 변환
        String numstr = String.valueOf(n);

        int len = numstr.length();
        int[] answer = new int[len];

        // 문자열을 뒤집어서 배열에 넣기
        for (int i = 0; i < len; i++) {
            // 문자를 정수로 변환하여 새로운 배열에 저장
            // -> char끼리 연산하면 정수형으로 취급되어 int형으로 형 변환이 일어남
            answer[i] = numstr.charAt(len - 1 - i) - '0';
        }

        return answer;
    }
}