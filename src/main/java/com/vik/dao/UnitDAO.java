package com.vik.dao;

import com.vik.model.BaseUnit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitDAO {

    //imitation of primary key for DB
    int id=0;

    //Basic presentation of array-database
    List<BaseUnit> baseUnits = new ArrayList<>();
    {
        baseUnits.add(new BaseUnit(4,"John","Zuck","jozz@mail.com"));
        baseUnits.get(id).setId(id++);
        baseUnits.add(new BaseUnit(29,"Jane","Morgen","jm@gmail.com"));
        baseUnits.get(id).setId(id++);
        baseUnits.add(new BaseUnit(33,"Lily","Doe","lild@yahoo.com"));
        baseUnits.get(id).setId(id++);
    }

    public UnitDAO() {
    }

    public List<BaseUnit> index(){
        return baseUnits;
    }


    //Returns unit with {id}
    public BaseUnit show(int id){
        BaseUnit temp = null;
        for (BaseUnit buffer:baseUnits) {
            if (buffer.getId() == id)
                temp = buffer;
        }
        return temp;
    }

    //Saving new Unit to array(later database)
    public void save(BaseUnit baseUnit){
        baseUnit.setId(id++);
        baseUnits.add(baseUnit);
    }

    //Updating info of Unit with {id}
    //If edit came with wrong {id} do nothing
    public void update(int id, BaseUnit baseUnit){
        BaseUnit temp = null;
        for (BaseUnit buffer:baseUnits) {
            if (buffer.getId() == id)
                temp = buffer;
        }
        if (temp == null)
            return;
        temp.setName(baseUnit.getName());
        temp.setSurname(baseUnit.getSurname());
        temp.setAge(baseUnit.getAge());
        temp.setEmail(baseUnit.getEmail());
    }

    public void delete(int id){
        for (BaseUnit buffer : baseUnits){
          if (buffer.getId() == id) {
              baseUnits.remove(buffer);
              return;
          }
        }
    }
}
