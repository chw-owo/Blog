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

//    @JoinColumn(name = "memoId")
//    @ManyToOne(fetch=FetchType.EAGER)
//    private Memo memo;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    public Comment(String username, String comment) {
        this.username = username;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }
}