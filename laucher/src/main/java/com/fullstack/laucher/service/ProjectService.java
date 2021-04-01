package com.fullstack.laucher.service;

import com.fullstack.laucher.domain.Project;
import com.fullstack.laucher.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired
 private ProjectRepository projectRepository;

 public Project saveOrUpdateProject(Project project){
   return projectRepository.save(project);
 }
}
