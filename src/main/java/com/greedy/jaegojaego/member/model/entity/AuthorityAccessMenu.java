package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * Class : AuthorityAccessMenu
 * Comment : AUTHORITY_ACCESS_MENU 테이블과 대응할 엔티티, 권한별로 들어갈 수 있는 메뉴가 명시된다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */

@Builder
@EqualsAndHashCode
@Entity(name = "AuthorityAccessMenu")
@Table(name = "AUTHORITY_ACCESS_MENU")
public class AuthorityAccessMenu implements Serializable {

    @Id
    @JoinColumn(name = "MENU_CODE")
    private int menuCode;

    @Id
    @JoinColumn(name = "AUTHORITY_CODE")
    private int authorityCode;

    public AuthorityAccessMenu() {}

    public AuthorityAccessMenu(int menuCode, int authorityCode) {
        this.menuCode = menuCode;
        this.authorityCode = authorityCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    @Override
    public String toString() {
        return "AuthorityAccessMenu{" +
                "menuCode=" + menuCode +
                ", authorityCode=" + authorityCode +
                '}';
    }
}
