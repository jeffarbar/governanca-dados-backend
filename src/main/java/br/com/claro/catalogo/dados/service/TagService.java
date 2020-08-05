package br.com.claro.catalogo.dados.service;

import java.util.HashSet;
import java.util.Set;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.claro.catalogo.dados.repository.TagRepository;
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
	
	private String TYPE = "Entity";

	public ListaTagResponseVo findTagByAssunto(){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", TYPE)
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.regexpQuery("assunto", regex));
		
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(subQuery).forEach(
				x-> resulta.add(new TagVo(x.getAssunto()) )
			);
		
		return new ListaTagResponseVo(resulta,"Assunto");
	}
	
	public ListaTagResponseVo findTagByDominioNegocio(){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", TYPE)
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.regexpQuery("dominioNegocio", regex));
		
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(subQuery).forEach(
				x-> resulta.add(new TagVo(x.getDominioNegocio()) )
			);
		
		return new ListaTagResponseVo(resulta,"Domínio Negócio");
	}
	
	public ListaTagResponseVo findTagByDominioDados(){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", TYPE)
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.regexpQuery("dominioDados", regex));
		
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(subQuery).forEach(
				x-> resulta.add(new TagVo(x.getDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Domínio Dados");
	}
	

	public ListaTagResponseVo findTagBySubDominioDados(){
	
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", TYPE)
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.regexpQuery("subDominioDados", regex));
		
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(subQuery).forEach(
				x-> resulta.add(new TagVo(x.getSubDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Subdomínio Dados");
	}

	public ListaTagResponseVo findTagByGrupoDominioDados(){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", TYPE)
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.regexpQuery("grupoDominioDados", regex));
		
		Set<TagVo> resulta = new HashSet<TagVo>();
		
		tagRepository.search(subQuery).forEach(
				x-> resulta.add(new TagVo(x.getGrupoDominioDados()) )
			);
		
		return new ListaTagResponseVo(resulta,"Grupo Domínio Dados");
	}
}
