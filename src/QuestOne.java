import java.util.ArrayList;

public class QuestOne
{
    public ArrayList TransformData(double[][] arr)
    {
        final int ALSB = 16384;
        final int GLSB = 131;
        final double g = 9.8;
        var list1 = new ArrayList<Double>();
        var list2 = new ArrayList<Double>();
        var list3 = new ArrayList<Double>();
        var listt = new ArrayList<Double>();
        var listf = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < arr.length; i++)
        {
            double t = arr[i][0];
            double ax = arr[i][1];
            double ay = arr[i][2];
            double az = arr[i][3];

            double AX_X0 = (double)(ax / (double)ALSB) * g;
            double AY_Y0 = (double)(ay / (double)ALSB) * g;
            double AZ_Z0 = (double)(az / (double)ALSB) * g;
            list1.add(AX_X0);
            list2.add(AY_Y0);
            list3.add(AZ_Z0);
            listt.add(t);
        }
        listf.add(list1);
        listf.add(list2);
        listf.add(list3);
        listf.add(listt);
        return listf;
    }
}
