package pers.panqt.springboot.modules.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.panqt.springboot.entry.User;

import java.util.List;


/**
 *  @time       2019年02月02日	18:51
 *	@author     panqt
 *
 *	@see pers.panqt.springboot.entry.User
 */
public interface ElasticRepository extends ElasticsearchRepository<User,Integer> {
    public List<User> findByUserNameLike(String userName);
}
