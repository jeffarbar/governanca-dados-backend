package br.com.claro.catalogo.dados.vo;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.claro.catalogo.dados.model.CatalogoDadosModel;

public class CatalogoDadoVo {

	public CatalogoDadoVo() {}
	
	public CatalogoDadoVo(CatalogoDadosModel model) {
		BeanUtils.copyProperties(model , this);	
		if(this.nameTable == null) {
			this.nameTable = this.name;
		}
	}

	private String id;
	
	@JsonProperty("Caminho")
	private String parentPath;
	
	@JsonProperty("Nome Tabela")
	private String nameTable;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("Nome Atributo")
	private String name;
	
	@JsonProperty("Definição")
	private String definition;
	
	@JsonProperty("Origem")
	private String origem;
	
	
	@JsonProperty("Banco de Dados")
	private String bancoDado;
	
	
	@JsonProperty("Domínio Negócio")
	private String dominioNegocio;
	
	
	@JsonProperty("Assunto")
	private String assunto;
	
	
	@JsonProperty("Domínio Dados")
	private String dominioDados;
	
	@JsonProperty("Sub Domínio Dados")
	private String subDominioDados;
	
	
	@JsonProperty("Labels")
	private String labels;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
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

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getBancoDado() {
		return bancoDado;
	}

	public void setBancoDado(String bancoDado) {
		this.bancoDado = bancoDado;
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
}
