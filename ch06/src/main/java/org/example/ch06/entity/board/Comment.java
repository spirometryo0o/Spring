package org.example.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude =  {"article", "user"})
@Builder
@Entity
@Table(name = "board_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 어노테이션
    private  int cno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Article article; // 댓글의 부모 글 번호

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;


    @CreationTimestamp // 해당 엔티티가 insert 될때 현재 날짜 시간 생성
    private LocalDateTime wdate;

}
