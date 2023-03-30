package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR NOT NULL," +
                "last_name VARCHAR NOT NULL," +
                "age SMALLINT  );";

        try (Connection connection1 = Util.connection();
             Statement statement1 = connection1.createStatement()) {
            statement1.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try (Connection connection=Util.connection();
             Statement statement=connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table deleted in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        String sql="INSERT INTO users(name,last_name,age)"+
                "VALUES(?,?,?);";
        try(Connection connection=Util.connection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            System.out.println(name + "  успешно добавлено к базе! ");
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void removeUserById(long id) {
        String sql="DELETE FROM users WHERE id=?";
        try(Connection connection=Util.connection();
            PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setLong(1,id);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public List<User> getAllUsers() {
        String sql="SELECT* FROM users";
        List<User>users=new ArrayList<>();
        try(Connection connection1=Util.connection();
            Statement statement1=connection1.createStatement()){
            ResultSet set=statement1.executeQuery(sql);
           while(set.next()) {
               User user = new User();
               user.setId(set.getLong("id"));
               user.setName(set.getString("name"));
               user.setLastName(set.getString("last_name"));
               user.setAge(set.getByte("age"));
               users.add(user);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;

    }

    public void cleanUsersTable() {
        String sql="TRUNCATE TABLE users";
        try (Connection connection=Util.connection();
             Statement statement=connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}