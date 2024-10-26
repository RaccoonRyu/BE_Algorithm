package CH00.Math.Set;

// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용하지 않음)

import java.util.ArrayList;

class MySet {
    // ArrayList
    ArrayList<Integer> list;

    // 생성자 1
    MySet() {
        this.list = new ArrayList<>();
    }

    // 생성자 2 - 데이터를 만들어서 객체를 만들 때 해당 데이터를 넣어주며 객체 생성
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();
        // 들어온 데이터를 받아 리스트에 하나씩 넣어줌
        for(int item : arr) {
            this.list.add(item);
        }
    }

    // 원소 추가 (중복 X)
    public void add(int x) {
        for(int item : this.list) { // list 내 원소를 순회하며 매개변수와 같은 값의 원소가 있다면 데이터 추가하지 않고 함수 종료
            if(item == x) {
                return;
            }
        }
        this.list.add(x);
    }

    // 교집합
    public MySet retainAll(MySet b) {
        // a와 b 집합을 교집합 했을 때 a와 b는 그대로 놓고 교집합 결과를 반환할 새 MySet 생성
        MySet result = new MySet();

        for(int itemA : this.list) { // 자기 자신의 집합을 순회하고
            for (int itemB : b.list) { // 매개변수로 들어온 집합을 순회하며 이 둘의 원소를 비교
                // 같은 데이터들만 새로 만든 result 집합에 add
                if(itemA == itemB) {
                    result.add(itemA);
                }
            }
        }
        return result;
    }

    // 합집합
    public MySet addAll(MySet b) {
        // a와 b 집합을 교집합 했을 때 a와 b는 그대로 놓고 합집합 결과를 반환할 새 MySet 생성
        MySet result = new MySet();

        for (int itemA : this.list) { // 집합 자기 자신의 요소를 결과에 저장
            result.add(itemA);
        }

        for (int itemB : b.list) { // 합집합 하려는 대상 집합의 요소를 결과에 저장
            result.add(itemB);
        }

        // 이 때 위에서 만들어둔 add 함수를 통해 요소를 저장하기 때문에 중복은 방지되어 들어간다.

        return result;
    }

    // 차집합
    public MySet removeAll(MySet b) {
        // a와 b 집합을 교집합 했을 때 a와 b는 그대로 놓고 차집합 결과를 반환할 새 MySet 생성
        MySet result = new MySet();

        for (int itemA : this.list) { // 현재 집합을 순회
            // 원래 집합과 차집합하려는 대상 집합간의 원소 포함 여부를 관리하기 위한 변수
            boolean contain = false;

            for(int itemB : b.list) { // 차집합 하려는 대상 집합을 순회
                // 값이 같은 원소가 있을 경우 남은 원소를 순회하지 않아도 되므로
                if(itemA == itemB) {
                    // 원소 포함 여부를 true로 바꾼 후 차집합 대상 집합 loop 탈출
                    contain = true;
                    break;
                }
            }

            // 포함 여부가 false라면 두개 집합에 같은 값을 가진 원소가 없다는 뜻. 즉 A-B에서 살아남은 원소를 결과 집합에 add한다.
            if(!contain) {
                result.add(itemA);
            }

        }

        return result;
    }
}

public class Set_Practice {
    public static void main(String[] args) {
        // 위에서 만든 MySet 클래스 이용하여 객체 생성
        MySet set = new MySet();

        set.add(1);
        set.add(1);
        set.add(1);
        System.out.println(set.list); // 중복 데이터 허용하지 않으므로 1 출력
        set.add(2);
        set.add(3);
        System.out.println(set.list); // 1, 2, 3

        set = new MySet(new int[] {1, 2, 3, 4, 5});
        MySet set2 = new MySet(new int[] {2, 4, 6, 8, 10});
        System.out.println("set = " + set);
        System.out.println("set2 = " + set2);

        MySet result = set.retainAll(set2);
        System.out.println("교집합 : " + result.list); // 2, 4 출력

        result = set.addAll(set2);
        System.out.println("합집합 : " + result.list); // 중복된 데이터 없이 모든 원소 합

        result = set.removeAll(set2);
        System.out.println("차집합 : " + result.list); // A-B 이므로 1, 3, 5 출력

    }
}
