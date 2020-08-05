package br.com.claro.catalogo.dados.service;

import java.util.ArrayList;
import java.util.List;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ListaCatalogoResponseVo;
import br.com.claro.catalogo.dados.vo.PesquisaRequestVo;


@Service
@Qualifier("catalogoDadosService")
public class CatalogoDadosService {

	@Autowired
	@Qualifier("catalogoDadosRepository")
	private CatalogoDadosRepository catalogoDadosRepository;
	

	public ListaCatalogoResponseVo findCatalogoDadoByParentPath(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("parentPath", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	public ListaCatalogoResponseVo findCatalogoDadoByOrigem(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("origem", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	public ListaCatalogoResponseVo findCatalogoDadoByName(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("name", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	public ListaCatalogoResponseVo findCatalogoDadoByDefinition(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("definition", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);

	}
	
	public ListaCatalogoResponseVo findCatalogoDadoByAssunto(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("assunto", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}

	public ListaCatalogoResponseVo findCatalogoDominioNegocio(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("dominioNegocio", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	public ListaCatalogoResponseVo findCatalogoDominioDados(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("dominioDados", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	
	public ListaCatalogoResponseVo findCatalogoDadoBySubDominioDados(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("subDominioDados", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	public ListaCatalogoResponseVo findCatalogoDadoByLabels(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("labels", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	
	public ListaCatalogoResponseVo findCatalogoDadoByGrupoDominioDados(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("grupoDominioDados", pesquisaVo.getStringPesquisa())
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
		
		return new ListaCatalogoResponseVo(resulta);
	}
	
	
	public ListaCatalogoResponseVo findCatalogoDado(PesquisaRequestVo pesquisaVo){
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", pesquisaVo.getType())
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.multiMatchQuery(pesquisaVo.getStringPesquisa(), 
				  	"parentPath","name","definition","dominioNegocio","assunto",
				  	"origem","dominioDados","subDominioDados","labels","grupoDominioDados")
				.operator(Operator.AND));
		
		List<CatalogoDadoVo> resulta = new ArrayList<CatalogoDadoVo>();
		
		catalogoDadosRepository.search(subQuery).forEach(
				x-> resulta.add(new CatalogoDadoVo(x) )
			);
	
		return new ListaCatalogoResponseVo(resulta);
	}
	
	
}
