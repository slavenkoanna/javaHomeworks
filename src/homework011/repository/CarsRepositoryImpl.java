package homework011.repository;

import homework011.Auto;
import homework011.CarsRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CarsRepositoryImpl implements CarsRepository<Auto> {

    @Override
    public void modelToFind(String model) {

    }

    public List<Auto> getAll(){
    return List.of();
}

}
