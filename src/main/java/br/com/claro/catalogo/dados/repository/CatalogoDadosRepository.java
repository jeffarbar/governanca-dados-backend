package br.com.claro.catalogo.dados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import br.com.claro.catalogo.dados.model.CatalogoDadosModel;

@Repository
public interface CatalogoDadosRepository extends ElasticsearchRepository <CatalogoDadosModel, String>{

	List<CatalogoDadosModel> findByTypeAndNameTable(String type, String nomeTabela);
		
}