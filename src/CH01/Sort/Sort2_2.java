package CH01.Sort;

import java.util.Arrays;

// 힙 자료구조를 새로 생성하여 데이터를 넣지않고 heapify를 통해 기존 배열을 가지고 힙 자료구조를 변경하여 Sort

public class Sort2_2 {
    // 병렬 구성하는 함수
    public static void heapSort(int[] arr) {
        // 힙에서 자식 노드를 가질 수 있는 데이터만 추출(arr.length/2 - 1)하여 힙 자료구조 변경 대상으로 지정
        // 자식 노드를 가질 수 있는 데이터 중 가장 마지막 데이터의 인덱스에서 i를 하나씩 감소하며 힙 자료구조로 변경한다.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        } // 여기까지 최대 힙 구하는 부분

        // 최대 힙을 통한 정렬 시작
        // 최댓값을 가장 뒤로 보낸 후 heapify를 통해 정렬하면 오름차순 정렬된다.
        // 가장 끝자리부터 정렬을 마치고 하나씩 줄여가며 loop 수행
        for (int i = arr.length - 1; i > 0; i--) {
            // 최대힙은 최댓값이 항상 0번째 오므로 끝자리로 보낸다.
            swap(arr, 0, i);
            // heapify를 통해 뒤로 보낸 최댓값 다음으로 가장 큰 수가 맨 앞에 오도록 한다.
            heapify(arr, 0, i);
        } // 반복이 끝나면 수가 오름차순 정렬된다.
    }

    // 힙 자료구조로 변경하는 함수
    public static void heapify(int[] arr, int parentIdx, int size) {
        // 자식 노드의 위치를 가져오는 index
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx; // 최대 힙 자료구조를 위한 maxIdx 변수. 맥스 data를 찾아서 자식 노드들과 비교 후 더 큰 수를 앞으로 당겨올 용도이다.

        // 좌-우 자식 노드와 부모 노드를 비교하여 실제 최댓값을 찾는다.
        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        // left 또는 right Index에 해당하는 값이 더 커서 max 인덱스가 교체된 경우
        if(parentIdx != maxIdx) {
            // 교체된 maxIdx를 parentIdx와 교체
            swap(arr, maxIdx, parentIdx);
            // 교체된 노드가 자식 노드를 가지면 추가적인 자리교체가 필요할 수 있으므로 heapify 재귀호출
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // 정렬 2
        // 힙 정렬
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        heapSort(arr);
        System.out.println("힙 정렬 : " + Arrays.toString(arr));
    }
}
