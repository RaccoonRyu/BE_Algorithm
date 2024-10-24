package CH03.TwoPointer.Practice;

// Practice1
// a, b, c, d로 이루어진 알파벳 문자열에 대해 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성
// 양 끝쪽의 문자를 비교한 후 같으면 삭제 / 연속해서 같은 문자가 등장하면 함께 삭제
// 최종적으로 남은 문자열을 반환

// 입출력 예시
// 입력 : "ab"
// 출력 : "ab"

// 입력 : "aaabbaa"
// 출력 : 없음 (삭제됨)

public class TwoPointer_Practice1 {

    public static String solution(String s) {
        // String 비어있음 처리
        if (s == null || s.length() == 0) {
            return null;
        }

        // 포인터 2개 선언 (하나는 앞, 하나는 문자열 끝 시작)
        int p1 = 0;
        int p2 = s.length() - 1;

        // loop 돌며 투 포인터로 비교 시작하며 지우기
        // p1이 가리키는 문자와 p2가 가리키는 문자가 같을 때 문자를 지운다.
        // 결국 p1이 가리키는 문자와 p2가 가리키는 문자가 같을 때 p1은 오른쪽, p2는 왼쪽으로 이동하면 지우고 남은 문자들의 위치값을 p1과 p2 가짐
        while (p1 < p2 && s.charAt(p1) == s.charAt(p2)) {
            // 비교를 위한 제일 끝(p2) 문자 하나 가져오기
            char c = s.charAt(p2);

            // 연속되는 같은 문자를 지우기 위한 p1 쪽 loop
            while (p1 <= p2 && s.charAt(p1) == c) {
                // 문자 비교하며 지우기 위해 p1을 우측으로 이동
                p1++;
            }

            // 연속되는 같은 문자를 지우기 위한 p2 쪽 loop
            while (p1 <= p2 && s.charAt(p2) == c) {
                // 문자 비교하며 지우기 위해 p2를 좌측으로 이동
                p2--;
            }
        }
        // 지우고 남은 문자들의 위치로 자른 문자열 반환
        return s.substring(p1, p2 + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution("ab")); // ab
        System.out.println(solution("aaabbaa")); // 없음
        System.out.println(solution("aabcddba")); // cdd
    }
}
