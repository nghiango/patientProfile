package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "treatments")
@TypeAlias("treatment")
public class Treatment {

    @Id
    private String id;

    private Date date;

    private String file;

    private String prescription;

    @Field("doctor_id")
    @DBRef(lazy = true)
    private User doctorId;

    @Field("treatment_list")
    @DBRef(lazy = true)
    private List<TreatmentDetail> treatmentDetailList;

    @Field("patient_id")
    @DBRef(lazy = true)
    private Patient patientId;

    @Field("treament_list")
    @DBRef(lazy = true)
    private List<File> fileList;

    public Treatment(Date date, String file, String prescription) {
        this.date = date;
        this.file = file;
        this.prescription = prescription;
    }

    public Treatment() {
    }
}
