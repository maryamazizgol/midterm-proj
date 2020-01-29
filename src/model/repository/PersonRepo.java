package model.repository;

import model.entity.PersonEnti;

import java.sql.*;
import java.util.ArrayList;



public class PersonRepo implements AutoCloseable {

    private PreparedStatement preparedStatement;
    private ArrayList personsList;
    private Connection con;

    public PersonRepo(){
        personsList = new ArrayList();
        Connect();
    }

    public Connection Connect(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam123", "MYJAVA");
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

        return con;
    }

    public ArrayList search(String name)
    {
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam123",
                "MYJAVA"))  	{
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Person WHERE name like '%"+name+"%'");

            ResultSet rs = preparedStatement.executeQuery();

            String pname = "";
            String address = "";
            String email = "";
            int id, phone;

            while(rs.next())
            {
                id = rs.getInt("id");
                pname = rs.getString("name");
                address = rs.getString("address");
                phone = rs.getInt("phone");
                email = rs.getString("email");

                PersonEnti person = new PersonEnti(id, pname, address, phone, email);

                personsList.add(person);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return personsList;

    }

    public void save(PersonEnti person){
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam123",
                "MYJAVA"))
        {
            PreparedStatement preparedStatement1 =
                    con.prepareStatement("insert into person (name, address, phone, email) values (?,?,?,?)");
            preparedStatement1.setString(1, person.getName());
            preparedStatement1.setString(2, person.getAddress());
            preparedStatement1.setInt(3, person.getPhone());
            preparedStatement1.setString(4, person.getEmail());

            preparedStatement1.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(PersonEnti person)
    {
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam123",
                "MYJAVA"))
        {


            PreparedStatement preparedStatement2 = connection.prepareStatement("update person SET name = ?, address=?" +
                    " , phone=? , email=? where id=?");

            preparedStatement2.setString(1 , person.getName());
            preparedStatement2.setString(2 , person.getAddress());
            preparedStatement2.setInt(3 , person.getPhone());
            preparedStatement2.setString(4 , person.getEmail());
            preparedStatement2.setInt(5 , person.getId());

            preparedStatement2.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public int remove(String name){
        int no = 0;
        try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "maryam123",
                "MYJAVA")){
            PreparedStatement preparedStatement3 = connection.prepareStatement("DELETE FROM Person WHERE name = ?");

            preparedStatement3.setString(1, name);
            no = preparedStatement3.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return no;
    }


    public void commit() throws Exception{
        con.commit ();
    }
    public void rollback() throws Exception{
        con.rollback ();
    }
    public void close() throws Exception{
        preparedStatement.close ();
        con.close ();
    }
}
