package controller;

import java.io.File;

import entity.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ProdutoService;
import service.ServiceException;
import util.CreateViewUtil;
import util.XmlUtils;

public class ProdutoController extends Controller {

	private ProdutoService service;


	@FXML
	private TableView<Produto> tblProduto;

	@FXML
	private void initialize() {
		service = new ProdutoService();
		try {
			tblProduto.setItems(FXCollections.observableList(service.getProdutos()));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void searchFile() {
		FileChooser chooser = new FileChooser();
		File file = chooser.showOpenDialog(new Stage());

		if (file == null) return;
		XmlUtils.loadProdutoToFile(file);
		Stage stage = new Stage();

		CreateViewUtil.createView(stage, "/view/Dialog_Novo_Produto.fxml", "Produtos XML");
		stage.showAndWait();
	}

	@FXML
	private void onScreenNewProduto() {
		CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
	}
}












