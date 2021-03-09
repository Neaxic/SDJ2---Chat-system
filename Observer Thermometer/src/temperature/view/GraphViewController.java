package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.ViewModel.ViewmodelSettings;

public class GraphViewController {
    private ViewHandler viewHandler;
    private Region root;
    private ViewmodelSettings viewmodelSettings;
    @FXML private LineChart graph;

    public GraphViewController()
    {
    }

    public void init(ViewHandler viewHandler,  ViewmodelSettings viewmodel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewmodelSettings = viewmodel;
        this.root = root;

        XYChart.Series series1 = new XYChart.Series();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        graph = new LineChart(xAxis, yAxis);
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>(1,20));
        graph.getData().add(series1);

    }
}
