package com.example.gestionprojet.bll.calculator.task;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bo.ProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorTaskInterface {
    void calculeCoutTache(ProjectTask projectTask);
}
