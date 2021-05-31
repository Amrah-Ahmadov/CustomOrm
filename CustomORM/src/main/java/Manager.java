import java.lang.reflect.Field;
import java.sql.*;

public class Manager {
    Connection c = null;
    PreparedStatement st = null;

    public void createConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost/myhwDB",
                            "postgres", "postgre58896");

            System.out.println("Opened database successfully");


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }


    public void createTable() throws SQLException {

        int check = 0;
        Class userClass = User.class;

        if (userClass.isAnnotationPresent(MyEntity.class)) {
            Field[] fields = userClass.getDeclaredFields();
            for (Field field : fields) {//traversal attributes
                if (field.isAnnotationPresent(MyColumn.class) || field.isAnnotationPresent(MyId.class)) {

                } else {
                    check++;
                }
            }
        } else {
            check++;
        }

        if (check == 0) {
            try {

                String sql = "CREATE TABLE USERS (id SERIAL NOT NULL PRIMARY KEY, first_name VARCHAR(50), last_name VARCHAR(50));";
                st = c.prepareStatement(sql);
                st.executeUpdate(sql);

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

        }

    }
    public void insertIntoTable(String name, String surname){

        try {
            String sql = "INSERT INTO USERS (first_name, last_name) values (?, ?);";
            st = c.prepareStatement(sql);
            st.executeUpdate(sql);
            st.setString(1, name);
            st.setString(2, surname);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void updateTable(int id, String name, String surname){

        try {


            String sql = "UPDATE USERS SET (first_name, last_name) values (?, ?)  WHERE id = ?;";
            st = c.prepareStatement(sql);
            st.executeUpdate(sql);
            st.setString(1, name);
            st.setString(2, surname);
            st.setInt(3, id);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void deleteTable(int id){

        try {

            String sql = "DELETE FROM USERS  WHERE id = ?;";
            st = c.prepareStatement(sql);
            st.executeUpdate(sql);
            st.setInt(1, id);


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void closeConnection() throws SQLException {
        st.close();
        c.close();
    }
}



