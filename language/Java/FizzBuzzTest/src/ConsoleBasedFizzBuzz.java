public class ConsoleBasedFizzBuzz implements FizzBuzz{
    @Override
    public void print(int from, int to) {
        for (int i = from; i <= to; i++) {

            String num="";

            if(i % 3  ==0)
                num += "Fizz";
            if(i % 5 == 0)
                num += "Buzz";
            if(num.length() == 0)
                num = Integer.toString(i);

            System.out.println(num);

            // 처음 작성한 코드
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else if (i % 5 == 0){
//                System.out.println("Buzz");
//            } else {
//                System.out.println(i);
//            }
        }
    }
}
