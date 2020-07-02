package net.nikosath.project_management_tool.service;

import lombok.RequiredArgsConstructor;
import net.nikosath.project_management_tool.domain.Project;
import net.nikosath.project_management_tool.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<Project> findAll(Sort sort) {
        return projectRepository.findAll(sort);
    }

    public Optional<Project> findByIdentifier(String identifier) {
        return projectRepository.findByIdentifier(identifier);
    }

    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public <S extends Project> S save(S entity) {
        return projectRepository.save(entity);
    }

    public <S extends Project> Iterable<S> saveAll(Iterable<S> entities) {
        return projectRepository.saveAll(entities);
    }

    public Optional<Project> findById(Long aLong) {
        return projectRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return projectRepository.existsById(aLong);
    }

    public Iterable<Project> findAllById(Iterable<Long> longs) {
        return projectRepository.findAllById(longs);
    }

    public long count() {
        return projectRepository.count();
    }

    public void deleteById(Long aLong) {
        projectRepository.deleteById(aLong);
    }

    public void delete(Project entity) {
        projectRepository.delete(entity);
    }

    public void deleteAll(Iterable<? extends Project> entities) {
        projectRepository.deleteAll(entities);
    }

    public void deleteAll() {
        projectRepository.deleteAll();
    }
}
