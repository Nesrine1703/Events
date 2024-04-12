package micro.example.organisation.services;

import micro.example.organisation.entities.Salle;

import java.util.List;

public interface IgestionSalle {
    List<Salle> retrieveAllSalles();

    Salle addSalle(Salle salle);

    Salle updateSalle(Salle salle);

    Salle retrieveSalle(Integer idSalle);

    void removeSalle(Integer idSalle);

}
