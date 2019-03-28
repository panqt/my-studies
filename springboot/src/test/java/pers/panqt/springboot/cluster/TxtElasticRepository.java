package pers.panqt.springboot.cluster;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**  @author panqt 2019/03/27 22:0*
 */
public interface TxtElasticRepository  extends ElasticsearchRepository<Txt,Integer> {
    public List<Txt> findByTxtLike(String txt);
}
