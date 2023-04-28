package com.example.gestionprojet.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(
        strategy = InheritanceType.JOINED
)

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)

public class ProjectTask {
    @Id
    @GeneratedValue
    private Long idTache;
    @Column
    private String nom;
    @Column
    private Double margeEntreprise;
    @Column
    private LocalDate dateDebut;
    @Column
    private Double nbJourEstime;
    @Column
    private Double coutTache;
    @ManyToOne
    @JoinColumn(name = "responsable_id_employe")
    private Employe responsable;
    @ManyToOne
    @JoinColumn(name = "approbateur_id_employe")
    private Employe approbateur;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employe> liEmployeAffectes = new ArrayList<>();
    @ManyToOne
    private Projet projet;

    public void setEntreprise(Entreprise entreprise){
        margeEntreprise = Objects.requireNonNullElse(margeEntreprise, entreprise.getMargeEntreprise());
    }
}
