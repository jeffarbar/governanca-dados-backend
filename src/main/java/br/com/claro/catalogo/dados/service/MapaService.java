package br.com.claro.catalogo.dados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.claro.catalogo.dados.repository.CatalogoDadosRepository;
import br.com.claro.catalogo.dados.repository.CatalogoDadosSimplesRepository;
import br.com.claro.catalogo.dados.vo.CatalogoDadoVo;
import br.com.claro.catalogo.dados.vo.ConectadoVo;
import br.com.claro.catalogo.dados.vo.ListaMapaResponseVo;
import br.com.claro.catalogo.dados.vo.MapaRequestVo;
import br.com.claro.catalogo.dados.vo.NodeVo;

@Service
@Qualifier("mapaService")
public class MapaService {

	@Autowired
	@Qualifier("catalogoDadosSimplesRepository")
	private CatalogoDadosSimplesRepository catalogoDadosSimplesRepository;
	
	public ListaMapaResponseVo findByMapa(MapaRequestVo mapaRequestVo){
		
		String pesquisa = mapaRequestVo.getStringPesquisa();
		
		List<NodeVo> nodes = new ArrayList<NodeVo>();
		List<ConectadoVo> conectados = new ArrayList<ConectadoVo>();
		
		String descricaoPesquisa = "Pesquisa: ".concat(pesquisa);
		
		nodes.add(this.geraNode(descricaoPesquisa));
		
		getTabelas(pesquisa).parallelStream().forEach( tab -> {
			if( tab != null ) {
				String descricaoTab = "Tabela: ".concat(tab);
				nodes.add(this.geraNode(descricaoTab)) ; 
				conectados.add(geraConectado(descricaoPesquisa, descricaoTab));
				
				getAtributos(tab).stream().forEach(atr ->{
					if(atr != null) {
						String descricaoAtr = "Atributo: ".concat(atr);
						nodes.add(this.geraNode(descricaoAtr)) ; 
						conectados.add(geraConectado(descricaoTab, descricaoAtr));
					}
				});
			}
		});
		
		
		return new ListaMapaResponseVo(nodes,conectados);
	}
	
	private NodeVo geraNode(String nome) {
		return new NodeVo(nome);
	}
	
	private ConectadoVo geraConectado(String origem, String destino) {
		return new ConectadoVo(origem, destino);
	}
	
	private List<String> getTabelas(String pesquisa) {

		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", "Entity")
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.multiMatchQuery(pesquisa, 
			  	"parentPath","name","definition","dominioNegocio","assunto",
			  	"origem","dominioDados","subDominioDados","labels","grupoDominioDados")
			.operator(Operator.AND));
		
		List<String> resulta = new ArrayList<String>();
		
		catalogoDadosSimplesRepository.search(subQuery).forEach(
				x-> resulta.add( x.getName() )
			);
		
		return resulta;
	}
	
	private List<String> getAtributos(String pesquisa) {

		List<String> resulta = new ArrayList<String>();
		
		catalogoDadosSimplesRepository.findByTypeAndNameTable("Attribute", pesquisa)
			.parallelStream().forEach(
					x-> resulta.add( x.getName() )
			);
		
		return resulta;
		
		
		/*
		
		BoolQueryBuilder subQuery = new BoolQueryBuilder();
		
		subQuery.must(QueryBuilders.matchQuery("type", "Attribute")
				.operator(Operator.AND));
		subQuery.must(QueryBuilders.matchQuery("nameTabela", pesquisa)
				.operator(Operator.AND));
		
		List<String> resulta = new ArrayList<String>();
		
		catalogoDadosSimplesRepository.search(subQuery).forEach(
				x-> resulta.add( x.getName() )
			);
		
		return resulta;
		
		*/
		
		
	}
	

}
