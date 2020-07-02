package net.nikosath.project_management_tool.web;

import lombok.RequiredArgsConstructor;
import net.nikosath.project_management_tool.domain.Project;
import net.nikosath.project_management_tool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        projectService.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
