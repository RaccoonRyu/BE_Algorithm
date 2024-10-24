package CH02.BinarySearch.Practice;

// Practice2
// 2차원 행렬에서 이진 탐색으로 데이터 찾기
// row x col 행렬 데이터가 주어졌을 때, target을 이진 탐색으로 찾는 프로그램을 작성
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// arr : {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}

// target : 3
// 출력 : true

// target : 13
// 출력 : false

// idea :

public class BS_Practice3 {

    public static boolean solution(int[][] matrix, int target) {
        // 배열 검사
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;

        // 이차원 배열 이진 탐색을 위해 right 조정
        int rows = matrix.length; // right 조정을 위한 행 수 계산
        int cols = matrix[0].length; // right 조정을 위한 열 수 계산
        int right = rows * cols - 1; // 행*열-1 하면 2차원 행렬의 가장 끝 인덱스를 가리킴

        // 이진 탐색 시작
        while(left <= right) {
            int mid = (left + right) / 2;

            // 중간값과 타켓값 비교하여 좌우 분할
            // 2차원 배열에서의 접근 방식 : 2차원배열[중앙값/열수][중앙값%열수] == target이면 mid 반환할 수 있음(true)!
            // 중앙값/열수 = 2차원배열 데이터의 중앙값에 해당하는 행 위치
            // 중앙값%열수 = 2차원배열 데이터의 중앙값에 해당하는 열 위치
            // ex) 3행 4열의 데이터 => left 0 / right 11 => mid = 5 이므로 2차원 배열 전체 데이터 중 5번 인덱스 데이터(6-1)가 중앙값. matrix[1][1]이 5번 인덱스 데이터.
            // 실제 중앙값이 맞는지 확인 => 행 위치 mid / cols : 5/4 = 1, 열 위치 mid % cols : 5%4 = 1. 중앙값은 matrix[1][1]으로 위와 일치한다.
            if(matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / cols][mid % cols] < target) { // target값이 중앙값보다 큰 경우 (우측 탐색)
                left = mid + 1;
            } else { // target값이 중앙값보다 작은 경우 (좌측 탐색)
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3)); // t
        System.out.println(solution(matrix, 13)); // f
        System.out.println(solution(matrix, 35)); // t
    }
}
