package com.sample.example.mapper;

import com.sample.example.model.PersonData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapperXml {
    PersonData findPersonById(Long id);
}
