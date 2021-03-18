package com.example.mybookshopapp.data;

public class Author {
    private Integer id;
    private String authorName;

    public Integer getId() {
        return id;
    }

    public Author setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Author setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
