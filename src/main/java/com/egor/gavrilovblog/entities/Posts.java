package com.egor.gavrilovblog.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Posts {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    private @Column(nullable = false, length = 300) String title;
    private @Column(nullable = false, length = 50000) String text;
    @Column(nullable = false)
    private Date date = new Date();
}
