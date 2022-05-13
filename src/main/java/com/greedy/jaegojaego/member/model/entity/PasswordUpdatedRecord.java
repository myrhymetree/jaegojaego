package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <pre>
 * Class : PasswordUpdatedRecord
 * Comment :PASSWORD_UPDATED_RECORD_NO 테이블과 대응할 엔티티, 비밀번호 변경이력 테이블이다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
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

    public PasswordUpdatedRecord() {}

    public PasswordUpdatedRecord(Integer passwordUpdatedRecordNo, String passwordUpdatedRecordPwd, LocalDateTime passwordUpdatedRecordDate, Integer memberNo, Member member) {
        this.passwordUpdatedRecordNo = passwordUpdatedRecordNo;
        this.passwordUpdatedRecordPwd = passwordUpdatedRecordPwd;
        this.passwordUpdatedRecordDate = passwordUpdatedRecordDate;
        this.memberNo = memberNo;
    }

    public Integer getPasswordUpdatedRecordNo() {
        return passwordUpdatedRecordNo;
    }

    public void setPasswordUpdatedRecordNo(Integer passwordUpdatedRecordNo) {
        this.passwordUpdatedRecordNo = passwordUpdatedRecordNo;
    }

    public String getPasswordUpdatedRecordPwd() {
        return passwordUpdatedRecordPwd;
    }

    public void setPasswordUpdatedRecordPwd(String passwordUpdatedRecordPwd) {
        this.passwordUpdatedRecordPwd = passwordUpdatedRecordPwd;
    }

    public LocalDateTime getPasswordUpdatedRecordDate() {
        return passwordUpdatedRecordDate;
    }

    public void setPasswordUpdatedRecordDate(LocalDateTime passwordUpdatedRecordDate) {
        this.passwordUpdatedRecordDate = passwordUpdatedRecordDate;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "PasswordUpdatedRecord{" +
                "passwordUpdatedRecordNo=" + passwordUpdatedRecordNo +
                ", passwordUpdatedRecordPwd='" + passwordUpdatedRecordPwd + '\'' +
                ", passwordUpdatedRecordDate=" + passwordUpdatedRecordDate +
                ", memberNo=" + memberNo +
                '}';
    }
}
