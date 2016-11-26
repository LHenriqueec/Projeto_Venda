package controller;

import entity.Grupo;
import entity.Marca;
import entity.Produto;
import entity.UnidadeMedida;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.ProdutoService;
import service.ServiceException;
import util.CreateViewUtil;
import util.StageGroup;

public class NovoProdutoController extends Controller {

	private ProdutoService service;
	private Produto produto;
	private BooleanProperty newUn;

	@FXML
	private ComboBox<Grupo> cmbGrupo;
	@FXML
	private ComboBox<Marca> cmbMarca;
	@FXML
	private TableView<UnidadeMedida> tbUnidadeMedidas;
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtProduto;
	@FXML
	private TextField txtNcm;
	@FXML
	private TextField txtEan;
	@FXML
	private TextField txtUn;
	@FXML
	private TextField txtQtd;

	@FXML
	private void initialize() throws ServiceException {
		service = ProdutoService.getService();
		newUn = new SimpleBooleanProperty();
		produto = service.getProduto();

		cmbMarca.getItems().setAll(service.getMarcas());
		cmbGrupo.getItems().setAll(service.getGrupos());

		txtUn.disableProperty().bind(newUn.not());
		txtQtd.disableProperty().bind(newUn.not());
		bind(produto);
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
	private void onNewUnMedida() {
		if (newUn.get()) {
			UnidadeMedida um = new UnidadeMedida();

			if (!txtUn.getText().isEmpty() && !txtQtd.getText().isEmpty()) {
				um.setUnidade(txtUn.getText().toUpperCase());
				um.setQuantidade(Integer.parseInt(txtQtd.getText()));

				produto.getUnMedida().add(um);
				tbUnidadeMedidas.getItems().add(um);
			}
			txtUn.clear();
			txtQtd.clear();
		}
		newUn.set(!newUn.get());
		txtUn.requestFocus();
	}

	@FXML
	private void onSalvar() throws ServiceException {
		produto.setGrupo(cmbGrupo.getValue());
		produto.setMarca(cmbMarca.getValue());

		tbUnidadeMedidas.getItems().forEach(produto.getUnMedida()::add);
		StageGroup.finishStage("ProdutoNovo");
		service.salvar(produto);
	}

	@FXML
	private void onCancelar() {
		StageGroup.finishStage("ProdutoNovo");
	}

	private void bind(Produto produto) {
		txtCodigo.textProperty().bindBidirectional(produto.codigoProperty());
		txtProduto.textProperty().bindBidirectional(produto.nomeProperty());
		txtEan.textProperty().bindBidirectional(produto.eanProperty());
		txtNcm.textProperty().bindBidirectional(produto.ncmProperty());
	}
}