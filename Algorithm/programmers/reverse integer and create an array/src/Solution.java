class Solution {
    public int[] solution(long n) {
        // 방법 1
        // 입력받은 숫자를 문자열로 변환하기
        String numstr = String.valueOf(n);

        int len = numstr.length();
        int[] answer = new int[len];

        // 문자열을 뒤집어서 배열에 넣기
        for (int i = 0; i < len; i++) {
            // 문자를 정수로 변환하여 새로운 배열에 저장
            // -> char끼리 연산하면 정수형으로 취급되어 int형으로 형 변환이 일어남
            answer[i] = numstr.charAt(len - 1 - i) - '0';
        }

        // 방법 2
        // 입력받은 숫자를 문자열로 변환하기: Long class의 static method인 toString() 활용
        String str = Long.toString(n);
        // 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        // 뒤집힌 문자열을 문자의 배열로 변환하기: String class의 toCharArray() 활용
        char[] arr = reversed.toCharArray();
        // 배열의 각 문자를 정수로 변환하기:
        int[] answer2 = new int[arr.length];
        for (int i = 0; i < answer2.length; i++) {
            answer2[i] = arr[i] - '0';
        }

        return answer;
    }
}