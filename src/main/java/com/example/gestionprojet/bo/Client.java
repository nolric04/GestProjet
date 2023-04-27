package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Long idClient;
    @Column(nullable = false)
    private String nomClient;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String telephone;
    @ManyToMany
    @JoinTable(name = "Client_Projet",
            joinColumns = @JoinColumn( name = "idClient" ),
            inverseJoinColumns = @JoinColumn( name = "idProjet" ) )
    private List<Projet> liProjet;
}
