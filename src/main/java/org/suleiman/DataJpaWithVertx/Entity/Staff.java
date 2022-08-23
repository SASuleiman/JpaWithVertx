package org.suleiman.DataJpaWithVertx.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.suleiman.DataJpaWithVertx.Utility.Skill;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff implements Serializable {
    @Id
    @SequenceGenerator(name = "staff_sequence",sequenceName = "staff_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "staff_sequence")
    private Long staffId;

    @Column(name = "staff_name",nullable = false)
    private String name;

    @Column(name = "skill_set",nullable = false)
    private String skill;

    @Column(nullable = false)
    private Long salary;

    @Embedded
    Dependent dependent;


//
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "staff")
//    Workstation workstation;

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "department_id",referencedColumnName = "departmentId")
//    Department department;

}
