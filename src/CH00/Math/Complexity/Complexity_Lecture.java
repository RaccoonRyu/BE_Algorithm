package CH00.Math.Complexity;

public class Complexity_Lecture {

    static int fibonacci(int n) {
        if (n < 3) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    static int factorial(int n) {
        if (n < 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // 복잡도 예제 코드
        // 복잡도 : 알고리즘 성능을 나타내는 척도

        // 1. 시간 복잡도
        System.out.println("** 시간 복잡도 **");

        // O(1) -> 어떤 양의 입력이 들어오든 한번 연산하는 것
        System.out.println("** O(1) **");
        System.out.println("hello");

        // O(logN) -> 입력값에 대해서 logN번 만큼 연산하는 것
        System.out.println("** O(logN) **");
        for (int i = 1; i < 16; i*=2) {
            System.out.println("hello");
        }

        // O(N) -> 입력값에 대해서 N번 만큼 연산하는 것
        System.out.println("** O(N) **");
        for (int i = 0; i < 2; i++) {
            System.out.println("hello");
        }

        // O(NlogN) -> 입력값에 대해 N * logN번 만큼 연산하는 것
        System.out.println("** O(NlogN) **");
        for (int i = 0; i < 2; i++) { // 바깥 for문 N번
            for (int j = 1; j < 8; j*=2) { // 안 for문 3번(밑이 2인 log8 = log 2^3 = 3)
                System.out.println("Hello");
            }
        }

        // O(N^2) -> 입력값에 대해 N의 제곱만큼 연산하는 것
        System.out.println("** O(N^2)");
        for (int i = 0; i < 2; i++) { // 바깥 for문 N번
            for (int j = 0; j < 2; j++) { // 안 for문 N번
                System.out.println("Hello"); // N번만큼 연산하는 for문이 2중으로 있음
            }
        }

        // O(2^N) -> 입력값에 대해 2의 N제곱 만큼 연산하는 것
        System.out.println("** O(2^N) **");
        // 피보나치 재귀
        System.out.println(fibonacci(6));

        // 2. 공간 복잡도
        System.out.println("** 공간 복잡도 **");
        // O(N) -> 함수를 재귀함수로 만들어서 재귀적으로 호출하면 시스템 내부의 함수 콜 스택에 적재되기 때문에, N번 만큼 적재된다는 의미
        System.out.println("** O(N) **");
        int n = 3;
        System.out.println(factorial(n));

        // O(1) -> N이 몇번 됐든 무관히 하나의 변수(result)로만 적재하여 연산함
        System.out.println("** O(1) **");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 1;
        }
    }
}
