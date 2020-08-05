package br.com.claro.catalogo.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.claro.catalogo.dados.service.CatalogoDadosService;
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaRequestVo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/catalogoDados")
@Api(value = "/catalogoDados", description = "Controller responsável pelos metodos do Catalogo de Dados")
public class CatalogoDadosController extends Controller{

	@Autowired
	@Qualifier("catalogoDadosService")
	private CatalogoDadosService catalogoDadosService;
	 
	@RequestMapping(path = "/findByParentPath", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByParentPath(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByParentPath(pesquisaVo);
	}
	 
	@RequestMapping(path = "/findByDefinition", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByDefinition(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByDefinition(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByName", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByName(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByName(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByOrigem", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByOrigem(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByOrigem(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByAssunto", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByAssunto(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByAssunto(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByLabels", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByLabels(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByLabels(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByDominioNegocio", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByDominioNegocio(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioNegocio(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findDominioDados(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioDados(pesquisaVo);
	}
	
	@RequestMapping(path = "/findBySubDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findSubDominioDados(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoBySubDominioDados(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByGrupoDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findGrupoDominioDados(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByGrupoDominioDados(pesquisaVo);
	}
	
	
	@RequestMapping(path = "/find", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo find(@RequestBody PesquisaRequestVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDado(pesquisaVo);
	}
}
