public class AxyAndGyro {

    public AxyAndGyro() {

    }

    public void InicParams() {
        final double k = 0.9;
        final double g = 9.8;
        final double dt = 0.1;
        final double Rad = 57.2958;
        final int ALSB = 16384;
        final int GLSB = 131;

        int g_x0 = -15076;
        int g_x = 10432;

        int g_y0 = 4300;
        int g_y = -1700;

        int g_z0 = -3592;
        int g_z = 1718;

        int a_x0 = 2832;
        int a_x = 3592;

        int a_y0 = -16384;
        int a_y = -10832;

        int a_z0 = -13804;
        int a_z = -12452;

        double gx0 = (double) g_x / (double) GLSB;
        double gy0 = (double) g_y / (double) GLSB;
        double gz0 = (double) g_z / (double) GLSB;

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

        System.out.println(anglext);
        System.out.println(angleyt);
        System.out.println(anglezt);


    }
}
