package net.nikosath.project_management_tool.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long id;
    private String name;
    private String identifier;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Builder(toBuilder = true)
    public Project(@NonNull String name,
                   @NonNull String identifier,
                   @NonNull String description,
                   @NonNull LocalDateTime startDateTime,
                   @NonNull LocalDateTime endDateTime) {
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
