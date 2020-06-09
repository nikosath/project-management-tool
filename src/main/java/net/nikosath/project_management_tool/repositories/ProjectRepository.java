package net.nikosath.project_management_tool.repositories;

import net.nikosath.project_management_tool.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
