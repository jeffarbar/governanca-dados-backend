package br.com.claro.catalogo.dados.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.claro.catalogo.dados.model.CatalogoDadosModel;
public interface CatalogoDadosRepository extends ElasticsearchRepository <CatalogoDadosModel, String>{

	List<CatalogoDadosModel> findByTabelaLike(String tabela);
	List<CatalogoDadosModel> findByBancoDadoLike(String bancoDados);
	List<CatalogoDadosModel> findByNomeLike(String nome);
	List<CatalogoDadosModel> findByDefinicaoLike(String describeTabela);
	List<CatalogoDadosModel> findByAssuntoLike(String assunto);
	List<CatalogoDadosModel> findByDominioNegocioLike(String dominioNegocio);
	List<CatalogoDadosModel> findByDominioDadosLike(String dominioDados);
	List<CatalogoDadosModel> findBySubDominioDadosLike(String subDominioDados);
	
	List<CatalogoDadosModel> findByTabelaLikeOrBancoDadoLikeOrNomeLikeOrDefinicaoLikeOrAssuntoLikeOrDominioNegocioLikeOrDominioDadosLikeOrSubDominioDadosLike(
			String tabela,String bancoDados, String nome, String definicao,String assunto, 
			String dominioNegocio, String dominioDados,String subDominioDados );
	
}
