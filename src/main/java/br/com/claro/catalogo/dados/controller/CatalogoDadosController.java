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
import br.com.claro.catalogo.dados.vo.ListaResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaVo;
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
	public @ResponseBody ListaResponseVo findByParentPath(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByParentPath(pesquisaVo);
	}
	 
	@RequestMapping(path = "/findByDefinition", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByDefinition(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByDefinition(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByName", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByName(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByName(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByOrigem", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByOrigem(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByOrigem(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByAssunto", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByAssunto(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByAssunto(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByLabels", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByLabels(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByLabels(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByDominioNegocio", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByDominioNegocio(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioNegocio(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findDominioDados(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioDados(pesquisaVo);
	}
	
	@RequestMapping(path = "/findBySubDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findSubDominioDados(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoBySubDominioDados(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByGrupoDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findGrupoDominioDados(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByGrupoDominioDados(pesquisaVo);
	}
	
	
	@RequestMapping(path = "/find", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo find(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDado(pesquisaVo);
	}
}
