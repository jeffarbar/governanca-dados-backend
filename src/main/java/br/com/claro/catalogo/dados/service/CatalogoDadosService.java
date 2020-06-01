package br.com.claro.catalogo.dados.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.PesquisaVo;



@Service
@Qualifier("elasticsearchService")
public class CatalogoDadosService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;
	

	public List<CatalogoDadoVo> findCatalogoDadoByTabela(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByTabelaLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	public List<CatalogoDadoVo> findCatalogoDadoByBancoDado(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByBancoDadoLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	public List<CatalogoDadoVo> findCatalogoDadoByNome(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByNomeLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	public List<CatalogoDadoVo> findCatalogoDadoByDefinicaoLike(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByDefinicaoLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	public List<CatalogoDadoVo> findCatalogoDadoByAssunto(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByAssuntoLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}

	public List<CatalogoDadoVo> findCatalogoDominioNegocio(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByDominioNegocioLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	public List<CatalogoDadoVo> findCatalogoDominioDados(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByDominioDadosLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	
	public List<CatalogoDadoVo> findCatalogoDadoBySubDominioDados(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findBySubDominioDadosLike(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
	}
	
	
	public List<CatalogoDadoVo> findCatalogoDado(PesquisaVo pesquisaVo){
		
		return catalogoDadosRepository.findByTabelaLikeOrBancoDadoLikeOrNomeLikeOrDefinicaoLikeOrAssuntoLikeOrDominioNegocioLikeOrDominioDadosLikeOrSubDominioDadosLike(
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa())
				.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
	}
	
}
