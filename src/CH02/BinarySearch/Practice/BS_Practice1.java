package CH02.BinarySearch.Practice;

// Practice1
// 이진 탐색 추가 구현
// target 값이 arr에 있으면 해당 인덱스를, 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값 반환

// 입출력 예시
// 입력 arr : 1, 2, 5, 10, 20, 30, 40, 50, 60

// target : 30
// 출력 : 5

// target : 3
// 출력 -3

// tip :
// 중간 값을 뽑을 때 배열의 길이가 엄청 길고 target값 또한 엄청 커서 우측에 편중돼있을 때 이 두 값을 더했을 때 자료형의 표현범위를 넘을 수 있음(overflow)
// 이 때는 mid를 long 타입으로 변환하거나
// mid = left + (right - left) / 2 으로 mid값을 구할 수 있다.
// 기존 mid와 차이는 left와 right가 매우 큰 수일 때 두 값을 더하면 overflow가 발생할 수 있지만, 뺄셈은 overflow를 방지할 수 있기 때문

public class BS_Practice1 {
    public static int solution (int[] arr, int target) {
        // 배열 검사
        if(arr == null || arr.length == 0) {
            return -1;
        }

        // 이진 탐색 코드는 기본과 동일
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 탐색 실패 -> left와 rigth가 만날 때
        // 탐색 실패 시 while문을 반복한 후 left 값을 부호반전 후 1 반환(해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값 반환)
        return -left - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));
        System.out.println(solution(arr, 3));
        System.out.println(solution(arr, 11));
        System.out.println(solution(arr, 35));

        // tip ex code
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE - 10;

        int minab = (a + b)/2; // overflow 발생
        int minab2 = a + (b - a) / 2; // overflow 발생하지 않고 매우 큰 값에서의 mid값 구할 수 있음. 배열의 길이가 매우 클 때 사용!
    }
}
