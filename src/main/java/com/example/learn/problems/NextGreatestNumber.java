package com.example.learn.problems;

import java.util.TreeSet;

/**
 * Find next greater number with same set of digits
 * <p>
 * <p>
 * Input:  n = "218765"
 * Output: "251678"
 * <p>
 * Input:  n = "1234"
 * Output: "1243"
 * <p>
 * Input: n = "4321"
 * Output: "Not Possible"
 * <p>
 * Input: n = "534976"
 * Output: "536479"
 * <p>
 * 1234
 * 1243
 * <p>
 * 1415
 * 1514
 * <p>
 * 12316
 * 12613
 * <p>
 * 12698
 * 12869
 * <p>
 * <p>
 * Algorithm :
 **/

public class NextGreatestNumber {

    public static void main(String[] args) {

        String input = "534976";
        String nextGreatestNumber = findNextGreatestNumber(input);
        System.out.println("Next Greatest Number : " + nextGreatestNumber);
    }

    private static String findNextGreatestNumber(String input) {
        char[] chars = input.toCharArray();
        TreeSet<Character> toBeSortedNums = new TreeSet<>();
        int lastInt = chars[chars.length - 1] - '0';
        System.out.println(lastInt);
        int i = chars.length - 2;
        for (; i >= 0; i--) {
            toBeSortedNums.add(chars[i]);
            int currentNum = chars[i] - '0';
            System.out.println(currentNum);
            if (currentNum < lastInt) {
                chars[chars.length - 1] = (char) (48 + currentNum);
                chars[i] = (char) (48 + lastInt);
                break;
            }
        }
        for (int j = i + 1; j < chars.length; j++) {
            chars[j] = toBeSortedNums.pollFirst();
        }
        return new String(chars);
    }
}
