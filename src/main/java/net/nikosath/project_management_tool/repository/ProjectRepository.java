package net.nikosath.project_management_tool.repository;

import net.nikosath.project_management_tool.domain.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Override
    List<Project> findAll(Sort sort);

    Optional<Project> findByIdentifier(String identifier);

}
