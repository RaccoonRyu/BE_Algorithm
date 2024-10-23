package CH01.Sort;

import java.util.Arrays;

public class Sort2_3 {

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) { // 왼쪽이 오른쪽보다 크거나 같을 때 탈출
            return;
        }

        // partition 함수를 통해 피벗 값 반환
        int pivot = partition(arr, left, right);

        // 이후 pivot을 기준으로 좌측, 우측에 대한 퀵 정렬을 재귀호출
        // pivot 자리는 정렬 상 제자리를 찾았으므로 제외하고 좌-우 퀵 정렬을 재귀호출 한다.
        // 좌측 퀵 정렬
        quickSort(arr, left, pivot -1);
        // 우측 퀵 정렬
        quickSort(arr, pivot + 1, right);
    }

    // pivot을 설정하는 함수
    public static int partition(int[] arr, int left, int right) {
        // 우선 가장 왼쪽 데이터를 pivot으로 설정
        int pivot = arr[left];
        // 왼쪽부터 움직일 인덱스
        int i = left;
        // 오른쪽부터 움직일 인덱스
        int j = right;

        // 왼쪽과 오른쪽이 만날 때 까지 loop 수행하며
        while (i < j) {
            // 오른쪽 값이 피벗보다 크고 왼쪽과 만나기 전 까지 loop 수행하며 j 감소 (피벗값보다 작은 값을 우->좌 방향으로 탐색하기 위해)
            while (arr[j] > pivot && i < j) {
                j--;
            }

            // 왼쪽 값이 피벗보다 작거나 같고 오른쪽과 만나기 전 까지 loop 수행하며 i 증가 (피벗값보다 큰 값을 좌->우 방향으로 탐색하기 위해)
            while (arr[i] <= pivot && i < j) {
                i++;
            }

            // 인덱스 i, j를 통해 찾은 값을 가지고 pivot값 swap
            swap(arr, i, j);
        }

        // 반복 이후 pivot값의 자리를 i와 j가 만난 위치인 i자리 로 바꿔줌
        swap(arr, left, i);

        // 바뀐 pivot 자리인 i를 반환
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // 정렬 2
        // 퀵 정렬
        // 배열이 주어졌을 때 특정 기준값(pivot)을 설정하고
        // 좌측에서부터 pivot보다 큰 값, 우측에서는 pivot보다 작은 값을 찾아서 찾은 두 값을 자리교체 반복한다.
        // 반복 중 우측과 좌측 인덱스가 만났을 때 해당 지점과 pivot값을 교체하며 정렬한다.
        // 이후 교체된 pivot 값을 중심으로 좌측, 우측에 대한 퀵 정렬을 재귀적으로 수행한다.
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬 : " + Arrays.toString(arr));
    }
}
