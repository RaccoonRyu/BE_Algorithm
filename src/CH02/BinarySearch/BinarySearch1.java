package CH02.BinarySearch;

public class BinarySearch1 {

    // 반복문 구조
    public static int binarySearch(int[] arr, int target) {
        // 배열의 왼쪽, 오른쪽 인덱스
        int left = 0;
        int right = arr.length - 1;

        // 왼쪽과 오른쪽이 만날 때 까지 loop 수행하며 mid값 찾기
        while(left <= right) {
            int mid = (left + right) / 2; // 중앙값 인덱스

            // 중앙값과 target이 같다면 중간값 인덱스 반환
            if(target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) { // target이 중앙값보다 작으면 중앙값 좌측부분 이진 탐색
                // 이진 탐색을 위한 오른쪽 인덱스가 중앙값 바로 왼쪽으로 변경
                right = mid - 1;
            } else { // target이 중앙값보다 큰 경우 중앙값 우측 부분 이진 탐색
                // 이진 탐색을 위한 왼쪽 인덱스가 중앙값 바로 오른쪽으로 변경
                left = mid + 1;
            }
        }

        // 반복문을 모두 수행했음에도 중앙값을 찾지 못했을 경우에는 target에 해당하는 데이터가 없다는 의미로 -1 return
        return -1;
    }

    public static int binarySearch2(int[] arr, int target, int left, int right) {
        // 재귀 호출의 탈출 조건
        if(left > right) {
            return -1;
        }

        // 중앙값
        int mid = (left + right) / 2;

        if(target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) { // target이 중앙값보다 작으면 중앙값 좌측부분 이진 탐색
            // 좌측부 이진 탐색을 위한 재귀함수 호출
            // 호출 시 타겟이 중앙값보다 작으므로 left는 그대로, right는 mid-1 한 인덱스를 조정하여 호출한다.
            return binarySearch2(arr, target, left, mid - 1);
        } else { // target이 중앙값보다 큰 경우 중앙값 우측 부분 이진 탐색
            // 호출 시 타겟이 중앙값보다 크므로 left는 mid+1, right는 변경없이 인덱스를 조정하여 호출한다.
            return binarySearch2(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        // 이진 탐색
        // 반복문 구조로 탐색 or 재귀 호출 구조로 탐색
        // 이진 탐색은 정렬이 된 데이터 중 특정 값을 찾기 때문에 배열은 오름차순 정렬된 상태
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index : " + binarySearch(arr, 30));
        System.out.println();

        System.out.println("Index : " + binarySearch2(arr, 30, 0, arr.length - 1));
    }
}
