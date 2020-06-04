package br.com.claro.catalogo.dados.util;

public class StringUtil {

	public static boolean isStrEspaco(String valor) {
		
		if(valor != null && valor.contains(" ")) {
			return true; 
		}
		return false;
	}
	public static boolean isNullOrBranco(String valor) {
	
		if(valor == null ) {
			return true;
		}
		
		valor =  valor.trim().toUpperCase();
		if(valor.equals("NULL") || valor.equals("")) {
			return true;
		}
		return false;
	}
}
