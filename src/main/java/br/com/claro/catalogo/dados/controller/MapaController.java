package br.com.claro.catalogo.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.claro.catalogo.dados.service.MapaService;
import br.com.claro.catalogo.dados.service.TagService;
import br.com.claro.catalogo.dados.vo.ListaMapaResponseVo;
import br.com.claro.catalogo.dados.vo.ListaTagResponseVo;
import br.com.claro.catalogo.dados.vo.MapaRequestVo;
import br.com.claro.catalogo.dados.vo.PesquisaRequestVo;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/mapa")
@Api(value = "/mapa", description = "Controller responsável mapa")
public class MapaController extends Controller{
	
	
	@Autowired
	@Qualifier("mapaService")
	private MapaService mapaService;
	
	@RequestMapping(path = "/find", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public @ResponseBody ListaMapaResponseVo findByMapa(@RequestBody MapaRequestVo mapaRequestVo) {
		
		return mapaService.findByMapa(mapaRequestVo);
	}
}
