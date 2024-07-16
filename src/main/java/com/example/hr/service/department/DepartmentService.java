package com.example.hr.service.department;

import com.example.hr.domain.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

    // 부서 추가 (필요 시에만 사용)
    boolean addDepartment(DepartmentDTO department);

    // 모든 부서 목록 조회
    List<DepartmentDTO> getAllDepartments();

    // 부서 정보 수정 (필요 시에만 사용)
    boolean updateDepartment(DepartmentDTO department);

    // 부서 삭제 (필요 시에만 사용)
    boolean deleteDepartmentById(Long departmentId);
}
