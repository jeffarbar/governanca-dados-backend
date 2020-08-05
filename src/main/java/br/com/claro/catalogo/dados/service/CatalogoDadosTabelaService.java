package br.com.claro.catalogo.dados.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import br.com.claro.catalogo.dados.model.CatalogoDadosModel;
import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.CatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaTabelaRequestVo;

@Service
@Qualifier("catalogoDadosTabelaService")
public class CatalogoDadosTabelaService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;

	
	public CatalogoResponseVo findByTabela(PesquisaTabelaRequestVo pesquisaTabelaVo){
		
		Optional<CatalogoDadosModel> resultado = catalogoDadosRepository.findById( pesquisaTabelaVo.getId());
		
		if( resultado.isPresent() ) {
			return new CatalogoResponseVo( new CatalogoDadoVo( resultado.get() ));
		}else {
			return new CatalogoResponseVo();
		}
	}
}
