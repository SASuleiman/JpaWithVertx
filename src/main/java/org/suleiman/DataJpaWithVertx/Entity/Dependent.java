package org.suleiman.DataJpaWithVertx.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "dependent_name")),
        @AttributeOverride(name = "relationship", column = @Column(name = "dependent_relationship"))
})
public class Dependent implements Serializable {
    private String name;
    private String relationship;
}
