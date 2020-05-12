package inspur.BXD_JCSP.Bixiangdong_study_string.Hashset;

public class TestHashSetMain {
    public static void main(String[] args) {

        System.out.println("HashSet----test");
    }
}


class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
        System.out.println("name" + this.name + ">>>>>" + "age:" + this.age);
    }


    public int hashCode() {
        System.out.println("哈希值被调用---");
        return this.name.hashCode() + this.age;
    }

    public  boolean equals(){
    return  false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}