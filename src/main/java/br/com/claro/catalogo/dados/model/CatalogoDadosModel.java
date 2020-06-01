package br.com.claro.catalogo.dados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//analogia indexName==banco de dados, type==tabela
@Document(indexName = "governanca", type = "catalogodados")
public class CatalogoDadosModel {

	@Id
	private String id;
	
	private String bancoDado;
	
	private String tabela;
	
	private String nome;
	
	private String definicao;
	
	private String dominioNegocio;
	
	private String assunto;
	
	private String dominioDados;
	
	private String subDominioDados;

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

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDefinicao() {
		return definicao;
	}

	public void setDefinicao(String definicao) {
		this.definicao = definicao;
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

}
