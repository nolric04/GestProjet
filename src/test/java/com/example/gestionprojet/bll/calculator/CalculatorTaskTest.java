package com.example.gestionprojet.bll.calculator;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bll.calculator.employe.CalculatorEmployeInterface;
import com.example.gestionprojet.bll.calculator.task.CalculatorTask;
import com.example.gestionprojet.bll.manager.client.ClientManagerInterface;
import com.example.gestionprojet.bll.manager.employe.EmployeManagerInterface;
import com.example.gestionprojet.bll.manager.entreprise.EntrepriseManagerInterface;
import com.example.gestionprojet.bll.manager.projet.ProjetManagerInterface;
import com.example.gestionprojet.bll.manager.projet.task.ProjectTaskManagerInterface;
import com.example.gestionprojet.bo.Employe;
import com.example.gestionprojet.bo.Entreprise;
import com.example.gestionprojet.bo.ProjectTask;
import com.example.gestionprojet.bo.Projet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
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

    //region Manager
    @Autowired
    EntrepriseManagerInterface entrepriseManager;
    @Autowired
    ProjetManagerInterface projetManager;
    @Autowired
    ClientManagerInterface clientManager;
    @Autowired
    EmployeManagerInterface employeManager;
    @Autowired
    ProjectTaskManagerInterface projectTaskManager;
    //endregion
    @BeforeAll
    public void setUp(){

        //region initialisation des Objets
        Entreprise entreprise = new Entreprise();
        entreprise.setNomEntreprise("Nolric EnterPrise");
        entreprise.setFraisStructure(150.0);
        entreprise.setRépercusionPrixFormation(15.0);

        Employe employe = new Employe();
        employe.setNom("Tavernier");
        employe.setEmail("aymeric@hotmail.fr");
        employe.setTelephone("0699224565");
        employe.setSalaire(2300.0);
        employe.setEntreprise(entreprise);


        Employe employe1 = new Employe();
        employe1.setNom("Pinho");
        employe1.setEmail("jonathan@campus-eni.fr");
        employe1.setTelephone("0123456789");
        employe1.setSalaire(2000.0);
        employe1.setEntreprise(entreprise);


        Projet projet = new Projet();
        projet.setNom("ENI EscapeGame");
        projet.setDateDebut(LocalDate.now());
        projet.setDateFin(LocalDate.of(2024,8, 25));
        projet.setMargeEntreprise(1.5);
        projet.getLiClient();
        projet.getLiTaches();

        ProjectTask task = new ProjectTask();
        task.setNom("Création de la liste des matériaux");
        task.setProjet(projet);
        task.setDateDebut(LocalDate.now());
        task.setNbJourEstime(2.0);
        task.getLiEmployeAffectes().add(employe);
        task.getLiEmployeAffectes().add(employe1);
        task.setResponsable(employe);
        task.setApprobateur(employe1);
        //endregion

        //region Ajout en Base
        entrepriseManager.add(entreprise);
        employeManager.add(employe, employe1);
        projetManager.add(projet);
        projectTaskManager.add(task);
        //endregion

        //region Mock
        Mockito.when(calculatorEmploye.calculMoyenneTauxJournalier(ArgumentMatchers.any(List.class))).thenReturn(10.0);
        //endregion
    }
    @Test
    public void calculCoutTacheTest(){
        List<ProjectTask> listTaches = projectTaskManager.getAll();
        calculatorTask.calculeCoutTache(listTaches.get(0));
        assertEquals(23.0, listTaches.get(0).getCoutTache());
    }
}

