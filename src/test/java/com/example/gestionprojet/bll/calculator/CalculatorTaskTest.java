package com.example.gestionprojet.bll.calculator;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bll.calculator.task.CalculatorTask;
import com.example.gestionprojet.bll.manager.projet.task.ProjectTaskManagerInterface;
import com.example.gestionprojet.bo.ProjectTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTaskTest {

    //region Declaration Mock
    @InjectMocks
    private CalculatorTask calculatorTask;
    @Mock
    private CalculatorEmploye calculatorEmploye;
    //endregion

    @Autowired
    ProjectTaskManagerInterface projectTaskManager;

    @Test
    public void calculCoutTacheTest(){
        //region Mock
        Mockito.when(calculatorEmploye.calculMoyenneSalaireJournalier(ArgumentMatchers.anyList())).thenReturn(10.0);
        //endregion
        List<ProjectTask> listTaches = projectTaskManager.getAll();
        calculatorTask.calculeCoutTache(listTaches.get(0));
        assertEquals(23.0, listTaches.get(0).getCoutTache());
    }
}

