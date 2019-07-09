import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class pesonDB {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public pesonDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public", "postgres", "momlifelove");
    }

    public void addPerson(User user ) throws Exception{
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getFirstname());
        preparedStatement.setString(5,user.getLastname());

        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getPerson(String username) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where username = ?");
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String > getperson = new ArrayList<>();
        if (resultSet.next()) {
            getperson.add(resultSet.getString("username"));
            getresultSet.getString("pass");
            resultSet.getString("email");
            resultSet.getString("firstname");
            resultSet.getString("lastname");
            resultSet.getString("photo");

        }

        return getperson;


    }




}
