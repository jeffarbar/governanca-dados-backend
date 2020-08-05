package br.com.claro.catalogo.dados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//analogia indexName==banco de dados, type==tabela
@Document(indexName = "governanca", type = "catalogodados")
public class CatalogoDadosModel {

	@Id
	private String id;
	
	private String nameTable;
	
	private String bancoDado;
	
	private String parentPath;
	
	private String name;
	
	private String definition;
	
	private String dominioNegocio;
	
	private String assunto;
	
	private String origem;
	
	private String dominioDados;
	
	private String subDominioDados;

	private String labels;
	
	private String grupoDominioDados;
	
	private String type; 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBancoDado() {
		return bancoDado;
	}

	public void setBancoDado(String bancoDado) {
		this.bancoDado = bancoDado;
	}


	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	
	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getDominioNegocio() {
		return dominioNegocio;
	}

	public void setDominioNegocio(String dominioNegocio) {
		this.dominioNegocio = dominioNegocio;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDominioDados() {
		return dominioDados;
	}

	public void setDominioDados(String dominioDados) {
		this.dominioDados = dominioDados;
	}

	public String getSubDominioDados() {
		return subDominioDados;
	}

	public void setSubDominioDados(String subDominioDados) {
		this.subDominioDados = subDominioDados;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getGrupoDominioDados() {
		return grupoDominioDados;
	}

	public void setGrupoDominioDados(String grupoDominioDados) {
		this.grupoDominioDados = grupoDominioDados;
	}

}
