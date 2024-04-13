package micro.example.organisation.services;

import micro.example.organisation.entities.Salle;
import micro.example.organisation.repositories.RepositorySalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSalle implements IgestionSalle {

    @Autowired
    RepositorySalle repositorySalle;

    @Override
    public List<Salle> retrieveAllSalles() {
        return repositorySalle.findAll();
    }

    @Override
    public Salle addSalle(Salle salle) {
        return repositorySalle.save(salle);
    }

    @Override
    public Salle updateSalle(Salle salle) {
        return repositorySalle.save(salle);
    }

    @Override
    public Salle retrieveSalle(Integer idSalle) {
        return repositorySalle.findById(idSalle).orElse(null);
    }

    @Override
    public void removeSalle(Integer idSalle) {
        repositorySalle.deleteById(idSalle);

    }
}