package net.nikosath.project_management_tool;

import net.nikosath.project_management_tool.domain.Project;
import net.nikosath.project_management_tool.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class ProjectManagementToolAppTests {

    @Autowired
    private ProjectRepository projectRepository;
    private static Project.ProjectBuilder projectBuilder = buildProjectTemplate();

    @Test
    void givenTwoPersistedProjects_whenRetrieveThemSortedByIdentifier_thenExpectCorrectOrder() {
        // given
        String identifier1 = "PROJ1";
        String identifier2 = "PROJ2";
        projectRepository.saveAll(
                List.of(
                        projectBuilder.identifier(identifier1).build(),
                        projectBuilder.identifier(identifier2).build()
                )
        );

        // when
        Sort sortByIdentifierDesc = Sort.sort(Project.class).by(Project::getIdentifier).descending();
        List<Project> projects = projectRepository.findAll(sortByIdentifierDesc);

        // then
        assertEquals(identifier2, projects.get(0).getIdentifier());
        assertEquals(identifier1, projects.get(1).getIdentifier());
    }

    private static Project.ProjectBuilder buildProjectTemplate() {
        return Project.builder()
                .name("A project")
                .description("A description")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusWeeks(2));
    }

}
