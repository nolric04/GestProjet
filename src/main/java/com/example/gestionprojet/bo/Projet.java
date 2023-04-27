package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@ToString(exclude = "liClient")
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
    List<Employe> liEmployeAffectes;
    @ManyToMany
    @JoinTable(name = "Client_Projet",
            joinColumns = @JoinColumn( name = "idProjet" ),
            inverseJoinColumns = @JoinColumn( name = "idClient" ) )
    List<Client> liClient;

    
}
