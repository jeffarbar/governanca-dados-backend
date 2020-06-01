package br.com.claro.catalogo.dados.vo;


import javax.validation.constraints.NotBlank;

public class UsuarioLdapVo {

    @NotBlank(message = "{login.not.blank}")
    private String login;
	
    @NotBlank(message = "{login.not.blank}")
    private String senha;
    
    private boolean adminLogin;

    public UsuarioLdapVo(String login, String senha, boolean adminLogin) {
        this.login = login;
        this.senha = senha;
        this.adminLogin = adminLogin;
    }
    
    public UsuarioLdapVo() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(boolean adminLogin) {
        this.adminLogin = adminLogin;
    }    

}
