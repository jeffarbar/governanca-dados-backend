package br.com.claro.catalogo.dados.vo;

import java.util.List;

public class ListaMapaResponseVo extends ResponseVo{

	public ListaMapaResponseVo(List<NodeVo> nodes, List<ConectadoVo> conectados) {
		super();
		this.nodes = nodes;
		this.conectados = conectados;
	}
	
	public ListaMapaResponseVo(int codigo, String message) {
		super(codigo, message);
	}
	
	private List<NodeVo> nodes;
	
	private List<ConectadoVo> conectados;

	public List<NodeVo> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeVo> nodes) {
		this.nodes = nodes;
	}

	public List<ConectadoVo> getConectados() {
		return conectados;
	}

	public void setConectados(List<ConectadoVo> conectados) {
		this.conectados = conectados;
	}
	
}
