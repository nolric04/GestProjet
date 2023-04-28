package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(fetch = FetchType.EAGER)
    List<ProjectTask> liTaches = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Client_Projet",
            joinColumns = @JoinColumn( name = "idProjet" ),
            inverseJoinColumns = @JoinColumn( name = "idClient" ) )
    List<Client> liClient = new ArrayList<>();

    
}
