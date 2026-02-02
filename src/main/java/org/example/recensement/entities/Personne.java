/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.recensement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 *
 * @author clarisse
 */
@Entity
@Table(catalog = "recensement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findById", query = "SELECT p FROM Personne p WHERE p.id = :id"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByDateNais", query = "SELECT p FROM Personne p WHERE p.dateNais = :dateNais"),
    @NamedQuery(name = "Personne.findBySexe", query = "SELECT p FROM Personne p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personne.findByProvince", query = "SELECT p FROM Personne p WHERE p.province = :province"),
    @NamedQuery(name = "Personne.findByTerritoire", query = "SELECT p FROM Personne p WHERE p.territoire = :territoire"),
    @NamedQuery(name = "Personne.findByVillage", query = "SELECT p FROM Personne p WHERE p.village = :village"),
    @NamedQuery(name = "Personne.findByPere", query = "SELECT p FROM Personne p WHERE p.pere = :pere"),
    @NamedQuery(name = "Personne.findByMere", query = "SELECT p FROM Personne p WHERE p.mere = :mere"),
    @NamedQuery(name = "Personne.findByProfession", query = "SELECT p FROM Personne p WHERE p.profession = :profession"),
    @NamedQuery(name = "Personne.findByEtatCivil", query = "SELECT p FROM Personne p WHERE p.etatCivil = :etatCivil"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personne.findByNbreEnfant", query = "SELECT p FROM Personne p WHERE p.nbreEnfant = :nbreEnfant")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nom;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String prenom;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private LocalDate dateNais;
    @Basic(optional = false)
    @Column(nullable = false, length = 8)
    private String sexe;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String province;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String territoire;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String village;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String pere;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String mere;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String profession;
    @Basic(optional = false)
    @Column(name = "etat civil", nullable = false, length = 11)
    private String etatCivil;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String adresse;
    @Basic(optional = false)
    @Column(nullable = false)
    private int nbreEnfant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Recensement> recensementCollection;
    @JoinColumn(name = "idRecensement", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Recensement idRecensement;

    public Personne() {
    }

    public Personne(Integer id) {
        this.id = id;
    }

    public Personne(Integer id, String nom, String prenom, LocalDate dateNais, String sexe, String province, String territoire, String village, String pere, String mere, String profession, String etatCivil, String adresse, int nbreEnfant) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.sexe = sexe;
        this.province = province;
        this.territoire = territoire;
        this.village = village;
        this.pere = pere;
        this.mere = mere;
        this.profession = profession;
        this.etatCivil = etatCivil;
        this.adresse = adresse;
        this.nbreEnfant = nbreEnfant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNais() {
        return dateNais;
    }

    public void setDateNais(LocalDate dateNais) {
        this.dateNais = dateNais;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTerritoire() {
        return territoire;
    }

    public void setTerritoire(String territoire) {
        this.territoire = territoire;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPere() {
        return pere;
    }

    public void setPere(String pere) {
        this.pere = pere;
    }

    public String getMere() {
        return mere;
    }

    public void setMere(String mere) {
        this.mere = mere;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbreEnfant() {
        return nbreEnfant;
    }

    public void setNbreEnfant(int nbreEnfant) {
        this.nbreEnfant = nbreEnfant;
    }

    public Collection<Recensement> getRecensementCollection() {
        return recensementCollection;
    }

    public void setRecensementCollection(Collection<Recensement> recensementCollection) {
        this.recensementCollection = recensementCollection;
    }

    public Recensement getIdRecensement() {
        return idRecensement;
    }

    public void setIdRecensement(Recensement idRecensement) {
        this.idRecensement = idRecensement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Personne[ id=" + id + " ]";
    }
    
}
