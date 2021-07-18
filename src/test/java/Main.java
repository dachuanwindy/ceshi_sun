
import java.util.Scanner;


class Main {
    private static Scanner in;

    public static void main(String[] args) {

        String[] strings = new Scanner(System.in).nextLine().split(" ");
        Long x = Long.parseLong(strings[0]);
        int y = Integer.parseInt(strings[1]);
        if (y <= 5 && y > 0) {
            int ySum = 1;
            for (int i = 1; i <= y; i++) {
                ySum = 26 * ySum;
            }
            long midValue = x / ySum;
            int result = 0;
            while (midValue != 0) {
                midValue = midValue / 10;
                result++;
            }
            System.out.println(result);
        }
    }
}