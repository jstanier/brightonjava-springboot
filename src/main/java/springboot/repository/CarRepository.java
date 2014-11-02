package springboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import springboot.domain.Car;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findByRegistrationNumber(
            @Param(value = "registrationNumber") String registrationNumber);
}
