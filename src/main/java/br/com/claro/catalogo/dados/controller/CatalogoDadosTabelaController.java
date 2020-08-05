package br.com.claro.catalogo.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.claro.catalogo.dados.service.CatalogoDadosAtributoTabelaService;
import br.com.claro.catalogo.dados.service.CatalogoDadosTabelaService;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.CatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaTabelaRequestVo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/catalogoDadosTabela")
@Api(value = "/catalogoDadosTabela", description = "Controller responsável pelos metodos do Catalogo de Dados da Tabela")
public class CatalogoDadosTabelaController extends Controller {

	@Autowired
	@Qualifier("catalogoDadosTabelaService")
	private CatalogoDadosTabelaService catalogoDadosTabelaService;

	@RequestMapping(path = "/findByTabela", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody CatalogoResponseVo findByTabela(@RequestBody PesquisaTabelaRequestVo pesquisaTabelaVo) {
		
		return catalogoDadosTabelaService.findByTabela(pesquisaTabelaVo);
	}
}
