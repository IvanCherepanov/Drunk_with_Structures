package com.company;

import java.util.ArrayDeque;
import java.util.Stack;

public class SimpleStack {
    public static void main(String[] args) {
        //int[] a1 = {4,3,6};
        //int[] a2 = {1,2,5};
        int[] a1 = {1,3,5,7,9};
        int[] a2 = {2,4,6,8,0};
        Stack<Integer> arr1 =   new Stack<Integer>();
        Stack<Integer> arr1_help =   new Stack<Integer>();
        Stack<Integer> arr2 =   new Stack<Integer>();
        Stack<Integer> arr2_help =   new Stack<Integer>();
        int size=4;//число элементов, на 1 меньше, чем в одном
        int quantity=(size+1)*2;
        int countFirst=size;//число элементов в первом массиве
        int countSecond=size;//число элементов в первом массиве
        for (int i = size; i >= 0; i--) {
            arr1.add(a1[i]);
            arr2.add(a2[i]);
        }

        int countPart = 0;
        boolean res = false;

        for (int i = 0; i < 106; i++) {
            countPart++;
            if ((arr1.peek() > arr2.peek() &&(arr1.peek() != 9) && (arr2.peek() != 0)) || ((arr1.peek() == 0) && (arr2.peek() == 9))) {
                int x=arr1.peek();
                int y=arr2.peek();
                arr1.pop();
                arr2.pop();
                countSecond--;//удалил, т.к условие
                countFirst--;//временно удалил
                while(!arr1.empty()){
                    arr1_help.add(arr1.peek());
                    arr1.pop();
                }
                arr1.add(y);
                arr1.add(x);
                for(int k=0;k<=countFirst;k++ ){
                    arr1.add(arr1_help.peek());
                    arr1_help.pop();
                }
                countFirst+=2;

            } else if ((arr1.peek() < arr2.peek() &&(arr1.peek() != 0) && (arr2.peek() != 9))|| ((arr1.peek() == 9) && (arr2.peek() == 0))) {
                int x=arr1.peek();//элемент первого стека
                int y=arr2.peek();//элемент второго стека
                arr1.pop();
                countFirst--;//удалил по условию
                arr2.pop();
                countSecond--;//удалил  временно
                while(!arr2.empty()){
                    arr2_help.add(arr2.peek());
                    arr2.pop();
                }
                arr2.add(x);
                arr2.add(y);
                for(int k=0;k<=countSecond;k++ ){
                    arr2.add(arr2_help.peek());
                    arr2_help.pop();
                }
                countSecond+=2;
            }
            //arr1.remove();
            //arr2.remove();

            if (arr1.size() == 0) {
                System.out.println("Second " + countPart);
                res = true;
                break;
            } else if (arr2.size() == 0) {
                System.out.println("First " + countPart);
                res = true;
                break;
            }
        }
        if (!res) System.out.println("Botva!");
    }
}
