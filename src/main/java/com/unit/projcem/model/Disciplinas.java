/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unit.projcem.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "disciplinas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplinas.findAll", query = "SELECT d FROM Disciplinas d")
    , @NamedQuery(name = "Disciplinas.findByIdDisc", query = "SELECT d FROM Disciplinas d WHERE d.idDisc = :idDisc")
    , @NamedQuery(name = "Disciplinas.findByNomDisc", query = "SELECT d FROM Disciplinas d WHERE d.nomDisc = :nomDisc")
    , @NamedQuery(name = "Disciplinas.findByTipoDisc", query = "SELECT d FROM Disciplinas d WHERE d.tipoDisc = :tipoDisc")})
public class Disciplinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disc")
    private Integer idDisc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_disc")
    private String nomDisc;
    @Size(max = 30)
    @Column(name = "tipo_disc")
    private String tipoDisc;
    @JoinTable(name = "disc_prof", joinColumns = {
        @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")}, inverseJoinColumns = {
        @JoinColumn(name = "mat_prof", referencedColumnName = "mat_prof")})
    @ManyToMany
    private Collection<Professores> professoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisc")
    private Collection<Boletins> boletinsCollection;

    public Disciplinas() {
    }

    public Disciplinas(Integer idDisc) {
        this.idDisc = idDisc;
    }

    public Disciplinas(Integer idDisc, String nomDisc) {
        this.idDisc = idDisc;
        this.nomDisc = nomDisc;
    }

    public Integer getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(Integer idDisc) {
        this.idDisc = idDisc;
    }

    public String getNomDisc() {
        return nomDisc;
    }

    public void setNomDisc(String nomDisc) {
        this.nomDisc = nomDisc;
    }

    public String getTipoDisc() {
        return tipoDisc;
    }

    public void setTipoDisc(String tipoDisc) {
        this.tipoDisc = tipoDisc;
    }

    @XmlTransient
    public Collection<Professores> getProfessoresCollection() {
        return professoresCollection;
    }

    public void setProfessoresCollection(Collection<Professores> professoresCollection) {
        this.professoresCollection = professoresCollection;
    }

    @XmlTransient
    public Collection<Boletins> getBoletinsCollection() {
        return boletinsCollection;
    }

    public void setBoletinsCollection(Collection<Boletins> boletinsCollection) {
        this.boletinsCollection = boletinsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisc != null ? idDisc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplinas)) {
            return false;
        }
        Disciplinas other = (Disciplinas) object;
        if ((this.idDisc == null && other.idDisc != null) || (this.idDisc != null && !this.idDisc.equals(other.idDisc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Disciplinas[ idDisc=" + idDisc + " ]";
    }
    
}
