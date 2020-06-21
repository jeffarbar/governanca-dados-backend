package br.com.claro.catalogo.dados.vo;


import java.util.Set;

public class ListaTagResponseVo extends ResponseVo{

	public ListaTagResponseVo(Set<TagVo> listaTag) {
		super();
		this.listaCatalogoDado = listaTag;
	}
	
	public ListaTagResponseVo(int codigo, String message) {
		super(codigo, message);
	}
	
	private Set<TagVo> listaCatalogoDado;

	public Set<TagVo> getListaCatalogoDado() {
		return listaCatalogoDado;
	}

	public void setListaCatalogoDado(Set<TagVo> listaCatalogoDado) {
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	
}
