package CH00.Math.Combitation;

// Practice
// 1, 2, 3, 4,를 이용하여 세자리 자연수를 만드는 방법 (순서 X, 중복 X)의 각 결과를 출력 -> 조합!
// 주의사항 : 이전 순열과 다르게, 예를 들어 1 2 3 / 2 3 1 / 1 3 2는 다른 케이스가 아니므로, 1 2 3만 뽑혀야 한다는 점에 유의!


public class Combination_Practice1 {

    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {

        // 재귀 호출의 탈출 조건 -> r을 1씩 빼면서 호출하기 때문에 r을 비교
        // 탈출과 동시에 출력
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                // visited 배열 값이 true인 인덱스의 값들만 출력
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // 출력은 다 되지 않았지만 함수가 끝까지 다 도는 경우 탈출
        // depth가 배열의 가장 끝(배열이 가지고있는 수의 끝)까지 도달한 경우
        if(depth == n) {
            return;
        }

        // visited 배열을 사용하여 해당 자릿수를 방문 했는지 안했는지를 비교하며 출력
        // 현재 depth에 해당하는 위치의 visited 배열 값을 true로 변경
        visited[depth] = true;
        // 이후 재귀형태로 자기 자신 호출
        combination(arr, visited, depth + 1, n, r - 1);
        // 해당 호출이 끝난 다음에는 depth에 해당하는 위치의 visited 배열 값을 false로 변경
        visited[depth] = false;
        // 다시 호출할 때는 depth만 하나 증가
        combination(arr, visited, depth + 1, n, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = {false, false, false, false};


        combination(arr, visited,0, 4, 3);
    }
}
