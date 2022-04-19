package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MaterialsManufacture")
@Table(name = "MATERIAL_MANUFACTURE")
public class MaterialsManufacture {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "MATERIAL_MANUFACTURE_SUBDIVISION_UNIT")
    private int subdivisionUnit;
}
