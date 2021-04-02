package com.fullstack.laucher.repository;

import com.fullstack.laucher.domain.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long>{

   Project findByProjectIdentifier(String projectIdentifier);

   @Override
    Iterable<Project> findAll();
  
}
