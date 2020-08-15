import java.sql.*;
import java.util.ArrayList;

public class DataBuilder {
    static Connection conn;

    public DataBuilder(Connection conn) {
        this.conn = conn;
    }


    public void createTable() throws SQLException {
        String qurey ="CREATE TABLE IF NOT EXISTS person(id int primary key unique auto_increment,first_name varchar(50),last_name varchar(50),address varchar(150),mobile_number varchar(15))";
        Statement statement = conn.createStatement();
        statement.execute(qurey);
    }

    public static void addRecord(Person person) throws SQLException {
        String query = "INSERT INTO person(first_name,last_name,address,mobile_number) VALUES(?,?,?,?)";
        PreparedStatement ppStatement = conn.prepareStatement(query);
        ppStatement.setString(1,person.getFirstName());
        ppStatement.setString(2,person.getLastName());
        ppStatement.setString(3,person.getAddress());
        ppStatement.setString(4,person.getMobileNumber());
        boolean flag =   ppStatement.execute();
       if (!flag){
           System.out.println("Your Reord has been successfully added\n");
       }else{
           System.out.println("There was an error in adding record\n");
       }
    }
    public static ArrayList<Person> searchRecord(int id) throws SQLException {
        String query ="SELECT * FROM person where id=?";
        PreparedStatement ppStatement = conn.prepareStatement(query);
        ppStatement.setString(1,id+"");
        ArrayList<Person> persons = new ArrayList<>();
        ResultSet rs = ppStatement.executeQuery();
        while (rs.next()){
            Person person = new Person();
            person.PersonShow((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            persons.add(person);
        }
        if (persons.isEmpty()){
            System.out.println("Id entered is incorrect or does not exits\n");
        }
        return persons;
    }
    public static ArrayList<Person> searchAllRecord() throws SQLException {
        String query ="SELECT * FROM person";
        PreparedStatement ppStatement = conn.prepareStatement(query);
        ArrayList<Person> persons = new ArrayList<>();
        ResultSet rs = ppStatement.executeQuery();
        while (rs.next()){
            Person person = new Person();
            person.PersonShow((rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            persons.add(person);
        }
        if (persons.isEmpty()){
            System.out.println("No record exits\n");
        }
        return persons;
    }
    public static void updateRecord(int id,Person person) throws SQLException {
        String query = "UPDATE person SET first_name=?,last_name=?,address=?,mobile_number=? where id=?";
        PreparedStatement ppStatement = conn.prepareStatement(query);
        ppStatement.setString(1,person.getFirstName());
        ppStatement.setString(2,person.getLastName());
        ppStatement.setString(3,person.getAddress());
        ppStatement.setString(4,person.getMobileNumber());
        ppStatement.setString(5,id+"");
        boolean flag =   ppStatement.execute();
        if (!flag){
            System.out.println("Your Reord has been successfully UPDATED\n");
        }else{
            System.out.println("Id entered is incorrect or does not exits\n");
        }


    }
    public static void deleteRecord(int id) throws SQLException {
        String query = "DELETE FROM person WHERE id=?";
        PreparedStatement ppStatement = conn.prepareStatement(query);
        ppStatement.setString(1,id+"");
        boolean flag = ppStatement.execute();
        if (!flag){
            System.out.println("Your Reord has been successfully DELETED\n");
        }else{
            System.out.println("Id entered is incorrect or does not exits\n");
        }

    }
}
