package pers.panqt.springboot.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.panqt.springboot.entry.Book;

import java.util.List;

/**
 *  @time       2019年02月02日	19:21
 *	@author     panqt
 *
 *	@comment    
 */
@RestController
public class ElasticController {

    @Autowired
    private ElasticRepository elasticRepository;



    @PostMapping("save")
    public Object save(@RequestBody Book book1){
        return elasticRepository.save(book1);
    }

    @GetMapping("get/{id}")
    public Book get(@PathVariable("id") int id){
        return elasticRepository.findById(id).get();
    }

    @GetMapping("getlike")
    public List<Book> getlike( String name){
        return elasticRepository.findByNameLike(name);
    }
}
