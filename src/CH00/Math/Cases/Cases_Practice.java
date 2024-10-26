package CH00.Math.Cases;

// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수 이면서 B의 약수인 경우의 수

import java.util.ArrayList;

public class Cases_Practice {
    // 약수를 구하는 함수
    // 약수 : 어떤 수를 나눠서 나머지가 발생하지 않는 수 ex) 4의 약수 : 1, 2, 4
    public ArrayList getDeivisor(int num) {
        // 매개변수로 들어온 수에 대한 약수들을 담아줄 ArrayList
        ArrayList result = new ArrayList();

        // 자기 자신의 절반까지만 for loop 수행 => 나눠서 떨어지는 수를 구하면 되므로 절반 이하의 수까지만 반복 수행한다.
        // ex) 6의 경우 1, 2, 3으로 6을 나누면 나눠떨어지지만 4로 나누면 2가 남음!
        for(int i = 1; i <= (int)num/2; i++){
            if(num % i == 0) {
                result.add(i);
            }
        }
        // 자기 자신 또한 약수에 포함되므로 결과 ArrayList의 마지막에 자기 자신 값 add
        result.add(num);

        return result;
    }

    // 최대 공약수를 구하는 함수
    // 최대 공약수 : 두 수의 공통된 약수 중 제일 큰 수
    // GCD : The Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        // 각 숫자들의 약수 구하기 (위에서 만든 약수 구하는 함수 사용)
        ArrayList divA = this.getDeivisor(numA);
        ArrayList divB = this.getDeivisor(numB);

        // 약수 중 최대 공약수 뽑기
        // 2중 loop를 수행하며 약수들 중에 같은 수가 발견 된다면 + 해당 약수가 gcd보다 크다면 이것이 최대 공약수
        for(int itemA : (ArrayList<Integer>)divA) {
            for(int itemB : (ArrayList<Integer>)divB) {
                if(itemA == itemB) {
                    if(itemA > gcd) {
                        gcd = itemA;
                    }
                }
            }
        }

        return gcd;
    }

    // 최소 공배수
    // 최소 공배수 : 두 수의 공통된 배수 중 가장 작은 수
    // 구하는 방법 : 두 수의 최대 공약수 구함 -> 두 수를 곱하고 두 수의 최대 공약수로 나눠주면 됨
    // LCM : The Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        // 위에 만든 함수로 최대 공약수 먼저 구함
        int gcd = this.getGCD(numA, numB);

        // 최대 공약수가 있다면
        if(gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }


    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 6;

        Cases_Practice cs = new Cases_Practice();
        ArrayList l1 = cs.getDeivisor(number1);
        ArrayList l2 = cs.getDeivisor(number2);
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수 : " + cs.getGCD(number1, number2));
        System.out.println("최소 공배수 : " + cs.getLCM(number1, number2));
    }
}
