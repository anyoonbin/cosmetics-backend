package com.teamtbd.cosmetics.member;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //JPA
@Builder // JPA 엔티티 객체생성자 빌더
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드 값 받는 파라미터 생성자 생성
@ToString
@Getter //접근자 자동생성    // @Data 어노테이션을 쓰면 한번에 여러 어노테이션 처리가능
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //일단 디비가 아이디 자동 생성되게
    //소셜 로그인 하면 어떤식으로 들어오는지 모름 아직 key를 안정함
    private Long id;

    @Column
    private String user_name;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String phonenumber;

    @Column
    private String gender;

    @Column
    private String birth;

    @Column
    private String skin_type;

    @Column
    private String join_date;

}