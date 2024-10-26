package CH00.Math.Combitation;

public class Combination_Lecture {

    static int getCombination(int n, int r) {
        // 순열
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        // 팩토리얼
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }

        return pResult / rResult;
    }

    public static void main(String[] args) {
        // 조합 예제 코드
        // 조합 : 서로 다른 n개 중 r개를 선택하는 경우의 수. 순서 X, 중복 X

        // 1. 조합
        System.out.println("** 조합 **");
        // 서로 다른 4명 중 주번 2명 뽑는 경우의 수
        int n = 4;
        int r = 2;

        // 결과를 저장할 변수 pResult, rResult
        // 순열
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        // 팩토리얼
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }

        // 조합 -> 순열을 팩토리얼로 나눔!
        System.out.println("결과 : " + pResult/rResult);


        // 2. 중복 조합
        System.out.println("** 중복 조합 **");
        // 후보 2명, 유권자 3명일 때 무기명 투표 경우의 수
        n = 2;
        r = 3;

        // 중복 조합 -> n + r - 1 C r 이므로 아래와 같이 작성한다.
        System.out.println("결과 : " + getCombination(n + r - 1, r));

    }
}
