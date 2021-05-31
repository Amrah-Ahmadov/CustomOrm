import javax.persistence.*;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Genre.findByName",
                query = "SELECT a FROM Genre a WHERE a.genreName = :genreName")
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String genreName;

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
