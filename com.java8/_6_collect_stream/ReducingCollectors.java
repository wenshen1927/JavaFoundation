package _6_collect_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collector.reducing()
 */
public class ReducingCollectors {

    public static void main(String[] args) {
        DishList.menu.stream()
                .collect(Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
                )).ifPresent(System.out::println);

        final Stream<Integer> stream = Arrays.asList(1, 23, 4, 5, 6).stream();
//        stream.reduce(new ArrayList<Integer>(),
//                (List<Integer> list, Integer e) -> {
//                    list.add(e);
//                    return list;
//                }, (List<Integer> list1, Integer e1) -> {
//                    list1.add(e1);
//                    return list1;
//                });

    }
}
