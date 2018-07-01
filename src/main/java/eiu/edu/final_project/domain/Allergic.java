package eiu.edu.final_project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;

@Data
@Document(collection = "allergies")
@TypeAlias("allergic")
public class Allergic {

    @Id
    private String id;

    @Field("medicine_id")
    @DBRef(lazy = true)
    private Medicine medicineId;

    @Field("patient_id")
    @DBRef(lazy = true)
    private Patient patientId;

    public Allergic() {
    }

}
