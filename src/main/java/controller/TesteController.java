package controller;

import java.io.File;

import org.w3c.dom.NodeList;

import entity.Produto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ProdutoService;
import util.CreateViewUtil;
import util.XmlUtils;

public class TesteController extends Controller {
	
	private ProdutoService service;

	@FXML
	private TableView<Produto> tblProdutos;

	@FXML
	private void initialize() {
		service = new ProdutoService();
		handlerTableAction();
	}

	@FXML
	private void chooseFile() {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Escolha um arquivo");
		File file = chooser.showOpenDialog(new Stage());

		updateTable(file);
	}

	private void updateTable(File file) {
		NodeList nodes = XmlUtils.carregarXML("fat035_1", file.toPath());
		tblProdutos.setItems(FXCollections.observableArrayList(XmlUtils.readProduto(nodes)));
	}

	
			
	private void handlerTableAction() {
		tblProdutos.setOnMouseClicked(e -> {
			System.out.println(getController("Novo_Produto").getSimpleName());
			try {
				Produto produto = tblProdutos.getSelectionModel().getSelectedItem();
				int index = tblProdutos.getSelectionModel().getSelectedIndex();
				changeProduto(produto, service.getProduto());
				
				if (e.getClickCount() == 2 && !tblProdutos.getSelectionModel().isEmpty()) {
					CreateViewUtil.createViewByNode(getScreen("Novo_Produto"), "Novo Produto", "ProdutoNovo");
				}
				
				tblProdutos.getItems().set(index, service.getProduto());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
	
	private void changeProduto(Produto newProduto, Produto oldProduto) {
		oldProduto.setCodigo(newProduto.getCodigo());
		oldProduto.setCusto(newProduto.getCusto());
		oldProduto.setEan(newProduto.getEan());
		oldProduto.setGrupo(newProduto.getGrupo());
		oldProduto.setMarca(newProduto.getMarca());
		oldProduto.setNcm(newProduto.getNcm());
		oldProduto.setNome(newProduto.getNome());
		oldProduto.setPeso(newProduto.getPeso());
		oldProduto.setUnMedida(newProduto.getUnMedida());
	}
}
