package inspur.BXD_JCSP.Bixiangdong_study.duotai_shili2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/3/18 21:57
 */
public class AAAAA {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat  = new SimpleDateFormat();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
