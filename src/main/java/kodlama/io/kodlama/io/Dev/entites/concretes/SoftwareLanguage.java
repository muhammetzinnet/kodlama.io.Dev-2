package kodlama.io.kodlama.io.Dev.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "softwarelanguages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SoftwareLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "softwareLanguage")
    private List<Technology> technologies;
}
