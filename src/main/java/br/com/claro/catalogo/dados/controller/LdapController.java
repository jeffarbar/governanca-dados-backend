package br.com.claro.catalogo.dados.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claro.catalogo.dados.service.AuthenticationService;
import br.com.claro.catalogo.dados.util.JwtTokenUtil;
import br.com.claro.catalogo.dados.vo.AuthVo;
import br.com.claro.catalogo.dados.vo.UsuarioLdapVo;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ldapauthentication")
@Api(value = "/ldapauthentication", description = "Controller responsável por lidar com as autenticações do ldap")
public class LdapController extends Controller{


    @Autowired
    @Qualifier("authenticationService")
    private AuthenticationService authenticationService; 


    @PostMapping(path = "/login")
    @ApiOperation(value = "Recebe o login e senha de um usuário para autenticação")
    public ResponseEntity<Object> login(
            @ApiParam(value = "Objeto do usuário que se deseja autenticar", required = true)
            @RequestBody @Valid UsuarioLdapVo usuario) {
        
        return ResponseEntity.ok(this.authenticationService.authenticate(usuario));
    }
    
    @PostMapping(path = "/logout")
    @ApiOperation(value = "Recebe o token do usuário para efetuar logout da sessão atual")
    public ResponseEntity<Object> logout(
            @ApiParam(value = "Token do usuário para logout", required = true)
            @RequestBody @Valid AuthVo authVo){
        return ResponseEntity.ok(this.authenticationService.deleteSession(authVo.getToken()));
    }
    
}
