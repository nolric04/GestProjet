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
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employe", nullable = false)
    private Long idEmploye;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String telephone;
    @Column
    private Double salaire;
}
