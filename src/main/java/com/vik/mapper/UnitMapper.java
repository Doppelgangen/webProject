package com.vik.mapper;

import com.vik.model.Unit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitMapper implements RowMapper<Unit> {
    @Override
    public Unit mapRow(ResultSet resultSet, int i) throws SQLException {
        Unit unit = new Unit();

        unit.setId(resultSet.getInt("id"));
        unit.setAge(resultSet.getInt("age"));
        unit.setName(resultSet.getString("name"));
        unit.setSurname(resultSet.getString("surname"));
        unit.setEmail(resultSet.getString("email"));

        return unit;
    }
}
