package com.greedy.jaegojaego.materials.model.dto;

public class MaterialFileDTO {

    private int fileNo;
    private String fileOriginalName;
    private String fileChangedName;
    private String fileUrl;
    private String deleteYn;
    private MaterialFileCategoryDTO materialFileCategory;
    private String fileDivision;
    private String thumbnailUrl;
    private Integer itemInfoNo;

    public MaterialFileDTO() {
    }

    public MaterialFileDTO(int fileNo, String fileOriginalName, String fileChangedName, String fileUrl, String deleteYn, MaterialFileCategoryDTO materialFileCategory, String fileDivision, String thumbnailUrl, Integer itemInfoNo) {
        this.fileNo = fileNo;
        this.fileOriginalName = fileOriginalName;
        this.fileChangedName = fileChangedName;
        this.fileUrl = fileUrl;
        this.deleteYn = deleteYn;
        this.materialFileCategory = materialFileCategory;
        this.fileDivision = fileDivision;
        this.thumbnailUrl = thumbnailUrl;
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

    public MaterialFileCategoryDTO getMaterialFileCategory() {
        return materialFileCategory;
    }

    public void setMaterialFileCategory(MaterialFileCategoryDTO materialFileCategory) {
        this.materialFileCategory = materialFileCategory;
    }

    public String getFileDivision() {
        return fileDivision;
    }

    public void setFileDivision(String fileDivision) {
        this.fileDivision = fileDivision;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(Integer itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "MaterialFileDTO{" +
                "fileNo=" + fileNo +
                ", fileOriginalName='" + fileOriginalName + '\'' +
                ", fileChangedName='" + fileChangedName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", deleteYn='" + deleteYn + '\'' +
                ", materialFileCategory=" + materialFileCategory +
                ", fileDivision='" + fileDivision + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
