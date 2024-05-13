import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1부터 max까지 fizz buzz 출력
        // max는 콘솔로부터 전달받음

        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();

        ConsoleBasedFizzBuzz fizzBuzz = new ConsoleBasedFizzBuzz();
        fizzBuzz.print(1, max);
    }
}