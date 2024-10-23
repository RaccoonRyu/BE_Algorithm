package CH01.Sort;

import java.util.Arrays;

public class Sort1 {

    // 버블 정렬
    public static void bubbleSort(int[] arr) {
        // i를 1부터 늘려가며 j의 끝을 하나씩 줄여가는 방법
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                // 앞의 값이 바로 뒤의 값 보다 크면 자리바꿈
                if(arr[j] > arr[j+1]) {
                    // 교환을 위한 임시 변수 tmp
                    int tmp = arr[j];
                    // 데이터 교환
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        /*// 아래와 같이 작성해도 된다.
        // i를 가장 끝으로 지정한 다음 i를 줄여가며 j의 끝을 줄여가는 방법(i가 감소하기 때문에)
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    // 교환하는 방법은 늘려가는 방법과 동일
                    // 교환을 위한 임시 변수 tmp
                    int tmp = arr[j];
                    // 데이터 교환
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }*/
    }

    // 삽입 정렬
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // j를 줄여가며 앞쪽과 비교하여 정렬
            for (int j = i; j > 0; j--) {
                // 현재 데이터가 앞쪽 데이터보다 작은 경우 자리바꿈
                if(arr[j] < arr[j-1]) {
                    // 교환을 위한 임시 변수 tmp
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else { // 앞의 데이터가 이미 정렬돼있으면(if문 결과 false) 더 이상 비교할 필요 없으므로 두번째 for문에서 정렬 않고 탈출
                    break;
                }
            }
        }
    }

    // 선택 정렬
    public static void selectionSort(int[] arr) {
        /*// 최솟값을 뽑는 형태로 구현
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // 최솟값의 인덱스
            for (int j = i + 1; j < arr.length; j++) {
                // 최솟값과 비교하여 최솟값보다 작은 값이 최솟값
                if(arr[j] < arr[min]) {
                    min = j; // j 인덱스의 값이 최솟값이므로 최솟값의 인덱스인 min값을 갱신
                }
            }
            // 최솟값에 해당하는 데이터 교환
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }*/

        // 최댓값을 뽑는 형태로 구현
        // 최댓값을 찾아서 뒤로 보내야하므로 i를 감소시키며 정렬
        for (int i = arr.length - 1; i > 0; i--) {
            int max = i;
            // j 또한 감소시키며 정렬
            for (int j = i - 1; j >= 0; j--) {
                // 최댓값과 비교하여 최댓값보다 작은 값이 최댓값
                if(arr[j] > arr[max]) {
                    max = j; // j 인덱스의 값이 최댓값이므로 최댓값의 인덱스인 max 갱신
                }
            }
            // 최댓값에 해당하는 데이터 교환
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
    }

    public static void main(String[] args) {
        // 정렬 1

        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬 : " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬 : " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬 : " + Arrays.toString(arr));
    }
}
