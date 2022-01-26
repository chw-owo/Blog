package com.example.demo.domain.comment;

import com.example.demo.domain.Timestamped;
import com.example.demo.domain.memo.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Setter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long memoId;


    private LocalDateTime createDate;
    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    public Comment(String username, String comment, Long memoId) {
        this.username = username;
        this.comment = comment;
        this.memoId = memoId;
    }

    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.memoId = requestDto.getMemoId();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
        this.memoId = requestDto.getMemoId();
    }
}