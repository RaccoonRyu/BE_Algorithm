package CH00.Math.Permutation;

// Practice2
// 1, 2, 3, 4를 이용하여 세자리 자연수를 만드는 방법(순서 O, 중복 X)의 각 결과를 출력하시오
// 순열 사용

import java.util.Arrays;

public class Permutation_Practice2 {
    // visited 배열을 사용하여 해당 자릿수를 방문 했는지 안했는지를 비교하며 출력
    public static void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {

        // 출력
        if(depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        // 재귀함수 호출
        for (int i = 0; i < n; i++) {
            // 해당 자릿수 방문한 적이 없다면
            if(visited[i] != true) {
                visited[i] = true; // 방문했으므로 true로 변경
                out[depth] = arr[i]; // out 배열의 depth번 자리에 arr 배열의 i번 자리 값 대입
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];

        permutation(arr, 0, n, r, visited, out);
    }
}
