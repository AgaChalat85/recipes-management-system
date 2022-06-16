package pl.agachalat.recipesmanagementsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPES")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rcpId", nullable = false)
    private Long rcpId;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "SERVINGS_NUMBER", nullable = false, length = 30)
    private String servingsNumber;

    @Column(name = "COOK_TIME", nullable = false)
    private Integer cookTime;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private List<Item> ingredientList = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private List<Instruction> instructions = new ArrayList<>();

    @Column(name = "favourite")
    private boolean isFavourite;

    @ManyToOne
    @JoinColumn(name = "USR_ID", nullable = false)
    private User user;

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Recipe)) {
            return false;
        }

        Recipe recipe = (Recipe) object;

        return new EqualsBuilder().append(this.rcpId, recipe.getRcpId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.rcpId).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("rcpId", rcpId)
                .append("name", name)
                .append("servingsNumber", servingsNumber)
                .append("cookTime", cookTime)
                .append("ingredientList", ingredientList)
                .append("instructions", instructions)
                .append("isFavourite", isFavourite)
                .append("user", user)
                .toString();
    }
}
