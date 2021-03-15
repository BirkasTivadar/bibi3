package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            result.add(numbers[i]);
        }
        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (Integer number : integerList) {
            sum += number;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (Integer number : integers) {
            sum += number;
        }
        return sum;
    }
}
