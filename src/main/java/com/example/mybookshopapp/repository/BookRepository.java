package com.example.mybookshopapp.repository;

import com.example.mybookshopapp.data.Author;
import com.example.mybookshopapp.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBookData() {
        List<Book> books = jdbcTemplate.query("SELECT authors.id, title, priceOld, price, authorName FROM books LEFT JOIN authors on books.authorId = authors.id", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"))
                    .setAuthor(rs.getString("authorName"))
                    .setTitle(rs.getString("title"))
                    .setPriceOld(rs.getString("priceOld"))
                    .setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public Map<Character, List<Author>> getAuthorData() {
        List<Author> authors = jdbcTemplate.query("SELECT id, authorName from authors ORDER BY authorName", (ResultSet rs, int rowNum) -> {
            Author author = new Author()
                    .setId(rs.getInt("id"))
                    .setAuthorName(rs.getString("authorName"));
            return author;
        });
        return authors.stream()
                .collect(
                        Collectors.groupingBy(
                                author -> author.getAuthorName().charAt(0)
                        )
                );
    }
}
