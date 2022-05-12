package com.greedy.jaegojaego.franchise.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
@SequenceGenerator(
        name = "ATTACHMENT_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseAttachmentFile")
@Table(name = "ATTACHMENT_FILE")
public class FranchiseAttachmentFile {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ATTACHMENT_SEQ_GENERATOR"
    )
    @Column(name = "ATTACHMENT_FILE_NO")
    private Integer attachmentNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String attachmentFileOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String attachmentFileChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String attachmentFileURL;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String attachmentFileDeleteYn;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private Integer attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String attachmentFileDivision;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Integer franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_CONTRACT_UPDATE_NO")
    private Integer franchiseContractUpdateNo;

}
