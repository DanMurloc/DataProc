import java.awt.*;
import java.util.ArrayList;

public class QuestOne {
    public ArrayList TransformData(double[][] arr) {
        final int ALSB = 16384;

        final double g = 9.8;
        var list1 = new ArrayList<Double>();
        var list2 = new ArrayList<Double>();
        var list3 = new ArrayList<Double>();
        var listt = new ArrayList<Double>();
        var listf = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < arr.length; i++) {
            double t = arr[i][0];
            double ax = arr[i][1];
            double ay = arr[i][2];
            double az = arr[i][3];

            double aux = (double) (ax / (double) ALSB) * g;
            double auy = (double) (ay / (double) ALSB) * g;
            double auz = (double) (az / (double) ALSB) * g;
            list1.add(aux);
            list2.add(auy);
            list3.add(auz);
            listt.add(t);
        }
        listf.add(list1);
        listf.add(list2);
        listf.add(list3);
        listf.add(listt);
        return listf;
    }

    public ArrayList TransformData2(double[][] arr) {
        final int GLSB = 131;
        var list1 = new ArrayList<Double>();
        var list2 = new ArrayList<Double>();
        var list3 = new ArrayList<Double>();
        var listt = new ArrayList<Double>();
        var listf = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < arr.length; i++) {
            double t = arr[i][0];
            double gx = arr[i][4];
            double gy = arr[i][5];
            double gz = arr[i][6];
            double gtx = gx / (double) GLSB;
            double gty = gy / (double) GLSB;
            double gtz = gz / (double) GLSB;
            list1.add(gtx);
            list2.add(gty);
            list3.add(gtz);
            listt.add(t);
        }
        listf.add(list1);
        listf.add(list2);
        listf.add(list3);
        listf.add(listt);
        return listf;
    }

    public double Frequency(Double[] t) {
        double interval = t[t.length - 1] - t[0];
        double hz = (double) (t.length - 1) / interval;
        return hz;
    }
}
