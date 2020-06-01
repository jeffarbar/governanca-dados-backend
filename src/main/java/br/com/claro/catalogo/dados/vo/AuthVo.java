package br.com.claro.catalogo.dados.vo;

import javax.validation.constraints.NotBlank;
/**
 *
 * @author Jefferson Farias
 */
public class AuthVo extends ResponseVo {

	@NotBlank(message = "{token.not.blank}")
    private String token;

    private boolean isAdmin;

    public AuthVo(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
    }

    public AuthVo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
