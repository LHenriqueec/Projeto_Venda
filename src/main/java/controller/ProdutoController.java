package controller;

import java.io.File;

import dao.DAOException;
import dao.DaoFactory;
import dao.ProdutoDAO;
import entity.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.CreateViewUtil;
import util.XmlUtils;

public class ProdutoController extends Controller {

	private ProdutoDAO dao;


	@FXML
	private TableView<Produto> tblProduto;

	@FXML
	private void initialize() {
		dao = DaoFactory.getInstance().getProdutoDAO();
		try {
			tblProduto.setItems(FXCollections.observableList(dao.getProdutos()));
		} catch (DAOException e) {
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












