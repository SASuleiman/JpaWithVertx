package org.suleiman.DataJpaWithVertx.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Departments")
public class Department implements Serializable {
    @Id
    @SequenceGenerator(name = "department_sequence",sequenceName = "department_sequence",allocationSize = 1)
    @GeneratedValue(generator = "department_sequence",strategy = GenerationType.AUTO)
    private Long departmentId;

    @Column(name = "department_name",nullable = false)
    private String departmentName;

    @Column(name = "building_name",nullable = false)
    private String building;


}
