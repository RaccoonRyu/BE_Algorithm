package CH00.Math.Set;

import java.util.Arrays;
import java.util.HashSet;

public class Set_Lecture {
    public static void main(String[] args) {
        // 집합 예제 코드
        // Java에서의 집합 사용은 HashSet을 이용한다.
        System.out.println("** HashSet **");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(1); // 1이라는 데이터 3번 넣음
        System.out.println("set1 = " + set1); // 데이터 중복 허용하지 않으므로 1만 출력
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1); // 1, 2, 3 출력
        set1.remove(1); // 인덱스가 아닌 값으로 데이터 삭제
        System.out.println("set1 = " + set1); // 2, 3 출력
        System.out.println(set1.size()); // set의 크기 반환
        System.out.println(set1.contains(2)); // 인덱스가 아닌 값으로 데이터 확인. true

        // 집합 연산
        System.out.println("** 집합 연산 **");

        // 1. 교집합
        // 교집합 연산을 위한 HashSet 집합 두개 생성
        HashSet a = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet b = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        // 교집합 연산을 위한 함수 retainAll
        // a에는 교집합이 계산된 원소만 남음
        /*a.retainAll(b);
        System.out.println("교집합 : " + a); // 2, 4 출력*/

        // 2. 합집합
        // 합집합 연산을 위한 함수 addAll()
        // a에는 합집합이 계산된 원소가 들어감
        /*a.addAll(b);
        System.out.println("합집합 : " + a); // 1, 2, 3, 4, 5, 6, 8, 10 출력*/

        // 3. 차집합
        // 차집합 연산을 위한 함수 removeAll()
        // a - b 차집합의 방향
        a.removeAll(b);
        System.out.println("차집합 : " + a); // a에는 b의 원소만 제거되어 1, 3, 5 출력
    }
}
