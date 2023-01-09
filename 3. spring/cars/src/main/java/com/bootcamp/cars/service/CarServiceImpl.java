package com.bootcamp.cars.service;

import com.bootcamp.cars.dto.Request.CarRequestDto;
import com.bootcamp.cars.dto.Response.CarListNoServiceResponseDto;
import com.bootcamp.cars.dto.Response.CarResponseDto;
import com.bootcamp.cars.exeptions.IdAlreadyExistException;
import com.bootcamp.cars.model.Car;
import com.bootcamp.cars.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService {

    private final ModelMapper mapper = new ModelMapper();

    //constructor
    public CarServiceImpl() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
        //.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    //repository dependency injection
    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarListNoServiceResponseDto> getCars() {
        return carRepository.getCars().stream().map(car -> mapper.map(car, CarListNoServiceResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String addCar(CarRequestDto carRequestDto) {
        //if (carRepository.addCarsToList(new Car(carRequestDto.getId(), carRequestDto.getBrand(),
        //carRequestDto.getModel()))) {}
        if (!findById(carRequestDto) && carRepository.addCarsToList(mapper.map(carRequestDto, Car.class))) {
            return "Alta Ok!";
        } else {
            //return "Error!";
            //With Exeptions
            throw new IdAlreadyExistException("Vehicle cannot be added!");
        }
    }

    //Return an element of list
    @Override
    public CarResponseDto findCarId(String id) {
        if (findByIdResponse(id)) {
            Car car = carRepository.findIdCar(id);
            return mapper.map(car, CarResponseDto.class);
        } else {
            throw new IdAlreadyExistException("The vehicle does not exist");
        }
    }

    //Return a list of cars by manufacturing date
    @Override
    public List<CarListNoServiceResponseDto> getCarsByManufacturingDate(LocalDate manufacturingDateSince, LocalDate manufacturingDateTo) {
        List<Car> cars = carRepository.getCars().stream().filter(car -> car.getManufacturingDate().isAfter(manufacturingDateSince)
                && car.getManufacturingDate().isBefore(manufacturingDateTo) || car.getManufacturingDate().isEqual(manufacturingDateSince)
                || car.getManufacturingDate().isEqual(manufacturingDateTo)).collect(Collectors.toList());
        return cars.stream().map(car -> mapper.map(car, CarListNoServiceResponseDto.class)).collect(Collectors.toList());
    }

    //Return a list cars by price
    @Override
    public List<CarListNoServiceResponseDto> getCarsByPrice(double priceSince, double priceTo) {
        List<Car> cars = carRepository.getCars().stream().filter(car -> car.getPrice() >= priceSince && car.getPrice() <=
                priceTo).collect(Collectors.toList());
        return cars.stream().map(car -> mapper.map(car, CarListNoServiceResponseDto.class)).collect(Collectors.toList());
    }

    public boolean findById(CarRequestDto carRequestDto) {
        return carRepository.getCars().stream().anyMatch(car -> car.getId().equals(carRequestDto.getId()));
    }

    //Find by id ResponseDto
    public boolean findByIdResponse(String id) {
        return carRepository.getCars().stream().anyMatch(car -> car.getId().equals(id));
    }
}
