package br.com.claro.catalogo.dados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//analogia indexName==banco de dados, type==tabela
@Document(indexName = "governanca", type = "catalogodados")
public class TagModel {

	@Id
	private String id;
	
	private String assunto;

	private String dominioNegocio;
	
	private String dominioDados;
	
	private String subDominioDados; 
	
	private String grupoDominioDados; 
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDominioDados() {
		return dominioDados;
	}

	public void setDominioDados(String dominioDados) {
		this.dominioDados = dominioDados;
	}

	public String getDominioNegocio() {
		return dominioNegocio;
	}

	public void setDominioNegocio(String dominioNegocio) {
		this.dominioNegocio = dominioNegocio;
	}

	public String getSubDominioDados() {
		return subDominioDados;
	}

	public void setSubDominioDados(String subDominioDados) {
		this.subDominioDados = subDominioDados;
	}

	public String getGrupoDominioDados() {
		return grupoDominioDados;
	}

	public void setGrupoDominioDados(String grupoDominioDados) {
		this.grupoDominioDados = grupoDominioDados;
	}

	@Override
	public String toString() {
		return "TagModel [id=" + id + ", assunto=" + assunto + ", dominioNegocio=" + dominioNegocio + ", dominioDados="
				+ dominioDados + ", subDominioDados=" + subDominioDados + ", grupoDominioDados=" + grupoDominioDados
				+ "]";
	}

	
	
}
