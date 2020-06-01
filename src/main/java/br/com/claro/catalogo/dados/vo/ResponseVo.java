package br.com.claro.catalogo.dados.vo;

public class ResponseVo {

	private String message;
	private int codigo;
	
	public final static int OK = 0;
	public final static int ERRO = -1;
	

    public ResponseVo(int codigo, String message) {
        this.codigo = codigo;
        this.message = message;
    }

    public ResponseVo() {
    	this.codigo = OK;
        this.message = "OK";
    }

	public String getMessage() {
		return message;
	}

	public int getCodigo() {
		return codigo;
	}
}
