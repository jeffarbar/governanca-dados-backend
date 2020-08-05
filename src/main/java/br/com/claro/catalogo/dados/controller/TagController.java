package br.com.claro.catalogo.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.claro.catalogo.dados.service.TagService;
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.ListaTagResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaRequestVo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tag")
@Api(value = "/tag", description = "Controller responsável pelos metodos das tags")
public class TagController extends Controller{

	@Autowired
	@Qualifier("tagService")
	private TagService tagService;
	
	@RequestMapping(path = "/findByAssunto", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaTagResponseVo findByAssunto() {
		
		return tagService.findTagByAssunto();
	}
	
	@RequestMapping(path = "/findByDominioNegocio", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaTagResponseVo findByDominioNegocio() {
		
		return tagService.findTagByDominioNegocio();
	}
	
	
	@RequestMapping(path = "/findByDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaTagResponseVo findByDominioDados() {
		
		return tagService.findTagByDominioDados();
	}
	
	
	@RequestMapping(path = "/findBySubDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaTagResponseVo findBySubDominioDados() {
		
		return tagService.findTagBySubDominioDados();
	}
	
	@RequestMapping(path = "/findByGrupoDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaTagResponseVo findByGrupoDominioDados() {
		
		return tagService.findTagByGrupoDominioDados();
	}
}
