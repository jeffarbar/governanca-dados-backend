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
	public @ResponseBody List<CatalogoDadoVo> findByTabela(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByTabela(pesquisaVo);
	}
	 
	@RequestMapping(path = "/findByDefinicao", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findByDefinicao(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByDefinicaoLike(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByNome", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findByNome(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByNome(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByBancoDado", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findByBancoDado(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByBancoDado(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByAssunto", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findByAssunto(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoByAssunto(pesquisaVo);
	}
	
	
	@RequestMapping(path = "/findByDominioNegocio", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findByDominioNegocio(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioNegocio(pesquisaVo);
	}
	
	@RequestMapping(path = "/findByDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findDominioDados(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDominioDados(pesquisaVo);
	}
	
	@RequestMapping(path = "/findBySubDominioDados", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> findSubDominioDados(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDadoBySubDominioDados(pesquisaVo);
	}
	
	
	@RequestMapping(path = "/find", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CatalogoDadoVo> find(@RequestBody PesquisaVo pesquisaVo) {
		
		return catalogoDadosService.findCatalogoDado(pesquisaVo);
	}
}
