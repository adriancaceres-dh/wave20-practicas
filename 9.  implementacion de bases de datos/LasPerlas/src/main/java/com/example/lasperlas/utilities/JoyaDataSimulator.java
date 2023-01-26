package com.example.lasperlas.utilities;

import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IJoyeriaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;


@Component
public class JoyaDataSimulator implements ApplicationRunner {
    private final IJoyeriaRepository iJoyeriaRepository;
    private final Faker faker;

    public JoyaDataSimulator(IJoyeriaRepository iJoyeriaRepository) {
      this.iJoyeriaRepository = iJoyeriaRepository;
      this.faker = new Faker();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
      for (int i = 0; i < 10; i++) {
        iJoyeriaRepository.save(getNewJewel());
      }
    }

    private Joya getNewJewel() {
      Joya newJewel = new Joya();
      newJewel.setId(faker.number().numberBetween(1, 100));
      newJewel.setNombre(faker.commerce().productName());
      newJewel.setParticularidad("It was made by: " + faker.company().name());
      newJewel.setMaterial(faker.commerce().material());
      newJewel.setPeso(faker.number().randomDouble(2,10,100));
      newJewel.setTienePiedra(faker.bool().bool());
      newJewel.setVentaONo(faker.bool().bool());
      return newJewel;
    }


}
