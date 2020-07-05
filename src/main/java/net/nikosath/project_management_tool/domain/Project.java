package net.nikosath.project_management_tool.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 4, max = 5)
    @Column(updatable = false, unique = true)
    private String identifier;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate updateDate;

    @Builder
    public Project(String name,
                   String identifier,
                   String description,
                   LocalDate startDate,
                   LocalDate endDate) {
        this.name = name;
        this.identifier = identifier;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
