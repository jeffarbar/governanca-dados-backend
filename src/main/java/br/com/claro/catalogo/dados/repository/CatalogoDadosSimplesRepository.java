package br.com.claro.catalogo.dados.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import br.com.claro.catalogo.dados.model.CatalogoDadosSimplesModel;

public interface CatalogoDadosSimplesRepository extends ElasticsearchRepository <CatalogoDadosSimplesModel, String>{

	List<CatalogoDadosSimplesModel> findByTypeAndNameTable(String type, String nameTable);
}
