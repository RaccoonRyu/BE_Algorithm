package CH03.TwoPointer;

import java.util.Arrays;

public class TwoPointer1 {

    public static int[] forLoop(int[] arr, int target) {
        // 부분합이 9가 되는 구간으로(인덱스) 사용할 배열을 -1 원소로 초기화
        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i]; // i번째 값에 j loop의 값을 더해주며 9가 되는 부분 찾기위한 변수
            for (int j = i + 1; j < arr.length; j++) {
                if(sum == target) { // sum이 target과 같을 때 배열 0번에는 i, 1번에는 j-1를 대입하면 부분합이 target인 구간이 된다.
                    result[0] = i;
                    result[1] = j - 1;
                    break; // 제일 빠른 해당 구간 하나만 찾을 것이므로 반복문 탈출
                }
                // sum이 target과 같지 않을 때는 j번째 값을 계속 더함
                sum += arr[j];
            }

            // 두번째 loop를 탈출하면 target을 찾은 것이므로 첫번째 loop도 탈출
            if(sum == target) {
                break;
            }
        }
        // 찾은 구간 출력
        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        // 포인터로 사용할 변수 생성
        int p1 = 0;
        int p2 = 0;

        // 부분합과 결과를 표현할 변수 및 배열 생성
        int sum = 0;
        int[] result = {-1, -1};

        // loop 수행하며 target과 sum 비교
        while (true) {
            // sum이 target보다 크다면 sum에서 p1에 해당하는 arr값을 뺌
            if(sum > target) {
                // arr[p1]이 구간을 벗어난 값이기 때문에 sum에서 빼준다. 이후 p1이 증가한다.
                sum -= arr[p1++];
            } else if(p2 == arr.length) { // p2가 배열 끝까지 도달했음에도 sum값을 찾아내지 못한 경우 탈출
                break;
            } else { // p2위치를 증가시키며 sum에 p2위치에 해당하는 값 더함
                // 이후 p2 증가
                sum += arr[p2++];
            }

            if(sum == target) { // sum이 target값과 같으면 구간 업데이트
                result[0] = p1;
                result[1] = p2 - 1;
                break;
            }
        }
        // 결과를 나타내는 구간 반환
        return result;
    }


    public static void main(String[] args) {
        // 투 포인터 예제
        // for-loop vs two pointers

        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14))); // 14가 될 수 있는 구간은 없기 때문에 -1, -1 리턴되어 출력

        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
    }
}
