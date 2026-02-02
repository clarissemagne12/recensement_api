/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.recensement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.recensement.entities.Role;

import java.io.Serializable;

/**
 *
 * @author user
 */
@Getter
@Entity
@Table(catalog = "recensement", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chefbureau.findAll", query = "SELECT c FROM Chefbureau c"),
    @NamedQuery(name = "Chefbureau.findById", query = "SELECT c FROM Chefbureau c WHERE c.id = :id"),
    @NamedQuery(name = "Chefbureau.findByNom", query = "SELECT c FROM Chefbureau c WHERE c.nom = :nom")})
public class Chefbureau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 191)
    private String nom;
    @JoinColumn(name = "idRole", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Role idRole;
    @JoinColumn(name = "idRapport", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Rapport idRapport;

    public Chefbureau() {
    }

    public Chefbureau(Integer id) {
        this.id = id;
    }

    public Chefbureau(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public void setIdRapport(Rapport idRapport) {
        this.idRapport = idRapport;
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
        if (!(object instanceof Chefbureau)) {
            return false;
        }
        Chefbureau other = (Chefbureau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Chefbureau[ id=" + id + " ]";
    }
    
}
