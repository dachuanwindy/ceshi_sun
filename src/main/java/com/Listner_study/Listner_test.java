package com.Listner_study;

public class Listner_test {

    public static void main(String[] args) {

        System.out.println("监听测试");


        person p = new person();
        p.regesiterPerson(new personListner() {
            @Override
            public void doeat(Event event) {
                person p = event.getPerson();

                System.out.println(p + "在吃东西");

            }

            @Override
            public void dorun(Event event) {
                person p = event.getPerson();
                System.out.println(p + "在跑步");
            }
        });
        p.eat();
        p.run();


    }
}
