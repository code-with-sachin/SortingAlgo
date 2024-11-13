import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    //fastest but hardest sorting algo
    //Step 1 - Choose one of the number/index in the array as PIVOT
    // 1 8 3 9 4 5 7
    // for our program we will be choosing last element as pivot
    // Step 2 - Do Partitioning - i.e Move all elements which are smaller than the pivot to the left and greater to the right
    // position after partitioning is : 5 4 3 1 7 8 9         (here 7 is pivot -> this would be the final position in array)
    // Step 3 - do the quick sort for left portion 5 4 3 1 (which is left of pivot 7)
    // Step 4 - repeat the same on remaining right portion 8 9
    // take 1 as pivot for left portion and repeat step 2-> 1 3 4 5
    // Now recursively quick sort all elements to the left and right of pivot.. but for our case there is nothing on left of pivot 1, therefore quicksort on right portion (3 4 5)
    // repeat again step 1, 2 -> i.e choose pivot etc - 5
    // At the end we would have just one element left , that means left portion is already sorted
    //Now recursively sort all number to right of 7 (step 3)

    public static void main(String[] args){
        Random random = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i<numbers.length; i++){
            numbers[i] = random.nextInt(100);   // random numbers less than 100
        }

        System.out.println("Array before sorting:" + Arrays.toString(numbers));

        quickSort(numbers, 0, numbers.length-1);

        System.out.println("Array after sorting:" + Arrays.toString(numbers));
//        System.out.println("Array after sorting:");
//        printArray(numbers);


    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        //base condition
        if (lowIndex >= highIndex){
            return;
        }
        int pivot = array[highIndex];       // highIndex = array.length-1
        //partitioning step         1 8 3 9 4 5 7
        // we will create two variables which will be the pointers

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        //loop that will move left and right index towards each other
        while (leftPointer < rightPointer){
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;      //increment left pointer
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);        // here highIndex is our Pivot
        //After above step all the numbers which are lower than pivot are on the left and higher ones are on the right of pivot

        //Then we are just remaining with recursive step to left & right of pivot
        //recursive quicksort left partition
        quickSort(array, lowIndex, leftPointer-1);      // cause leftpointer & rightpointer is at pivot right now

        //recursive quicksort right partition
        quickSort(array, leftPointer+1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int i =0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}
