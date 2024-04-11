package com.example.ms_commentairesetevaluations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/CommentaireEvaluation")
public class CommentaireEvaluationController {
    @Autowired
    ICommentaireEvaluationService iCommentaireEvaluationService;
    @GetMapping("/get-all-commentaires")
    List<Commentaire> getAllCommentaires() {
        return iCommentaireEvaluationService.retrieveAllCommentaires();
    }
    @GetMapping("/get-commentaire/{idCommentaire}")
    Commentaire getCommentaire(@PathVariable("idCommentaire") Integer idCommentaire) {
        return iCommentaireEvaluationService.retrieveCommentaire(idCommentaire);
    }
    @PostMapping("/add-commentaire")
    Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
        return iCommentaireEvaluationService.addCommentaire(commentaire);
    }
    @PutMapping("/update-commentaire")
    Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {
        return iCommentaireEvaluationService.updateCommentaire(commentaire);
    }
    @DeleteMapping("/delete-commentaire/{idCommentaire}")
    void deleteCommentaire(@PathVariable("idCommentaire") Integer idCommentaire) {
        iCommentaireEvaluationService.removeCommentaire(idCommentaire);
    }



    @GetMapping("/get-all-evaluations")
    List<Evaluation> getAllEvaluations() {
        return iCommentaireEvaluationService.retrieveAllEvaluations();
    }
    @GetMapping("/get-evaluation/{idEvaluation}")
    Evaluation getEvaluation(@PathVariable("idEvaluation") Integer idEvaluation) {
        return iCommentaireEvaluationService.retrieveEvaluation(idEvaluation);
    }
    @PostMapping("/add-evaluation")
    Evaluation addEvaluation(@RequestBody Evaluation evaluation) {
        return iCommentaireEvaluationService.addEvaluation(evaluation);
    }
    @PutMapping("/update-evaluation")
    Evaluation updateEvaluation(@RequestBody Evaluation evaluation) {
        return iCommentaireEvaluationService.updateEvaluation(evaluation);
    }
    @DeleteMapping("/delete-evaluation/{idEvaluation}")
    void deleteEvaluation(@PathVariable("idEvaluation") Integer idEvaluation) {
        iCommentaireEvaluationService.removeEvaluation(idEvaluation);
    }
}
