public class Main {
    public static void main(String[] args) {
        ListaCarreraDeLaSelva carrera = new ListaCarreraDeLaSelva();

        Participantes Diego = new Participantes("1010","Diego", "Malagon",23,"320","314","o+");
        Participantes Alejandro = new Participantes("1011","Alejandro", "Ruiz",12,"321","314","o+");
        Participantes Alberto = new Participantes("1012","Alberto", "Castro",18,"322","314","o+");
        Participantes Rodrigo = new Participantes("1013","Rodrigo", "Estupiñan",54,"323","314","o+");
        Participantes Francisco = new Participantes("1014","Francisco", "Malaver",8,"324","314","o+");

        Diego.agregarCategoria(1);
        Alejandro.agregarCategoria(3);
        Alberto.agregarCategoria(2);
        Rodrigo.agregarCategoria(3);
        Francisco.agregarCategoria(1);

        carrera.agregarCompetidor(Diego);
        carrera.agregarCompetidor(Alejandro);
        carrera.agregarCompetidor(Alberto);
        carrera.agregarCompetidor(Rodrigo);
        carrera.agregarCompetidor(Francisco);

        System.out.println("info de la carrera: \n ");
        carrera.infoCarrera();
        System.out.println("Participantes inscritos en la categoria precisada \n");
        carrera.obtenerInscritosPorCategoria(2);
        carrera.retirarParticipante(2);
        System.out.println("info de la carrera : \n");
        carrera.infoCarrera();

    }


}