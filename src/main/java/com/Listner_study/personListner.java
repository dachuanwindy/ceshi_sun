package com.Listner_study;

public interface personListner {


    void doeat(Event event);

    void dorun(Event event);
}


class Event {


    public com.Listner_study.person getPerson() {
        return person;
    }

    public void setPerson(com.Listner_study.person person) {
        this.person = person;
    }

    public person person;

    public Event() {
    }

    public Event(person person) {
        this.person = person;
    }


}


//person 事件为 源
class person {

    private personListner listner;

    public void run() {

        if (listner != null) {
            System.out.println(" 跑步");
        }
    }

    public void eat() {
        if (listner != null) {
            System.out.println("吃饭···");
            listner.doeat(new Event());
        }
    }

    public void regesiterPerson(personListner personListner) {
        this.listner = personListner;

        System.out.println("注册成功");
    }
}