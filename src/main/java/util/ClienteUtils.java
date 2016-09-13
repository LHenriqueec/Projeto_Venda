package util;

import org.w3c.dom.NamedNodeMap;

import dao.DAOException;
import dao.DaoFactory;
import entity.Cliente;
import entity.Vendedor;

public class ClienteUtils {

	public static void readClientesToXML(NamedNodeMap attributes) throws DAOException {
		String nomeVendedor = attributes.getNamedItem("id_vendedor").getTextContent().split("-")[1];
		Vendedor vendedor = DaoFactory.getInstance().getVendedorDAO().getVendedorByNome(nomeVendedor);
		
		Cliente cliente = new Cliente();
		cliente.setCnpj(attributes.getNamedItem("cnpj_cpf").getTextContent());
		cliente.setInscEstadual(attributes.getNamedItem("insc_estadual").getTextContent());
		cliente.setRazao(attributes.getNamedItem("razao_social").getTextContent());
		cliente.setFantasia(attributes.getNamedItem("nm_fantasia").getTextContent());
		cliente.setVendedor(vendedor);
		DaoFactory.getInstance().getClienteDAO().salvar(cliente);
		
		
		System.out.println(cliente);
	}
}
