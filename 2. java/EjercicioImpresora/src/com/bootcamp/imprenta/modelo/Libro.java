package com.bootcamp.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements IImprimible {

    private List<IImprimible> paginas;
    private Persona autor;
    private String titulo;
    private String genero;

    public Libro(Persona autor, String titulo, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        paginas = new ArrayList<>();
    }

    public Libro addPagina(IImprimible pagina){
        paginas.add(pagina);
        return this;
    }

    @Override
    public String imprimir(){
        StringBuilder sb = new StringBuilder("Titulo: ");
        sb.append(this.titulo).append("\n")
                .append("Autor: ").append(autor).append("\n")
                .append("Genero: ").append(genero).append("\n")
                .append("Números de páginas: ").append(paginas.size()).append("\n");
        for(IImprimible pag: this.paginas){
            sb.append(pag.imprimir()).append("\n");
        }
        return  sb.toString();
    }
}
