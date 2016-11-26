package controller;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.NodeList;

import entity.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ProdutoService;
import service.ServiceException;
import util.CreateViewUtil;
import util.XmlUtils;

public class TesteController extends Controller {
	
	private ProdutoService service;

	@FXML
	private TableView<Produto> tblProdutos;
	@FXML
	private TableView<Produto> tblNotFind;
	@FXML
	private Label lblText;

	@FXML
	private void initialize() {
		service = ProdutoService.getService();
		handlerTableAction();
	}

	@FXML
	private void chooseFile() throws ServiceException {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Escolha um arquivo");
		File file = chooser.showOpenDialog(new Stage());
		
		if (file != null) updateView(file);
	}

	private void updateView(File file) throws ServiceException {
		NodeList nodes = XmlUtils.carregarXML("fat035_1", file.toPath());
		
		ObservableList<Produto> produtos = FXCollections.observableArrayList(XmlUtils.readProduto(nodes));
		List<Produto> produtosDAO = service.getProdutos();
		
		List<Produto> listContains = produtosDAO.stream().filter(produtos::contains).collect(Collectors.toList());
		List<Produto> listNotContains = produtos.stream().filter(p -> !produtosDAO.contains(p)).collect(Collectors.toList());
		
		tblProdutos.setItems(FXCollections.observableArrayList(listContains));
		
		if (!listNotContains.isEmpty()) {
			lblText.setVisible(true);
			tblNotFind.setVisible(true);
			tblNotFind.setItems(FXCollections.observableArrayList(listNotContains));
		}
	}

	private void handlerTableAction() {
		tblProdutos.setOnMouseClicked(e -> {
			try {
				if (e.getClickCount() == 2 && !tblProdutos.getSelectionModel().isEmpty()) {
					int index = tblProdutos.getSelectionModel().getSelectedIndex();
					Produto produto = tblProdutos.getItems().get(index);
					service.setProduto(produto);
					CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
					tblProdutos.getItems().set(index, produto);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		tblNotFind.setOnMouseClicked(e -> {
			try {
				if (e.getClickCount() == 2 && !tblProdutos.getSelectionModel().isEmpty()) {
					int index = tblProdutos.getSelectionModel().getSelectedIndex();
					Produto produto = tblProdutos.getItems().get(index);
					service.setProduto(produto);
					CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
					tblProdutos.getItems().set(index, produto);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
