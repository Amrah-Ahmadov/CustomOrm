import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Menu {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("movie_catalog");
    EntityManager em=emf.createEntityManager();

    Scanner scan = new Scanner(System.in);
    int commandNumber;
    int number;
    String scanning;
    public void beginTransaction(){
        em.getTransaction().begin();
    }
    public void endTransaction(){
        emf.close();
        em.close();
    }
    public void showMenu(){
        System.out.println("Uzerinde emeliyyat aparmaq istediyiniz entiti ni secin:");
        System.out.println("Movie 1");
        System.out.println("Genre 2");
        System.out.println("Person 3");
        System.out.println("Programdam cixis 4");

    }
    public void showMovieCrudMenu(){
        System.out.println("Movie yarat 1");
        System.out.println("Movie ada gore tap 2");
        System.out.println("Movie deyisiklik et 3");
        System.out.println("Movie sil 4");

    }
    public void showGenreCrudMenu(){
        System.out.println("Janr yarat 1");
        System.out.println("Janri ada gore tap 2");
        System.out.println("Janra deyisiklik et 3");
        System.out.println("Janri sil 4");
    }
    public void showPersonCrudMenu(){
        System.out.println("Person yarat 1");
        System.out.println("Person ada gore tap 2");
        System.out.println("Person deyisiklik et 3");
        System.out.println("Person sil 4");
        commandNumber = scan.nextInt();
    }
    public void addMovie(){

        Movie movie = new Movie();
        System.out.println("Filmin adini daxil edin: ");
        scanning = scan.next();
        movie.setName(scanning);
        System.out.println("Filmin janrini daxil edin:");
        scanning = scan.next();
        Genre genre = new Genre(scanning);
        movie.setGenre(genre);
        System.out.println("Film elave olundu");
        em.persist(movie);
        em.getTransaction().commit();

    }
    public void findMovie(){

        System.out.println("Tapmaq istediyiniz filmin adini daxil edin:");
        scanning = scan.next();
        Movie myMovie = em.createNamedQuery("Movie.findByName", Movie.class)
                .setParameter("name", scanning)
                .getSingleResult();
        em.getTransaction().commit();

        System.out.println(myMovie);
    }
    public void modifyMovie(){

        System.out.println("deyisiklik etmek istediyiniz filmin id sini daxil edin:");
        number = scan.nextInt();
        Movie movie = em.find(Movie.class, number);
        System.out.println("ad daxil edin:");
        scanning = scan.next();
        movie.setName(scanning);
        System.out.println("janr elave et");
        scanning = scan.next();
        movie.setGenre(new Genre(scanning));
        System.out.println("Deyisiklikler elave olundu");
        em.getTransaction().commit();

    }
    public void deleteMovie(){

        System.out.println("silmek istediyiniz filmin id sini daxil edin:");
        number = scan.nextInt();
        Movie movie = em.find(Movie.class, number);
        em.remove(movie);
        System.out.println("silindi");
        em.getTransaction().commit();

    }
    public void addGenre(){

        System.out.println("Elave etmek istediyiniz janri daxil edin:");
        scanning = scan.next();
        Genre genre = new Genre(scanning);
        System.out.println("Elave olundu");
        em.persist(genre);
        em.getTransaction().commit();

    }
    public void findGenre(){
        System.out.println("Tapmaq istediyiniz janrin adini daxil edin:");
        scanning = scan.next();
        Genre genre  = em.createNamedQuery("Genre.findByName", Genre.class)
                .setParameter("genreName", scanning)
                .getSingleResult();
        em.getTransaction().commit();

        System.out.println(genre);
    }
    public void modifyGenre(){

        System.out.println("deyisiklik etmek istediyiniz janrin id sini daxil edin:");
        number = scan.nextInt();
        Genre genre = em.find(Genre.class, number);
        System.out.println("janrin yeni adini daxil edin:");
        scanning = scan.next();
        genre.setGenreName(scanning);
        System.out.println("Deyisiklikler elave olundu");
        em.getTransaction().commit();

    }
    public void deleteGenre(){

        System.out.println("silmek istediyiniz janrin id sini daxil edin:");
        number = scan.nextInt();
        Genre genre = em.find(Genre.class, number);
        em.remove(genre);
        System.out.println("silindi");
        em.getTransaction().commit();

    }
    public void addPerson(){

        PersonDetail pd = new PersonDetail();
        Profession profession = new Profession();
        Person person = new Person();
        System.out.println("elave etmek istediyiniz sexsin adini daxil edin:");
        scanning = scan.next();
        pd.setName(scanning);
        System.out.println("elave etmek istediyiniz sexsin soyadini daxil edin:");
        scanning = scan.next();
        pd.setSurname(scanning);
        System.out.println("elave etmek istediyiniz sexsin yasini daxil edin:");
        number = scan.nextInt();
        pd.setAge(number);
        System.out.println("elave etmek istediyiniz sexsin cinsini daxil edin:");
        scanning = scan.next();
        pd.setGender(scanning);
        System.out.println("elave etmek istediyiniz sexsin istisasini daxil edin:");
        scanning = scan.next();
        profession.setProfessionName(scanning);
        person.getProfessions().add(profession);
        person.setPersonDetail(pd);
        System.out.println("Elave olundu");
        em.getTransaction().commit();

    }
    public void findPerson(){
        System.out.println("Tapmaq istediyiniz sexsin adini daxil edin:");
        scanning = scan.next();
        Person person  = em.createNamedQuery("Person.findByName", Person.class)
                .setParameter("name", scanning)
                .getSingleResult();
        em.getTransaction().commit();

        System.out.println(person);
    }
    public void modifyPerson(){

        System.out.println("deyisiklik etmek istediyiniz sexsin id sini daxil edin:");
        number = scan.nextInt();
        Person person = em.find(Person.class, number);
        System.out.println("deyisiklik etmek istediyiniz sexsin yeni adini daxil edin:");
        scanning = scan.next();
        person.getPersonDetail().setName(scanning);
        System.out.println("deyisiklik etmek istediyiniz sexsin soyadini daxil edin:");
        scanning = scan.next();
        person.getPersonDetail().setSurname(scanning);
        System.out.println("deyisiklik etmek istediyiniz sexsin yasini daxil edin:");
        number = scan.nextInt();
        person.getPersonDetail().setAge(number);
        System.out.println("deyisiklik etmek istediyiniz sexsin cinsini daxil edin:");
        scanning = scan.next();
        person.getPersonDetail().setGender(scanning);
        System.out.println("deyisiklik etmek istediyiniz sexsin ixtisasini daxil edin:");
        scanning = scan.next();
        person.getProfessions().add(new Profession(scanning));
        System.out.println("Deyisiklikler elave olundu");
        em.getTransaction().commit();

    }
    public void deletePerson(){

        System.out.println("silmek istediyiniz sexsin id sini daxil edin:");
        number = scan.nextInt();
        Person person = em.find(Person.class, number);
        em.remove(person);
        System.out.println("silindi");
        em.getTransaction().commit();

    }
}
