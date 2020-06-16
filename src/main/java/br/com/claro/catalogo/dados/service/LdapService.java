package br.com.claro.catalogo.dados.service;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import br.com.claro.catalogo.dados.vo.UsuarioLdapVo;

/**
 *
 * @author LucasPereiraLopes
 */

@Service
@Qualifier("ldapBusiness")
public class LdapService {
    
    @Value("${ldap.remote.url}")
    protected String ldapURL;

    @Value("${ldap.tree.parameters}")
    protected String ldapTreeParams;

    @Value("${ldap.remote.group.admin}")
    protected String ldapGroupAdmin;

    @Value("${ldap.login.dc.suffix}")
    protected String ldapLoginDCSuffix;

    
    protected final String roleAdmin = "ROLE_ADMIN";
    protected final String roleUser = "ROLE_USER";
    
    private static final Logger logger = LogManager.getLogger(LdapService.class);
    
    public UserDetails createUserLocal(UsuarioLdapVo credentials){
    	try {
    		return new User(credentials.getLogin(), credentials.getSenha(), this.setPermissions(true));
    	}catch (Exception e) {
    		logger.error("{}", "Erro na criação do usuário " + e.getMessage());
		}
    	return null;
    }
    
    public UserDetails validateUser(UsuarioLdapVo credentials){
        try {
            DirContext ctx;
            boolean isAdmin;
            
            ctx = new InitialDirContext(configLdapContext(credentials));
            
            if(credentials.isAdminLogin()){
                isAdmin = this.checkIsAdmin(ctx, credentials);    
            }else{
                isAdmin = false;
            }      
            ctx.close();
            
            return new User(credentials.getLogin(), credentials.getSenha(), this.setPermissions(isAdmin));
        } catch (Exception ex) {
        	logger.error("{}", "Erro ao criar Ldap " + ex.getMessage());
            return null;
        }
    }
    
    public boolean verifyIsAdmin(UserDetails user){
        boolean isAdmin = false;
        try {
	        for (GrantedAuthority role : user.getAuthorities()){
	            if(role.getAuthority().equals(this.roleAdmin)){
	                isAdmin = true;
	            }
	        }
	        return isAdmin;
        }catch (Exception e) {
        	logger.error("{}", "Erro ao verificar admin " + e.getMessage());
            return false;
		}
    }
    
    private Set<GrantedAuthority> setPermissions(boolean isAdmin) throws Exception{
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        if(isAdmin){
            grantedAuthorities.add(new SimpleGrantedAuthority(this.roleAdmin));
        }else {
            grantedAuthorities.add(new SimpleGrantedAuthority(this.roleUser));
        }
        
        return grantedAuthorities;
    }
    
    private boolean checkIsAdmin(DirContext ctx, UsuarioLdapVo usuarioLdapVo) throws Exception{
        try {
            String searchBase = "";
            String searchFilter = "(&(objectClass=user)(sAMAccountName=" + usuarioLdapVo.getLogin() + ")(memberOf=CN=" + this.ldapGroupAdmin + "," + this.ldapTreeParams + "))";
            String[] attrIDs = {"cn"};

            SearchControls searchControls = new SearchControls();
            searchControls.setReturningAttributes(attrIDs);
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);//ONELEVEL_SCOPE

            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchControls);

            if (answer.hasMore()) {
                return true;
                //SearchResult rslt = (SearchResult) answer;
                //Attributes attrs = rslt.getAttributes();
                //System.out.println(attrs.get("cn")); 
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private Hashtable<String, String> configLdapContext(UsuarioLdapVo usuarioLdapVo) throws Exception{
        Hashtable<String, String> env = new Hashtable<String, String>();
        String dn = usuarioLdapVo.getLogin() + "@" + this.ldapLoginDCSuffix;

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, this.ldapURL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, dn);
        env.put(Context.SECURITY_CREDENTIALS, usuarioLdapVo.getSenha());

        return env;
    }
}
