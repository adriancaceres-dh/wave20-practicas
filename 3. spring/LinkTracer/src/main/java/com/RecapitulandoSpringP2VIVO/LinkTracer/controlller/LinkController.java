package com.RecapitulandoSpringP2VIVO.LinkTracer.controlller;

import com.RecapitulandoSpringP2VIVO.LinkTracer.dto.DtoRequest;
import com.RecapitulandoSpringP2VIVO.LinkTracer.model.Link;
import com.RecapitulandoSpringP2VIVO.LinkTracer.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody DtoRequest dtoRequest)
    {
        return new ResponseEntity<>(linkService.agregar(dtoRequest), HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Integer> metrics(@PathVariable int id)
    {
        return new ResponseEntity<>(linkService.metrics(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<Link> invalidate(@PathVariable int id)
    {
        return new ResponseEntity<Link>(linkService.invalidate(id), HttpStatus.OK);
    }

    @GetMapping("/redirect/{id}")
    public boolean redirect(@PathVariable int id,@RequestParam String password, HttpServletResponse response) throws IOException {
        String redirectResultado = linkService.reedireccionar(id, password);

        if(redirectResultado == null)
        {
            return false;
        }
        else
        {
            response.sendRedirect(redirectResultado);
        }
        return true;
    }

}
