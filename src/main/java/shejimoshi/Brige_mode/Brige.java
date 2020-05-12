package shejimoshi.Brige_mode;

class B {

    public static void main(String args[]) {
        System.out.println("www");
        int a[] = {1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4};
        find(a, 4);
    }

    static void find(int a[], int value) {

        int count = 0;
        int low = 0;
        int high = a.length - 1;
        int md = 0;

        while (high >= low) {
            md = (low + high) / 2;
            if (a[md] > value) {
                high = md;
            } else if (a[md] < value) {
                low = md;
            } else if (a[md] == value) {
                break;
            }
        }
        for (int j = md; a[j] == value && j <= a.length; j++) {
            count++;
        }
        for (int i = md; a[i] == value && i > 0; i--) {
            count++;
        }
        System.out.println(count - 1);
    }
}
