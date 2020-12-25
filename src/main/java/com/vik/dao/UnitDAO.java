package com.vik.dao;

import com.vik.mapper.UnitMapper;
import com.vik.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnitDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UnitDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //Saves all of units into array list
    //Clears list each time when GET index page (for if changes made into database from outside)
    public List<Unit> index(){
        return jdbcTemplate.query("SELECT * FROM units", new UnitMapper());
    }


    //Returns unit with {id}
    public Unit show(int id){
        return jdbcTemplate.query("SELECT * FROM units WHERE id = ?", new Object[]{id}, new UnitMapper())
                .stream().findAny().orElse(null);
    }

    //Saving new unit database
    public void save(Unit unit){
        jdbcTemplate.update("INSERT INTO units (age, name, surname, email) VALUES (?, ?, ?, ?)",
                unit.getAge(), unit.getName(), unit.getSurname(), unit.getEmail());
    }

    //Updating info of Unit with {id}
    //If edit came with wrong {id} do nothing
    public void update(int id, Unit unit){
        jdbcTemplate.update("UPDATE units SET age = ?, name = ?, surname = ?, email = ? WHERE id = ?",
                unit.getAge(), unit.getName(), unit.getSurname(), unit.getEmail(), id);
    }

    //Delete unit with {id} from database
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM units WHERE id = ?", id);
    }
}
