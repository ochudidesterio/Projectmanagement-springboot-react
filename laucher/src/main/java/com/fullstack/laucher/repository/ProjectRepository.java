package com.fullstack.laucher.repository;

import com.fullstack.laucher.domain.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long>{
  @Override
  Iterable<Project> findAllById(Iterable<Long>iterable);
   
    
  
}
