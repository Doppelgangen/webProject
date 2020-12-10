package com.vik.mapper;

import com.vik.model.BaseUnit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseUnitMapper implements RowMapper<BaseUnit> {
    @Override
    public BaseUnit mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int age = resultSet.getInt("age");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");

        return new BaseUnit(id, age, name, surname, email);
    }
}
