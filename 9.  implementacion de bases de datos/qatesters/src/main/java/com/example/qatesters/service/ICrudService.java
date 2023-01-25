package com.example.qatesters.service;

import com.example.qatesters.dtos.MessageDto;
import com.example.qatesters.dtos.TestCaseDto;

import java.util.List;

public interface ICrudService<E> {
  MessageDto create(TestCaseDto dto);
  MessageDto update(E entity);
  TestCaseDto findById(Long id);
  MessageDto delete(Long id);
  List<E> findAll();
}
