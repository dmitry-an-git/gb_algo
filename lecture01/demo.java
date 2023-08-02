import java.util.ArrayList;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        
        for (Integer num : findAllDividers(12)) {
            System.out.println(num);
        }

        for (Integer num : findAllSimple(100)) {
            System.out.println(num);
        }

        System.out.println(findChance(9));
        System.out.println(findChance(10));
        System.out.println(findChance(3));
    }

    public static List<Integer> findAllDividers(Integer number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findAllSimple(Integer max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }

    public static double findChance(Integer sum) {
        Integer turns = 0;
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    for (int k = 1; k < 7; k++) {
                        if (i+j+k == sum) {
                            turns++;
                        }
                    }
                }
            }
        return (double)turns/36;
    }
}


