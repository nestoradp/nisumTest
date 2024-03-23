package com.nisum.test.security.application.mappers;

import com.nisum.test.security.application.dto.PhoneDTO;
import com.nisum.test.security.domain.entities.Phone;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PhoneMapper {


    public Phone convertFromDTO(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setId(phoneDTO.getId());
        phone.setNumber(phoneDTO.getNumber());
        phone.setCityCode(phoneDTO.getCityCode());
        phone.setCountryCode(phoneDTO.getCountryCode());
        return phone;
    }



    public PhoneDTO convertToDTO(Phone phone){
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(phone.getId());
        phoneDTO.setNumber(phone.getNumber());
        phoneDTO.setCityCode(phone.getCityCode());
        phoneDTO.setCountryCode(phone.getCountryCode());
        return phoneDTO;
    }


    public List<Phone> convertFromDTO(List<PhoneDTO> phoneDTOList){
        return phoneDTOList.stream().map(this::convertFromDTO).collect(Collectors.toList());
    }

    public List<PhoneDTO> convertToDTO(List<Phone> phoneList){
        return phoneList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

}
