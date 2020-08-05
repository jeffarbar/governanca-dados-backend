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
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaAtributoTabelaRequestVo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/catalogoDadosAtributoTabela")
@Api(value = "/catalogoDadosAtributoTabela", description = "Controller responsável pelos metodos do Catalogo de Dados do Atributos da Tabela")
public class CatalogoDadosAtributoTabelaController extends Controller{
	
	@Autowired
	@Qualifier("catalogoDadosAtributoTabelaService")
	private CatalogoDadosAtributoTabelaService catalogoDadosAtributoTabelaService;

	@RequestMapping(path = "/findByNameTabela", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ListaCatalogoResponseVo findByNameTabela(@RequestBody PesquisaAtributoTabelaRequestVo pesquisaAtributoTabelaVo) {
		
		return catalogoDadosAtributoTabelaService.findByNameTabela(pesquisaAtributoTabelaVo);
	}
}