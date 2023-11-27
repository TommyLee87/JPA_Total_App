package com.kh.jpatotalapp.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "board")
@Getter@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;
    private String title;
    private String content;
    private String imgPath;
    private LocalDateTime regDate;

    @PrePersist
    public void prePersist() {
        regDate = LocalDateTime.now();
    }

    @ManyToOne // 하나의 멤버가 여러 게시판에 글 작성
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne // 하나의 게시판에 여러 카테고리
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "board") // 하나의 게시글에 여러 댓글
    private List<Comment> comments; // 댓글 목록

}
