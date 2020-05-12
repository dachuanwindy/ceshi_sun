package inspur.BXD_JCSP.Bixiangdong_IO.File_study;

/**
 * 装饰类设计模式：
 * 想要对以已有的功能进行增强， 可以定义类将已有的对象传入，基于已有的功能，比提供加强功能
 * 那么自定义的类就成为装饰类;
 * <p>
 * 装饰模式的特点是： 构造新的类，这个类中在构造方法中传入需要装饰的对象，然后编写更强功能的方法，，这样代码改动量就很小了，
 * <p>
 * <p>
 * <p>
 * 装饰设计模式的由来 举例说明
 * <p>
 * class  Myreaader
 * ———readerText
 * ———readerMidia
 * ———readderPicture
 * <p>
 * 这样问题来了，我们向对这几个方法进行进行功能加强，增加bufferreader 缓冲技术，
 * 方式1: 直接修改方法，
 * 方式2：另外写一个类，对这个方法进行加强 ：这就是装饰模式的
 * 比如说： class bufferrader {
 * private readerText  readertext;
 * bufferrader(readerText  readertext){
 * this.readerText= readertext;
 * }
 * public buffermethod(){
 * 功能扩·······；
 * }
 * }
 * 问题： 可以解决问题，而且效率有所提高。假如说有很多需要加强的方法，这样就代码量就上去了。
 * 方式3： class buffereader extends Myreaader{
 * private Myreader myreader;
 * bufferreader( Myreader myreader){
 * this.myreader =myreader;
 * }
 * public bufferreader_method(){
 * <p>
 * 扩展功能编写-----
 * }
 * <p>
 * }
 * 这样就是装饰模式与继承的组合，好处是：只要将父类转进去就可以，不用去写每个方法；
 */
public class Zhuangshi_shejimoshi {

    public static void main(String[] args) {

        Person person = new Person();
//        person.chifan();


        Superperson superperson = new Superperson(person);
        superperson.superchifan();
    }
}

class Person {

    public void chifan() {
        System.out.println("chifang");
    }

}

class Superperson {
    private Person person;

    Superperson(Person person) {
        this.person = person;
    }

    public void superchifan() {

        System.out.println("开胃酒");
        System.out.println("吃饭");
        person.chifan();
        System.out.println("甜点");

    }
}
