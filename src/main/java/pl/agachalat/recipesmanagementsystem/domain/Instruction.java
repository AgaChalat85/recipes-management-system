package pl.agachalat.recipesmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "INSTRUCTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INS_ID", nullable = false)
    private Long insId;

    @Column(name = "DESCRIPTION", nullable = false, length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "RCP_ID", nullable = false)
    private Recipe recipe;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Instruction)) {
            return false;
        }

        Instruction instruction = (Instruction) object;

        return new EqualsBuilder().append(this.insId, instruction.getInsId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.insId).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("insId", insId)
                .append("description", description)
                .append("recipe", recipe)
                .toString();
    }
}
