package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue
    private Long idEntreprise;
    @Column
    private String nomEntreprise;
    @OneToMany
    @ToString.Exclude
    private List<Employe> liEmploye = new ArrayList<>();
    @OneToMany
    @ToString.Exclude
    private List<Projet> liProjet = new ArrayList<>();
    @Column
    private Double fraisStructure;
    @Column
    private Double margeEntreprise;
    @Column
    private Double répercusionPrixFormation;
}
