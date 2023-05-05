package com.egor.gavrilovblog.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Posts {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private @Column(nullable = false, length = 300) String title;
    private @Lob
    @Column(nullable = false) String text;
    @Column(nullable = false)
    private Date date = new Date();

    public Posts(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Posts() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return id == posts.id && Objects.equals(title, posts.title) && Objects.equals(text, posts.text) && Objects.equals(date, posts.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, date);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
