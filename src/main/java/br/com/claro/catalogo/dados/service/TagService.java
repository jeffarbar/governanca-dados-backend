package br.com.claro.catalogo.dados.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.repository.TagRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ListaResponseVo;
import br.com.claro.catalogo.dados.vo.ListaTagResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaVo;
import br.com.claro.catalogo.dados.vo.TagVo;

@Service
@Qualifier("tagService")
public class TagService {

	
	@Autowired
	@Qualifier("tagRepository")
	private TagRepository tagRepository;
	

	public ListaTagResponseVo findTagByAssunto(){
		
		Set<TagVo> resulta = tagRepository.getAssuntos()
				.parallelStream().map( x-> new TagVo(x.getAssunto()) ).collect(Collectors.toSet());
		
		return new ListaTagResponseVo(resulta);
	}
	
	
	public ListaTagResponseVo findTagByDominioNegocio(){
		
		Set<TagVo> resulta = tagRepository.getDominioNegocio()
				.parallelStream().map( x-> new TagVo(x.getDominioNegocio()) ).collect(Collectors.toSet());
		
		return new ListaTagResponseVo(resulta);
	}
	
	public ListaTagResponseVo findTagByDominioDados(){
		
		Set<TagVo> resulta = tagRepository.getDominioDados()
				.parallelStream().map( x-> new TagVo(x.getDominioDados()) ).collect(Collectors.toSet());
		
		return new ListaTagResponseVo(resulta);
	}
	

	public ListaTagResponseVo findTagBySubDominioDados(){
	
		Set<TagVo> resulta = tagRepository.getSubDominioDados()
			.parallelStream().map( x-> new TagVo(x.getSubDominioDados()) ).collect(Collectors.toSet());
	
		return new ListaTagResponseVo(resulta);	
	}

	public ListaTagResponseVo findTagByGrupoDominioDados(){
		
		Set<TagVo> resulta = tagRepository.getGrupoDominioDados()
				.parallelStream().map( x-> new TagVo(x.getGrupoDominioDados())).collect(Collectors.toSet());
		
		return new ListaTagResponseVo(resulta);
	}

}
