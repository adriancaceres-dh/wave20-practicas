package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.service.LiteratureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureRepository literatureRepository;

    @Autowired
    LiteratureService literatureService;

    public LiteratureController ( LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("findAll")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<Literature>> findByAuthorIs(@PathVariable String author) {
        return new ResponseEntity<>(literatureService.findByAuthorIs(author), OK);
    }

    @GetMapping("findByTitle/{title}")
    public ResponseEntity<List<Literature>> findByTitleContains(@PathVariable String title) {
        return new ResponseEntity<>(literatureService.findByTitleContains(title), OK);
    }

    @GetMapping("findByCantPagesGreaterThan/{cantPages}")
    public ResponseEntity<List<Literature>> findByTitleContains(@PathVariable Integer cantPages) {
        return new ResponseEntity<>(literatureService.findByCantPagesGreaterThan(cantPages), OK);
    }

    /* querys */
}
