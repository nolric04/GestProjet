package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Projet {
    @Id
    @GeneratedValue
    private Long idProjet;
    @Column
    private String nom;
    @Column
    private Double margeEntreprise;
    @Column
    private LocalDate dateDebut;
    @Column
    private LocalDate dateFin;
    @ManyToMany
    @JoinTable(name = "Client_Projet",
            joinColumns = @JoinColumn( name = "idProjet" ),
            inverseJoinColumns = @JoinColumn( name = "idClient" ) )
    List<Employe> liEmployeAffectes;
    @ManyToMany
    List<Client> liClient;

    
}
