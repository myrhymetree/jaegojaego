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
@PrimaryKeyJoinColumn(name = "FRANCHISE_MANAGER_NO")
public class FranchiseAccount extends Member {

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @Column(name = "MANAGER_PHONE")
    private String managerPhone;

    @Column(name = "MANAGER_EMAIL")
    private String managerEmail;

    @Column(name = "REPRESENTATIVE_NO")
    private Integer representativeNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "REPRESENTATIVE_NO", insertable = false, updatable = false)
    private FranchiseInfo franchiseInfo;

}
