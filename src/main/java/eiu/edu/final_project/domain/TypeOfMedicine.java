package eiu.edu.final_project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "TypeOfMedicines")
@TypeAlias("TypeOfMedicine")
public class TypeOfMedicine {

    @Id
    private String id;

    @Field("typename")
    private String typeName;

    @Field("medicine_list")
    @DBRef(lazy = true)
    private List<Medicine> medicineList;

    public TypeOfMedicine(String typeName) {
        this.typeName = typeName;
    }

    public TypeOfMedicine() {
    }
}
