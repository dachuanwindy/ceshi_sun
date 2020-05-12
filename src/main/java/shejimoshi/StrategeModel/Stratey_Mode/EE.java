package shejimoshi.StrategeModel.Stratey_Mode;

interface  A{
    void a();
}
class AA implements A{

    @Override
    public void a() {
        System.out.println("aaaaa");
    }
}
interface B{
    void  b();
}
class BB implements B{
    @Override
    public void b() {
        System.out.println("bbbbbb");
    }
}
class C implements A,B{


    @Override
    public void a() {
        A a =new AA();
        a.a();
    }

    @Override
    public void b() {
        b();
    }
}

public  class  EE{
    public  static  void main(String []args){
        C c=new C();
        c.a();
      //  c.b();
    }
}