import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoSort {

    //Worst sorting algorithm
    public static void main(String[] args){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i<5; i++){
            list.add(random.nextInt(100));
        }

        list.forEach(i -> System.out.println(i));

        //sorting algo
        while (!isListSorted(list)){
            Collections.shuffle(list);
        }
        System.out.println("After sorting:");
        list.forEach(i -> System.out.println(i));
    }

    private static boolean isListSorted(List<Integer> list) {
        if (list == null) {
            return true;
        }

        int length = list.size();
        if (length <=1){
            return true;
        }

        for (int i =0; i < length-1; i++){
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
