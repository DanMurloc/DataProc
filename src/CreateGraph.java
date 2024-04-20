import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.util.stream.DoubleStream;

public class CreateGraph
{
    public void Charting(Double[] arrdata,Double[] arrtime, String title, String X, String Y)
    {
        double[] xData = new double[arrdata.length];
        double[] yData = new double[arrtime.length];

        for (int i = 0; i < arrdata.length; i++) {
            yData[i] = arrdata[i];
            xData[i] = arrtime[i];
        }

        XYChart chart = new XYChart(1200,700);
        chart.setTitle(title);
        chart.setXAxisTitle(X);
        chart.setYAxisTitle(Y);

        // Добавление данных на график как точек без соединительных линий
        chart.getStyler().setMarkerSize(5);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("PS", xData, yData).setMarker(SeriesMarkers.CIRCLE);
        // Show it
        JFrame jFrame = new SwingWrapper(chart).displayChart();
    }
}
