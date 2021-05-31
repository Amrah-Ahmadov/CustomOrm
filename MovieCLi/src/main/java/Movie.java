import javax.persistence.*;
import java.util.List;
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "Movie.findByName",
                query = "SELECT a FROM Movie a WHERE a.name = :name")
})
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    Genre genre;
    @OneToMany(targetEntity=Person.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,orphanRemoval = true)
    List<Person> persons;

    public Movie() {
    }

    public Movie(String name, Genre genre, List<Person> persons) {
        this.name = name;
        this.genre = genre;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", persons=" + persons +
                '}';
    }
}
