package kr.couchcoding.tennis_together.domain.user.model;

import javax.persistence.*;

import kr.couchcoding.tennis_together.domain.location.model.LocCd;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // 기본 생성자 생성
@Table(name="user_info")
public class User {

    @Id 
    @Column(length = 50, columnDefinition = "firebase uid")
    private String uid;
    
    @Column(length = 10, columnDefinition = "휴대폰 번호")
    private String phone;

    @Column(nullable = false, length = 50) // 디폴트는 nullalbe = true, length = 255
    private String name;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(nullable = false, length = 6)
    private String birth;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private int history;

    @Column(nullable = false, name = "reg_dtm")
    private LocalDateTime regDtm;

    @Column(nullable = false, name = "upd_dtm")
    private LocalDateTime updDtm;

    @Column(nullable = false, name = "act_dv_cd")
    private char actDvCd;

    @Column(length = 100, name = "profile_url")
    private String profileUrl;

    private double score;

    @ManyToOne
    @JoinColumn(name = "loc_cd_no")
    private  LocCd locCd;

    /*
    * Entity에는 Setter를 사용하지 않는다.
    *  - 객체의 일관성을 유지하는데 문제가 생길 수 있기 때문에
    *  - 객체는 생성할 때는 Builder를 사용
    * */
    @Builder
    public User(String uid, String phone, String name, String password, String nickname, String birth, char gender,
                int history, LocalDateTime regDtm, LocalDateTime updDtm, char actDvCd, String profileUrl,
                double score, LocCd locCd){
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.history = history;
        this.regDtm = regDtm;
        this.updDtm = updDtm;
        this.actDvCd = actDvCd;
        this.profileUrl = profileUrl;
        this.score = score;
        this.locCd = locCd;
    }

}