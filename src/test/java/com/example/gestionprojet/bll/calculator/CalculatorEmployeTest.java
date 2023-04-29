package com.example.gestionprojet.bll.calculator;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bll.manager.employe.EmployeManager;
import com.example.gestionprojet.bo.Employe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CalculatorEmployeTest {

    @Autowired
    CalculatorEmploye calculatorEmploye;
    @Autowired
    EmployeManager employeManager;

    @Test
    public void calculMoyenneParMoisTest(){
        List<Employe> liEmploye = employeManager.getAll();
        Double coutListEmploye = calculatorEmploye.calculMoyenneParMois(liEmploye);
        assertEquals(2150.0, coutListEmploye);
    }
}
