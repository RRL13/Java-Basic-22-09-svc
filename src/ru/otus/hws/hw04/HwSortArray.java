package ru.otus.hws.hw04;

import java.lang.reflect.Array;
import java.util.*;

public class HwSortArray {
    //ArrayList<Integer> arrayForSort = new ArrayList<Integer>();
    public static void main(String[] args) {
        final int arraySize = 100000;
        int[] arrayForSort = new int[arraySize];
        ArrayList<Integer> arrayListForSort = new ArrayList<>();

        addRndInArray(arrayForSort, arrayListForSort);

        long deltaTimeBubble = SortArrayBubbleTime(arrayForSort);
        long deltaArrayListSortBubble = SortArrayListBubbleTime(arrayListForSort);

        Collections.shuffle(arrayListForSort);
        long deltaCollectionsSort = SortArrayCollectionsTime(arrayListForSort);



        System.out.println("Time for sort " + arrayForSort.length + " elements = " + deltaTimeBubble + "ms.");
        System.out.println("Time for sort with ArrayList " + arrayForSort.length + " elements = " + deltaArrayListSortBubble + "ms.");
        System.out.println("Time for sort with Collections " + arrayForSort.length + " elements = " + deltaCollectionsSort + "ms.");
    }


    public static void addRndInArray(int[] inputArray) {
        int arraySize = inputArray.length;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = random.nextInt();
        }
    }

    public static void addRndInArray(ArrayList inputArray, int arraySize) {
        //int arraySize = inputArray.length;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            inputArray.add(random.nextInt());

        }
    }

    public static void addRndInArray(int[] inputArray, ArrayList inputArrayList) {
        int arraySize = inputArray.length;
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            inputArrayList.add(random.nextInt());
            inputArray[i] = random.nextInt();

        }
    }

    public static long SortArrayBubbleTime(int[] inputArray) {
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

    public static long SortArrayListBubbleTime(ArrayList<Integer> arrayListForSort) {
        //List arrayListForSort = new ArrayList<>();
        //Collections.addAll(arrayListForSort, inputArray);
        //arrayListForSort = Arrays.asList(inputArray);
        int arraySize = arrayListForSort.size();
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

    public static long SortArrayCollectionsTime(ArrayList<Integer> arrayListForSort){
        //List arrayListForSort = new ArrayList<>();
        //arrayListForSort = Arrays.asList(inputArray);

        long startSortCollections = new Date().getTime();
        Collections.sort(arrayListForSort);
        long endSortCollections = new Date().getTime();

        return endSortCollections - startSortCollections;
    }


}
