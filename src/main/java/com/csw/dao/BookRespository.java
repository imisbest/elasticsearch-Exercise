package com.csw.dao;

import com.csw.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface BookRespository extends ElasticsearchRepository<Book, String> {
    List<Book> findByNameAndContent(String nameKeyword, String contentKeyword);

    List<Book> findByNameAndContentAndAuthor(String nameKryword, String contentKeyword);

    List<Book> findByNameOrContent(String nameKeyword, String contentKeyword);

    List<Book> findByPrice(Double price);

    List<Book> findByPriceBetween(Double min, Double max);
}
