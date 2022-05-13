package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 * Class : FranchiseAccount
 * Comment : FRANCHISE_ACCOUNT 테이블과 대응할 엔티티, MEMBER 테이블과 슈퍼타입-서브타입 관게로 이루어짐
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Entity(name = "FranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
@PrimaryKeyJoinColumn(name = "FRANCHISE_MANAGER_NO")
@DynamicUpdate
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

    public FranchiseAccount() {}

    public FranchiseAccount(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, List<MemberRole> memberRoleList, List<PasswordUpdatedRecord> passwordUpdatedRecords, String managerName, String managerPhone, String managerEmail, Integer representativeNo, FranchiseInfo franchiseInfo) {
        super(memberNo, memberId, memberPwd, memberPwdUpdateDate, memberPwdInitStatus, memberCreatedDate, memberRemovedDate, memberRemoveStatus, officeDivision, memberDivision, memberRoleList, passwordUpdatedRecords);
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.managerEmail = managerEmail;
        this.representativeNo = representativeNo;
        this.franchiseInfo = franchiseInfo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public Integer getRepresentativeNo() {
        return representativeNo;
    }

    public void setRepresentativeNo(Integer representativeNo) {
        this.representativeNo = representativeNo;
    }

    public FranchiseInfo getFranchiseInfo() {
        return franchiseInfo;
    }

    public void setFranchiseInfo(FranchiseInfo franchiseInfo) {
        this.franchiseInfo = franchiseInfo;
    }

    @Override
    public String toString() {
        return "FranchiseAccount{" +
                "managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", representativeNo=" + representativeNo +
                '}';
    }
}
