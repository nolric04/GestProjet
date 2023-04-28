package com.example.gestionprojet.bll.calculator.employe;

import com.example.gestionprojet.bo.Employe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorEmploye {

    /**
     *
     * @param employe
     * @return
     */
    public double calculMoyenneParMois(List<Employe> employe){
        Double moyenne = 0.0;
        for (Employe emp : employe) {
            moyenne += emp.getSalaire();
        }
        return Math.round(moyenne/employe.size()*100.0)/100.0;
    }

    /**
     *
     * @param employe
     * @return
     */
    public double calculMoyenneTauxJournalier(List<Employe> employe){
        Double moyenne = 0.0;
        for (Employe emp : employe) {
            moyenne += emp.getSalaire();
        }
        return Math.round((moyenne/employe.size()/22)*100.0)/100.0;
    }

    /**
     *
     * @param employe
     * @return
     */
    public double calculCoutJournalier(Employe employe){
        Double cout = 0.0;
        Double tauxHoraire= 0.0;
        tauxHoraire += calculMoyenneTauxJournalier(new ArrayList<Employe>(){
                {
                    add(employe);
                }
            });
        System.out.println(tauxHoraire);
            cout +=tauxHoraire *2;
            cout += employe.getEntreprise().getFraisStructure();
            cout += employe.getEntreprise().getRépercusionPrixFormation();
        return cout;
    }

}
