package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // link to primary employee id
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "degree")
    private String degree; // e.g. B.Tech, M.Tech

    @Column(name = "college")
    private String college;

    @Column(name = "year_of_passing")
    private Integer yearOfPassing;

    @Column(name = "grade")
    private String grade; // e.g. CPI/Percentage

}