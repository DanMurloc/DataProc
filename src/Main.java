import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AxyAndGyro a = new AxyAndGyro();
        a.InicParams();
        System.out.println();
        String projectDirectory = System.getProperty("user.dir"); // Получаем текущую директорию проекта
        String csvFilePath = projectDirectory + "\\Date\\data1.csv"; // Формируем путь к файлу
        ReadFilesCVS c = new ReadFilesCVS();
        double[][] arrData = null;
        arrData=c.ReadFils(arrData, csvFilePath);
        //c.DataPrint(arrData);
        ArrayList<List<double[]>> list1 = new ArrayList<>();
        QuestOne q1 = new QuestOne();
        list1 = q1.TransformData(arrData);
        // Создаем одномерные массивы для хранения элементов
        Double[] arrf1 = list1.get(0).toArray(Double[]::new);
        Double[] arrf2 = list1.get(1).toArray(Double[]::new);
        Double[] arrf3 = list1.get(2).toArray(Double[]::new);
        Double[] arrft = list1.get(3).toArray(Double[]::new);


        CreateGraph g = new CreateGraph();
        g.Charting(arrf1,arrft);

    }
}

