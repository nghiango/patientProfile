package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
@TypeAlias("role")
public class Roles {

    @Id
    private String id;

    private String role;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }
}
