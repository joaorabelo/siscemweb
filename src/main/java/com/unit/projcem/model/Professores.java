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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "professores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professores.findAll", query = "SELECT p FROM Professores p")
    , @NamedQuery(name = "Professores.findByMatProf", query = "SELECT p FROM Professores p WHERE p.matProf = :matProf")
    , @NamedQuery(name = "Professores.findByNomProf", query = "SELECT p FROM Professores p WHERE p.nomProf = :nomProf")
    , @NamedQuery(name = "Professores.findByCpfProf", query = "SELECT p FROM Professores p WHERE p.cpfProf = :cpfProf")
    , @NamedQuery(name = "Professores.findByRgProf", query = "SELECT p FROM Professores p WHERE p.rgProf = :rgProf")
    , @NamedQuery(name = "Professores.findByFoneProf", query = "SELECT p FROM Professores p WHERE p.foneProf = :foneProf")
    , @NamedQuery(name = "Professores.findByFoneProf2", query = "SELECT p FROM Professores p WHERE p.foneProf2 = :foneProf2")})
public class Professores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_prof")
    private Integer matProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nom_prof")
    private String nomProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf_prof")
    private int cpfProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rg_prof")
    private String rgProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fone_prof")
    private int foneProf;
    @Column(name = "fone_prof2")
    private Integer foneProf2;
    @ManyToMany(mappedBy = "professoresCollection")
    private Collection<Disciplinas> disciplinasCollection;
    @JoinTable(name = "tur_prof", joinColumns = {
        @JoinColumn(name = "mat_prof", referencedColumnName = "mat_prof")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tur", referencedColumnName = "id_tur")})
    @ManyToMany
    private Collection<Turmas> turmasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matProf")
    private Collection<Boletins> boletinsCollection;
    @JoinColumn(name = "id_end", referencedColumnName = "id_end")
    @ManyToOne(optional = false)
    private Enderecos idEnd;

    public Professores() {
    }

    public Professores(Integer matProf) {
        this.matProf = matProf;
    }

    public Professores(Integer matProf, String nomProf, int cpfProf, String rgProf, int foneProf) {
        this.matProf = matProf;
        this.nomProf = nomProf;
        this.cpfProf = cpfProf;
        this.rgProf = rgProf;
        this.foneProf = foneProf;
    }

    public Integer getMatProf() {
        return matProf;
    }

    public void setMatProf(Integer matProf) {
        this.matProf = matProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public int getCpfProf() {
        return cpfProf;
    }

    public void setCpfProf(int cpfProf) {
        this.cpfProf = cpfProf;
    }

    public String getRgProf() {
        return rgProf;
    }

    public void setRgProf(String rgProf) {
        this.rgProf = rgProf;
    }

    public int getFoneProf() {
        return foneProf;
    }

    public void setFoneProf(int foneProf) {
        this.foneProf = foneProf;
    }

    public Integer getFoneProf2() {
        return foneProf2;
    }

    public void setFoneProf2(Integer foneProf2) {
        this.foneProf2 = foneProf2;
    }

    @XmlTransient
    public Collection<Disciplinas> getDisciplinasCollection() {
        return disciplinasCollection;
    }

    public void setDisciplinasCollection(Collection<Disciplinas> disciplinasCollection) {
        this.disciplinasCollection = disciplinasCollection;
    }

    @XmlTransient
    public Collection<Turmas> getTurmasCollection() {
        return turmasCollection;
    }

    public void setTurmasCollection(Collection<Turmas> turmasCollection) {
        this.turmasCollection = turmasCollection;
    }

    @XmlTransient
    public Collection<Boletins> getBoletinsCollection() {
        return boletinsCollection;
    }

    public void setBoletinsCollection(Collection<Boletins> boletinsCollection) {
        this.boletinsCollection = boletinsCollection;
    }

    public Enderecos getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Enderecos idEnd) {
        this.idEnd = idEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matProf != null ? matProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professores)) {
            return false;
        }
        Professores other = (Professores) object;
        if ((this.matProf == null && other.matProf != null) || (this.matProf != null && !this.matProf.equals(other.matProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Professores[ matProf=" + matProf + " ]";
    }
    
}
