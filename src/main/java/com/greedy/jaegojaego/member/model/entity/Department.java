package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "Department")
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "DEPARTMENT_SEQ_GENERATOR",
        sequenceName = "DEPARTMENT_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPARTMENT_SEQ_GENERATOR"
    )
    @Column(name = "DEPARTMENT_NO")
    private Integer departmentNo;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
}
