import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class hello {
    static long nd=1000*24*60*60;
    public static void main (String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String d1= sdf.format(date);
        System.out.println("日期"+d1);
        String s="2020-3-21";
        Date startday=sdf.parse(s);
        long a=date.getTime();
        long b=startday.getTime();
        long c=a-b;
        System.out.println(c/nd);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }


    }
}
