package br.com.claro.catalogo.dados.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.claro.catalogo.dados.model.CatalogoDadosModel;
public interface CatalogoDadosRepository extends ElasticsearchRepository <CatalogoDadosModel, String>{

	List<CatalogoDadosModel> findByTabelaContaining(String tabela);
	List<CatalogoDadosModel> findByBancoDadoContaining(String bancoDados);
	List<CatalogoDadosModel> findByNomeContaining(String nome);
	List<CatalogoDadosModel> findByDefinicaoContaining(String describeTabela);
	List<CatalogoDadosModel> findByAssuntoContaining(String assunto);
	List<CatalogoDadosModel> findByDominioNegocioContaining(String dominioNegocio);
	List<CatalogoDadosModel> findByDominioDadosContaining(String dominioDados);
	List<CatalogoDadosModel> findBySubDominioDadosContaining(String subDominioDados);
	
	List<CatalogoDadosModel> findByTabelaContainingOrBancoDadoContainingOrNomeContainingOrDefinicaoContainingOrAssuntoContainingOrDominioNegocioContainingOrDominioDadosContainingOrSubDominioDadosContaining(
			String tabela,String bancoDados, String nome, String definicao,String assunto, 
			String dominioNegocio, String dominioDados,String subDominioDados );
	
}
