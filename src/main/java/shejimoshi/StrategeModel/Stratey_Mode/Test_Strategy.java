package shejimoshi.StrategeModel.Stratey_Mode;

public class Test_Strategy {
    public static  void main(String [] args){
        Duck duck = new GreenDuak();
        Duck duck1 =new Redduck();
        duck.fly();
        duck.guagua();
        duck.display();


    }
}
