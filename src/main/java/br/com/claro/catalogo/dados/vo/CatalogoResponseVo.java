package br.com.claro.catalogo.dados.vo;

import java.util.List;

public class CatalogoResponseVo extends ResponseVo{

	
	public CatalogoResponseVo(int codigo, String message, CatalogoDadoVo catalogoDado) {
		super(codigo, message);
		this.catalogoDado = catalogoDado;
	}
	
	public CatalogoResponseVo(CatalogoDadoVo catalogoDado) {
		super();
		this.catalogoDado = catalogoDado;
	}
	
	public CatalogoResponseVo(int codigo, String message) {
		super(codigo, message);
	}
	
	public CatalogoResponseVo() {
		super();
	}
	
	private CatalogoDadoVo catalogoDado;

	public CatalogoDadoVo getCatalogoDado() {
		return catalogoDado;
	}

	public void setCatalogoDado(CatalogoDadoVo catalogoDado) {
		this.catalogoDado = catalogoDado;
	}
	

}
