package org.example;

public class ContainerWithMostWater {

    public static int mine(int[] array) {
        int length = array.length;
        int mid = length / 2;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int indexMax1 = -1;
        int indexMax2 = -1;

        for (int i = 0; i < length; i++) {
            int index = (i == mid && length % 2 != 0) ? 0 : (i < mid ? i : length - 1 - i);
            int result = array[i] - index;

            indexMax2 = (result > max1) ? indexMax1 : (result > max2 ? i : indexMax2);
            max2 = (result > max1) ? max1 : (result > max2 ? result : max2);
            indexMax1 = (result > max1) ? i : indexMax1;
            max1 = (result > max1) ? result : max1;
        }


        int i = Math.min(indexMax1, indexMax2);
        int j = Math.max(indexMax1, indexMax2);
        return (j - i) * Math.min(array[i], array[j]);
    }

    public static void main(String[] args) {
        int[] caseA = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] caseB = {1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] caseC = {9, 9, 9, 9, 1, 1, 1, 1};
        int[] caseD = {9, 1, 1, 1, 1, 1, 1, 1, 9};
        int[] caseE = {1, 1, 1, 9, 9, 9, 1, 1, 1};
        int[] caseF = {1, 2, 3, 4, 100, 4, 3, 2, 1};
        int[] caseG = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] caseH = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Case A: " + mine(caseA)); // Ожидание: 49
        System.out.println("Case B: " + mine(caseB)); // Ожидание: 9
        System.out.println("Case C: " + mine(caseC)); // Ожидание: 9
        System.out.println("Case D: " + mine(caseD)); // Ожидание: 72
        System.out.println("Case E: " + mine(caseE)); // Ожидание: 9
        System.out.println("Case F: " + mine(caseF)); // Ожидание: 4
        System.out.println("Case G: " + mine(caseG)); // Ожидание: 9
        System.out.println("Case H: " + mine(caseH)); // Ожидание: 9
    }
}
