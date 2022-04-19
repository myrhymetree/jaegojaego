package com.greedy.jaegojaego.materials.model.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity(name = "Materials")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Materials {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private MaterialsCategory materialCategory;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemStatus;
}
