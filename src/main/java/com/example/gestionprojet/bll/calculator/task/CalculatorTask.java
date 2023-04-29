package com.example.gestionprojet.bll.calculator.task;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bo.ProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorTask {

    @Autowired
    CalculatorEmploye calculatorEmploye;

    public void calculeCoutTache(ProjectTask projectTask){
        Double coutMoyen = calculatorEmploye.calculMoyenneTauxJournalier(projectTask.getLiEmployeAffectes());
        Double coutEstime = coutMoyen*projectTask.getNbJourEstime();
        projectTask.setCoutTache(coutEstime);
    }
}
