package com.bootcamp.joyeria.dto.response;

import com.bootcamp.joyeria.dto.common.JoyaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatedJoyaDTO {
    private Integer status;
    private JoyaDTO joyaDTO;
}
