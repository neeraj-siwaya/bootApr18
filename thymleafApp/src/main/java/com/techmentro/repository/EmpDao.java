package com.techmentro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techmentro.entity.Emp;

@Repository
public interface EmpDao extends CrudRepository<Emp, Integer>
{

}
