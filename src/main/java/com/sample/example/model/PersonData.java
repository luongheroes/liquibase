package com.sample.example.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PersonData implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private Integer roleId;
}
