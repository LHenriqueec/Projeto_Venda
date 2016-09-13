package service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dao.DAOException;
import dao.DaoFactory;
import dao.GrupoDAO;
import entity.Grupo;
import entity.Produto;

public class GrupoService {
	
	private GrupoDAO dao;
	
	public GrupoService() {
		dao = DaoFactory.getInstance().getGrupoDAO();
	}

    public List<Produto> getList() {
        return getXML();
    }

    private List<Produto> getXML() {
    	List<Produto> produtos = new ArrayList<>();

    	try {
    		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Files.newInputStream(Paths.get("C:\\Users\\LuizS\\Documents\\Nota5.xml")));
    		
    		Produto produto = null;
    		NodeList root = doc.getElementsByTagName("det");
    		
    		for (int i = 0; i < root.getLength(); i++) {
    			produto = new Produto();
    			Element prodTag = (Element) root.item(i);
    			produto.setCodigo(prodTag.getElementsByTagName("cProd").item(0).getTextContent());
    			produto.setNome(prodTag.getElementsByTagName("xProd").item(0).getTextContent());
    			produto.setCusto(Double.parseDouble(prodTag.getElementsByTagName("vUnCom").item(0).getTextContent()));
    			
    			produtos.add(produto);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return produtos;
    }
    
    public void salvar(Grupo grupo) throws ServiceException {
    	try {
    		
    		dao.salvar(grupo);
    		
    	} catch (DAOException e) {
    		throw new ServiceException(e);
    	}
    }
}












