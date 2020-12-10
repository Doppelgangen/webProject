package com.vik.dao;

import com.vik.mapper.BaseUnitMapper;
import com.vik.model.BaseUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:datasource-cfg.properties")
public class UnitDAO {

    private static String URL = "spring.datasource.url";
    private static String USERNAME = "spring.datasource.username";
    private static String PASSWORD = "spring.datasource.password";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*//imitation of primary key for DB
    int id=0;

    //Basic presentation of array-database
    List<BaseUnit> baseUnits = new ArrayList<>();
    {
        baseUnits.add(new BaseUnit(id++, 4,"John","Zuck","jozz@mail.com"));
        baseUnits.add(new BaseUnit(id++, 29,"Jane","Morgen","jm@gmail.com"));
        baseUnits.add(new BaseUnit(id++, 33,"Lily","Doe","lild@yahoo.com"));
    }*/

    public UnitDAO() {
    }

    public List<BaseUnit> index(){
        List<BaseUnit> baseUnitList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM units";
            ResultSet resultSet = statement.executeQuery(SQL);
//            baseUnitList.add(new BaseUnitMapper().mapRow(resultSet,1));

            while(resultSet.next()) {
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

        return baseUnitList;
    }


    //Returns unit with {id}
    public BaseUnit show(int id){
     /*   BaseUnit temp = null;
        for (BaseUnit buffer:baseUnits) {
            if (buffer.getId() == id)
                temp = buffer;
        }
        return temp;*/
        return null;
    }

    //Saving new Unit to array(later database)
    public void save(BaseUnit baseUnit){
     /*   baseUnit.setId(id++);
        baseUnits.add(baseUnit);*/
    }

    //Updating info of Unit with {id}
    //If edit came with wrong {id} do nothing
    public void update(int id, BaseUnit baseUnit){
    /*    BaseUnit temp = null;
        for (BaseUnit buffer:baseUnits) {
            if (buffer.getId() == id)
                temp = buffer;
        }
        if (temp == null)
            return;
        temp.setName(baseUnit.getName());
        temp.setSurname(baseUnit.getSurname());
        temp.setAge(baseUnit.getAge());
        temp.setEmail(baseUnit.getEmail());*/
    }

    public void delete(int id){/*
        for (BaseUnit buffer : baseUnits){
          if (buffer.getId() == id) {
              baseUnits.remove(buffer);
              return;
          }
        }*/
    }
}
