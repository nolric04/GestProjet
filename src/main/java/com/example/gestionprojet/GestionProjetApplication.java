package com.example.gestionprojet;

import com.example.gestionprojet.bll.calculator.employe.CalculatorEmploye;
import com.example.gestionprojet.bll.calculator.task.CalculatorTask;
import com.example.gestionprojet.bll.manager.client.ClientManagerInterface;
import com.example.gestionprojet.bll.manager.employe.EmployeManagerInterface;
import com.example.gestionprojet.bll.manager.entreprise.EntrepriseManagerInterface;
import com.example.gestionprojet.bll.manager.projet.ProjetManagerInterface;
import com.example.gestionprojet.bll.manager.projet.task.ProjectTaskManagerInterface;
import com.example.gestionprojet.bo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class GestionProjetApplication implements CommandLineRunner {

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
    @Autowired
    CalculatorTask calculatorTask;
    @Autowired
    CalculatorEmploye calculatorEmploye;

    public static void main(String[] args) {
        SpringApplication.run(GestionProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    @Transactional
    public void init(){
        Entreprise entreprise = new Entreprise();
        entreprise.setNomEntreprise("Nolric EnterPrise");
        entreprise.setFraisStructure(150.0);
        entreprise.setRépercusionPrixFormation(15.0);

        Client client = new Client();
        client.setNomClient("Gourmelin");
        client.setEmail("aymeric.tavernier2021@campus-eni.fr");
        client.setTelephone("0767928840");

        Employe employe = new Employe();
        employe.setNom("Tavernier");
        employe.setEmail("aymeric211@hotmail.fr");
        employe.setTelephone("0699224565");
        employe.setSalaire(2300.0);
        employe.setEntreprise(entreprise);


        Employe employe1 = new Employe();
        employe1.setNom("Pinho");
        employe1.setEmail("jonathan.pinho@campus-eni.fr");
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
        task.setNbJourEstime(2.3);
        task.getLiEmployeAffectes().add(employe);
        task.setResponsable(employe);
        task.setApprobateur(employe1);


        entrepriseManager.addOne(entreprise);
        clientManager.addOne(client);
        employeManager.add(employe, employe1);
        projetManager.add(projet);
        projectTaskManager.addOne(task);

        projectTaskManager.getAll().forEach(t -> {
            calculatorTask.calculeCoutTache(t);
            projectTaskManager.update(t);
        });
//        employeManager.getAll().forEach(System.out::println);
//        projectTaskManager.getAll().forEach(System.out::println);
//        System.out.println(calculatorEmploye.calculCoutJournalier(employe));
        System.out.println(calculatorEmploye.calculMoyenneSalaireJournalier(new ArrayList<Employe>(){
            {
                add(employe);
                add(employe1);
            }
        }));
    }
}
