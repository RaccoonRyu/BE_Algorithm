package CH00.Math.RootLog;

// Practice
// 제곱과 제곱근을 Math 없이 구현하기

public class RootLog_Practice {

    public static double pow(int a, double b) {
        // 밑은 정수로, 지수는 소수(double)로 받아와 제곱 계산

        // 반환을 위한 변수
        double result = 1;

        // b가 음수인지를 판단하기 위한 변수
        boolean isMinus = false;

        // 그 어떤 수를 0 제곱하든 1이므로 1 반환
        if(b == 0) {
            return 1;
        } else if (b < 0) { // b가 음수로 들어오는 경우
            b *= -1;
            isMinus = true;
        }

        for (int i = 0; i < b; i++) {
            // result에 a를 b까지 반복해서 곱해서 할당 -> a가 b제곱 만큼 제곱됨!
            result *= a;
        }

        // b가 음수(마이너스 제곱)면 제곱한 수를 역수로 반환하고, 아니면 그대로 반환
        return isMinus ? 1 / result : result;
    }

    public static double sqrt(int a) {
        // 정수를 받아 해당 정수의 제곱근 구하기

        // 반환을 위한 변수 생성
        double result = 1;

        // 바빌로니아 방법을 이용한 제곱근 구하기
        // 바빌로니아 방법이란?
        // i의 값이 커질수록 제곱근의 근사치가 커짐
        for (int i = 0; i < 10; i++) {
            // result에 바빌로니아 방법을 통해 연산한 제곱근 값을 대입
            result = (result + (a / result)) / 2;
        }

        return result;
    } // 제곱을 제곱근에 대해 직접 구하는 방법은 익혀두기

    public static void main(String[] args) {
        System.out.println("** Math pow **");
        System.out.println(Math.pow(2,3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println("** My pow **");
        System.out.println(pow(2,3));
        System.out.println(pow(2, -3));
        System.out.println(pow(-2, -3));

        System.out.println("** Math sqrt **");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));

        System.out.println("** My sqrt **");
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));
    }
}
