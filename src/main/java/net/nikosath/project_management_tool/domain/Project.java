package net.nikosath.project_management_tool.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

// TODO nathanasakis 2020-06-11: Use Flyway/Liquibase to specify the ordering of table columns
@Entity
@Getter
@ToString
@NoArgsConstructor
public class Project {

    @Id
    // TODO nathanasakis 2020-06-11: Optimize for batch queries
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String identifier;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Builder
    public Project(String name,
                   String identifier,
                   String description,
                   LocalDateTime startDateTime,
                   LocalDateTime endDateTime) {
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
