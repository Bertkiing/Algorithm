package test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author bertking
 * @date 2019/10/25
 * <p>
 * 定义这个类，其属性全部私有化，这从表面上来看是一个"不可变类(immutable class)".But in fact?
 *
 * 运行下面的程序：结果发现前后两次的输出居然不一样，也就是这个类被改变啦。
 *
 * 原因出在哪里？
 *
 * 关键在于：String是不可变类，而Date类是可变类，所以只要能获取到其实例，即可对其内部进行修改。
 *
 * 解决办法:
 *  使用"保护性拷贝"
 *
 *  即：在获取可变对象的实例前，重新new一个相同值的对象。
 *
 *
 *  Effective Java书中曾经指出，只要能够不创建对象，就不要创建多余的对象。另外一条是只要需要创建对象，就不要吝啬地创建它。
 *  它们并不矛盾，前者的目的是为了尽可能减少资源的占用，提高运行效率，后者是为了安全性。
 *
 */
public class Person {
    private String name;
    private Date birth;
    private ArrayList<Integer> list;

    public Person(String name, Date birth) {
        this.name = name;
        this.birth = birth;
        this.list = new ArrayList<>(5);
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Date getBirth() {
        return birth;
//        return new Date(birth.toString()); //TODO 保护性拷贝
    }

    public ArrayList<Integer> getList() {
        return list;
//        return new ArrayList<>().addAll(list); // TODO 保护性拷贝

    }

    //    public void setBirth(Date birth) {
//        this.birth = birth;
//    }


    public static void main(String[] args) {
        Person person = new Person("Bertking",new Date(2019-1900, 5, 15));
        print(person);

        System.out.println("----------------------");

        Date birth = person.getBirth();
        birth.setYear(2018-1900);
        person.list.add(10);

        print(person);
    }

    private static void print(Person person) {
        System.out.println("Name:" + person.name);
        System.out.println("Birth:" + person.birth);
        System.out.println("List.size:"+person.list.size());
    }
}




