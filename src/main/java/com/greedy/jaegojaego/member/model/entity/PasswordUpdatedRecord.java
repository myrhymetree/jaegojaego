package com.greedy.jaegojaego.member.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SequenceGenerator(
        name = "PASSWORD_UPDATED_RECORD_SEQ_GENERATOR",
        sequenceName = "PASSWORD_UPDATED_RECORD_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "PasswordUpdatedRecord")
@Table(name = "PASSWORD_UPDATED_RECORD")
public class PasswordUpdatedRecord {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PASSWORD_UPDATED_RECORD_SEQ_GENERATOR"
    )
    @Column(name = "PASSWORD_UPDATED_RECORD_NO")
    private Integer passwordUpdatedRecordNo;

    @Column(name = "PASSWORD_UPDATED_RECORD_UPDATED_PASSWORD")
    private String passwordUpdatedRecordPwd;

    @Column(name = "PASSWORD_UPDATED_RECORD_UPDATED_DATE")
    private LocalDateTime passwordUpdatedRecordDate;

    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO",updatable = false, insertable = false)
    private Member member;
}
