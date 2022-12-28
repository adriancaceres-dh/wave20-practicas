package com.bootcamp.Blog.Models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EntradaBlog {
    private String idBlog;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicación;

    public EntradaBlog(String idBlog, String tituloBlog, String nombreAutor, LocalDate fechaPublicación) {
        this.idBlog = idBlog;
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaPublicación = fechaPublicación;
    }

    public EntradaBlog() {
    }

    public static EntradaBlog crearEntradaBlog(String idBlog, String tituloBlog, String nombreAutor, LocalDate fechaPublicación){
        return new EntradaBlog(idBlog, tituloBlog, nombreAutor, fechaPublicación);
    }
}
