package controller;

import java.io.File;
import java.util.List;

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
		service = ProdutoService.getService();
		handlerSelectedTable();

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

		if (file == null)
			return;
		XmlUtils.loadProdutoToFile(file);
		Stage stage = new Stage();

		CreateViewUtil.createView(stage, "/view/Dialog_Novo_Produto.fxml", "Produtos XML");
		stage.showAndWait();
	}

	@FXML
	private void onScreenNewProduto() {
		CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
	}

	@SuppressWarnings("unused")
	private void verifyExist() {
		try {
			List<Produto> produtos = service.getProdutos();
			// TODO: Colocar os itens, repetidos carregados do XML e do Banco de
			// Dados, em negrito e vermelho
			tblProduto.getItems().filtered(produtos::contains);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	private void handlerSelectedTable() {
		tblProduto.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				int index = tblProduto.getSelectionModel().getSelectedIndex();
				Produto produto = tblProduto.getItems().get(index);
				service.setProduto(produto);
				CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
			}
		});
	}
}
