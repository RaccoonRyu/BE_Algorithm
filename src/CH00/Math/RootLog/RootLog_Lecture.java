package CH00.Math.RootLog;

public class RootLog_Lecture {
    public static void main(String[] args) {
        // 지수와 로그
        // Java의 Math 클래스를 사용하여 구해본다.

        // 1. 제곱, 제곱근, 지수
        System.out.println("** 제곱 **");
        // Math.pow(밑, 제곱 수) : 밑의 숫자를 제곱 수만큼 제곱한다
        System.out.println(Math.pow(2, 3)); // 8.0
        System.out.println(Math.pow(2, -3)); // 0.125 -> 마이너스 제곱은 밑의 숫자를 역수로 계산해주면 된다 (ex. 2의 -3제곱 = 1/2을 세제곱)
        System.out.println(Math.pow(-2, -3)); // -0.125

        System.out.println(Math.pow(2, 30)); // 1.073741824E9. 뒤의 E9는 10의 9제곱
        System.out.printf("%.0f\n", Math.pow(2, 30)); // 소숫점 나오지 않는 float 형태(%.0f)로 문자 그대로 출력

        System.out.println("** 제곱근 **");
        // Math.squr(숫자) : 해당 숫자의 제곱근
        System.out.println(Math.sqrt(16)); // 4.0
        // pow를 사용할 수도 있다.
        System.out.println(Math.pow(16, 1.0/2)); // 16의 1/2제곱 = 4.0
        System.out.println(Math.pow(16, 1.0/4)); // 16의 1/4제곱 = 2.0

        // 참고) 절대값
        System.out.println("** 절대 값 **");
        // Math.abs(숫자) : 해당 숫자의 절대값
        System.out.println(Math.abs(5)); // 5
        System.out.println(Math.abs(-5)); // 5


        // 2. 로그
        System.out.println("** 로그 **");
        // Math.log : 밑이 자연 상수(e)인 로그
        // Math.log10 : 밑이 10인 로그(상용 로그)
        // 자연 상수 E를 넣으면 1이 출력됨.
        System.out.println(Math.log(Math.E)); // 자연 상수 E를 넣으면 1.0이 출력됨.
        System.out.println(Math.log10(1000)); // 3.0 출력됨
        // 밑이 다른 로그 사용법
        // Math.log(숫자1) / Math.log(숫자2) => 이 경우 log숫자2의 숫자1이 됨
        System.out.println(Math.log(4) / Math.log(2)); // log2의 4 이므로 2.0 출력

    }
}
