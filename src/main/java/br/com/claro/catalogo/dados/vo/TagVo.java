package br.com.claro.catalogo.dados.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.claro.catalogo.dados.model.TagModel;

public class TagVo{

	public TagVo(String tag) {
		this.campoTag = tag;
	}
	
	@JsonProperty("Campo Tag")
	private String campoTag;

	public String getCampoTag() {
		return campoTag;
	}

	public void setCampoTag(String campoTag) {
		this.campoTag = campoTag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoTag == null) ? 0 : campoTag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TagVo other = (TagVo) obj;
		if (campoTag == null) {
			if (other.campoTag != null)
				return false;
		} else if (!campoTag.equals(other.campoTag))
			return false;
		return true;
	}
	
}
