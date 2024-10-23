package CH01.Sort.Practices;

// Practice1
// nums 배열에 3가지 색으로 구분되는 데이터들이 들어있다.
// 0은 흰색, 1은 파랑, 2는 빨강이라고 할 때
// 주어진 nums 배열에서 흰색 부터 빨강 순으로 인접하게 정렬 시킨 후 출력하는 프로그램을 작성하시오.

// 입출력 예시
// 입력 : 2, 0, 2, 1, 1, 0
// 출력 : 0, 0, 1, 1, 2, 2

// 오름차순으로 정렬하는 문제!
// 인플레이스, 안정성, 추가 메모리 제약 사항 없음
// 카운트를 할 개수 자체도 많지 않기 때문에 따라서 시간복잡도가 비교적 낮은 계수 정렬로 풀기

import java.util.Arrays;

public class Sort_Practice1 {

    public static void solution(int[] arr) {
        // 배열의 존재여부와 길이 검사
        if(arr == null || arr.length == 0) {
            return;
        }

        // 계수 테이블 작성
        int[] cntArr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            // loop 수행하며 배열에서 정렬하려는 값을 계수 테이블의 인덱스로 삼고, 해당 인덱스를 갖는 계수 테이블의 값 1 증가(수를 셌다는 의미)
            cntArr[arr[i]]++;
        }

        // 정렬 시작
        // 정렬을 위한 인덱스 변수
        int idx = 0;
        // 계수 테이블 길이만큼 순회하며
        for (int i = 0; i < cntArr.length; i++) {
            // 배열에서 정렬하려는 값을 인덱스로 갖는 계수 테이블 값이 있을 때 까지 loop
            while(cntArr[i] > 0) {
                // 배열에서 정렬하려는 값을 인덱스로 갖는 계수 테이블 값이 있으면 해당 위치를 배열 값으로 할당
                arr[idx++] = i;
                // 할당하고 나면 데이터를 arr에 정렬했으므로 계수 테이블이 갖는 값 1씩 차감
                cntArr[i] -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 0, 1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
