package pl.agachalat.recipesmanagementsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID", nullable = false)
    private Long usrId;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String eMail;

    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof User)) {
            return false;
        }

        User user = (User) object;

        return new EqualsBuilder().append(this.usrId, user.getUsrId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.usrId).build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("usrId", usrId)
                .append("name", name)
                .append("email", eMail)
                .append("items", items)
                .append("recipes", recipes)
                .toString();
    }

}
