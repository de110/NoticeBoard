package com.ttff.board1.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
// @Table
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    // @Column(nullable = false, name = "user")
    // private User user;

    @Column(name = "region")
    private String region;

    @Builder
    public Board(String title, String contents, String region) {
        this.title = title;
        this.contents = contents;
        this.region = region;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}