package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "TreatmentDetails")
@TypeAlias("TreatmentDetail")
public class TreatmentDetail {

    @Id
    private String id;

    private String diseases;

    @Field("treatment_Id")
    @DBRef
    private Treatment treatmentId;

    @Field("medicine_id")
    @DBRef
    private Medicine medicineId;

    public TreatmentDetail(String diseases) {
        this.diseases = diseases;
    }

    public TreatmentDetail() {
    }
}
