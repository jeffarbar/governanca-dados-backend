package br.com.claro.catalogo.dados.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.claro.catalogo.dados.service.CatalogoDadosService;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
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
	 
	@RequestMapping(path = "/findByTabela", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByTabela(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByTabela(pesquisaVo);
	}
	 
	@RequestMapping(path = "/findByDefinicao", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByDefinicao(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByDefinicao(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByNome", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByNome(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByNome(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByBancoDado", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByBancoDado(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByBancoDado(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByAssunto", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo findByAssunto(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByAssunto(pesquisaVo);
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
	
	
	@RequestMapping(path = "/find", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaResponseVo find(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDado(pesquisaVo);
	}
}
