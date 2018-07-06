package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "medicines")
@TypeAlias("medicine")
public class Medicine {

    @Id
    private String id;

    private String name;

    private String mfg;

    private String producer;

    private String dosage;

    @Field("type_id")
    @DBRef(lazy = true)
    private TypeOfMedicine typeId;

    @Field("allergic_list")
    @DBRef(lazy = true)
    private List<Allergic> allergicList;

    @Field("treatment_detail_list")
    @DBRef(lazy = true)
    private List<TreatmentDetail> treatmentDetailList;

    public Medicine(String id, String name, String mfg, String producer, String dosage) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.producer = producer;
        this.dosage = dosage;
    }

    public Medicine() {
    }
}
