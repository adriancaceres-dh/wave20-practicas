package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServicePublicationTest {

    @Mock
    IPublicationRepository mockPublicationRepository;

    @InjectMocks
    ServicePublication mockServicePublication;

    @Test
    void addPublication() {
    }

    @Test
    void getPublicationsOrderAscOKTest() {
    }

    @Test
    void getPublicationsOrderDescOKTest() {
    }

    @Test
    void getPublicationsOrderOKTest() {
    }
    
    @Test
    void getPublicationsInvalidOrderTest() {
    }

    @Test
    void getLastTwoWeeksPublicationsOKTest() {
    }
}