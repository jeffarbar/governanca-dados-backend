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
@Qualifier("catalogoDadosService")
public class CatalogoDadosService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;
	

	public ListaResponseVo findCatalogoDadoByParentPath(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByParentPathContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByOrigem(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é inválida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta =  catalogoDadosRepository.findByOrigemContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByName(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByNameContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	public ListaResponseVo findCatalogoDadoByDefinition(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByDefinitionContaining(pesquisaVo.getStringPesquisa())
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
	
	public ListaResponseVo findCatalogoDadoByLabels(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByLabelsContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	
	public ListaResponseVo findCatalogoDadoByGrupoDominioDados(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByGrupoDominioDadosContaining(pesquisaVo.getStringPesquisa())
			.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
		
		return new ListaResponseVo(resulta);
	}
	
	
	public ListaResponseVo findCatalogoDado(PesquisaVo pesquisaVo){
		
		if( this.isValido(pesquisaVo) ) {
			return new ListaResponseVo(-3, "Valor da string de pesquisa é invalida, não pode espaço");
		}
		
		List<CatalogoDadoVo> resulta = catalogoDadosRepository.findByParentPathContainingOrNameContainingOrDefinitionContainingOrDominioNegocioContainingOrAssuntoContainingOrOrigemContainingOrDominioDadosContainingOrSubDominioDadosContainingOrLabelsContainingOrGrupoDominioDadosContaining(
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),pesquisaVo.getStringPesquisa(),
				pesquisaVo.getStringPesquisa())
				.parallelStream().map(  CatalogoDadoVo :: new ).collect(Collectors.toList());
	
		return new ListaResponseVo(resulta);
	}
	
	private boolean isValido(PesquisaVo pesquisaVo) {
		
		return StringUtil.isStrEspaco(pesquisaVo.getStringPesquisa());
	}
}
