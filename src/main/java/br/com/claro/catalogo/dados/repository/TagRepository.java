package br.com.claro.catalogo.dados.repository;


import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import br.com.claro.catalogo.dados.model.TagModel;

@Repository
public class TagRepository{

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Value("${elasticsearch.search.regex}")
	private String regex;
	
	public List<TagModel> getAssuntos(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("assunto", regex);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(queryBuilder)
				  .withFields("assunto")
				  .build();
		
		return elasticsearchTemplate.queryForList(searchQuery, TagModel.class);
	}
	
	public List<TagModel> getDominioNegocio(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("dominioNegocio", regex);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(queryBuilder)
				  .withFields("dominioNegocio")
				  .build();
		
		return elasticsearchTemplate.queryForList(searchQuery, TagModel.class);

	}
	
	public List<TagModel> getDominioDados(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("dominioDados", regex);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(queryBuilder)
				  .withFields("dominioDados")
				  .build();
		
		return elasticsearchTemplate.queryForList(searchQuery, TagModel.class);

	}

	public List<TagModel> getSubDominioDados(){
		
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("subDominioDados", regex);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(queryBuilder)
				  .withFields("subDominioDados")
				  .build();
		
		return elasticsearchTemplate.queryForList(searchQuery, TagModel.class);

	}

	public List<TagModel> getGrupoDominioDados(){
	
		QueryBuilder queryBuilder = QueryBuilders.regexpQuery("grupoDominioDados", regex);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(queryBuilder)
				  .withFields("grupoDominioDados")
				  .build();
		
		return elasticsearchTemplate.queryForList(searchQuery, TagModel.class);
	
	}
}
