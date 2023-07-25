package maplearn;

import java.util.ArrayList;
import java.util.Collections;

public class NewsExercise {
    public static void main(String[] args) {
        News news1 = new News("新冠sadasdasdasdasdasdasdsad");
        News news2 = new News("男子");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        for(Object news:arrayList){
            News temnews=(News)news;
            System.out.println(processTitle(temnews.getTitle()));
        }
    }
    public static String processTitle(String title){
        if(title==null){
            return "";
        }
        if (title.length()>15){
            return  title.substring(0,15)+"...";
        }else {
            return title;
        }
    }
}
