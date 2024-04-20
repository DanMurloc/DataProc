import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 0, на лабораторной");
        AxyAndGyro a = new AxyAndGyro();
        a.InicParams();
        System.out.println("################################################");
        String projectDirectory = System.getProperty("user.dir"); // Получаем текущую директорию проекта
        String csvFilePath = projectDirectory + "\\Date\\data1.csv"; // Формируем путь к файлу
        ReadFilesCVS c = new ReadFilesCVS();
        double[][] arrData =c.ReadFils( csvFilePath);
        //c.DataPrint(arrData);
        var list1 = new ArrayList<ArrayList<Double>>();
        QuestOne q1 = new QuestOne();
        list1 = q1.TransformData(arrData);
        // Создаем одномерные массивы для хранения элементов
        Double[] arrf1 = list1.get(0).toArray(Double[]::new);
        Double[] arrf2 = list1.get(1).toArray(Double[]::new);
        Double[] arrf3 = list1.get(2).toArray(Double[]::new);
        Double[] arrft = list1.get(3).toArray(Double[]::new);
        CreateGraph g = new CreateGraph();
        //Графики к первому заданию
        //g.Charting(arrf1,arrft,"График ускорения от времени X","Время, c","Ускорение, м/с^2");
        //g.Charting(arrf2,arrft,"График ускорения от времени Y","Время, c","Ускорение, м/с^2");
        //g.Charting(arrf3,arrft,"График ускорения от времени Z","Время, c","Ускорение, м/с^2");
        list1.clear();
        list1=q1.TransformData2(arrData);
        arrf1=list1.get(0).toArray(Double[]::new);
        arrf2=list1.get(1).toArray(Double[]::new);
        arrf3= list1.get(2).toArray(Double[]::new);
        arrft = list1.get(3).toArray(Double[]::new);
        //Графики ко второму заданию
        //g.Charting(arrf1,arrft,"График ускорения от времени X","Время, с","Скорость, град/c");
        //g.Charting(arrf2,arrft,"График ускорения от времени Y","Время, с","Скорость, град/c");
        //g.Charting(arrf3,arrft,"График ускорения от времени Z","Время, с","Скорость, град/c");
        //Значение частоты к третьему заданию
        System.out.println("Задание 3.1 расчет частоты");
        System.out.println("Значение частоты:\t"+q1.Frequency(arrft)+"Гц");
        System.out.println("################################################");
        var q2 = new QuestTwo();
        list1.clear();
        //задание 2.1 комлементарный фильтр
        list1= q2.Komplemetarns(arrData);
        arrf1=list1.get(0).toArray(Double[]::new);
        arrf2=list1.get(1).toArray(Double[]::new);
        arrf3= list1.get(2).toArray(Double[]::new);
        arrft = list1.get(3).toArray(Double[]::new);
        //g.Charting(arrf1,arrft,"График углового перемещения от времени X","Время, с","Угол, градус");
        //g.Charting(arrf2,arrft,"График углового перемещения от времени Y","Время, с","Угол, градус");
        //g.Charting(arrf3,arrft,"График углового перемещения от времени Z","Время, с","Угол, градус");
        System.out.println("3.2 Расчет углового пути");
        double A1=q2.AnglePath(arrf1);
        double A2=q2.AnglePath(arrf2);
        double A3=q2.AnglePath(arrf3);
        System.out.println("Угловой путь по X: "+A1+" Градусы");
        System.out.println("Угловой путь по Y: "+A2+" Градусы");
        System.out.println("Угловой путь по Z: "+A3+" Градусы");
        System.out.println("3.3 Расчет оборотов");
        System.out.println("Число оборотов по X: "+q2.Turnovers(q2.AnglePath(arrf1))+" Оборотов");
        System.out.println("Число оборотов по Y: "+q2.Turnovers(q2.AnglePath(arrf2))+" Оборотов");
        System.out.println("Число оборотов по Z: "+q2.Turnovers(q2.AnglePath(arrf3))+" Оборотов");

        projectDirectory = System.getProperty("user.dir"); // Получаем текущую директорию проекта
        csvFilePath = projectDirectory + "\\Date\\data2.csv"; // Формируем путь к файлу
        c = new ReadFilesCVS();
        arrData =c.ReadFils( csvFilePath);
        list1.clear();
        QuestThree q3 = new QuestThree();
        list1=q3.QuatToEaler(arrData);
        arrf1=list1.get(0).toArray(Double[]::new);
        arrf2=list1.get(1).toArray(Double[]::new);
        arrf3= list1.get(2).toArray(Double[]::new);
        arrft = list1.get(3).toArray(Double[]::new);
        //Графики ко второму заданию
        //g.Charting(arrf1,arrft,"График углового перемещения  по X","Время, с","Угол, град");
        // g.Charting(arrf2,arrft,"График ускорения от времени Y","Время, с","Угол, град");
        // g.Charting(arrf3,arrft,"График ускорения от времени Z","Время, с","Угол, град");
        System.out.println("################################################");
        System.out.println("Расчёт величины дрейфа углового перемещения по оси Z датчика в град/ч.");
        double dr = q3.Dreyf(arrf3,arrft);
        System.out.println("Величина дрейфа по Z: "+dr+" Градус/ч");
        System.out.println("################################################");
        /* ВАРИАЦИЯ АЛЛАНА
        System.out.println("3.3. Построение графика вариации Аллана для данных гироскопа " +
                "и акселерометра из представленного датасета.");
        arrf1=list1.get(4).toArray(Double[]::new);
        ArrayList<ArrayList<Double>> li = q3.AllanVariance(arrf1);
        Double [] ar = li.get(0).toArray(Double[]::new);
        Double [] ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для аксилирометра  по X","Тау","Вариация");

        arrf1=list1.get(5).toArray(Double[]::new);
        li = q3.AllanVariance(arrf1);
        ar = li.get(0).toArray(Double[]::new);
        ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для аксилирометра  по Y","Тау","Вариация");

        arrf1=list1.get(6).toArray(Double[]::new);
        li = q3.AllanVariance(arrf1);
        ar = li.get(0).toArray(Double[]::new);
        ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для аксилирометра  по Z","Тау","Вариация");

        arrf1=list1.get(7).toArray(Double[]::new);
        li = q3.AllanVariance(arrf1);
        ar = li.get(0).toArray(Double[]::new);
        ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для гироскопа  по X","Тау","Вариация");

        arrf1=list1.get(8).toArray(Double[]::new);
        li = q3.AllanVariance(arrf1);
        ar = li.get(0).toArray(Double[]::new);
        ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для гироскопа  по Y","Тау","Вариация");

        arrf1=list1.get(9).toArray(Double[]::new);
        li = q3.AllanVariance(arrf1);
        ar = li.get(0).toArray(Double[]::new);
        ar2 = li.get(1).toArray(Double[]::new);
        g.Charting(ar2,ar,"График Вариации Аллана для гироскопа  по Z","Тау","Вариация");
        */
    }
}

