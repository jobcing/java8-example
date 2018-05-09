package Chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by ByeongChan on 2018. 5. 9..
 */

public class StreamBasic {
    public static void main(String[] args) {
        // Java 7
        getLowCaloricDishInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("-------");

        getLowCaloricDishInJava8(Dish.menu).forEach(System.out::println);
    }

    public static List<String> getLowCaloricDishInJava7(List<Dish> menu){
        // 칼로리가 낮은 Dish 인스턴스 구하기
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish d : menu){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }

        // Dish를 칼로리 순으로 정렬하여 이름만을 추출
        List<String> lowCaloricDishesName = new ArrayList<>();

        Collections.sort(lowCaloricDishes, new Comparator<Dish>(){
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        for(Dish d : lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishInJava8(List<Dish> menu){
        // 람다 스트림을 이용하여 간단하게 위와 똑같은 작업을 처리
        return menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
