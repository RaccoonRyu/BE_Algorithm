package CH00.Math.Recurrence;

public class Recurrence_Lecture {

    public static int recursion1(int n) {
        if(n == 1) {
            return 1;
        }
        // n이 1이 아니라면 한 후 1을 감소시키면서 자기 자신을 호출하고 3 곱함
        return 3 * recursion1(n - 1);
    }

    public static int recursion2(int n) {
        if(n == 1) {
            return 1;
        }
        // n이 1이 아니라면 1을 감소시키면서 자기 자신을 호출하고 n 더함
        return n + recursion2(n - 1);
    }

    public static int recursion3(int n) {
        if(n < 3) {
            return 1;
        }
        // n이 3보다 크면 앞의 두 수를 더해서 return
        return recursion3(n-2) + recursion3(n-1);
    }

    public static void main(String[] args) {
        // 점화식과 재귀함수
        // 점화식 : 어떤 수열의 일반항을 그 이전의 항들을 이용하여 정의한 식 (ex 피보나치 수열)
        // 재귀함수 : 어떤 함수가 자신을 다시 호출하여 작업을 수행하는 방식 -> 무한 루프를 탈출하기 위한 종료조건이 반드시 필요!

        // 점화식 -> 반복문 / 재귀함수
        System.out.println("** 점화식 / 재귀함수 연습 1 **");
        // 1, 3, 9, 27, ... 의 n번째 수
        int n = 4;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if(i == 0) {
                result = 1;
            } else {
                result *= 3;
            }
        }
        System.out.println(result);

        // 점화식 -> a1 = 3 x a0이므로 an+1 = 3 x an
        // 재귀함수로 구현 (recursion1)
        System.out.println(recursion1(n));


        System.out.println("** 점화식 / 재귀함수 연습 2 **");
        // 1, 2, 3, 4, 5, 6, ... 의 n번째 까지의 합
        n = 5;
        result = 0;
        for (int i = 0; i < n + 1; i++) {
            result += i;
        }
        System.out.println(result);

        // 재귀함수로 구현
        System.out.println(recursion2(n));


        System.out.println("** 점화식 / 재귀함수 연습 3 **");
        // 1, 3, 9, 27, ... 의 n번째 수 (피보나치 수열)
        n = 6;
        result = 0;
        // 초기 항 두개
        int a1 = 1;
        int a2 = 1;

        // n이 3보다 작으면 초기 항은 모두 1이므로 1 반환
        if(n < 3) {
            result = 1;
        } else { // n이 3보다 클 경우 loop를 통해 두 수를 합해가며 n번째 수 찾음
            for (int i = 2; i < n; i++) {
                result = a1 + a2;
                // 다음 항들은 직전 숫자(이전 항)들을 쫓아가야 하므로 아래와 같이 작성.
                a1 = a2;
                a2 = result;
            }
        }
        System.out.println(result); // 8

        // 재귀함수로 출력
        System.out.println(recursion3(n));
    }
}
