/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.recensement.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author user
 */
@Entity
@Table(catalog = "recensement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
    @NamedQuery(name = "Role.findByLibelle", query = "SELECT r FROM Role r WHERE r.libelle = :libelle")})
public class Role  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private Collection<Agent> agentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private Collection<Chefbureau> chefbureauCollection;

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<Agent> getAgentCollection() {
        return agentCollection;
    }

    public void setAgentCollection(Collection<Agent> agentCollection) {
        this.agentCollection = agentCollection;
    }

    public Collection<Chefbureau> getChefbureauCollection() {
        return chefbureauCollection;
    }

    public void setChefbureauCollection(Collection<Chefbureau> chefbureauCollection) {
        this.chefbureauCollection = chefbureauCollection;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Role[ id=" + id + " ]";
    }
    
}
