package br.com.claro.catalogo.dados.repository;



import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import br.com.claro.catalogo.dados.model.TagModel;

@Repository
public interface TagRepository extends ElasticsearchRepository <TagModel, String>{

}
