package com.JPA.demo.service;

import com.JPA.demo.dto.ClientDTO;
import com.JPA.demo.dto.InvoiceDTO;
import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.entity.Invoice;
import com.JPA.demo.repository.IClientRepository;
import com.JPA.demo.repository.IInvoiceRepository;
import com.JPA.demo.repository.IProductRepository;
import com.JPA.demo.service.interfaces.IInvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    IInvoiceRepository invoiceRepository;

    @Autowired
    IClientRepository clientRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public InvoiceDTO saveEntity(InvoiceDTO invoiceDTO) {

        var invoice = mapper.map(invoiceDTO, Invoice.class);

        var client = clientRepository.findById(invoiceDTO.getClient().getId()).get();

        invoice.setClient(client);

        invoice = invoiceRepository.save(invoice);

        return mapper.map(invoice, InvoiceDTO.class);
    }

    @Override
    public InvoiceDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<InvoiceDTO> getAllEntities() {
        var entities = invoiceRepository.findAll();

        return entities.stream().map(
                e -> mapper.map(e, InvoiceDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
