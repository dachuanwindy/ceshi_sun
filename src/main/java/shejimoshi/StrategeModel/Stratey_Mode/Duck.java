package shejimoshi.StrategeModel.Stratey_Mode;

public abstract class Duck {
    Fly mfly11;
    GuaGua mguagua;
    public void fly() {
       mfly11.fly();
    }

    public void guagua() {
        mguagua.GuaGua();
    }

    public abstract void display();
}


class GreenDuak extends Duck {
    public GreenDuak() {
        mfly11 = new qucikfly();
        mguagua = new jianjiao();
    }

    @Override
    public void display() {
        System.out.println("吕头鸭子 飞的快，叫声大");
    }
}

class Redduck extends Duck {

    public Redduck() {
        mfly11 = new lowfly();
        mguagua = new bujiao();
    }


    @Override
    public void display() {
        System.out.println("红头鸭子飞的慢，叫声小");
    }
}
