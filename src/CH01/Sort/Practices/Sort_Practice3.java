package CH01.Sort.Practices;

// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때
// 오버랩 되는 구간을 합치는 프로그램을 작성 (오버랩 구간 : 1, 3과 2, 6구간이 있다면 2~3이 겹치는구간. -> 이를 합쳐 1, 6으로 만듦)
// 합친 구간은 오름차순으로 정렬해서 반환

// 입출력 예시
// 입력 : [2, 6], [1, 3], [15, 18], [8, 10]
// 출력 : [1, 6], [8, 10], [15, 18]

// 정렬 idea : 2차원 배열에서 어떤 값을 기준으로 정렬하는 방법 -> 퀵 정렬 많이 쓰임!

import java.util.ArrayList;
import java.util.Arrays;

public class Sort_Practice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        // intervals 비어있음 여부 처리
        if(intervals == null || intervals.length < 2) {
            return new ArrayList<>();
        }

        // 2차원 배열안의 1차원 배열들을 첫번째 값들로 정렬해둔 다음 구간 겹침을 확인
        sort(intervals);

        // 구간 겹침 확인
        // result에 구간이 합쳐저 정리된 결과를 넣어줌
        ArrayList<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0]; // curInterval은 현재 배열 안에서의 첫번째 구간
        result.add(curInterval);

        // loop 돌면서 구간 겹치기
        for (int i = 1; i < intervals.length; i++) {
            // 현재 curInterval 바로 뒷부분(배열 속 값을 앞, 뒤라고 할 때)이 그 다음 interval의 앞부분보다 크거나 같을 때 합쳐줌 = 구간 겹침
            if(curInterval[1] >= intervals[i][0]) {
                // curInterval의 뒷부분을 그 다음 interval의 뒷부분으로 바꿔준다.
                curInterval[1] = intervals[i][1];
            } else { // 구간이 겹치지 않는 경우는 결과에 i 인덱스를 갖는 intervals를 추가
                curInterval = intervals[i];
                result.add(curInterval);
            }
        }
        // 결과 반환
        return result;
    }

    // 퀵 정렬을 통해 배열들을 각 배열의 첫번째 값으로 정렬
    public static void sort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
    }

    public static void quickSort(int[][] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        // pivot 설정 함수 partition
        int pivot = partition(arr, left, right);

        // 이후 pivot을 기준으로 좌측, 우측에 대한 퀵 정렬을 재귀호출
        // pivot 자리는 정렬 상 제자리를 찾았으므로 제외하고 좌-우 퀵 정렬을 재귀호출 한다.
        // 좌측 퀵 정렬
        quickSort(arr, left, pivot - 1);
        // 우측 퀵 정렬
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[][] arr, int left, int right) {
        // 2차원 배열 안의 배열들을 각 배열의 첫번째 값으로 정렬하기 위한 코드
        int pivot = arr[left][0];
        int i = left;
        int j = right;

        while(i < j) {
            while (arr[j][0] > pivot && i < j) {
                j--;
            }

            while (arr[i][0] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }

    // 2차원 배열을 swap 하는 함수
    public static void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for(int [] item : solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();
    }
}
