package CH01.Sort.Practices;

// Practice2
// 문자열 배열 strs가 주어졌을 때 anagram으로 묶어서 출력하는 프로그램을 작성
// anagram : 철자 순서를 바꾸면 같아지는 문자 ex) elvis <-> lives
// anagram 그룹 내에서 출력 순서는 상관 없다

// 입출력 예시
// 입력 : "eat", "tea", "tan", "ate", "nat", "bat"
// 출력 : [[eat, tea, ate], [bat], [tan, nat]]

// 정렬 idea : eat든 ate든 정렬하면 aet가 된다. 즉 정렬 후 같은 문자열이 되면 애너그램!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sort_Practice2 {

    public static ArrayList<ArrayList<String>> solution(String[] strs) {
        // 문자열 배열의 비어있음 검사
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] cArr = s.toCharArray();
            // 정렬 시작
            sort(cArr);
            String key = String.valueOf(cArr); // 정렬한 문자 배열을 String으로 변환

            // 정렬된 문자열을 key로 Map에 들어있음 여부 확인
            if(!map.containsKey(key)) { // 문자열과 같은 Key 값이 Map 안에 없다면 put (해당 Key로 데이터가 최초로 들어온다면)
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s); // key를 이용해 map의 값 ArrayList 가져온 다음 문자열 값을 add해줌

        }

        // map에 있는 key값 빼고 value만(ArrayList) 빼서 반환
        return new ArrayList<>(map.values());
    }

    // 삽입 정렬을 이용해 char 배열을 정렬하는 sort 함수
    public static void sort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution(strs);
        System.out.println(Arrays.toString(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        solution(strs);
        System.out.println(Arrays.toString(strs));
    }
}
