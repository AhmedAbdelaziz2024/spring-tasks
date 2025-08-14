package com.springboot.mapper;

import com.springboot.dto.EmployeeDTO;
import com.springboot.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-15T00:59:58+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private EmailMapper emailMapper;

    @Override
    public EmployeeDTO toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setAge( employee.getAge() );
        employeeDTO.setSalary( employee.getSalary() );
        employeeDTO.setEmails( emailMapper.toDtoList( employee.getEmails() ) );

        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        if ( dto.getId() != null ) {
            employee.setId( dto.getId() );
        }
        employee.setName( dto.getName() );
        if ( dto.getAge() != null ) {
            employee.setAge( dto.getAge() );
        }
        if ( dto.getSalary() != null ) {
            employee.setSalary( dto.getSalary() );
        }
        employee.setEmails( emailMapper.toEntityList( dto.getEmails() ) );

        return employee;
    }

    @Override
    public List<EmployeeDTO> toDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtos.size() );
        for ( EmployeeDTO employeeDTO : dtos ) {
            list.add( toEntity( employeeDTO ) );
        }

        return list;
    }
}
