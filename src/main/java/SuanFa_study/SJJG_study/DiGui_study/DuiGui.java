package SuanFa_study.SJJG_study.DiGui_study;

public class DuiGui {

    public static int Sum(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else
            return Sum(n - 1) + Sum(n - 2);
    }

    public static void main(String[] args) {
        int result = Sum(10);
        System.out.println(result);

        Car car1 = new Car("car1");

        Car car2 = new Car("car2");
        System.out.println(car1.equals(car2));

    }

}


class Car {


    private String name;

    Car() {

    }

    Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        Car car = new Car();
        String name = car.name;
        return name.hashCode();
    }
}