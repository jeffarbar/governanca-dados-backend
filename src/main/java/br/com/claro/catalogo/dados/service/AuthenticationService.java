package br.com.claro.catalogo.dados.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.claro.catalogo.dados.util.JwtTokenUtil;
import br.com.claro.catalogo.dados.util.StringUtil;
import br.com.claro.catalogo.dados.vo.AuthVo;
import br.com.claro.catalogo.dados.vo.ResponseVo;
import br.com.claro.catalogo.dados.vo.UsuarioLdapVo;

/**
 *
 * @author Jefferson Farias
 */

@Service
@Qualifier("authenticationService")
public class AuthenticationService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    @Qualifier("ldapService")
    private LdapService ldapService;
    
    @Value("${autenticacao.ldap}")
    private boolean isLdap;
    
    @Value("${autenticacao.login}")
    private String login;
    
    @Value("${autenticacao.senha}")
    private String senha;
    
    private static final Logger logger = LogManager.getLogger(AuthenticationService.class);

    public Object authenticate(UsuarioLdapVo usuario) {
    	
        if ( !StringUtil.isNullOrBranco(usuario.getLogin()) &&  !StringUtil.isNullOrBranco(usuario.getSenha()) ) {

        	boolean isAdmin = false;
        	UserDetails user = null;
        	
        	if(this.isLdap) {
        		  
        		user = this.ldapService.validateUser(usuario);

                if(user == null){
                	logger.error("{}", "Usuário não encontrato no ldap " + usuario.getLogin());
                	return new ResponseVo(ResponseVo.ERRO, "Login ou senha incorreto");
                }

                isAdmin = this.ldapService.verifyIsAdmin(user);
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user, user.getUsername(), user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authRequest);

        	}else {
        		
        		if(login.equalsIgnoreCase(usuario.getLogin()) && senha.equals(usuario.getSenha()) ) {
        			isAdmin = true;
        			user = this.ldapService.createUserLocal(usuario);
        		}else {
        			logger.error("{}", "Login ou senha incorreto " + usuario.getLogin());
        			return new ResponseVo(ResponseVo.ERRO, "Login ou senha incorreto");
        		}
        	}
                  
        	final String token = jwtTokenUtil.generateToken(user);
                  
            return new AuthVo(token, isAdmin);
        
        }
        
        return new ResponseVo(ResponseVo.OK,"Verifique login ou senha inserido");
    }
    
    public ResponseVo deleteSession(String token){
        SecurityContextHolder.getContext().setAuthentication(null);   
        return new ResponseVo(ResponseVo.OK,"Logout efetuado com sucesso");
    }
}
