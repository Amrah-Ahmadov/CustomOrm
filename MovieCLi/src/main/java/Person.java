import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Person.findByName",
                query = "SELECT a FROM Person a JOIN PersonDetail pd ON pd.id = a.personDetail.id WHERE pd.name = :name")
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    PersonDetail personDetail;
    @OneToMany(targetEntity=Profession.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,orphanRemoval = true)
    List<Profession> professions;

    public Person() {

    }

    public Person(PersonDetail personDetail, List<Profession> professions) {
        this.personDetail = personDetail;
        this.professions = professions;
    }

    public PersonDetail getPersonDetail() {
        return personDetail;
    }

    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personDetail=" + personDetail +
                ", professions=" + professions +
                '}';
    }
}
