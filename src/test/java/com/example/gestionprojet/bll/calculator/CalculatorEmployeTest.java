package com.example.gestionprojet.bll.calculator;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmployeInterface;
import com.example.gestionprojet.bll.manager.employe.EmployeManager;
import com.example.gestionprojet.bo.Employe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CalculatorEmployeTest {

    @Autowired
    CalculatorEmployeInterface calculatorEmploye;
    @Autowired
    EmployeManager employeManager;

    @Test
    public void calculMoyenneParMoisTest(){
        List<Employe> liEmploye = employeManager.getAll();
        Double coutListEmploye = calculatorEmploye.calculMoyenneParMois(liEmploye);
        assertEquals(2150.0, coutListEmploye);
    }

    @Test
    public void calculCoutJournalierTest(){
        List<Employe> liEmploye = employeManager.getAll();
        Double coutListEmploye = calculatorEmploye.calculCoutJournalier(liEmploye.get(0));
        assertEquals(374.1, coutListEmploye);
    }

    @Test
    public void calculMoyenneTauxJournalierTest() {
        List<Employe> liEmploye = employeManager.getAll();
        Double coutListEmploye = calculatorEmploye.calculMoyenneSalaireJournalier(liEmploye);
        assertEquals(97.73, coutListEmploye);
    }
}
