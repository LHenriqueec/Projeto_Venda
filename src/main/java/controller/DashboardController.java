package controller;

import java.time.Month;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import util.FaturamentoUtils;

public class DashboardController extends Controller {

	@FXML
	private LineChart<String, Double> lnChart;
	
	@FXML
	private void initialize() {
		onAtualizar();
	}
	
	@FXML
	private void onAtualizar() {
		lnChart.getData().clear();
		XYChart.Series<String, Double> series = new XYChart.Series<>();
		series.setName("R$");
		series.getData().add(new XYChart.Data<>("Jan", carregar(Month.JANUARY)));
		series.getData().add(new XYChart.Data<>("Fev", carregar(Month.FEBRUARY)));
		series.getData().add(new XYChart.Data<>("Mar", carregar(Month.MARCH)));
		series.getData().add(new XYChart.Data<>("Abr", carregar(Month.APRIL)));
		series.getData().add(new XYChart.Data<>("Mai", carregar(Month.MAY)));
		series.getData().add(new XYChart.Data<>("Jun", carregar(Month.JUNE)));
		series.getData().add(new XYChart.Data<>("Jul", carregar(Month.JULY)));
		series.getData().add(new XYChart.Data<>("Ago", carregar(Month.AUGUST)));
		series.getData().add(new XYChart.Data<>("Set", carregar(Month.SEPTEMBER)));
		series.getData().add(new XYChart.Data<>("Out", carregar(Month.OCTOBER)));
		series.getData().add(new XYChart.Data<>("Nov", carregar(Month.NOVEMBER)));
		series.getData().add(new XYChart.Data<>("Dez", carregar(Month.DECEMBER)));
		lnChart.getData().add(series);
	}
	
	private double carregar(Month month) {
		return FaturamentoUtils.readTotal(month);
	}
}
