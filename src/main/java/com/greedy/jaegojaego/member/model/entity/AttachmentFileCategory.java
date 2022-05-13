package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <pre>
 * Class : AttachmentFileCategory
 * Comment : ATTACHMENT_FILE_CATEGORY 테이블과 대응할 엔티티, 첨부파일 카테고리을 담당한다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Entity
@Table(name = "ATTACHMENT_FILE_CATEGORY")
public class AttachmentFileCategory implements Serializable {

    @Id
    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private int attachmentFileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NAME")
    private String attachmentFileCategoryName;

    public AttachmentFileCategory() {}

    public AttachmentFileCategory(int attachmentFileCategoryNo, String attachmentFileCategoryName) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
        this.attachmentFileCategoryName = attachmentFileCategoryName;
    }

    public int getAttachmentFileCategoryNo() {
        return attachmentFileCategoryNo;
    }

    public void setAttachmentFileCategoryNo(int attachmentFileCategoryNo) {
        this.attachmentFileCategoryNo = attachmentFileCategoryNo;
    }

    public String getAttachmentFileCategoryName() {
        return attachmentFileCategoryName;
    }

    public void setAttachmentFileCategoryName(String attachmentFileCategoryName) {
        this.attachmentFileCategoryName = attachmentFileCategoryName;
    }

    @Override
    public String toString() {
        return "AttachmentFileCategory{" +
                "attachmentFileCategoryNo=" + attachmentFileCategoryNo +
                ", attachmentFileCategoryName='" + attachmentFileCategoryName + '\'' +
                '}';
    }
}
