package org.suleiman.DataJpaWithVertx.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.suleiman.DataJpaWithVertx.Utility.Device;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "workstations")
public class Workstation implements Serializable {
    @Id
    @SequenceGenerator(name = "workstation_sequence",sequenceName = "workstation_sequence",allocationSize = 1)
    @GeneratedValue(generator = "workstation_sequence",strategy = GenerationType.AUTO)
    private Long workstationId;

    @Column(name = "device_type",nullable = false)
    private String device;

    @Column(nullable = false)
    private String manufacturer;

    @Column(name = "serial_number",nullable = false,unique = true)
    private String serialNumber;
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "staff_id",referencedColumnName = "staffId")
//    Staff staff;

}
