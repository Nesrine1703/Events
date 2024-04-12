package micro.example.organisation.repositories;

import micro.example.organisation.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public abstract class RepositorySalle implements JpaRepository<Salle, Integer> {

}




