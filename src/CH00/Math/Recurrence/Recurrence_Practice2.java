package CH00.Math.Recurrence;

// Practice2
// 최대공약수를 재귀함수로 구현하시오

public class Recurrence_Practice2 {

    public static int gcd(int a, int b) { // 중요하고 간단한 형태의 코드!!
        // 처음에 a를 b로 나눈 나머지가 0이면
        // b에 해당하는 숫자가 최대 공약수이므로 b를 반환
        if(a % b == 0) {
            return b;
        }
        // 처음에 a를 b로 나눈 나머지가 0이 아니면
        // (a, b)의 최대공약수는 (b, a % b)의 최대공약수와 동일하므로
        // b(다음 함수의 a)를 a % b로 나눈 나머지(다음 함수의 b)가 0이 나올 때 까지 재귀 호출
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(3, 5));
        System.out.println(gcd(2, 6));
        System.out.println(gcd(8, 12));
    }
}
