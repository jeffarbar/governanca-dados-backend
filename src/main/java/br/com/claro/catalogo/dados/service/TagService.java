package br.com.claro.catalogo.dados.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.lucene.search.SearcherFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.repository.TagRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ListaResponseVo;
import br.com.claro.catalogo.dados.vo.ListaTagResponseVo;

import br.com.claro.catalogo.dados.vo.TagVo;

@Service
@Qualifier("tagService")
public class TagService {

	
	@Autowired
	@Qualifier("tagRepository")
	private TagRepository tagRepository;
	
	@Value("${elasticsearch.search.regex}")
	private String regex;
	

	public ListaTagResponseVo findTagByAssunto(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("assunto", regex);
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(queryBuilder).forEach(
				x-> resulta.add(new TagVo(x.getAssunto()) )
			);
		
		return new ListaTagResponseVo(resulta,"Assunto");
	}
	
	public ListaTagResponseVo findTagByDominioNegocio(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("dominioNegocio", regex);
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(queryBuilder).forEach(
				x-> resulta.add(new TagVo(x.getDominioNegocio()) )
			);
		
		return new ListaTagResponseVo(resulta,"Domínio Negócio");
	}
	
	public ListaTagResponseVo findTagByDominioDados(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("dominioDados", regex);
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(queryBuilder).forEach(
				x-> resulta.add(new TagVo(x.getDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Domínio Dados");
	}
	

	public ListaTagResponseVo findTagBySubDominioDados(){
	
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("subDominioDados", regex);
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(queryBuilder).forEach(
				x-> resulta.add(new TagVo(x.getSubDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Subdomínio Dados");
	}

	public ListaTagResponseVo findTagByGrupoDominioDados(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("grupoDominioDados", regex);
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(queryBuilder).forEach(
				x-> resulta.add(new TagVo(x.getGrupoDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Grupo Domínio Dados");
	}
}
