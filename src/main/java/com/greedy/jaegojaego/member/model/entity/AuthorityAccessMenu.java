package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "AuthorityAccessMenu")
@Table(name = "AUTHORITY_ACCESS_MENU")
public class AuthorityAccessMenu implements Serializable {

    @Id
    @JoinColumn(name = "MENU_CODE")
    private int menuCode;

    @Id
    @JoinColumn(name = "AUTHORITY_CODE")
    private int authorityCode;
}
