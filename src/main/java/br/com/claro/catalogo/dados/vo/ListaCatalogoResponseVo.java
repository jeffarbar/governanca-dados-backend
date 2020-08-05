package br.com.claro.catalogo.dados.vo;

import java.util.List;

public class ListaCatalogoResponseVo extends ResponseVo{
	
	public ListaCatalogoResponseVo(int codigo, String message, List<CatalogoDadoVo> listaCatalogoDado) {
		super(codigo, message);
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	public ListaCatalogoResponseVo(List<CatalogoDadoVo> listaCatalogoDado) {
		super();
		this.listaCatalogoDado = listaCatalogoDado;
	}
	
	public ListaCatalogoResponseVo(int codigo, String message) {
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
