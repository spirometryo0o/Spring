package org.example.ch06.entity.board;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "commentList"}) // 해당 엔티티에서 관계 설정한 속성은 반드시 제외해야됨, 제외 안하면 no-session 에러 발생
@Builder
@Entity
@Table(name = "board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int ano;
    private String title;
    private String content;

    // Article 엔티티 관점에서 User 엔티티는 다대일(N:1), fetch는 엔티티를 로딩하는 시점을 설정하는 속성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer") //joinColumn 테이블 컬럼명
    private User user;

    /*
         일대다관계(OneToMany)
         - 참조타입이 List<앤티티>로 선언
         - fetch는 LAZY로 사용, EAGER는 성능부담 발생
         - mappedBy는 해당 엔티티(Article)와 관계가 설정되는 대상 엔티티(Comment)의 현재 엔티티 속성을 선언
         - mappedBy는 대상 엔티티의 외래키(FK)속성을 선언
     */
    // 일대다 관계는 List 선언
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> commentList;

    @CreationTimestamp // 해당 엔티티가 insert 될때 현재날짜 생성
    private LocalDateTime wdate;
}
