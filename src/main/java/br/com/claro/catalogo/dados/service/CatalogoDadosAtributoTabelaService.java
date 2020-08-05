package br.com.claro.catalogo.dados.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaAtributoTabelaRequestVo;

@Service
@Qualifier("catalogoDadosAtributoTabelaService")
public class CatalogoDadosAtributoTabelaService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;
	
	private String TYPE = "Attribute";
	
	public ListaCatalogoResponseVo findByNameTabela(PesquisaAtributoTabelaRequestVo pesquisaAtributoTabelaVo){
		
		List<CatalogoDadoVo> resultado = catalogoDadosRepository.findByTypeAndNameTable(
				TYPE, pesquisaAtributoTabelaVo.getNomeTabela())
				.parallelStream().map( CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaCatalogoResponseVo(resultado);
	}
}
