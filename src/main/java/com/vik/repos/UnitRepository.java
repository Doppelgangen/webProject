package com.vik.repos;

import com.vik.model.BaseUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitRepository extends CrudRepository<BaseUnit, Integer> {
    List<BaseUnit> findByName(String name);
}
