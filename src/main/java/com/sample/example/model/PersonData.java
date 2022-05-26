package com.sample.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonData {
    private Integer id;
    private String name;
    private String address;
    private Integer roleId;
}
