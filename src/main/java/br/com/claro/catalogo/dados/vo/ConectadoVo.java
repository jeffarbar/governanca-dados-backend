package br.com.claro.catalogo.dados.vo;

public class ConectadoVo {

	public ConectadoVo() {}

	public ConectadoVo(String source, String target) {
		super();
		this.source = source;
		this.target = target;
	}
	
	private String source;
	
	private String target;
	
	private Curve curve = new Curve();

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Curve getCurve() {
		return curve;
	}

	public void setCurve(Curve curve) {
		this.curve = curve;
	}

}

class Curve{
	
	private Double x = -43.5535;
	
	private Double y = 299.545;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
}
