import java.util.ArrayList;

public class QuestThree {
    public ArrayList QuatToEaler(double[][] arr)
    {
        ArrayList<ArrayList<Double>> ListF = new ArrayList<>();

        ArrayList<Double> List1 = new ArrayList<>();
        ArrayList<Double> List2 = new ArrayList<>();
        ArrayList<Double> List3 = new ArrayList<>();
        ArrayList<Double> Listt = new ArrayList<>();

        ArrayList<Double> ListAX = new ArrayList<>();
        ArrayList<Double> ListAY = new ArrayList<>();
        ArrayList<Double> ListAZ = new ArrayList<>();

        ArrayList<Double> ListGX = new ArrayList<>();
        ArrayList<Double> ListGY = new ArrayList<>();
        ArrayList<Double> ListGZ = new ArrayList<>();
        for (int i =0;i<arr.length;i++)
        {
            Double t = arr[i][1];
            Double qx = arr[i][2];
            Double qy = arr[i][3];
            Double qz = arr[i][4];
            Double qw = arr[i][5];

            Double psi = Math.atan2(2*(qw*qx+qy*qz),1-2*Math.pow(qx,2)- 2*Math.pow(qz,2));
            Double phi =  Math.asin(2 * qw * qy - qx * qz);
            Double teta = Math.atan2(2*(qw*qz+qx*qy),1-2*Math.pow(qy,2)- 2*Math.pow(qz,2));
            //Преобразование радиан в градусы
            psi = psi * (180.0 / Math.PI);
            phi = phi * (180.0 / Math.PI);
            teta = teta * (180.0 / Math.PI);

            List1.add(psi);
            List2.add(phi);
            List3.add(teta);
            Listt.add(t);
            ListAX.add(arr[i][6]);
            ListAY.add(arr[i][7]);
            ListAZ.add(arr[i][8]);

            ListGX.add(arr[i][9]);
            ListGY.add(arr[i][10]);
            ListGZ.add(arr[i][11]);
        }
        ListF.add(List1);
        ListF.add(List2);
        ListF.add(List3);
        ListF.add(Listt);
        ListF.add(ListAX);
        ListF.add(ListAY);
        ListF.add(ListAZ);
        ListF.add(ListGX);
        ListF.add(ListGY);
        ListF.add(ListGZ);
        return ListF;
    }

    public double Dreyf(Double[] arrz, Double[] arrt)
    {
        double dreyf = ((arrz[arrz.length - 1] - arrz[0]) / (arrt[arrt.length - 1] - arrt[0])) * 3600;
        return dreyf;
    }

    public ArrayList AllanVariance(Double[] storageMath)
    {
        var result = new ArrayList<Double>();
        var diap = new ArrayList<Double>();

        int N = storageMath.length; // определяем кол-во элементов входного массива
        double sum;
        int myN;
        int i, j, k;
        double[] avr;
        avr = new double[N];
        int shag = 0;

        for (i = 1; i <= N / 500; i++)
        {
            myN = N / i; // усредняем диапазон
            for (j = 0; j <= myN - 1; j++)
            {
                sum = 0;
                for (k = j * i; k < j * i + i; k++)
                {
                    sum += storageMath[k]; // суммируем элементы
                }
                avr[j] = sum / i; // делим суммы элементов на кол-во
            }
            sum = 0; // обнуляем
            for (j = 0; j < (myN - 1); j++)
            {
                sum += Math.pow((avr[j + 1] - avr[j]), 2); // вычисляем разницы средних значений
            }
            result.add(Math.sqrt(sum / (2 * (myN - 1))));
            diap.add((double) shag);
            shag += 500;
        }
        ArrayList<ArrayList<Double>> last = new ArrayList<ArrayList<Double>>();
        last.add(diap);
        last.add(result);
        return last;
    }

}
