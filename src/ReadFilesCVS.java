import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFilesCVS
{
    public double[][] ReadFils(double[][] arr2, String filePath) {
        String csvFilePath = filePath;
        int n = 5; // Количество элементов для удаления из начала массива

        double[][] arr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Пропускаем первые n строк
            for (int i = 0; i < n; i++) {
                br.readLine();
            }

            String line;
            // Считываем оставшиеся строки в массив lines
            String[] lines = br.lines().toArray(String[]::new);

            // Создаем двумерный массив
            String[][] twoDimensionalArray = new String[lines.length][];

            // Заполняем двумерный массив
            for (int i = 0; i < lines.length; i++) {
                twoDimensionalArray[i] = lines[i].split(",");
            }

            arr = new double[twoDimensionalArray.length][twoDimensionalArray[0].length];

            // Парсим строки в double и заполняем arr
            for (int i = 0; i < twoDimensionalArray.length; i++) {
                for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                    arr[i][j] = Double.parseDouble(twoDimensionalArray[i][j]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        arr2 = arr;
        return arr2;
    }

    public void DataPrint(double [][] arr)
    {
        // Вывод двумерного массива (если нужен)
        for (double[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
