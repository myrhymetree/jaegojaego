package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MaterialsCategory")
@Table(name = "MATERIAL_CATEGORY")
public class MaterialsCategory {

    @Id
    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategoryNo;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

}
