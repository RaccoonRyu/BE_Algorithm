package CH01.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Sort3_2 {

    public static void countingSort(int[] arr) {
        // 계수 정렬은 계수 테이블 필요 - 계수 테이블은 배열에서 가장 최댓값을 찾은 다음 해당 최댓값 만큼을 사이즈로 만들어준다.
        // 배열 내 최댓값 구함
        int max = Arrays.stream(arr).max().getAsInt();
        // 계수 테이블 생성
        int[] cntArr = new int[max + 1];

        // loop 수행하며 계수테이블에 정렬하려는 값을 계수 테이블의 인덱스로 삼고, 해당 인덱스를 갖는 계수 테이블의 값 1 증가(수를 셌다는 의미)
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        // 정렬을 위한 인덱스
        int idx = 0;
        // 계수 테이블 순회하며 정렬
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                // 위의 로직을 수행하고나면 데이터를 arr에 정렬했으므로 집계 테이블이 가진 수를 1씩 뺌
                cntArr[i] -= 1;
            }
        }

        // 정렬하려는 배열에 유독 너무 큰 값(ex 10, 10, 10000000)이 있으면 메모리 효율성이 떨어지므로 HashMap 사용하여 해결
        // 이 경우 정렬하려는 배열의 길이만큼 HashMap이 생성되므로 메모리를 효율적으로 사용가능
        // ex)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            // map에 item을 key로 넣고, value에는 key가 있으면 해당 key 값 없으면 0 가져온다음 + 1하여 put
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int idx2 = 0;
        // Key값들을 가져와서 각 데이터가 몇개씩 들어있는지에 대한 테이블 구성
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        // Key의 순서 보장을 위한 정렬
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while (cnt > 0) {
                arr[idx2++] = list.get(i);
                cnt--;
            }
        }

    }

    public static void main(String[] args) {
        // 계수 정렬
        int[] arr = {10, 10, 32, 52, 27, 48, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬 : " + Arrays.toString(arr));
    }
}
