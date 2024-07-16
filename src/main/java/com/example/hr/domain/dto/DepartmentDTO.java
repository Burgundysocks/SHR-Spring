package com.example.hr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
    private String dExplain;
}
