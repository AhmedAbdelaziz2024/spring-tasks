package com.springboot.service;
import com.springboot.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO dto);
    EmployeeDTO update(Long id, EmployeeDTO dto);
    void delete(Long id);
    List<EmployeeDTO> getAll();
    EmployeeDTO getById(Long id);
    List<EmployeeDTO> getByIds(List<Long> ids);
    List<EmployeeDTO> getByNames(List<String> names);

}
