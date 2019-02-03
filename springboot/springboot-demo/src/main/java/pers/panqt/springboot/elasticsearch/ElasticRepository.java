package pers.panqt.springboot.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.panqt.springboot.entry.Book;

import java.util.List;


/**
 *  @time       2019年02月02日	18:51
 *	@author     panqt
 *
 *	@comment    
 */
public interface ElasticRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findByNameLike(String name);
}
