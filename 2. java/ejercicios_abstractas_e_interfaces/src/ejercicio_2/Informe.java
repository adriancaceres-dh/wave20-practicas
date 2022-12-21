package ejercicio_2;

public class Informe implements Imprimible{
    private String texto;
    private int cantidad_paginas;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidad_paginas() {
        return cantidad_paginas;
    }

    public void setCantidad_paginas(int cantidad_paginas) {
        this.cantidad_paginas = cantidad_paginas;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidad_paginas=" + cantidad_paginas +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
