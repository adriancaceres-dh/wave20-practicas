package com.JPA.demo.service;

import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.repository.IInvoiceRepository;
import com.JPA.demo.repository.IProductRepository;
import com.JPA.demo.service.interfaces.IInvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    IInvoiceRepository invoiceRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public InvoiceDTO saveEntity(InvoiceDTO personDTO) {
        return null;
    }

    @Override
    public InvoiceDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<InvoiceDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
