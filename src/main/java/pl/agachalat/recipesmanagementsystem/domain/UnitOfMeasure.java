package pl.agachalat.recipesmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "UNITS_OF_MEASURE")
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UOM_ID", nullable = false)
    private Long uomId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "SYS_ID", nullable = false)
    private System system;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof UnitOfMeasure)) {
            return false;
        }

        UnitOfMeasure unitOfMeasure = (UnitOfMeasure) object;

        return new EqualsBuilder().append(this.uomId, unitOfMeasure.getUomId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.uomId).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("uomId", uomId)
                .append("name", name)
                .append("system", system)
                .toString();
    }
}
