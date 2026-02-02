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
 * @author user
 */
@Entity
@Table(catalog = "recensement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Recensement.findAll", query = "SELECT r FROM Recensement r"),
    @NamedQuery(name = "Recensement.findById", query = "SELECT r FROM Recensement r WHERE r.id = :id"),
    @NamedQuery(name = "Recensement.findByDate", query = "SELECT r FROM Recensement r WHERE r.date = :date"),
    @NamedQuery(name = "Recensement.findByLieu", query = "SELECT r FROM Recensement r WHERE r.lieu = :lieu")})
public class Recensement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDate date;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String lieu;
    @JoinColumn(name = "idAgent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Agent idAgent;
    @JoinColumn(name = "idPersonne", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Personne idPersonne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecensement")
    private Collection<Personne> personneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecensement")
    private Collection<Rapport> rapportCollection;

    public Recensement() {
    }

    public Recensement(Integer id) {
        this.id = id;
    }

    public Recensement(Integer id, LocalDate date, String lieu) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Agent getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Agent idAgent) {
        this.idAgent = idAgent;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
    }

    public Collection<Rapport> getRapportCollection() {
        return rapportCollection;
    }

    public void setRapportCollection(Collection<Rapport> rapportCollection) {
        this.rapportCollection = rapportCollection;
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
        if (!(object instanceof Recensement)) {
            return false;
        }
        Recensement other = (Recensement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Recensement[ id=" + id + " ]";
    }
    
}
