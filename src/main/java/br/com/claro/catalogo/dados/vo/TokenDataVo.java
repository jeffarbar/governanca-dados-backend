package br.com.claro.catalogo.dados.vo;


import java.util.Set;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Jefferson Farias
 */
public class TokenDataVo {
    
    private String ldap;
    
    private Set<GrantedAuthority> roles;

    public TokenDataVo() {
    }

    public TokenDataVo(String ldap, Set<GrantedAuthority> roles) {
        this.ldap = ldap;
        this.roles = roles;
    }

    public String getLdap() {
        return ldap;
    }

    public void setLdap(String ldap) {
        this.ldap = ldap;
    }

    public Set<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Set<GrantedAuthority> roles) {
        this.roles = roles;
    }
    
}
