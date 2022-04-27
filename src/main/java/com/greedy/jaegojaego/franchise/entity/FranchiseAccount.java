package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "FranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
public class FranchiseAccount extends Member {

    @Column(name = "FRANCHISE_MAMAGER_NO")
    private Integer managerNo;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @Column(name = "MANAGER_PHONE")
    private String managerPhone;

    @Column(name = "MANAGER_EMAIL")
    private String managerEmail;

    @Column(name = "REPRESENTATIVE_NO")
    private Integer representativeNo;

}
