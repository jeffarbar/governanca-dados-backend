package br.com.claro.catalogo.dados.vo;

public class NodeVo {
	
	public NodeVo() {}

	public NodeVo(String text) {
		super();
		this.text = text;
	}

	private String text;
	
	private String node = "";
	
	private String url = "";
	
	private String category = "wiki";

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
	
}
