package CH01.Sort;

import java.util.Arrays;

public class Sort2_1 {
    // 정렬하려는 배열을 분할하는 함수
    // tmp 배열 : mergeSort를 하기 위한 임시로 필요한 추가 메모리 공간
    // left, right : 분할을 할 때 사용할 인덱스
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            // arr을 분할한 좌측 부분
            mergeSort(arr, tmp, left, mid);
            // arr을 분할한 우측 부분
            mergeSort(arr, tmp, mid + 1, right);
            // merge 호출하여 역순으로 합병하며 올라옴
            merge(arr, tmp, left, right, mid);
        }
    }

    // 분할한 배열을 합치는 함수
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        // 데이터를 찾아서 넣기 위한 임시 인덱스
        int p = left;
        int q = mid + 1;
        int idx = p;

        // p가 mid보다 안쪽에 있거나 q가 right보다 안쪽에 있으면(OR) 각각에 대한 인덱스는 유효한 범위 안에 있음
        // 배열 안에서 좌측 기준 p는 중앙값 이전까지 유효, 우측 기준 q는 중앙값+1 부터 가장 오른쪽 이전까지 유효
        while (p <= mid || q <= right) {
            // p, q 두 값이 모두 유효범위 안에 있을 때(AND) 두 값을 비교해서 더 작은 수를 완성
            if(p <= mid && q <= right) {
                // p쪽 값이 더 작으면 tmp에 인덱스 증가시키며 tmp에 p 인덱스에 해당하는 값 할당. p 또한 인덱스이므로 증가
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else { // q가 더 작은 경우 tmp에 인덱스 증가시키며 tmp에 q 인덱스에 해당하는 값 할당. q 또한 인덱스이므로 증가
                    tmp[idx++] = arr[q++];
                }
            } else if(p <= mid && q > right) { // p만 유효범위 안에 있는 경우 (= 오른쪽에는 데이터가 다 합병되었고 왼쪽에만 합병할 데이터가 남은 경우)
                // 좌측만 남았을 때는 idx 하나씩 증가시키며 p 인덱스에 해당하는 값만 할당
                tmp[idx++] = arr[p++];
            } else { // q만 유효범위 안에 있는 경우 (= 왼쪽에는 데이터가 다 합병되었고 오른쪽에만 합병할 데이터가 남은 경우
                tmp[idx++] = arr[q++];
            }
        }

        // 정렬이 끝난 후 tmp에 넣었던 데이터를 원래 배열인 arr로 가져옴
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // 정렬 2
        // 합병 정렬
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬 : " + Arrays.toString(arr));
    }
}
