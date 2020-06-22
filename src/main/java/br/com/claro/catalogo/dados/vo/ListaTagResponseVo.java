package br.com.claro.catalogo.dados.vo;

import java.util.Set;

public class ListaTagResponseVo extends ResponseVo{

	public ListaTagResponseVo(Set<TagVo> listaTag, String nomeTag) {
		super();
		this.listaCatalogoDado = listaTag;
		this.nomeTag = nomeTag;
	}
	
	public ListaTagResponseVo(int codigo, String message) {
		super(codigo, message);
	}

	private Set<TagVo> listaCatalogoDado;
	
	private String nomeTag;

	
	public String getNomeTag() {
		return nomeTag;
	}

	public void setNomeTag(String nomeTag) {
		this.nomeTag = nomeTag;
	}

	public Set<TagVo> getListaCatalogoDado() {
		return listaCatalogoDado;
	}

	public void setListaCatalogoDado(Set<TagVo> listaCatalogoDado) {
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	
}
