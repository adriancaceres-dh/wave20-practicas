package com.example.lasperlas.init;

import com.example.lasperlas.entity.Jewel;
import com.example.lasperlas.repository.JewelRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JewelDataAdder implements ApplicationRunner {
    private final JewelRepository jewelRepository;
    private final Faker faker;

    public JewelDataAdder(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            jewelRepository.save(getNewJewel());
        }

    }

    private Jewel getNewJewel() {
        Jewel newJewel = new Jewel();
        newJewel.setName(faker.commerce().productName());
        newJewel.setParticularity("It was made by: " + faker.company().name());
        newJewel.setMaterial(faker.commerce().material());
        newJewel.setWeight(faker.number().randomDouble(2,10,100));
        newJewel.setHasStones(faker.bool().bool());
        newJewel.setCanBeSold(faker.bool().bool());
        return newJewel;
    }

}
