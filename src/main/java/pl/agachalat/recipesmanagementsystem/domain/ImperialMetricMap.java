package pl.agachalat.recipesmanagementsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "IMPERIAL_TO_METRIC_MAPPING")
@Immutable
@Getter
@Setter
@NoArgsConstructor
public class ImperialMetricMap {

    @Id
    @Column(name = "IMM_ID", nullable = false)
    private Long immId;

    @ManyToOne
    @JoinColumn(name = "IMPERIAL_ID", nullable = false)
    private UnitOfMeasure imperialUnit;

    @ManyToOne
    @JoinColumn(name = "METRIC_ID", nullable = false)
    private UnitOfMeasure metricUnit;

    @Column(name = "METRIC_QUANTITY")
    private Double metricQuantity;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof ImperialMetricMap)) {
            return false;
        }

        ImperialMetricMap imperialMetricMap = (ImperialMetricMap) object;

        return new EqualsBuilder().append(this.immId, imperialMetricMap.getImmId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.immId).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("immId", immId)
                .append("imperialUnit", imperialUnit)
                .append("metricUnit", metricUnit)
                .append("metricQuantity", metricQuantity)
                .toString();
    }
}
