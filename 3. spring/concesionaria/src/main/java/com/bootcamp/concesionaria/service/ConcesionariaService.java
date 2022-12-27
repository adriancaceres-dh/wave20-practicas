package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoConServiceDTO;
import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.model.Vehiculo;
import com.bootcamp.concesionaria.repository.ConcesionariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcesionariaService implements IConcesionariaService{

    @Autowired
    private ConcesionariaRepository concesionariaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public VehiculoConServiceDTO getVehiculo(int id){
        Vehiculo vehiculo = concesionariaRepository.getVehiculos().stream().filter(v -> v.getId() == id).findFirst().get();
        return mapper.map(vehiculo,VehiculoConServiceDTO.class);
    }

    @Override
    public void cargarVehiculo(VehiculoConServiceDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO,Vehiculo.class);
        int id = concesionariaRepository.getVehiculos().size()+1;
        vehiculo.setId(id);
        concesionariaRepository.agregarVehiculo(vehiculo);
    }

    @Override
    public List<VehiculoDTO> getVehiculos() {
        return concesionariaRepository.getVehiculos().stream().map(vehiculo -> mapper.map(vehiculo,VehiculoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDTO> getVehiculosPorFecha(String since , String to) {
        LocalDate fechaDesde = LocalDate.parse(since, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechaHasta = LocalDate.parse(to, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<VehiculoDTO> vehiculosDTO = concesionariaRepository.getVehiculos().stream().map(vehiculo -> mapper.map(vehiculo,VehiculoDTO.class)).collect(Collectors.toList());
        return vehiculosDTO.stream().filter(vehiculoDTO -> vehiculoDTO.getFecha().compareTo(fechaDesde) > 0 && vehiculoDTO.getFecha().compareTo(fechaHasta) < 0).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDTO> getVehiculosPorPrecio(int since, int to) {
        List<VehiculoDTO> vehiculosDTO = concesionariaRepository.getVehiculos().stream().map(vehiculo -> mapper.map(vehiculo,VehiculoDTO.class)).collect(Collectors.toList());
        return vehiculosDTO.stream().filter(vehiculoDTO -> vehiculoDTO.getPrecio() > since && vehiculoDTO.getPrecio() < to).collect(Collectors.toList());
    }
}
