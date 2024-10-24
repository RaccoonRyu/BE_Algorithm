package CH02.BinarySearch.Practice;

// Practice2
// 원형 정렬 상태 배열에서의 이진 탐색
// nuimbs 배열에 원형 상태로 데이터가 정렬되어 있을 때 이진 탐색으로 데이터를 찾는 프로그램을 작성
// O(log n) 유지
// 배열을 재정렬하지 않고 풀기

// 입출력 예시
// arr : 4, 5, 6, 7, 8, 0, 1, 2

// target : 0
// 출력 : 5

// target: 3
// 출력 : -1

// 풀이 idea : 배열을 재정렬 하기 때문에 기존 이진 탐색방식에서 변형되어야 함

public class BS_Practice2 {

    public static int solution(int[] arr, int target) {
        // 배열 체크
        if(arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(target == arr[mid]) {
                return mid;
            }

            // 여기서부터 기존 이진 탐색방식에서 변형
            // 상황에 맞춰 조건식 세운 다음 절반/절반 비교형태로 이진 탐색 구성
            // 4, 5, 6, 7, 0, 1, 2 원형 정렬된 상태는 중앙값보다 좌측값이 작은 경우
            if(arr[left] <= arr[mid]) {
                // target의 구간 설정 - 좌측값 < target < 중앙값 => 좌측에서 탐색
                if(target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else { // 우측 탐색
                    left = mid + 1;
                }
            // 11, 5, 6, 7, 8, 9, 10 원형 정렬된 상태는 중앙값보다 좌측값이 큰 경우
            } else {
                // target의 구간 설정 - 중앙 값 < target < 우측 값 => 우측에서 탐색
                if(target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else { // 좌측 탐색 (원형정렬 상태에서는 target이 중앙값보다 크더라도 왼쪽에 존재할 수 있기 때문)
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));
        System.out.println(solution(nums, 3));
    }
}
