package com.fullstack.laucher.web;

import com.fullstack.laucher.domain.Project;
import com.fullstack.laucher.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  @PostMapping
  public ResponseEntity<Project>createNewProject(@RequestBody Project project){
    Project proProject = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project,HttpStatus.CREATED);
  }
}
