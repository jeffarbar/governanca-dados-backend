package br.com.claro.catalogo.dados.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.util.StringUtil;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ListaResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaVo;



@Service
@Qualifier("elasticsearchService")
public class CatalogoDadosService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;
	

	public ListaResponseVo findCatalogoDadoByTabela(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByTabelaContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByBancoDado(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é inválida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta =  catalogoDadosRepository.findByBancoDadoContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByNome(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByNomeContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByDefinicao(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByDefinicaoContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByAssunto(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByAssuntoContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}

	public ListaResponseVo findCatalogoDominioNegocio(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByDominioNegocioContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDominioDados(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByDominioDadosContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	
	public ListaResponseVo findCatalogoDadoBySubDominioDados(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findBySubDominioDadosContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	
	public ListaResponseVo findCatalogoDado(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByTabelaContainingOrBancoDadoContainingOrNomeContainingOrDefinicaoContainingOrAssuntoContainingOrDominioNegocioContainingOrDominioDadosContainingOrSubDominioDadosContaining(
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa())
				.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
	
		return new ListaResponseVo(resulta);
	}
	
	private boolean isValido(PesquisaVo pesquisaVo) {
		
		return StringUtil.isStrEspaco(pesquisaVo.getStringPesquisa());
	}
}
