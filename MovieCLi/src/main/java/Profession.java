import javax.persistence.*;

@Entity
@Table
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String professionName;

    public Profession() {
    }

    public Profession(String professionName) {
        this.professionName = professionName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", professionName='" + professionName + '\'' +
                '}';
    }
}
