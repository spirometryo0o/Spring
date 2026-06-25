package org.example.ch03.dto;

import lombok.*;

@Data // = @Getter, @Setter, @RequiredArgsConstructor, @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTO {


    private String userid;
    private String name;
    private String birth;
    private int age;

}
