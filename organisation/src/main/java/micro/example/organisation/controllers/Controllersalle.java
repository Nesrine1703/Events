package micro.example.organisation.controllers;

import lombok.RequiredArgsConstructor;
import micro.example.organisation.entities.Salle;
import micro.example.organisation.services.IgestionSalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/OrganisationSalle")
public class Controllersalle {
    @Autowired
    private final IgestionSalle igestionSalle;

    @GetMapping("/get-all-Salles")
    List<Salle> getAllSalles() {
        return igestionSalle.retrieveAllSalles();
    }

    @GetMapping("/get-Salle/{idSalle}")
    Salle getSalle(@PathVariable("idSalle") Integer idSalle) {
        return igestionSalle.retrieveSalle(idSalle);
    }

    @PostMapping("/add-Salle")
    Salle addSalle(@RequestBody Salle Salle) {
        return igestionSalle.addSalle(Salle);
    }

    @PutMapping("/update-Salle")
    Salle updateSalle(@RequestBody Salle Salle) {
        return igestionSalle.updateSalle(Salle);
    }

    @DeleteMapping("/delete-Salle/{idSalle}")
    void deleteSalle(@PathVariable("idSalle") Integer idSalle) {
        igestionSalle.removeSalle(idSalle);
    }
}