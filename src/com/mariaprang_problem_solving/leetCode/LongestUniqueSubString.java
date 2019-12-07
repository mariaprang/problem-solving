package com.mariaprang_problem_solving.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestUniqueSubString {

    /*
    TASK: Given a string return the longest substring without repeating characters
    Example 1:
    Input: "abcabcbb"
    Output: "abc"

    Example2:
    Input: "bbbb"
    Output: "b"

    Example 3:
    Input: "pwwkew"
    Output: "wke"
    * */

    private String findLongestFromList(List <String> stringList) {
        String longestString = "";
        for (String word : stringList) {
            if (word.length() > longestString.length()) {
                longestString = word;
            }
        }
        return longestString;
    }

    public String findLongestSubstring(String initialString) {

        List <String> substringList = new ArrayList <String>();

        String tempString = "";
        for (int index = 0; index < initialString.length(); index++) {
            String character = String.valueOf(initialString.charAt(index));
            if (!tempString.contains(character)) {
                tempString += character;
            } else {
                substringList.add(tempString);
                tempString = "";
                tempString += character;
            }

        }


        return findLongestFromList(substringList);

    }

    public static boolean assertEquals(String one, String two) {
        System.out.println(one.equals(two));
        return one.equals(two);
    }

    public static void main(String[] args) {
        String example1 = "abcabcabc";
        String example2 = "bbbb";
        String example3 = "pwwkew";
        LongestUniqueSubString test = new LongestUniqueSubString();

        assertEquals(test.findLongestSubstring(example1), "abc");
        assertEquals(test.findLongestSubstring(example2), "b");
        assertEquals(test.findLongestSubstring(example3), "wke");


    }

}
