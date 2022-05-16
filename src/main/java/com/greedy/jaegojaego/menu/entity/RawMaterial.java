package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "rawMaterial")
@Table(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM")
public class RawMaterial implements Serializable {

    @EmbeddedId
    private RawMaterialPK rawMaterialPK;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_NAME")
    private String rawMaterialName;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_CAPACITY")
    private String rawMaterialCapacity;


    public RawMaterial() {}

    public RawMaterial(RawMaterialPK rawMaterialPK, String rawMaterialName, String rawMaterialCapacity) {
        this.rawMaterialPK = rawMaterialPK;
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    public RawMaterialPK getRawMaterialPK() {
        return rawMaterialPK;
    }

    public void setRawMaterialPK(RawMaterialPK rawMaterialPK) {
        this.rawMaterialPK = rawMaterialPK;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getRawMaterialCapacity() {
        return rawMaterialCapacity;
    }

    public void setRawMaterialCapacity(String rawMaterialCapacity) {
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "rawMaterialPK=" + rawMaterialPK +
                ", rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity='" + rawMaterialCapacity + '\'' +
                '}';
    }
}
