package CH01.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sort3_1 {

    public static void radixSort(int[] arr) {
        // 기수 정렬은 큐로 구성된 기수 테이블이 필요
        ArrayList<Queue<Integer>> list = new ArrayList<>();

        // 반복문 수행하며 기수 테이블 준비 (해당 테이블은 매 정렬 회차마다 테이블에 데이터를 채우고 비우고를 반복함)
        for (int i = 0; i < 10; i++) {
            // 기수 테이블 안에서 필요한 0~9까지의 테이블 준비
            // 해당 자리에 데이터가 생길 때 마다 아래의 LinkedList에 연결
            list.add(new LinkedList<>());
        }

        // 인덱스로 사용할 변수와 나누며 자리찾을 때 쓸 변수 할당
        int idx = 0;
        int div = 1; // 맨 처음은 1의 자리수 이므로 1
        int maxLen = getMaxLen(arr);

        // 기수 정렬 반복
        // 첫번째 loop는 0부터 자릿수까지 반복
        for (int i = 0; i < maxLen; i++) {
            // 아래 loop는 각 자리에 맞는 큐 위치에 데이터를 넣어줌
            // ex) 1의 자리의 처음부터 배열의 길이 만큼 반복
            for (int j = 0; j < arr.length; j++) {
                // ex) 데이터를 1의 자리로 나누고 (10/1 = 10) 10 나머지 연산을 하면 0~9 사이의 인덱스가 구해지므로(10 % 10 = 0), 구해진 인덱스에 해당하는 큐에 데이터 넣음
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            // 아래 loop는 위 loop에서 넣어준 데이터를 순서대로 가져와서 배치
            for (int j = 0; j < 10; j++) {
                // 가장 낮은 자리로 정렬한 큐부터 가장 높은 자리로 정렬한 큐를 가져옴
                Queue<Integer> queue = list.get(j);

                // 큐가 빌 때 까지 각 자리별로 정렬한 데이터를 arr에 할당
                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }

            // 다음 자릿수 반복을 위해 변수 초기화
            idx = 0;
            div *= 10; // 1의 자릿수 반복 이후 10의 자릿수 그리고 100의 자릿수 반복이 가능하도록 초기화
        }
    }

    // 기수 정렬을 몇번 반복할지는 기수 테이블 속 데이터의 최대 자리수가 필요하기 때문에 최대 자리수를 구하는 함수 작성
    // 파라미터로 배열을 받아서 배열 내의 가장 긴 자리수의 데이터를 찾아서 해당 값을 반환
    public static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1; // 숫자의 길이 구함 (10~99는 2, 100~999는 3 이런 방식으로)
            // 배열 속에서 더 큰 자릿수를 가진 수가 나올 때 마다 교체
            if(maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 정렬 3
        // 기수 정렬
        // 기수 테이블 생성 -> 자릿수 얻은 다음 -> 자릿수만큼 반복
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬 : " + Arrays.toString(arr));
    }
}
