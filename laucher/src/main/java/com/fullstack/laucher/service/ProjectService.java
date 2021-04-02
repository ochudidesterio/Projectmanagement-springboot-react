package com.fullstack.laucher.service;

import com.fullstack.laucher.domain.Project;
import com.fullstack.laucher.exceptions.ProjectIDexception;
import com.fullstack.laucher.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  @Autowired
 private ProjectRepository projectRepository;

 public Project saveOrUpdateProject(Project project){
   try {
     project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
     return projectRepository.save(project);
   } catch (Exception e) {
     //TODO: handle exception
     throw new ProjectIDexception("Project ID "+ project.getProjectIdentifier().toUpperCase()+ " already exists");
   }
   
 }
 
 public Project findProjectByIdentifier(String projectId){
   Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
   if(project==null){
    throw new ProjectIDexception("Project ID "+ projectId+ " doesnt exist");
   }
   return project;
 }

 public Iterable<Project>findAllProjects(){
  return projectRepository.findAll();
 }
 public void deleteProjectByIdentifier(String projectId){
    Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if(project==null){
      throw new ProjectIDexception("Cannot delete project with "+ projectId+ " cause doesnt exist");
     }
     projectRepository.delete(project);
 }

}
