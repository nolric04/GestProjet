package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private List<Employe> liEmploye;
    @OneToMany
    @ToString.Exclude
    private List<Projet> liProjet;
    @Column
    private Double fraisStructure;
}
