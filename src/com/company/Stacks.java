package com.company;

public class Stacks {
    public static void main(String[] args) {
        MyStack ts = new MyStack();
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push2(16);
        ts.push2(17);
        ts.push2(18);
        ts.push2(19);
        ts.push2(20);
        ts.push1(11);
        ts.push2(7);
        ts.push2(8);
        ts.pop1();
        ts.push2(40);
        ts.pop2();
    }



    static class MyStack {
        private int[] arr;
        private int top1;
        private int top2;

        public MyStack() {
            this.arr = new int[10];
            this.top1 = -1;
            this.top2 = arr.length;
        }

        public void push1(int val) {
            if (top1 < top2 - 1)
                arr[++top1] = val;
            else
                System.out.println("overflow for stack 1");
        }

        public void pop1() {
            if (top1 == -1 )
                System.out.println("Nothing to pop");
            else {
                System.out.println("Popped " + arr[top1--]);
            }
        }

        public void push2(int val) {
            if (top2 > top1 + 1)
                arr[--top2] = val;
            else
                System.out.println("overflow for stack 2");
        }

        public void pop2() {
            if (top2 == arr.length)
                System.out.println("Nothing to pop");
            else
                System.out.println("Popped " + arr[top2++]);
        }
    }
}
