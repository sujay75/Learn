package com.learn.datastructures;

public class Stack {

    int arr[];
    int size;
    int index;

    Stack(int size) {
        this.size = size;
        this.arr = new int[10];
        index = -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(70);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private int peek() {
        if (-1 == index) {
            System.out.println("Empty");
            return -1;
        }
        return arr[index];
    }

    private int pop() {
        if (index != -1) {
            int pop = arr[index];
            index--;
            return pop;
        } else {
            System.out.println("Empty");
            return -1;
        }
    }

    private void push(int i) {
        if (index == arr.length - 1) {
            System.out.println(" filled ");
        } else {
            index++;
            arr[index] = i;
        }
    }
}
