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
@Table(name = "SYSTEM")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SYS_ID", nullable = false)
    private Long sysId;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

     @Override
     public boolean equals(Object object) {
        if(!(object instanceof System)) {
            return false;
        }

        System system = (System) object;

        return new EqualsBuilder().append(this.sysId, system.getSysId()).isEquals();
     }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.sysId).build();
    }

    @Override
    public String toString() {
         return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                                   .append("sysId", sysId)
                                   .append("name", name)
                                   .toString();
    }

}
