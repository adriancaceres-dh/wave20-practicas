package com.mercadolibre.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.StringContains.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsRestControllerIntegrationsTest {
@Autowired
    MockMvc mockMvc;

@ParameterizedTest
    @MethodSource("loadData")
    void romanTest(String num, String roman) throws Exception{
    performTest(num, roman);
}
    private void performTest(String decimal, String roman) throws Exception {
        this.mockMvc.perform(get("/" + decimal))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(roman)));
    }
    private static Stream<Arguments> loadData() {
        return Stream.of(
                Arguments.of("1", "I"),
                Arguments.of("5", "V"),
                Arguments.of("10", "X"),
                Arguments.of("1000", "M"));
    }
}