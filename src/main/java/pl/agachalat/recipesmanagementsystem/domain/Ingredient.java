package pl.agachalat.recipesmanagementsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
@Immutable
@Getter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ING_ID", nullable = false)
    private Long ingId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "UOM_ID", nullable = false)
    private UnitOfMeasure unitOfMeasure;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Ingredient)) {
            return false;
        }

        Ingredient ingredient = (Ingredient) object;

        return new EqualsBuilder().append(this.ingId, ingredient.getIngId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.ingId).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ingId", ingId)
                .append("name", name)
                .append("unitOfMeasure", unitOfMeasure)
                .toString();
    }
}
