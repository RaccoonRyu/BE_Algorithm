package CH01.Sort;

import java.util.Arrays;

public class Sort3_3 {

    public static void shellSort(int[] arr) {
        // 초기 gap 설정 (보통 배열의 길이/2)
        int gap = arr.length/2;

        // 정렬을 위해 초기 gap부터 2로 나눠가면서 loop 수행. 감소하며 왼쪽으로 이동
        for (int g = gap; g > 0 ; g /= 2) {
            // gap 간격을 이용하여 정렬 시작 (gap 간격을 가지고 삽입 정렬)
            // i는 오른쪽으로 증가하며 이동
            for (int i = g; i < arr.length; i++) {
                // gap 인덱스의 arr 값을 tmp에 저장
                int tmp = arr[i];
                // j는 i - g 의 구간을 g만큼 빼며 왼쪽 이동
                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if(arr[j] > tmp) {
                        arr[j + g] = arr[j];
                    } else {
                        break;
                    }
                }
                // 바로 위 loop가 끝나면 tmp값을 j + g 인덱스의 arr에 저장
                arr[j + g] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        // 쉘 정렬
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("쉘 정렬 : " + Arrays.toString(arr));
    }
}
