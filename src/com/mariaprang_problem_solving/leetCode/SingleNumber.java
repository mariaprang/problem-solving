package com.mariaprang_problem_solving.leetCode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /*
    Given a non-empty array of integers,
    every element appears three times except for one, which appears exactly once. Find that single one.
    Example 1:

    Input: [2,2,3,2]
    Output: 3

    Example 2:
    Input: [0,1,0,1,0,1,99]
    Output: 99
    * */

    private Map <Integer, Integer> occurencies;

    private void beforeTestRunner() {
        occurencies = new HashMap <>();
    }


    public int singleNumber(int[] nums) {

        for (int number : nums) {
            if (!occurencies.containsKey(number)) {
                occurencies.put(number, 1);
            } else {
                int occurs = occurencies.get(number);
                occurencies.put(number, ++occurs);
            }
        }

        Map.Entry <Integer, Integer> entry = countAndReturn();
        return entry.getKey();
    }

    private Map.Entry <Integer, Integer> countAndReturn() {
        for (Map.Entry <Integer, Integer> entry : occurencies.entrySet()) {
            if (entry.getValue() == 1) {
                return entry;
            }
        }
        return null;
    }

    public static boolean assertEquals(Integer one, Integer two) {
        System.out.println(one.equals(two));
        return one.equals(two);
    }

    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();

        int[] array1 = {0, 1, 0, 1, 0, 1, 99};
        int[] array2 = {2, 2, 3, 2};
        test.beforeTestRunner();
        System.out.println(assertEquals(test.singleNumber(array1), 99));
        test.beforeTestRunner();
        System.out.println(assertEquals(test.singleNumber(array2), 3));


    }

}
