package stream;

import entity.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("卢浩文",23));
        list.add(new Student("图宇航",22));
        list.add(new Student("德玛西亚",29));
//        list.add(new Student("德玛西亚",null));

        //key是姓名，value是年龄,
        // 注意：第三个参数(a,b) -> b  的含义是如果key有重复的就用最后一个key的value值。
        //如果value为空。Optional.ofNullable(s.getAge()).orElse(0)
        Map<String, Integer> map1 = list.stream().collect(Collectors.toMap
                (Student::getName, s->Optional.ofNullable(s.getAge()).orElse(0),(a,b)->b));
        System.out.println(map1);

        System.out.println("=================================");

        //key是姓名，value是对象
        Map<String, Student> map2 = list.stream().collect(Collectors.toMap(Student::getName, a  -> a ,(a,b) -> b));
        System.out.println(map2);

        //key是姓名，value是list
        Map<String, List<Student>> map3 = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map3);

        //排序 升序
        List<Student> sorted = list.stream().sorted
                (Comparator.comparing(x -> Optional.ofNullable(x.getAge()).orElse(0))).collect(Collectors.toList());
        System.out.println(sorted);

        //max min
        Optional<Student> max = list.stream().max((a, b) -> a.getAge() - b.getAge());
        System.out.println(max.get());

    }
}
