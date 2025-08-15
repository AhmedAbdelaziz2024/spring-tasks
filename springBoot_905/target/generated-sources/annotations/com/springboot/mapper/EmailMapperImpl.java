package com.springboot.mapper;

import com.springboot.dto.EmailDTO;
import com.springboot.model.Email;
import com.springboot.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-15T18:10:34+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmailMapperImpl implements EmailMapper {

    @Override
    public Email toEntity(EmailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Email email = new Email();

        email.setEmployee( emailDTOToEmployee( dto ) );
        email.setId( dto.getId() );
        email.setName( dto.getName() );
        email.setContent( dto.getContent() );

        return email;
    }

    @Override
    public EmailDTO toDto(Email email) {
        if ( email == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setEmployeeId( emailEmployeeId( email ) );
        emailDTO.setId( email.getId() );
        emailDTO.setName( email.getName() );
        emailDTO.setContent( email.getContent() );

        return emailDTO;
    }

    @Override
    public List<EmailDTO> toDtoList(List<Email> emails) {
        if ( emails == null ) {
            return null;
        }

        List<EmailDTO> list = new ArrayList<EmailDTO>( emails.size() );
        for ( Email email : emails ) {
            list.add( toDto( email ) );
        }

        return list;
    }

    @Override
    public List<Email> toEntityList(List<EmailDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Email> list = new ArrayList<Email>( dtos.size() );
        for ( EmailDTO emailDTO : dtos ) {
            list.add( toEntity( emailDTO ) );
        }

        return list;
    }

    protected Employee emailDTOToEmployee(EmailDTO emailDTO) {
        if ( emailDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        if ( emailDTO.getEmployeeId() != null ) {
            employee.setId( emailDTO.getEmployeeId() );
        }

        return employee;
    }

    private Long emailEmployeeId(Email email) {
        if ( email == null ) {
            return null;
        }
        Employee employee = email.getEmployee();
        if ( employee == null ) {
            return null;
        }
        long id = employee.getId();
        return id;
    }
}
