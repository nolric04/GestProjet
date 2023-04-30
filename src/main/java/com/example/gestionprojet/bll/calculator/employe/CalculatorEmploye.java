package com.example.gestionprojet.bll.calculator.employe;

import com.example.gestionprojet.bo.Employe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorEmploye implements CalculatorEmployeInterface{

    /**
     *  Calcule la moyenne par mois du salaire de l'employé
     * @param employe
     * @return
     */
    @Override
    public Double calculMoyenneParMois(List<Employe> employe){
        Double moyenne = 0.0;
        for (Employe emp : employe) {
            moyenne += emp.getSalaire();
        }
        return Math.round(moyenne/employe.size()*100.0)/100.0;
    }

    /**
     *  Calcule le salaire par Jours de l'employé
     * @param employe unlimited Employe Param
     * @return
     */
    @Override
    public Double calculMoyenneSalaireJournalier(Employe... employe){
        Double moyenne = 0.0;
        for (Employe emp : employe) {
            moyenne += emp.getSalaire();
        }
        return Math.round((moyenne/employe.length/22)*100.0)/100.0;
    }
    /**
     *   Calcule le salaire par Jours de l'employé
     * @param employe
     * @return
     */
    @Override
    public Double calculMoyenneSalaireJournalier(List<Employe> employe){
        return calculMoyenneSalaireJournalier(employe.toArray(new Employe[employe.size()]));
    }

    /**
     *Calcule le prix Journalier d'un employé.
     * Prend en compte :
     *      - le Salaire
     *      - les charges
     *      - les Frais de Structure
     *      - les frais de répercusion de Formations
     * @param employe
     * @return
     */
    @Override
    public Double calculCoutJournalier(Employe employe){
        Double cout = 0.0;
        Double tauxHoraire= 0.0;
        tauxHoraire += calculMoyenneSalaireJournalier(new ArrayList<Employe>(){
                {
                    add(employe);
                }
            });
            cout +=tauxHoraire *2;
            cout += employe.getEntreprise().getFraisStructure();
            cout += employe.getEntreprise().getRépercusionPrixFormation();
        return cout;
    }



}
