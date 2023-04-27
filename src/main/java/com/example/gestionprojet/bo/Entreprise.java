package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Entreprise {
    @Id
    @GeneratedValue
    private Long idEntreprise;
    @Column
    private String nomEntreprise;
    @OneToMany
    private List<Employe> liEmploye;
    @OneToMany
    private List<Projet> liProjet;
    @Column
    private Double fraisStructure;
}
