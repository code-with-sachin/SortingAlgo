import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Unsorted array: " + Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("Array after sorting: " +Arrays.toString(numbers));
    }

    private static void insertionSort(int[] inputArray) {
        //for each value we will copy it to temp variable and the compare it to left
        for (int i=1; i<inputArray.length; i++){
            int currentValue = inputArray[i];       //Temp variable

            int j = i-1;

            while (j >= 0 && inputArray[j] > currentValue) {
                //shifting value at left to right as j is bigger than i(right element)
                inputArray[j+1] = inputArray[j];
                j--;        //decrement j to move at start
            }
            inputArray[j+1] = currentValue;
        }
    }
}
