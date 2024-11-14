import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    //TC - O(nlog n)
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i=0; i<numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Unsorted array: " + Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println("Array after sorting: " +Arrays.toString(numbers));
    }

    //divide and conquer algorithm
    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        //we will be calling mergeSort method recursively to divide it smaller and smaller till just 1 element
        //base condition
        if (inputLength < 2){
            return;
        }
        //divide our array from mid point
        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        //filling up the lefthalf and right half array
        //for lefthalf
        for (int i = 0; i<midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        //for righthalf
        for (int i = midIndex; i<inputLength; i++){
            rightHalf[i-midIndex] = inputArray[i];      //since we would be starting from starting index to fill in righthalf array
        }

        //now we merge sort each of the leftHalf and rightHalf arrays
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //Merge those two halfs sorted arrays together
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftHalfSize = leftHalf.length;
        int rightHalfSize = rightHalf.length;

        //most confusing part - Comparing elements and adding lowest one
        // therefore we will take 3 iterator to walk in left right and merged array

        int i =0, j=0, k=0;         // i will be iterator for left half, j for right and k for merged array

        while (i < leftHalfSize && j < rightHalfSize) {
            //compare i th element
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        //cleanup and add the elements that are still remaining in either left or right arrays
        while (i < leftHalfSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalfSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }
}
