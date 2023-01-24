package com.bootcamp.QA_Testers.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseResponseDTO {

    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;

    LocalDate last_update;
}
