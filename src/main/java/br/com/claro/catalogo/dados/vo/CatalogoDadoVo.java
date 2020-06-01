package br.com.claro.catalogo.dados.vo;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.claro.catalogo.dados.model.CatalogoDadosModel;

public class CatalogoDadoVo {

	public CatalogoDadoVo() {}
	
	public CatalogoDadoVo(CatalogoDadosModel model) {
		BeanUtils.copyProperties(model , this);
	}
	
	@JsonProperty("Banco de Dados")
	private String bancoDado;
	
	@JsonProperty("Tabela")
	private String tabela;
	
	@JsonProperty("Domínio Negócio")
	private String dominioNegocio;
	
	@JsonProperty("Definição")
	private String definicao;
	
	@JsonProperty("Assunto")
	private String assunto;
	
	@JsonProperty("Nome")
	private String nome;
	
	@JsonProperty("Domínio Dados")
	private String dominioDados;
	
	@JsonProperty("Sub Domínio Dados")
	private String subDominioDados;

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

	public String getDominioNegocio() {
		return dominioNegocio;
	}

	public void setDominioNegocio(String dominioNegocio) {
		this.dominioNegocio = dominioNegocio;
	}

	public String getDefinicao() {
		return definicao;
	}

	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
