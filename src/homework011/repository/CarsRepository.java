package homework011;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public interface CarsRepository<Auto> {

    void modelToFind(String model);

    List<homework011.Auto> getAll();

    String toString();
}



