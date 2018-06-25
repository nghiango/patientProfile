package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "files")
@TypeAlias("file")
public class File {

    @Id
    private String id;

    @Field("image")
    private byte[] image;

    @Field("treatment_id")
    @DBRef
    private Treatment treatmentId;

    public File(byte[] image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setTreatmentId(Treatment treatmentId) {
        this.treatmentId = treatmentId;
    }

    public File() {
    }
}
