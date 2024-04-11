package com.example.ms_commentairesetevaluations;

import java.util.List;

public interface ICommentaireEvaluationService {
    List<Commentaire> retrieveAllCommentaires();
    Commentaire addCommentaire (Commentaire c);
    Commentaire updateCommentaire (Commentaire c);
    Commentaire retrieveCommentaire(Integer idCommentaire);
    void removeCommentaire(Integer idCommentaire);


    List<Evaluation> retrieveAllEvaluations();
    Evaluation addEvaluation (Evaluation e);
    Evaluation updateEvaluation (Evaluation e);
    Evaluation retrieveEvaluation(Integer idEvaluation);
    void removeEvaluation(Integer idEvaluation);
}
