package CH02.BinarySearch;

import java.util.Arrays;

public class BinarySearch2 {

    public static void main(String[] args) {
        // 이진 탐색 2
        // Java에서 기본 제공하는 이진 탐색 사용
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("** 찾는 데이터가 있는 경우 **");
        // Arrays.binarySearch(배열, 찾는 값) : Java가 기본 제공하는 이진 탐색함수
        System.out.println(Arrays.binarySearch(arr, 1)); // 0
        System.out.println(Arrays.binarySearch(arr, 10)); // 3
        System.out.println(Arrays.binarySearch(arr, 30)); // 5

        System.out.println("** 찾는 데이터가 없는 경우 **");
        // 데이터가 없는 경우에는 key값이 배열에 있어야 하는 인덱스에 1을 더한 후 음수를 취한다.
        // ex) 3은 arr 배열의 2번 인덱스에 있어야 하지만 (2 < 3 < 5), 없기 때문에 -(2+1)
        // 이는 해당 데이터를 삽입하는 위치를 파악하는데 사용할 수 있다.
        // ex) 현재 arr에서 3을 이진탐색하면 -3을 반환하므로 부호반전 후 1을 빼면 2번 인덱스에 삽입하면 된다.
        System.out.println(Arrays.binarySearch(arr, 3));
        System.out.println(Arrays.binarySearch(arr, 11));
        System.out.println(Arrays.binarySearch(arr, 35));

    }
}
