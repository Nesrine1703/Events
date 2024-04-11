package com.example.ms_commentairesetevaluations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaireEvaluationService implements ICommentaireEvaluationService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public List<Commentaire> retrieveAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire addCommentaire(Commentaire c) {
        return commentaireRepository.save(c);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire c) {
        return commentaireRepository.save(c);
    }

    @Override
    public Commentaire retrieveCommentaire(Integer idCommentaire) {
        return commentaireRepository.findById(idCommentaire).orElse(null);
    }

    @Override
    public void removeCommentaire(Integer idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);

    }



    @Override
    public List<Evaluation> retrieveAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation addEvaluation(Evaluation e) {
        return evaluationRepository.save(e);
    }

    @Override
    public Evaluation updateEvaluation(Evaluation e) {return evaluationRepository.save(e);}

    @Override
    public Evaluation retrieveEvaluation(Integer idEvaluation) {
        return evaluationRepository.findById(idEvaluation).orElse(null);
    }

    @Override
    public void removeEvaluation(Integer idEvaluation) {
        evaluationRepository.deleteById(idEvaluation);

    }
}
