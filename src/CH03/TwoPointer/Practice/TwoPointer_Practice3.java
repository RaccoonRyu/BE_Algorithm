package CH03.TwoPointer.Practice;

// Practice3
// 문자열 s를 거꾸로 출력하는 프로그램을 작성
// 단, 각 단어의 알파벳 순서는 그대로 유지하여 출력
// 문장에 공백이 여러개일 시, 단어와 단어 사이의 하나의 공백을 제외한 나머지 공백은 제거

// 입출력 예시
// 입력 : "the sky is blue"
// 출력 : "blue is sky the" => 단어의 알파벳 순서는 유지됨

// 입력 : "   hello      java    "
// 출력 : "java hello" => 단어의 알파벳 순서는 유지되고, 단어 간 여러개의 공백은 하나의 공백으로 제거

// idea :

public class TwoPointer_Practice3 {

    public static String solution(String s) {
        // 빈 문자열 검사
        if (s == null) {
            return null;
        }

        // s가 2보다 작으면 뒤집을 필요 없으므로 return s
        if (s.length() < 2) {
            return s;
        }

        // 문자열의 공백이 여러개일 수 있으므로 공백 우선 제거
        s = removeSpaces(s); // 공백 제거한 문자열 재할당

        // s를 char[]로 변경하고 문자열 s를 처음부터 끝까지 전체 뒤집기(알파벳 순서 무관)
        char[] cArr = s.toCharArray();
        reverseString(cArr, 0, s.length() - 1);

        // 알파벳 순서를 유지하도록 변경
        reverseWords(cArr, s.length());

        // char 배열을 String으로 변환하고 반환
        return new String(cArr);
    }

    // 공백 제거하는 함수
    public static String removeSpaces(String s) {
        // 공백 제거 시 인덱스로 사용할 포인터 2개
        int p1 = 0;
        int p2 = 0;

        // 인덱싱을 위해 문자열을 char 배열로 변경
        char[] cArr = s.toCharArray();
        // 공백 제거를 위한 문자열 길이 저장
        int length = s.length();

        // loop 반복하며 공백 제거 => 한 단어에 대해 앞 뒤로 공백 제거가 가능함
        while (p2 < length) {
            // p2 < length이고 cArr[p2]이 공백일 때 p2증가 (단순 이동) => 문자열 앞쪽에 공백이 있을 경우
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            }

            // p2 < length이고 cArr[p2]이 공백이 아닐 때 배열에 공백이 아닌 데이터를 채우기 위해 p1 증가
            while (p2 < length && cArr[p2] != ' ') {
                // 공백이 아닐 때는 p2의 데이터를 p1 자리에 넣고 p1, p2 증가 (공백이 아닌 데이터를 앞쪽부터 채워넣는 모양)
                cArr[p1++] = cArr[p2++];
            }

            // p2 < length이고 cArr[p2]이 공백일 때 p2증가 (단순 이동) => 2번째 loop 다음 문자에 공백이 있을 경우
            while (p2 < length && cArr[p2] == ' ') {
                p2++;
            } // => 여기까지 한 단어에 대해 앞 뒤로 공백 제거가 가능함

            // 여전히 p2 < length => 뒤에 다른 단어가 있음을 의미하고, 단어와 단어 사이에는 공백 하나 필요하므로 추가
            if (p2 < length) {
                cArr[p1++] = ' ';
            }
        } // => loop를 모두 수행하면 단어와 단어 사이에만 공백이 있는 형태의 char[]로 만들어짐

        // char[] to String하고 반환
        return new String(cArr).substring(0, p1);
    }

    // 문자열 뒤집기 함수
    public static void reverseString(char[] cArr, int i, int j) {
        while (i < j) {
            // i는 0부터 증가하고 j는 문자열 끝부터 감소하며 문자를 교환
            char temp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = temp;
        }
    }

    // 뒤집으며 알파벳 순서(단어 순서)를 맞추는 함수
    public static void reverseWords(char[] cArr, int length) {
        // 포인터 2개 사용
        int p1 = 0;
        int p2 = 0;

        while (p1 < length) {
            // p1은 공백에서 증가 => 공백이 아닌 곳에서 멈춤 (단어의 처음)
            while (p1 < p2 || p1 < length && cArr[p1] == ' ') {
                p1++;
            }
            // p2는 공백이 아닌 곳에서 증가 => 공백에서 멈춤 (단어의 끝)
            while (p2 < p1 || p2 < length && cArr[p2] != ' ') {
                p2++;
            }

            // 이후 p1, p2 인덱스를 사용하여 문자열 뒤집기 함수 호출
            reverseString(cArr, p1, p2 - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("   hello      java    "));
    }
}
