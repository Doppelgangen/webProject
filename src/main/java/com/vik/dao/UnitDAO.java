package com.vik.dao;

import com.vik.model.BaseUnit;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UnitDAO {


    public UnitDAO() {
    }


    //Saves all of units into array list
    //Clears list each time when GET index page (for if changes made into database from outside)
    public List<BaseUnit> index(){
        List<BaseUnit> baseUnitList = new ArrayList<>();
        if (baseUnitList.isEmpty()) {
            try {
                Statement statement = DataSource.getConnection().createStatement();
                String SQL = "SELECT * FROM units";
                ResultSet resultSet = statement.executeQuery(SQL);
//            baseUnitList.add(new BaseUnitMapper().mapRow(resultSet,1));

                while (resultSet.next()) {
                    BaseUnit baseUnit = new BaseUnit();

                    baseUnit.setId(resultSet.getInt("id"));
                    baseUnit.setAge(resultSet.getInt("age"));
                    baseUnit.setName(resultSet.getString("name"));
                    baseUnit.setSurname(resultSet.getString("surname"));
                    baseUnit.setEmail(resultSet.getString("email"));

                    baseUnitList.add(baseUnit);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return baseUnitList;
    }


    //Returns unit with {id}
    public BaseUnit show(int id){
        BaseUnit baseUnit = new BaseUnit();

        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(
                    "SELECT * FROM units WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            baseUnit.setId(resultSet.getInt("id"));
            baseUnit.setAge(resultSet.getInt("age"));
            baseUnit.setName(resultSet.getString("name"));
            baseUnit.setSurname(resultSet.getString("surname"));
            baseUnit.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (baseUnit.getId() == 0)
            baseUnit = null;
        return baseUnit;
    }

    //Saving new unit database
    public void save(BaseUnit baseUnit){
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(
                    "INSERT INTO units (age, name, surname, email) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, baseUnit.getAge());
            preparedStatement.setString(2, baseUnit.getName());
            preparedStatement.setString(3, baseUnit.getSurname());
            preparedStatement.setString(4, baseUnit.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Updating info of Unit with {id}
    //If edit came with wrong {id} do nothing
    public void update(int id, BaseUnit baseUnit){
        if (id == 0)
            return;
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(
                    "UPDATE units SET age = ?, name = ?, surname = ?, email = ? WHERE id = ?");
            preparedStatement.setInt(1, baseUnit.getAge());
            preparedStatement.setString(2, baseUnit.getName());
            preparedStatement.setString(3, baseUnit.getSurname());
            preparedStatement.setString(4, baseUnit.getEmail());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Delete unit with {id} from database
    public void delete(int id){
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(
                    "DELETE FROM units WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
