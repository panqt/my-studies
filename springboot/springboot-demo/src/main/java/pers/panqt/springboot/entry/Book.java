package pers.panqt.springboot.entry;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 *  @time       2019年02月02日	18:45
 *	@author     panqt
 *
 *	@comment    
 */

//indexName索引名称 可以理解为数据库名 必须为小写 不然会报异常
//type类型 可以理解为表名
@Document(indexName = "springbootdemo",type = "book")
public class Book {

    private Integer id;
    private String name; //书名
    private String author; //作者
    private String publisher; //出版社

    public Book(){}

    public Book(Integer id,String name, String author, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
