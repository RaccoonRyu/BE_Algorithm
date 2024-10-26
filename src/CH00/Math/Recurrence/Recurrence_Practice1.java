package CH00.Math.Recurrence;

// Practice1
// 팩토리얼을 재귀함수로 구현하시오.

public class Recurrence_Practice1 {

    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        // n이 1이 아닐 경우에는 하나씩 빼면서 곱해주기
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}
