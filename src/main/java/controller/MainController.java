package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController extends Controller {

	
	@FXML
	private void onExit() {
		Platform.exit();
	}
	
	@FXML
	private void onProduto() {
		goToScreen("Produto");
	}
	
	@FXML
	private void ontNovo_Produto() {
		goToScreen("Novo_Produto");
	}
	
	@FXML
	private void onDashboard() {
		goToScreen("Dashboard");
	}
}
