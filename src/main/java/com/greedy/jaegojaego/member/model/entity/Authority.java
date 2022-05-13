package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : Authority
 * Comment : AUTHORITY 테이블과 대응할 엔티티, 권한에 대한 테이블이다
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Builder
@Entity(name = "Authority")
@EqualsAndHashCode
@Table(name = "AUTHORITY")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    @Column(name = "AUTHORITY_INFO")
    private String authorityInfo;

    public Authority() {}

    public Authority(int authorityCode, String authorityName, String authorityInfo) {
        this.authorityCode = authorityCode;
        this.authorityName = authorityName;
        this.authorityInfo = authorityInfo;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityInfo() {
        return authorityInfo;
    }

    public void setAuthorityInfo(String authorityInfo) {
        this.authorityInfo = authorityInfo;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityCode=" + authorityCode +
                ", authorityName='" + authorityName + '\'' +
                ", authorityInfo='" + authorityInfo + '\'' +
                '}';
    }
}
