package SuanFa_study.DemoKP;

public class KuaipaiDemo {

    public static void main(String args[]) {
        //   int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        //quickSort(a, 0, a.length - 1);
        //   ceshi1(a, 0, a.length - 1);
        // ceshi2(a, 0, a.length - 1);
        // 递归算法
        //int ss = suanfa2(10);
        //System.out.println("...>>>" + ss);
        //输出素数
        //  suanfa1();
        //水仙数
        //suanfa3();
        //质数分解
        //    suanfa4(6);
        //suanfa5(12, 7);
        //判断组合个数
        //  suanfa6();
        // 插入排序
        // insert_paixu(a);
        //   Insert_paxu11(a);


 /*       Map<String, String> map = new HashMap<String, String>();
        map.put("1", "23");
        map.put("2", "2j");
        map.put("3", "24");
        map.put("5", "21");*/

/*        for (String e : map.keySet()) {
            String str = map.get(e);
            System.out.println(str);
        }*/

 /*       Iterator<Map.Entry<String, String>> It = map.entrySet().iterator();
        while (It.hasNext()) {
            Map.Entry<String, String> ee = It.next();
            String w = ee.getKey();
            String e = ee.getValue();
            System.out.println(e + "====" + w);}*/

        Binary_find(100);


    }

    public void KP(int left, int right, int a[]) { // quicksorted
        int i = left;
        int j = right;
        int key = a[left];
        while (i < j && a[j] >= key) {
            j--;
            if (i < j && a[j] < key) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        while (i < j && a[i] < key) {
            i++;
            if (i < j && a[i] > key) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        a[left] = a[i];
        a[i] = key;
        KP(left, i - 1, a);
        KP(i + 1, right, a);

        for (int f = 0; f < a.length; f++) {
            System.out.println("输出排序后");
        }
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            while (i <= j) {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            }
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);


        }
        for (int ff = 0; ff < numbers.length; ff++) {

            System.out.println("paxu " + numbers[ff]);
        }
    }


    public static void ceshi1(int[] a, int left, int right) {

        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        int temp;
        int base = a[left];
        while (i <= j) {
            while (a[i] < base && i < right) i++;
            while (base < a[j] && left < j) j--;
            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            ceshi1(a, left, j);
        }
        if (right > i) {
            ceshi1(a, i, right);
        }

    }


    public static void ceshi2(int a[], int left, int right) {
        System.out.println("快速排序测试输出");

        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp;
        int base = a[left];
        while (i <= j) {
            while (i < right && base > a[i]) i++;
            while (j > left && base < a[j]) j--;
            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) ceshi2(a, left, j);
        if (i < right) ceshi2(a, i, right);
        for (int s = 0; s < a.length; s++)
            System.out.println(">>>" + a[s]);
    }

    //找出1-200之间的素数
    public static void suanfa1() {
        int count = 0;
        for (int i = 2; i < 15; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println("输出的素数为》》》" + i);
                System.out.println("个数为" + count);
            }
        }

    }

    // 找出100个数，规律：1 1 2 3 5 8 13， 递归算法
    public static int suanfa2(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return suanfa2(i - 1) + suanfa2(i - 2);
        }


    }

    // 插入排序法
    public static void charupaixu(int a[]) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j > 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
        }
    }

    //水仙花数
    public static void suanfa3() {

        int ge = 0;
        int shi = 0;
        int bai = 0;
        for (int i = 100; i < 999; i++) {

            ge = i % 100 % 10;
            shi = (i % 100) / 10;
            bai = (i - ge - 10 * shi) / 100;
            if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai)
                System.out.println(i);
        }
    }

    //zhishufenjie
    public static void suanfa4(int i) {

        for (int x = 2; x <= i; x++) {
            if (i % x == 0) {
                System.out.print(x);
                if (i != x) {
                    System.out.print("*");
                }
                suanfa4(i / x);
            }

        }


        //最小公倍数， 最大公约数


    }

    // 最大公约数,最小公倍数为 a*b/a,b的最大公约数
    public static void suanfa5(int x, int y) {
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        int a = x;

        while ((x % a) != 0 || (y % a) != 0) {
            a--;
            if (a == 0) break;
        }
        System.out.println("最大公约数" + a);
    }


    public static void suanfa6() {

        int count = 0;
        for (int i = 0; i <= 4; i++)
            for (int j = 0; j <= 4; j++)
                for (int m = 0; m <= 4; m++) {
                    if (i != j && j != m && m != i) {
                        count++;
                    }

                }


    }


    public static void insert_paixu(int a[]) {

        int i, j, Datenote;
        for (i = 1; i < a.length; i++) {
            Datenote = a[i];
            j = i - 1;
            while (j >= 0 && Datenote < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = Datenote;
        }

        for (int s = 0; s < a.length; s++) {
            System.out.println("插入排序 的输出为：：" + a[s]);
        }
    }

    public static void Insert_paxu11(int a[]) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];

            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }


        for (int i = 0; i < a.length; i++) {
            System.out.println("INsert_kaixu====" + a[i]);
        }
    }


    //希尔排序  首先是计算跨度，然后在缩小跨度
    public static void shell_paixu(int a[]) {
        int h = 1;
        while (h < a.length / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            int temp;
            for (int i = h; i < a.length; i++) {
                temp = a[i];
                int j = i - h;
                while (j > h - 1 && a[j - h] > temp) {

                    a[j] = a[j - h];
                    j = j - h;
                }
                a[j] = temp;
            }
            h = (h - 1) / 3;
        }
    }


//二分法查找，实现统计个数  ---面试题

    public static void Binary_find(int key) {
        int a[] = {1, 2, 2, 2, 2, 2, 6, 7, 8, 9, 11, 14, 15, 18, 20, 30, 45};


        int count = 0;
        int left = 0, right = a.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (key < a[middle]) {
                right = middle - 1;
            }
            if (key > a[middle]) {
                left = middle + 1;
            }
            if (key == a[middle]) {
                System.out.println("find it");
                break;
            }
        }
        int key_1 = middle;
        while (a[middle] == key) {
            middle--;
            count++;
        }
        while (a[key_1 + 1] == key) {
            key_1++;
            count++;
        }

        System.out.println(count);
    }
}


