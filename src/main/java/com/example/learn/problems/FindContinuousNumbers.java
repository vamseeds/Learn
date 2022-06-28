package com.example.learn.problems;

import java.util.*;

//{s1r1,s2r1,s2r3,s1r4,s3r1,s1r6,s4r1,s1r2}
public class FindContinuousNumbers {

    public static void main(String[] args) {
        int length = 4;
        List<String> stringList = List.of("s1.r1", "s2r1", "s2r3", "s1r4", "s3r1", "s1r6", "s4r1", "s1r2");
        HashMap<String, Value> map = new HashMap<>();
        for (String ele : stringList) {
            String[] strings = ele.split(".");
            String suite = strings[0];
            String sequence = strings[0];
            Integer integer = Integer.valueOf(sequence.substring(1));
            Value value = new Value();
            if (map.containsKey(suite)) {
                Value value1 = map.get(suite);
                TreeMap<Integer, Tracker> sequence1 = value1.sequence;// 1 ,(1,1)
                // TreeSet<Integer> get=value1.sequence;
                // 2, (2,1)
                // 3, (3,1)
                //sequence1.get
               /* int existingFwdCount = 1;
                int existingBckCount = 1;
                if (sequence1.containsKey(integer - 1)) {
                    Tracker tracker = sequence1.get(integer - 1);
                    existingBckCount = tracker.backWardCount + 1;
                }
                if (sequence1.containsKey(integer + 1)) {
                    Tracker tracker = sequence1.get(integer + 1);
                    existingFwdCount = tracker.fwdCount + 1;
                }
                if (existingBckCount == length || existingFwdCount == length) {
                    System.out.println(true);
                }*/

                /*Tracker tracker = new Tracker();
                tracker.fwdCount = existingFwdCount;
                tracker.backWardCount = existingBckCount;
                sequence1.put(integer, tracker);*/
            } else {

                Tracker tracker = new Tracker();
                tracker.fwdCount = 1;
                tracker.backWardCount = 1;
                Value val = new Value();
                val.sequence.put(integer, tracker);
                map.put(suite, value);

            }

        }


    }

    static class Value {
        // r2 ->2  (1-1 =0)
        TreeMap<Integer, Tracker> sequence;

    }

    static class Tracker {
        Integer fwdCount;
        Integer backWardCount;
    }
}
