package stream;

import entity.Student;

import java.util.Optional;

public class test2 {
    public static void main(String[] args) {
        //判断名称是否为空，是就返回false（通过isPresent）
        String name = null;
        boolean present = Optional.ofNullable(name).isPresent();
        System.out.println(present);

        // ifPresent 判断不为空就会执行后面内容。打印结果
        Optional.ofNullable(name).ifPresent(x-> System.out.println(x));

        //判断不为空后对数据进行操作。
        Student stuent = new Student("zhangsan",20);
        Optional<String> strings = Optional.ofNullable(stuent).map(x -> x.getName()).map(y -> y.toUpperCase());
        System.out.println(strings);
    }
}
