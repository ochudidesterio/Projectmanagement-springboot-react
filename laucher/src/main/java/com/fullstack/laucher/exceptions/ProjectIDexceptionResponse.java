package com.fullstack.laucher.exceptions;

public class ProjectIDexceptionResponse {
  private String projectIdentifier;

  public ProjectIDexceptionResponse(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }
  
  
}
