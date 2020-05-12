package Java_JC.java_extends;


public class java_extends {

    public  static  void  main(String [] args){
        System.out.println("继承技术的学习");
        western w=new western();
        NBA nba =new NBA();
        w.huixiong();
        w.huojian();
        w.maci(3);
        nba.huojian();
        w.huojian();
    }
}

class ceshi1{
    public ceshi1(){
        super();
    };
    public void huojian(){
        System.out.println("huojian");
    }
    public  void  huixiong(){
        System.out.println("huixiong");
    }

    protected void  maci(int j){
        System.out.println("马刺"+j);
    }
}

class western extends  ceshi1{
    public western(){
        super();
    }

    public void yongshi(){
        System.out.println("勇士");
    }
@Override
    public void  huojian(){

        System.out.println("火箭重写");
    }

}

class  NBA extends western{
    public NBA (){
        super();
    }
}
//向上转型