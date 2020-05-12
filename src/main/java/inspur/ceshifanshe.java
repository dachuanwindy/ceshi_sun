package inspur;

import java.lang.reflect.Type;

class Dao<T> {
    public T name() {


        return null;
    }

    public T getname() {
        return null;
    }
}

class Persondao extends Dao<Persondao> {

    public Persondao() {
        System.out.println(this);
        System.out.println(this.getClass());
        Type type = this.getClass().getSuperclass();
        System.out.println("====>>>" + type);
    }

}

public class ceshifanshe {

    public static void main(String[] agrs) {

        Persondao persondao = new Persondao();

    }

}