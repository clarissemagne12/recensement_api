/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.recensement.entities;

import jakarta.persistence.*;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Collection;

/**
 * ENTITÉ : Agent
 * ================================
 * Cette classe représente un agent de recensement.
 * Elle est mappée à une table de la base de données via JPA.
 *
 * Un agent :
 * - possède un identifiant unique
 * - a un nom
 * - est associé à un rôle
 * - peut effectuer plusieurs recensements
 * @author clarisse
 */
@Entity // Indique que cette classe est une entité JPA
@Table(catalog = "recensement", schema = "") // Associe l'entité à la base de données
@NamedQueries({
        // Requête pour récupérer tous les agents
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
        // Requête pour rechercher un agent par son identifiant
    @NamedQuery(name = "Agent.findById", query = "SELECT a FROM Agent a WHERE a.id = :id"),

        // Requête pour rechercher un agent par son nom
    @NamedQuery(name = "Agent.findByNom", query = "SELECT a FROM Agent a WHERE a.nom = :nom")})
public class Agent implements Serializable {
    // Identifiant pour la sérialisation
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique de l’agent
     * Clé primaire auto-générée
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    /**
     * Nom de l’agent
     * Champ obligatoire avec une longueur maximale de 191 caractères
     */
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nom;


    /**
     * Rôle de l’agent
     * Relation ManyToOne : plusieurs agents peuvent avoir le même rôle
     */
    @JoinColumn(name = "idRole", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Role idRole;

    /**
     * Liste des recensements effectués par l’agent
     * Relation OneToMany : un agent peut effectuer plusieurs recensements
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgent")
    private Collection<Recensement> recensementCollection;

    /**
     * Constructeur par défaut (obligatoire pour JPA)
     */
    public Agent() {
    }

    /**
     * Constructeur avec identifiant
     */
    public Agent(Integer id) {
        this.id = id;
    }

    /**
     * Constructeur avec identifiant et nom
     */
    public Agent(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    /**
     * GENERATION DES GETTERS ET SETTERS PAR DEFAUT ET AVEC UN PARAMETRE
     */
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

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Collection<Recensement> getRecensementCollection() {
        return recensementCollection;
    }

    public void setRecensementCollection(Collection<Recensement> recensementCollection) {
        this.recensementCollection = recensementCollection;
    }

    /**
     * Méthode hashCode basée sur l’identifiant
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Comparaison entre deux agents basée sur l’identifiant
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Représentation textuelle de l’agent
     */
    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Agent[ id=" + id + " ]";
    }
    
}
