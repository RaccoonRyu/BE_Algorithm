package CH03.TwoPointer.Practice;

// Practice2
// nums1과 nums2 두 배열이 주어졌을 때 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성
// 결과 배열의 원소에는 중복값이 없도록 하며 출력 순서는 상관 없음

// 입출력 예시
// 입력 : nums1 1, 2, 2, 1 / nums2 2, 2
// 출력 : 2

// 입력 : nums1 4, 9, 5 / nums2 9, 4, 9, 8, 4
// 출력 : 4, 9(or 9, 4)

// idea : 투 포인터를 이용하여 각 배열마다 하나씩 포인터를 이동시키며 서로 크고 작은지를 비교 + 오름차순이 되어있다면 쉽기 때문에 정렬 진행

import java.util.Arrays;
import java.util.HashSet;

public class TwoPointer_Practice2 {

    public static int[] solution(int[] nums1, int[] nums2) {
        // 데이터 비교를 위한 HashSet 생성
        HashSet<Integer> set = new HashSet<>();

        // 배열들 정렬 (오름차순)
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 포인터 2개 (처음부터 시작)
        int p1 = 0;
        int p2 = 0;

        // loop를 통한 비교 시작
        while (p1 < nums1.length && p2 < nums2.length) {
            // 배열이 오름차순 되어있으므로, nums1[p1] < nums2[p2]라면 p1을 올려가며 p2과 같은지 더 커지는지 비교
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) { // 배열이 오름차순 되어있으므로, nums1[p1] > nums2[p2]라면 p2을 올려가며 p1과 같은지 더 커지는지 비교
                p2++;
            } else { // nums1[p1] == nums2[p2] 인 상황
                // nums1[p1] == nums2[p2] 이면 HashSet에 둘 중 무슨 값을 넣든 무관
                // HashSet이므로 중복 데이터는 들어가지 않는다.
                set.add(nums1[p1]);
                // 이후 loop를 위해 p1, p2값 증가
                p1++;
                p2++;
            }
        } // loop가 끝나면 HashSet에 공통된 원소 데이터가 들어감

        // HashSet을 다시 int[]로 변환하여 return
        int[] result = new int[set.size()];
        int idx = 0;
        // set 안의 요소를 꺼내 result에 넣는 for-each loop
        for(Integer n : set) {
            result[idx++] = n;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
