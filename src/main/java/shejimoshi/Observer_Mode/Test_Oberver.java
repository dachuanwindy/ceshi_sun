package shejimoshi.Observer_Mode;

public class Test_Oberver {

    public  static  void main(String [] args){
     Subject subject=new Myobject();
     subject.add(new oberver1());
     subject.add(new oberver2());
     subject.delet(new oberver2());
     subject.operation();

    }
}
