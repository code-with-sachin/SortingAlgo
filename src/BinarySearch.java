public class BinarySearch {
    //To check if given value exists in Array or NOT
    //Binary search is much  faster for sorted arrays -> So array has to be sorted for binary search
    //Approach - Check center or Middle value of the array
    // 1 2 4 5 7 9 11 -> 5 (middle)
    //Now compare it with the value we are looking for (is it great or smaller or equal to that value?)
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 5, 7, 9, 11};

        int ans = binarySearch(nums, 5);
        System.out.println("The index of number we are searching is " +ans);

    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length -1;

        while (low<=high){
            int midIndex = (low+high)/2;
            int midNumber = numbers[midIndex];

            if (midNumber == numberToFind) {
                return midIndex;    //we found the number -> so return the index
            } else if (midNumber < numberToFind) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }
        return -1;
    }
}
