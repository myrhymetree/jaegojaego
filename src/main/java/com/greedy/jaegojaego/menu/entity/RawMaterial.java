package com.greedy.jaegojaego.menu.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "rawMaterial")
@Table(name = "TBL_FINISHED_PRODUCT_CONFIGURATION_ITEM")
public class RawMaterial implements Serializable {

    //pk,fk
    @Id
    @ManyToOne
    @JoinColumn(name = "FINISHED_PRODUCT_MENU_NO")
    private Menu menuNo;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_NAME")
    private String rawMaterialName;

    @Column(name = "FINISHED_PRODUCT_CONFIGURATION_ITEM_CAPACITY")
    private int rawMaterialCapacity;

    //fk
    @OneToMany
    @JoinColumn(name = "ITEM_INFO_NO")
    private List<RawMaterial> materialNo;

    public RawMaterial() {}

    public RawMaterial(Menu menuNo, String rawMaterialName, int rawMaterialCapacity, List<RawMaterial> materialNo) {
        this.menuNo = menuNo;
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
        this.materialNo = materialNo;
    }

    public Menu getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Menu menuNo) {
        this.menuNo = menuNo;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public int getRawMaterialCapacity() {
        return rawMaterialCapacity;
    }

    public void setRawMaterialCapacity(int rawMaterialCapacity) {
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    public List<RawMaterial> getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(List<RawMaterial> materialNo) {
        this.materialNo = materialNo;
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "menuNo=" + menuNo +
                ", rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity=" + rawMaterialCapacity +
                ", materialNo=" + materialNo +
                '}';
    }
}
