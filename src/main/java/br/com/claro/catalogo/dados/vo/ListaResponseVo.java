package br.com.claro.catalogo.dados.vo;

import java.util.List;

public class ListaResponseVo extends ResponseVo{
	
	public ListaResponseVo(int codigo, String message, List<CatalogoDadoVo> listaCatalogoDado) {
		super(codigo, message);
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	public ListaResponseVo(List<CatalogoDadoVo> listaCatalogoDado) {
		super();
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	public ListaResponseVo(int codigo, String message) {
		super(codigo, message);
	}

	private List<CatalogoDadoVo> listaCatalogoDado;

	public List<CatalogoDadoVo> getListaCatalogoDado() {
		return listaCatalogoDado;
	}

	public void setListaCatalogoDado(List<CatalogoDadoVo> listaCatalogoDado) {
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
}
