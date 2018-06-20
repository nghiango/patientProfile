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
import java.util.Set;

@Data
@Document(collection = "patients")
@TypeAlias("patient")
public class Patient {

    @Id
    private String id;

    private String fullName;

    private String address;

    private String sex;

    private Date dob;

    @DBRef(lazy = true)
    @Field("allergic_list")
    private List<Allergic> allergicList;

    @DBRef(lazy = true)
    @Field("treatment_list")
    private List<Treatment> treatmentList;

    public Patient(String fullName, String address, String sex, Date dob) {
        this.fullName = fullName;
        this.address = address;
        this.sex = sex;
        this.dob = dob;
    }

    public Patient() {
    }
}
