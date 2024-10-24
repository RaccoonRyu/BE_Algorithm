package CH02.BinarySearch.Practice;

// Practice5
// 정수형 배열 nums와 정수 m이 주어졌다
// nums에는 양의 정수 값들이 들어있고, m은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums 배열을 m 개의 부분 배열로 분리할 때,
// 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력

// 입출력 예시
// nums : 7, 2, 5, 10, 8
// m : 2
// 출력 : 18

// nums : 1, 2, 3, 4, 5
// m : 2
// 출력 : 9

// idea : nums를 통해 배열을 가공하기 -> 부분 배열의 합 중 가장 큰 값이 최소여야 하므로, 부분 배열의 합 범위를 구한 다음 이진 탐색시작!
// 부분 배열 중 최솟값은 모든 요소를 1개씩 분리한 것 중에 제일 큰 값
// 부분 배열 중 최댓값은 모든 요소를 분리하지 않고 합한 값
// 이렇게 구한 최소-최댓값 사이에서 이진 탐색을 수행한다.

public class BS_Practice5 {

    public static int solution(int[] nums, int m) {
        // 배열 체크
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // 새로운 탐색 범위를 위한 좌-우변수 설정
        int left = 0;
        int right = 0;

        // 기존 배열을 통해 새로운 이진 탐색범위 설정
        for(int num : nums) {
            left = Math.max(num, left); // 부분 배열 중 최솟값 : 모든 요소를 1개씩 분리한 것 중에 제일 큰 값
            right += num; // 부분 배열 중 최댓값 : 모든 요소를 분리하지 않고 합한 값
        }

        if(m == 1) { // 분리하지 않음을 의미하므로 모두 더한 값을 반환
            return right;
        }

        // 이진 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2;
            // mid 값을 통해 부분 배열의 합을 구했을 때 몇 개의 부분배열으로 분리되는지 세기 위한 변수
            int cnt = 1;
            // 분리했을 때 부분 배열의 최댓값
            int total = 0;

            for (int num : nums) {
                total += num;
                if(total > mid) { // 부분배열의 합이 중앙값을 넘으면 num값 전까지가 하나의 부분 배열
                    // 더했지만 중앙값을 넘었던 num값 전 까지의 값이 하나의 부분 배열의 합이므로 다음 부분집합을 위해 total에 대입
                    total = num; // 새로운 부분 배열 시작
                    // 부분 배열 개수 증가
                    cnt++;
                }
            }

            if(cnt <= m) { // cnt가 m보다 작으면 좌측 검사(중앙값보다 더 작은 부분 배열 합의 최솟값이 있음)
                right = mid - 1;
            } else { // cnt가 m보다 크면 우측 검사(중앙값보다 더 큰 부분 배열 합의 최솟값이 있음)
                left = mid + 1;
            }
        }

        // loop 모두 수행된 후의 left값이 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 합!
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));

        nums = new int[]{1, 4, 4};
        System.out.println(solution(nums, 3));
    }
}
