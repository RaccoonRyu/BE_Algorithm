package CH03.TwoPointer.Practice;

// Practice4
// 주어진 nums 배열에서 3개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 set은 제외하고 출력하세요

// 입출력 예시
// 입력 : nums {-1, 0, 1, 2, -1, -4}
// 출력 : [[-1, -1, 2], [-1, 0, 1]]

// 입력 : nums {1, -7, 6, 3, 5, 2}
// 출력 : [[-7, 1, 6], [-7, 2, 5]]

// idea
// - 배열이 오름차순으로 정렬되면 편함 => 3개 숫자를 더했을 때 0이 되어야 하니 배열 내 최솟값을 비교대상으로 고정한 다음 포인터 두개(1~끝 인덱스)를 사용한다.
// - 위에서 고정된 가장 작은 수 + p1 위치 값 + p2 위치 값 < 0이면 p1을 오른쪽으로 이동, 반대의 경우에는 p2를 왼쪽으로 이동
// - p1와 p2가 만났음에도 0이 되는 값을 찾지 못했다면 최솟값 바로 다음 값을 비교대상으로 변경 후 p1과 p2 재설정을 반복한다.

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointer_Practice4 {

    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        // 들어오는 배열 정렬
        Arrays.sort(nums);

        // 결과 반환용 변수
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // 최솟값을 움직이는 바깥쪽 for loop
        // 안쪽 for문에서 두개 포인터를 사용할 것이기 때문에 배열의 길이 - 2 해준다.
        for (int i = 0; i < nums.length - 2; i++) {
            // i가 0일때 또는 i가 0보다 크면서 연속되는 숫자가 같지 않으면 아래 코드 실행 => 중복된 숫자 조합을 피하기 위해 해당 조건 사용
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int p1 = i + 1;
                int p2 = nums.length - 1;
                // 추후 비교를 위해 sum값을 부호 반전 => nums[p1] + nums[p2] + nums[i] == 0과 동일해짐
                int sum = 0 - nums[i];

                // 포인터 둘이 만날 때 까지 이동하면서 세개 숫자의 합이 0이 되는지 검사
                while (p1 < p2) {
                    // 세개 숫자를 합쳐서 0이 되는 경우 ArrayList 안에 3개의 숫자가 들어간 ArrayList 추가
                    if (nums[p1] + nums[p2] == sum) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));

                        // 포인터를 이용한 중복 제거
                        // 연속된 같은 수가 나왔을 때 건너 뛰기
                        while(p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }

                        while(p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }

                        // 포인터 한칸씩 이동
                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] < sum) { // 3개 숫자를 합쳤을 때 0보다 작으면 p1 우측 이동
                        p1++;
                    } else { // 3개 숫자를 합쳤을 때 0보다 크면 p2 좌측 이동
                        p2--;
                    }
                }
            }
        }
        // 세개 숫자의 합이 0이 되는 set들이 중복없이 들어간 result 반환
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution(nums));

        nums = new int[]{1, -7, 6, 3, 5, 2};
        System.out.println(solution(nums));
    }
}
