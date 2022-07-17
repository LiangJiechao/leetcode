package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiaoliang
 * @date 2021/12/11 09:37
 **/
public class StreamApiTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("---");
        list1.stream().sorted(Comparator.comparing(Integer::intValue, (i1, i2) -> i2 - i1).reversed()).forEach(System.out::println);
        System.out.println("---");

        List<String> collect = list1.stream().map(Integer::toBinaryString).collect(Collectors.toList());
        for (String item : collect) {
            System.out.print(item + " ");
        }
        System.out.println();

        List<String> collect1 = collect.stream().map(String::valueOf).map(item -> item.substring(0, 1)).collect(Collectors.toList());
        for (String item : collect1) {
            System.out.print(item + " ");
        }

        System.out.println();
        int[] ints = list1.stream().mapToInt(Integer::intValue).toArray();
        for (Integer item : ints) {
            System.out.print(item + " ");
        }
        System.out.println();

//        list1.forEach(item->{
//            System.out.println(item);
//        });
        // int[] 转 Integer[]
        Integer[] integers1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        List<Integer> integerList = Arrays.asList(integers1);
//        Integer[] integers2 = new Integer[list1.size()];
//        integers2 = list1.toArray(integers2);
        // list1.toArray(new Object[0])
        Integer[] integers2 = list1.toArray(new Integer[0]);
        for (Integer item : integers2) {
            System.out.print(item + " ");
        }

//        List<Integer> collect = list1.parallelStream().map(item -> item * 2).collect(Collectors.toList());
//        collect.forEach(System.out::println);
//        OddNumberPredicate predicate = new OddNumberPredicate();
//        List<Integer> collect = list1.stream().filter(item -> {
//            return predicate.test(item);
//        }).collect(Collectors.toList());
//        List<Integer> collect = list1.stream().filter(new OddNumberPredicate()).collect(Collectors.toList());
//        collect.forEach(System.out::println);

        Runnable runnable = () -> System.out.println("runnable");
        runnable.run();

        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(7, 8));
        IntFunction<String> stringIntFunction = (int a) -> a + "是一个数";
        System.out.println(stringIntFunction.apply(789));

        Stream<String> a = Stream.of("a", "b", "c");
        List<String> list = a.peek(e -> System.out.println(e.toUpperCase())).collect(Collectors.toList());
        list.forEach(System.out::print);// abc

        Stream<String> a1 = Stream.of("a", "c", "b");
        a1.sorted().forEach(e -> System.out.println(e));

        String[] words = {"Hello", "World"};
        // 将每个单词转换为由其字幕构成的数组
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));
        // 将Stream<String[]>通过flatMap转换为Stream<String>
        // 将各个生成流扁平化为单个流
//        Stream<String> stringStream = stream.flatMap(subList -> Arrays.stream(subList));
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        List<String> collect2 = stringStream.distinct().collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println();

        // 返回两个列表的组合 {1,2,3} {3,4}
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<int[]> collect3 = l1.stream()
                .flatMap(item1 ->
                        l2.stream().map(item2 -> new int[]{item1, item2})
                ).collect(Collectors.toList());
        System.out.println(collect3);

        //Integer collect4 = list1.stream().collect(Collectors.summingInt(Integer::intValue));
        Integer collect4 = list1.stream().mapToInt(Integer::intValue).sum();
        System.out.println(collect4);
        IntSummaryStatistics collect5 = list1.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(collect5);

    }

}
