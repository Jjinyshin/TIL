public class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        // 방법 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                // 대문자인 경우
                c = (char) ((c - 'A' + n) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                // 소문자인 경우
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            sb.append(c);
        }
        // 방법 2
        for (char c : s.toCharArray()) {
            // c를 n만큼 민 문자열을 sb에 이어붙이는 식
            sb.append(push(c, n));
        }

        return sb.toString();
    }

    private char push(char c, int n) {
        // c를 n만큼 밀어 반환
        if (!Character.isAlphabetic(c)) {
            // c가 알파벳이 아닌 경우 그대로 반환
            return c;
        }
        else {
            // 알파벳을 0~25로 변환하면 대/소문자 상관없이 로직은 공통이다.
            // 알파벳을 숫자로 변환하기; 숫자를 표현하는 문자를 정수로 변환하는 것임.
            int offset = Character.isUpperCase(c) ? 'A' : 'a';
            int position = c - offset;
            position = (position + n) % ('Z' - 'A' + 1);
            return (char) (offset + position);

        }
    }
}
