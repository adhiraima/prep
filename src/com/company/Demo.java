package com.company;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String args[]){
        int numThreads = 4;
        List<List<Integer>> splits = new LinkedList<>();

        for (int i = 1; i <= 200; i++) {
            if (i <= numThreads) {
                List<Integer> mp = new LinkedList<>();
                mp.add(i);
                splits.add(mp);
            } else {
                System.out.println("Coming here >>> " + i);
                int index = i % numThreads;
                System.out.println("The index >>> " + index);
                while(index > numThreads)
                    index %= numThreads;
                splits.get(index == 0 ? numThreads - 1 : index - 1).add(i);
            }
        }
        for (List<Integer> lst : splits)
            System.out.println(lst);
    }
}