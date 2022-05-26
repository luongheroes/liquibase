package com.sample.example.mapper;

import com.sample.example.model.PersonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {
    @Select("SELECT * FROM person WHERE id = #{id}")
    PersonData findById(long id);
}
