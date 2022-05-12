package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "materialFile")
@Table(name = "ATTACHMENT_FILE")
@SequenceGenerator(
        name = "FILE_SEQ_GENERATOR",
        sequenceName = "ATTACHMENT_FILE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class MaterialFile {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FILE_SEQ_GENERATOR"
    )
    @Column(name = "ATTACHMENT_FILE_NO")
    private int fileNo;

    @Column(name = "ATTACHMENT_FILE_ORIGINAL_NAME")
    private String fileOriginalName;

    @Column(name = "ATTACHMENT_FILE_CHANGED_NAME")
    private String fileChangedName;

    @Column(name = "ATTACHMENT_FILE_URL")
    private String fileUrl;

    @Column(name = "ATTACHMENT_FILE_DELETE_YN")
    private String deleteYn;

    @Column(name = "ATTACHMENT_FILE_THUMBNAIL_URL")
    private String thumbnailUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private MaterialFileCategory materialFileCategory;

    @Column(name = "ATTACHMENT_FILE_DIVISION")
    private String fileDivision;

    @Column(name = "ITEM_INFO_NO")
    private Integer itemInfoNo;

    public MaterialFile() {
    }

    public MaterialFile(int fileNo, String fileOriginalName, String fileChangedName, String fileUrl, String deleteYn, String thumbnailUrl, MaterialFileCategory materialFileCategory, String fileDivision, Integer itemInfoNo) {
        this.fileNo = fileNo;
        this.fileOriginalName = fileOriginalName;
        this.fileChangedName = fileChangedName;
        this.fileUrl = fileUrl;
        this.deleteYn = deleteYn;
        this.thumbnailUrl = thumbnailUrl;
        this.materialFileCategory = materialFileCategory;
        this.fileDivision = fileDivision;
        this.itemInfoNo = itemInfoNo;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileOriginalName() {
        return fileOriginalName;
    }

    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName;
    }

    public String getFileChangedName() {
        return fileChangedName;
    }

    public void setFileChangedName(String fileChangedName) {
        this.fileChangedName = fileChangedName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public MaterialFileCategory getFileCategory() {
        return materialFileCategory;
    }

    public void setFileCategory(MaterialFileCategory materialFileCategory) {
        this.materialFileCategory = materialFileCategory;
    }

    public String getFileDivision() {
        return fileDivision;
    }

    public void setFileDivision(String fileDivision) {
        this.fileDivision = fileDivision;
    }

    public Integer getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(Integer itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "MaterialFile{" +
                "fileNo=" + fileNo +
                ", fileOriginalName='" + fileOriginalName + '\'' +
                ", fileChangedName='" + fileChangedName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", deleteYn='" + deleteYn + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", fileCategory=" + materialFileCategory +
                ", fileDivision='" + fileDivision + '\'' +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
