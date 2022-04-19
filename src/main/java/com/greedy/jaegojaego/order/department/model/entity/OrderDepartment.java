package com.greedy.jaegojaego.order.department.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "department")
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "DEPARTMENT_SEQ_GENERATOR",
        sequenceName = "DEPARTMENT_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDepartment {

    @Id
    @Column(name = "DEPARTMENT_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPARTMENT_SEQ_GENERATOR"
    )
    private int deptNo;

    @Column(name = "DEPARTMENT_NAME")
    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
