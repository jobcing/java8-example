package Chapter05;

import Chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Chapter04.Dish.menu;

/**
 * Created by ByeongChan on 2018. 5. 9..
 *
 * 스트림 API의 필터링 연산 예제
 */

public class Filtering {
    public static void main(String[] args) {

        // Filtering with predicate
        List<Dish> vegetarianMenu =
                menu.stream()
                    .filter(Dish::isVegetarian)
                    .collect(Collectors.toList());

        vegetarianMenu.forEach(System.out::println);


        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        // Truncating a stream
        List<Dish> dishesLimit =
                menu.stream()
                    .filter(d -> d.getCalories() > 300)
                    .limit(3)
                    .collect(Collectors.toList());

        dishesLimit.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip =
                menu.stream()
                    .filter(d -> d.getCalories() > 300)
                    .skip(2)
                    .collect(Collectors.toList());

        dishesSkip.forEach(System.out::println);
    }
}
