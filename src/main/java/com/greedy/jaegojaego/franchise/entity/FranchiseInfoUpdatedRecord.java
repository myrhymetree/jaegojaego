package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@SequenceGenerator(
        name = "FRANCHISE_INFO_UPDATED_RECORD_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_UPDATED_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseInfoUpdatedRecord")
@Table(name = "FRANCHISE_INFO_UPDATED_RECORD")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FranchiseInfoUpdatedRecord {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_INFO_UPDATED_RECORD_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_UPDATED_INFO_NO")
    private Integer franchiseUpdatedInfoNo;

    @Column(name = "INFO_WRITE_MEMBER_NO")
    private Integer infoWriteMemberNo;

    @Column(name = "FRANCHISE_UPDATED_DATE")
    private LocalDateTime franchiseUpdatedDate;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Integer franchiseRepresentativeNo;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_NO")
//    private CompanyAccount companyAccount;

}
