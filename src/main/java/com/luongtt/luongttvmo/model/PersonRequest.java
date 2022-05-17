package com.luongtt.luongttvmo.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {
    @NonNull
    private String name;
    private String address;
    private int role;
}
