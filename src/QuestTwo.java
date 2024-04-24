import java.util.ArrayList;

public class QuestTwo {
    public ArrayList Komplemetarns(double[][] arr) {
        var list1 = new ArrayList<Double>();
        var list2 = new ArrayList<Double>();
        var list3 = new ArrayList<Double>();
        var listt = new ArrayList<Double>();
        var listf = new ArrayList<ArrayList<Double>>();

        final double k = 0.9;
        final double g = 9.8;
        final double Rad = 57.2958;
        final int ALSB = 16384;
        final int GLSB = 131;

        for (int i = 1; i < arr.length; i++) {
            double dt = arr[i][0] - arr[i - 1][0];

            double g_x0 = arr[i - 1][4];
            double g_x = arr[i][4];

            double g_y0 = arr[i - 1][5];
            double g_y = arr[i][5];

            double g_z0 = arr[i - 1][6];
            double g_z = arr[i][6];

            double a_x0 = arr[i - 1][1];
            double a_x = arr[i][1];

            double a_y0 = arr[i - 1][2];
            double a_y = arr[i][2];

            double a_z0 = arr[i - 1][3];
            double a_z = arr[i][3];

            double gx0 = (double) g_x0 / (double) GLSB;
            double gy0 = (double) g_y0 / (double) GLSB;
            double gz0 = (double) g_z0 / (double) GLSB;

            double gx = (double) g_x / (double) GLSB;
            double gy = (double) g_y / (double) GLSB;
            double gz = (double) g_z / (double) GLSB;

            double ax0 = (double) a_x0 / (double) ALSB;
            double ay0 = (double) a_y0 / (double) ALSB;
            double az0 = (double) a_z0 / (double) ALSB;


            double angle_accelx0 = Rad * Math.acos(ax0);
            double angle_accely0 = Rad * Math.acos(ay0);
            double angle_accelz0 = 0;

            double angleGyroskopX = angle_accelx0 + gx * dt;
            double angleGyroskopY = angle_accely0 + gy * dt;
            double angleGyroskopZ = angle_accelz0 + gz * dt;

            double ax = (double) a_x / (double) ALSB;
            double ay = (double) a_y / (double) ALSB;
            double az = (double) a_z / (double) ALSB;

            double angle_accelx = Rad * Math.acos(ax);
            double angle_accely = Rad * Math.acos(ay);
            double angle_accelz = Rad * Math.acos(az);


            double anglext = k * angleGyroskopX + (1 - k) * angle_accelx;
            double angleyt = k * angleGyroskopY + (1 - k) * angle_accely;
            double anglezt = angleGyroskopZ;

            list1.add(anglext);
            list2.add(angleyt);
            list3.add(anglezt);
            listt.add(arr[i][0]);
        }
        listf.add(list1);
        listf.add(list2);
        listf.add(list3);
        listf.add(listt);
        return listf;
    }

    //угловой путь
    public double AnglePath(Double[] arr) {
        double sum = 0;
        for (int i = 1; i < arr.length; i++) {
            double dl = Math.abs(arr[i] - arr[i - 1]);
            if (Double.isNaN(dl)) {
                continue;
            }
            sum += dl;
        }
        return sum;
    }

    //обороты
    public int Turnovers(double sum) {
        return ((int) (sum) / 360);
    }
}
