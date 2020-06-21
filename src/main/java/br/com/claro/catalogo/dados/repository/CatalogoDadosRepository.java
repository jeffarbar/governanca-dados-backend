package br.com.claro.catalogo.dados.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.claro.catalogo.dados.model.CatalogoDadosModel;

@Repository
public interface CatalogoDadosRepository extends ElasticsearchRepository <CatalogoDadosModel, String>{

	List<CatalogoDadosModel> findByParentPathContaining(String parentPath);
	List<CatalogoDadosModel> findByNameContaining(String name);
	List<CatalogoDadosModel> findByDefinitionContaining(String definition);
	List<CatalogoDadosModel> findByDominioNegocioContaining(String dominioNegocio);
	List<CatalogoDadosModel> findByAssuntoContaining(String assunto);
	List<CatalogoDadosModel> findByOrigemContaining(String origem);
	List<CatalogoDadosModel> findByDominioDadosContaining(String dominioDados);
	List<CatalogoDadosModel> findBySubDominioDadosContaining(String subDominioDados);
	List<CatalogoDadosModel> findByLabelsContaining(String labels);
	List<CatalogoDadosModel> findByGrupoDominioDadosContaining(String grupoDominioDados);
	
	

	List<CatalogoDadosModel> findByParentPathContainingOrNameContainingOrDefinitionContainingOrDominioNegocioContainingOrAssuntoContainingOrOrigemContainingOrDominioDadosContainingOrSubDominioDadosContainingOrLabelsContainingOrGrupoDominioDadosContaining(
			String parentPath, String name, String definition, String dominioNegocio, String assunto, 
			String origem,String dominioDados, String subDominioDados , String labels, String grupoDominioDados);


	
}
