package com.csw.test;

import com.csw.ElasticSearchApplication;
import com.csw.dao.BookRespository;
import com.csw.entity.Book;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ElasticSearchApplication.class)
@RunWith(SpringRunner.class)
public class TestBookRespository {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private BookRespository bookRespository;

    @Test
    public void testSearchPageAndSortAndFilterAndHight() {
        HighlightBuilder.Field field = new
                HighlightBuilder.Field("*")
                .requireFieldMatch(false)
                .preTags("<span style='color:red'>")
                .postTags("</span>");


    }

    @Test
    public void testFindNameAndContent() {
        List<Book> books = bookRespository.findByPrice(23.23);
        books.forEach(book -> System.out.println(book));
    }

    @Test//删除
    public void testDelete() {
        Book book = new Book().setId("1");
        bookRespository.delete(book);
    }

    //根据id查询一个
    @Test
    public void testFindone() {
        Optional<Book> book = bookRespository.findById("3");
        System.out.println(book.get());
    }

    //查询所有
    @Test
    public void testFinaAll() {
        Iterable<Book> all = bookRespository.findAll();
        all.forEach(b -> System.out.println(b));
    }

    @Test
    public void testsave() {
        Book book = new Book("3", "小白杨-3", 23.23, new Date(), "羊真的很好吃", "罗永浩");
        bookRespository.save(book);
    }
}
