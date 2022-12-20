package com.bootcamp;

public class LibroPDF implements IDescripcion{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    @Override
    public void mostrar() {
        System.out.println("titulo es: "+ titulo+" del autor: "+nombreAutor+" contiene: "+cantidadPaginas+" paginas");
    }
}
