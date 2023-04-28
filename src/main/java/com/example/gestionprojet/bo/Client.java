package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Projet> liProjet = new ArrayList<>();
}
