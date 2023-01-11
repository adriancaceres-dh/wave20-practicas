package com.bootcamp.codigo.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MorseTest {
    @Test
    public void probarMorse(){
        Morse morse = new Morse();
        String salida = morse.convertirAMorse("-- . .-. -.-. .- -.. --- .-.. .. -... .-. .");
        Assertions.assertEquals("mercadolibre",salida);

    }
}
