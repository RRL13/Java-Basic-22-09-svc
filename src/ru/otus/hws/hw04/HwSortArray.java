package ru.otus.hws.hw04;

import java.util.*;

public class HwSortArray {
    //ArrayList<Integer> arrayForSort = new ArrayList<Integer>();
    public static void main(String[] args) {
        Integer[] arrayForSort = new Integer[100000];

        addRndInArray(arrayForSort);
        long deltaTimeBubble = SortArrayBubbleTime(arrayForSort);

        addRndInArray(arrayForSort);
        long deltaArrayListSortBubble = SortArrayListBubbleTime(arrayForSort);

        addRndInArray(arrayForSort);
        long deltaCollectionsSort = SortArrayCollectionsTime(arrayForSort);



        System.out.println("Time for sort " + arrayForSort.length + " elements = " + deltaTimeBubble + "ms.");
        System.out.println("Time for sort with ArrayList " + arrayForSort.length + " elements = " + deltaArrayListSortBubble + "ms.");
        System.out.println("Time for sort with Collections " + arrayForSort.length + " elements = " + deltaCollectionsSort + "ms.");
    }


    public static void addRndInArray(Integer[] inputArray) {
        int arraySize = inputArray.length;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt();
        }
    }

    public static long SortArrayBubbleTime(Integer[] inputArray) {
        int arraySize = inputArray.length;
        int temp = 0;
        long startSortBubble = new Date().getTime();
        for (int k = arraySize - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                }
            }
        }
        long endSortBubble = new Date().getTime();
        return endSortBubble - startSortBubble;
    }

    public static long SortArrayListBubbleTime(Integer[] inputArray) {
        List arrayListForSort = new ArrayList<>();
        //Collections.addAll(arrayListForSort, inputArray);
        arrayListForSort = Arrays.asList(inputArray);
        int arraySize = inputArray.length;
        int temp = 0;
        long startArrayListSortBubble = new Date().getTime();
        for (int k = arraySize - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {

                if ((int) arrayListForSort.get(i) > (int) arrayListForSort.get(i + 1)) {
                    temp = (int) arrayListForSort.get(i);
                    arrayListForSort.set(i, arrayListForSort.get(i + 1));
                    arrayListForSort.set(i + 1, temp);


                }
            }
        }
        long endArrayListSortBubble = new Date().getTime();

        return  endArrayListSortBubble - startArrayListSortBubble;

    }

    public static long SortArrayCollectionsTime(Integer[] inputArray){
        List arrayListForSort = new ArrayList<>();
        arrayListForSort = Arrays.asList(inputArray);

        long startSortCollections = new Date().getTime();
        Collections.sort(arrayListForSort);
        long endSortCollections = new Date().getTime();

        return endSortCollections - startSortCollections;
    }


}
