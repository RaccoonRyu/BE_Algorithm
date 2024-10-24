package CH02.BinarySearch.Practice;

// Practice4
// 정수형 배열 weights와 정수 days가 주어졌다
// weights에는 각 상품의 무게들의 정보가 들어있고, days는 운송 납기일이다.
// 상품들은 weights에 적혀있는 순서대로 실어서 운송해야하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시

// weights : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days : 5
// 출력 : 15

// weights : 3, 2, 2, 4, 1, 4
// days : 3
// 출력 : 6

// idea : 적재할 상품들의 무게를 days로 구간 나눔 한 후, 각 구간 내 무게들의 합을 모두 커버할 수 있는 최소 적재량을 구한다!
// 이 때 최소한의 적재량을 구하는 힌트는 배열 내 최댓값과 배열 내 모든 요소의 합이다.
// => 적어도 최댓값 이상은 한번에 운반해야 하고, 하루에 모든 물건을 다 보낸다고 하면 이는 곧 배열 요소의 합과 같기 때문
// 따라서 배열 내 최댓 값(새 배열의 최솟값) < 최소한의 적재량 < 배열 내 모든 요소의 합(새 배열의 최댓값)을 정렬된 상태의 배열이라고 생각하여 이진 탐색을 진행하면 된다.
// 즉, 문제에 주어진 배열을 가지고 바로 이진 탐색을 하는 것이 아닌 문제 조건에 맞게 배열을 변형한 후 이진 탐색

public class BS_Practice4 {

    public static int solution(int[] weights, int days) {
        // 빈 배열 체크
        if(weights == null || weights.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        // 적재량을 조건에 적합한 배열로 변경
        for (int w : weights) {
            left = Math.max(left, w); // 하나만 옮길 때의 최댓 값
            right += w; // 모든 물건을 한번에 옮길 때의 값
        }

        // 이진 탐색 수행
        while (left <= right) {
            // target으로 하는 적재량을 구하기 위한 중앙값
            int mid = (left + right) / 2;
            // 해당 적재량을 가지고 무게들을 며칠만에 옮길 수 있는지 계산하기 위한 변수
            int cnt = 1; // 배송에 필요한 일수
            int cur = 0; // 현재까지의 무게

            for(int w : weights) {
                // 무게들을 하나씩 더해나가며 적재량을 넘을 때 마다 필요 날짜를 증가
                if(cur + w > mid) { // 현재까지의 무게+그 다음 무게 가 적재량을 넘으면 필요 일수를 증가
                    cnt += 1;
                    cur = 0; // 날짜가 넘어가면서 현재 무게는 0 초기화
                }
                // 현재 무게에 무게를 누적
                cur += w;
            }

            if(cnt > days) { // 계산한 필요일수가 납기일을 넘으면 현재 적재량으로는 부족하므로 중앙값보다 더 큰 적재량 필요(우측 탐색)
                left = mid + 1;
            } else { // 필요일수가 납기일보다 여유있는 경우 중앙값보다 더 작은 적재량 필요(좌측 탐색)
                right = mid - 1;
            }
        }
        // loop 모두 수행된 후의 left값이 최소 적재량!
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));
    }
}
