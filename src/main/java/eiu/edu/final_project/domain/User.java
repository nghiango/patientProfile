package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

@Data
@Document(collection = "Users")
@TypeAlias("User")
public class User {

    @Id
    private String id;

    private Integer active;

    private String name;

    @Field("username")
    private String userName;

    private String password;

    private String address;

    private String sex;

    @DBRef(lazy = true)
    private List<Roles> roles;

    @Field("treatment_list")
    @DBRef(lazy = true)
    private List<Treatment> treatmentList;

    public User(Integer active, String name, String userName, String password, String address, String sex) {
        this.active = active;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.sex = sex;
    }

    public User() {
    }
}
