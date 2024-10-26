package CH00.Math.Permutation;

// Practice1
// 1, 2, 3, 4를 이용하여 세자리 자연수를 만드는 방법(순서 O, 중복 X)의 각 결과를 출력하시오
// 순열 사용

public class Permutation_Practice1 {
    public static void permutation(int[] arr, int depth, int n, int r) {

        // 자릿수에 맞는 수가 만들어졌을때 출력 (depth == r)
        if(depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 기본 구조는 for문으로 자기 자신 함수를 호출하고, depth를 하나씩 늘려주며 세자리 자연수의 자리를 만들어줌
        for (int i = depth; i < n; i++) {
            // 자릿수를 변경해준 다음 permutation 호출
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            // 위의 과정이 끝나면 다시 원래대로 자릿수를 변경
            swap(arr, depth, i);
        }

    }

    // 자릿수를 변경해주는 코드
    // 배열, 몇번째 자리수인지를 의미하는 depth, 바꿀 자리의 위치인 idx
    public static void swap(int[] arr, int depth, int idx) {
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        // n은 자연수 개수, 3은 자연수의 자릿수, depth는 각 자리수 (0 : 1의 자리, 1 : 10의 자리 ...)
        permutation(arr, 0, 4, 3);
    }
}
