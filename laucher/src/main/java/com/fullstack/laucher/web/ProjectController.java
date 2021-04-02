package com.fullstack.laucher.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fullstack.laucher.domain.Project;
import com.fullstack.laucher.service.MapValidationService;
import com.fullstack.laucher.service.ProjectService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;
  @Autowired

  private MapValidationService mapValidationservice;

  @PostMapping("")
  public ResponseEntity<?>createNewProject(@Valid @RequestBody Project project, BindingResult result){
    ResponseEntity<?>errorMap = mapValidationservice.mapValidationService(result);
    if(errorMap!=null)return errorMap;
    Project proProject = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project,HttpStatus.CREATED);
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<?>getProjectById(@PathVariable String projectId){
    Project project = projectService.findProjectByIdentifier(projectId);
    return new ResponseEntity<Project>(project,HttpStatus.OK);
  }

  @GetMapping("/all")
  public Iterable<Project>getAllProjects(){
    return projectService.findAllProjects();
  }
  @DeleteMapping("/{projectId}")
  public ResponseEntity<?> deleteProject(@PathVariable String projectId){
    projectService.deleteProjectByIdentifier(projectId);
    return new ResponseEntity<String>("Project with "+projectId+ " was deleted",HttpStatus.OK);
  }
}
