package CH01.Sort.Practices;

// Practice4
// 정수 배열 nums가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.
// 정렬이 필요한 구간의 길이 : 해당 구간만을 정렬하면 전체 배열이 오름차순으로 정렬되는 구간의 길이.
// 큰 값 다음 작은 값이 나타나는 부분에서 구간의 시작과 끝을 포착할 수 있다.

// 입출력 예시
// 입력 : 2, 6, 4, 8, 5, 3, 9, 10
// 출력 : 5
// 입력 : 1, 3, 1
// 출력 : 2

// 정렬 idea
// 1. 구간을 설정하기 위해 먼저 오름차순이 일어나지 않는 부분을 찾습니다.
//    - 왼쪽에서 오른쪽으로 진행하며, 큰 값 다음 작은 값이 나오는 부분이 구간의 시작점입니다.
// 2. 구간의 시작점과 끝점을 결정합니다.
//    - 구간의 좌측 끝은 해당 구간에 들어가기 전에 첫 번째로 큰 값보다 작은 값이 나오는 시점입니다.
//    - 구간의 우측 끝은 구간 안의 값보다 큰 첫 번째 값을 만날 때까지 확장됩니다.
// 3. 해당 구간의 길이를 반환합니다.

public class Sort_Practice4 {

    public static int solution(int[] nums) {
        // nums의 비어있음 검사
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 최솟값으로 사용할 변수
        int min = Integer.MAX_VALUE;
        // 가장 좌측의 값을 찾을 인덱스 변수
        int firstIdx = 0;

        // loop 수행하며 가장 좌측 값 찾기
        // min값을 갱신하면서 가장 작은값보다 더 큰 값이 왼쪽에 있는지를 우->좌 방향으로 검사하며 찾기
        for (int i = nums.length - 1; i >= 0; i--) {
            // Math.min() : 최솟값 비교
            min = Math.min(min, nums[i]);
            // min과 i번째 배열 값을 비교하며 가장 좌측의 값을 찾기위한 코드
            if(nums[i] > min) {
                firstIdx = i;
            }
        }

        // 최댓값으로 사용할 변수
        int max = Integer.MIN_VALUE;
        // 가장 우측의 값을 찾을 인덱스 변수
        int lastIdx = -1;
        // loop 수행하며 가장 우측 값 찾기
        // 좌->우 방향으로 가장 큰 값보다 더 작은 값이 오른쪽에 있는지를 검사하며 찾기
        for (int i = 0; i < nums.length; i++) {
            // Math.max() : 최댓값 비교
            max = Math.max(max, nums[i]);
            // max보다 작은 값이 오른쪽에 있으면 해당 값이 구간의 가장 우측 값이다.
            if(nums[i] < max) {
                lastIdx = i;
            }
        }

        // 결과 반환 (구간의 길이 : lastIdx - firstIdx + 1)
        return lastIdx - firstIdx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
