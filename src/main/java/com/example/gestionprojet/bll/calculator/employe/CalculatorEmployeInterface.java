package com.example.gestionprojet.bll.calculator.employe;

import com.example.gestionprojet.bo.Employe;

import java.util.List;

public interface CalculatorEmployeInterface {
    Double calculMoyenneParMois(List<Employe> employe);
    Double calculCoutJournalier(Employe employe);
    Double calculMoyenneTauxJournalier(List<Employe> employe);
    Double calculMoyenneTauxJournalier(Employe... employe);
}
