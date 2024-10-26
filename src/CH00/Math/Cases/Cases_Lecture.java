package CH00.Math.Cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Cases_Lecture {
    public static void main(String[] args) {
        // 경우의 수 예제 코드

        // 1. 합의 법칙
        System.out.println("** 합의 법칙 **");

        // 두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수

        int[] dice1 = {1, 2, 3, 4 ,5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;

        // 기본 풀이
        // 주사위 2개를 for loop 수행하며 두 주사위 눈금 합이 3의 배수라면 nA 1씩 증가, 4의 배수라면 nB 1씩 증가
        for(int item1 : dice1) {
            for (int item2 : dice2) {
                if((item1 + item2) % 3 == 0) {
                    nA += 1;
                }

                if((item1 + item2) % 4 == 0) {
                    nB += 1;
                }

                // 합의 법칙 - 3, 4의 배수 공통된 경우의 수 빼줌
                if ((item1 + item2) % 12 == 0) {
                    nAandB += 1;
                }
            }
        }

        System.out.println("결과 : " + (nA + nB - nAandB));

        // HashSet 이용
        // HashSet을 생성할 때 경우의 수를 이루는 case들을 담기 위한 ArrayList를 제네릭으로 사용한다.
        HashSet<ArrayList> allCase = new HashSet<>();

        for(int item1 : dice1) {
            for(int item2 : dice2) {
                // 3의 배수이거나 4의 배수일 때
                if((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0) {
                    // 주사위 1과 주사위2의 눈금을 리스트로 만들어 새 ArrayList를 생성하고
                    ArrayList list = new ArrayList(Arrays.asList(item1, item2));
                    // HashSet에 넣어주면 모든 주사위 눈금 정보를 기록할 수 있다.
                    // 또한 HashSet을 이용하면 중복된 정보는 자동으로 제거된다. -> 6, 6 삭제
                    allCase.add(list);
                }
            }
        }
        // 모든 결과의 수는 HashSet의 size
        System.out.println("결과 : "  + allCase.size());

        // 2. 곱의 법칙
        System.out.println("** 곱의 법칙 **");

        // 두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수

        nA = 0;
        nB = 0;

        // for loop로 풀이
        for (int item1 : dice1) {
            if(item1 % 3 == 0) { // 주사위 눈금이 3의 배수인 경우 nA 증가
                nA++;
            }
        }

        for (int item1 : dice1) {
            if(item1 % 4 == 0) { // 주사위 눈금이 4의 배수인 경우 nB 증가
                nB++;
            }
        }

        // 이 모든 상황이 동시에 발생하는 상황이므로 nA와 nB를 곱한다.
        System.out.println("결과 : " + (nA * nB));
    }
}
