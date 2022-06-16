package pl.agachalat.recipesmanagementsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITM_ID", nullable = false)
    private Long itmId;

    @ManyToOne
    @JoinColumn(name = "ING_ID", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Item)) {
            return false;
        }

        Item item = (Item) object;

        return new EqualsBuilder().append(this.itmId, item.getItmId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.itmId).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("itmId", itmId)
                .append("ingredient", ingredient)
                .append("quantity", quantity)
                .toString();
    }
}
