package controller;

import entity.Grupo;
import entity.Marca;
import entity.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import service.ProdutoService;
import service.ServiceException;
import util.CreateViewUtil;
import util.StageGroup;

public class NovoProdutoController extends Controller {

	private ProdutoService service;
	private Produto produto;
	
	@FXML
	private ComboBox<Grupo> cmbGrupo;
	@FXML
	private ComboBox<Marca> cmbMarca;
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtProduto;
	@FXML
	private TextField txtNcm;
	@FXML
	private TextField txtEan;

	@FXML
	private void initialize() throws ServiceException {
		service = new ProdutoService();
		
		cmbMarca.getItems().setAll(service.getMarcas());
		cmbGrupo.getItems().setAll(service.getGrupos());
	}

	@FXML
	private void onNewMarca() throws ServiceException {
		CreateViewUtil.createViewByNode(getScreen("Nova_Marca"), "Nova Marca", "Marca");
		cmbMarca.getItems().setAll(service.getMarcas());
	}

	@FXML
	private void onNewGrupo() throws ServiceException {
		CreateViewUtil.createViewByNode(getScreen("Novo_Grupo"), "Novo Grupo", "Grupo");
		cmbGrupo.getItems().setAll(service.getGrupos());
	}
	
	@FXML
	private void onSalvar() throws ServiceException {
		service.salvar(produto);
	}

	@FXML
	private void onCancelar() {
		StageGroup.finishStage("ProdutoNovo");
	}
}