package codefun2000;

import java.text.DecimalFormat;
import java.util.Scanner;

public class oppo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double x2 =  scanner.nextDouble();
        double y1 =  scanner.nextDouble();
        double y2 =  scanner.nextDouble();
        double x =  scanner.nextDouble();
        double y =  scanner.nextDouble();
        double width = Math.abs(x1 - x2);
        double height = Math.abs(y1 - y2);
        double diagonal = Math.sqrt(width * width + height * height) / 2;
        double dist1 = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
        double dist2 = Math.sqrt((x - x2) * (x - x2) + (y - y1) * (y - y1));
        double dist3 = Math.sqrt((x - x1) * (x - x1) + (y - y2) * (y - y2));
        double dist4 = Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
        double radius = Math.max(diagonal, Math.max(dist1, Math.max(dist2, Math.max(dist3, dist4))));

        double area = Math.PI * radius * radius;
        DecimalFormat df44 = new DecimalFormat("#.00");
        System.out.println(  area);
    }
    public  double  dist(double  x1,double  y1,double  x2,double  y2){
        double res;

        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
