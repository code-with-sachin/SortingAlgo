public class BinarySearchApproach2 {

    //Binary search algorithm recursion way
        public static void main(String[] args) {
            int[] nums = {1, 2, 4, 5, 7, 9, 11};

            System.out.println("0 is at position: " + binarySearch(nums, 0, 0, nums.length));
            System.out.println("1 is at position: " + binarySearch(nums, 1, 0, nums.length));
            System.out.println("2 is at position: " + binarySearch(nums, 2, 0, nums.length));
            System.out.println("3 is at position: " + binarySearch(nums, 3, 0, nums.length));
            System.out.println("4 is at position: " + binarySearch(nums, 4, 0, nums.length));
            System.out.println("5 is at position: " + binarySearch(nums, 5, 0, nums.length));
            System.out.println("6 is at position: " + binarySearch(nums, 6, 0, nums.length));
            System.out.println("7 is at position: " + binarySearch(nums, 7, 0, nums.length));
            System.out.println("8 is at position: " + binarySearch(nums, 8, 0, nums.length));
            System.out.println("9 is at position: " + binarySearch(nums, 9, 0, nums.length));
            System.out.println("10 is at position: " + binarySearch(nums, 10, 0, nums.length));
            System.out.println("12 is at position: " + binarySearch(nums, 12, 0, nums.length));

        }

        private static int binarySearch(int[] numbers, int numberToFind, int low, int high) {

            if (high >= low && low <= numbers.length - 1) {
                int middlePosition = low + (high - low) / 2;
                int middleNumber = numbers[middlePosition];

                if (numberToFind == middleNumber){
                    return middlePosition;
                }
                if (numberToFind < middleNumber){
                    return binarySearch(numbers, numberToFind, low, middlePosition - 1);
                }
                else {
                    return binarySearch(numbers, numberToFind, middlePosition + 1, high);
                }
            }
            return -1;
        }
}
