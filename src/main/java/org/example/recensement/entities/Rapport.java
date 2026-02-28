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
    @NamedQuery(name = "Rapport.findAll", query = "SELECT r FROM Rapport r"),
    @NamedQuery(name = "Rapport.findById", query = "SELECT r FROM Rapport r WHERE r.id = :id"),
    @NamedQuery(name = "Rapport.findByDate", query = "SELECT r FROM Rapport r WHERE r.date = :date")})
public class Rapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRapport")
    private Collection<Chefbureau> chefbureauCollection;
    @JoinColumn(name = "idRecensement", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Recensement idRecensement;

    public Rapport() {
    }

    public Rapport(Long id) {
        this.id = id;
    }

    public Rapport(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Collection<Chefbureau> getChefbureauCollection() {
        return chefbureauCollection;
    }

    public void setChefbureauCollection(Collection<Chefbureau> chefbureauCollection) {
        this.chefbureauCollection = chefbureauCollection;
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
        if (!(object instanceof Rapport)) {
            return false;
        }
        Rapport other = (Rapport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Rapport[ id=" + id + " ]";
    }
    
}
