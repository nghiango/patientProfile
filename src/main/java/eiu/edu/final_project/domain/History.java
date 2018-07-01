package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "histories")
@TypeAlias("history")
public class History {

    @Id
    private String id;

    @Field("datetime")
    private Date datetime;

    @Field("patient_id")
    @DBRef(lazy = true)
    private Patient patientId;

    public History(Date datetime) {
        this.datetime = datetime;
    }

    public History() {
    }
}
