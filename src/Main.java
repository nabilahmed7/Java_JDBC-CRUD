import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnConfig.getConnection();
        if (conn!=null){
            DataBuilder dbbuilder = new DataBuilder(conn);
            dbbuilder.createTable();
            System.out.println("Welcome");
            welcomeMenu();

    }else{
            System.out.println("DB Not Connected");
        }

    }

    public static void decision(int value) throws SQLException {
        if(value == 1){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter First Name : ");
            String fName = scanner.nextLine();
            System.out.println("Enter Last Name : ");
            String lName = scanner.nextLine();
            System.out.println("Enter Address : ");
            String address = scanner.nextLine();
            System.out.println("Enter Mobile Number : ");
            String mNmbr = scanner.nextLine();
            Person person = new Person(fName,lName,address,mNmbr);
            DataBuilder.addRecord(person);
            welcomeMenu();
        }else if(value == 2){
            int val = showRecordsMenu();
            if(val == 1){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter id : ");
                int id = scanner.nextInt();
                ArrayList<Person> persons = new ArrayList<>();
                persons = DataBuilder.searchRecord(id);
                for(int i=0;i<persons.size();i++){
                    String r = persons.get(i).toString();
                    System.out.println(r);
                }
                welcomeMenu();
            }else if(val == 2){
                ArrayList<Person> persons = new ArrayList<>();
                persons = DataBuilder.searchAllRecord();
                for(int i=0;i<persons.size();i++){
                    String r = persons.get(i).toString();
                    System.out.println(r);
                }
                welcomeMenu();
            }else if (val == 3){
                welcomeMenu();
            }else {
                System.out.println("Please Choose anyone of these");
                showRecordsMenu();
            }
        }else if(value == 3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Id : ");
            int id = scanner.nextInt();
            DataBuilder.deleteRecord(id);
            welcomeMenu();
        }else if(value == 4){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Id : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter New First Name : ");
            String fName = scanner.nextLine();
            System.out.println("Enter New Last Name : ");
            String lName = scanner.nextLine();
            System.out.println("Enter New Address : ");
            String address = scanner.nextLine();
            System.out.println("Enter New Mobile Number : ");
            String mNmbr = scanner.nextLine();
            Person person = new Person(fName,lName,address,mNmbr);
            DataBuilder.updateRecord(id,person);
            welcomeMenu();
        }else if(value == 5){
            System.exit(0);
        }
        else{
            System.out.println("Please Choose anyone of these");
            welcomeMenu();
        }
    }

    public static void welcomeMenu() throws SQLException {
        System.out.println("Press 1 to add record \n" +
                "Press 2 to show records\n" +
                "Press 3 to delete any existing record with ID \n" +
                "Press 4 to update any existing record with its ID \n" +
                "Press 5 to Exit");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        decision(value);
    }

    public static int showRecordsMenu() throws SQLException {
        System.out.println("Press 1 to View record with ID \n" +
                "Press 2 to View all records\n" +
                "Press 3 to Exit");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return value;
    }
}
