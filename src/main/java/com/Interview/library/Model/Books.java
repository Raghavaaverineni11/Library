package com.Interview.library.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto_increment
    private Integer id;

    @Column(name = "bookname", length = 100)
    private String name;

    @Column(name = "author", length = 100)
    private String author;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // this creates the foreign key
    @JsonBackReference
    private User user;

    public Books() {
    }

    public Books(Integer id, String name, String author, Integer price, User user) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.user = user;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
