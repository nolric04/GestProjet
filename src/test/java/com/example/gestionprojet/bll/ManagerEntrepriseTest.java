package com.example.gestionprojet.bll;

import com.example.gestionprojet.bll.manager.entreprise.EntrepriseManagerInterface;
import com.example.gestionprojet.bo.Entreprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ManagerEntrepriseTest {

    @Autowired
    EntrepriseManagerInterface manager;
    @Test
    void addNewEntrepriseTest() {
        Entreprise e = new Entreprise();
        e.setNomEntreprise("NouveauNom");
        e.setFraisStructure(150.0);
        manager.addOne(e);

        assertEquals(e.toString(), manager.getAll().get(0).toString());
    }
}
