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
@Table(name = "enderecos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e")
    , @NamedQuery(name = "Enderecos.findByIdEnd", query = "SELECT e FROM Enderecos e WHERE e.idEnd = :idEnd")
    , @NamedQuery(name = "Enderecos.findByUfEnd", query = "SELECT e FROM Enderecos e WHERE e.ufEnd = :ufEnd")
    , @NamedQuery(name = "Enderecos.findByCidEnd", query = "SELECT e FROM Enderecos e WHERE e.cidEnd = :cidEnd")
    , @NamedQuery(name = "Enderecos.findByLocalEnd", query = "SELECT e FROM Enderecos e WHERE e.localEnd = :localEnd")
    , @NamedQuery(name = "Enderecos.findByBaiEnd", query = "SELECT e FROM Enderecos e WHERE e.baiEnd = :baiEnd")
    , @NamedQuery(name = "Enderecos.findByCompEnd", query = "SELECT e FROM Enderecos e WHERE e.compEnd = :compEnd")
    , @NamedQuery(name = "Enderecos.findByNumEnd", query = "SELECT e FROM Enderecos e WHERE e.numEnd = :numEnd")
    , @NamedQuery(name = "Enderecos.findByCep", query = "SELECT e FROM Enderecos e WHERE e.cep = :cep")})
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_end")
    private Integer idEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "uf_end")
    private String ufEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cid_end")
    private String cidEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "local_end")
    private String localEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "bai_end")
    private String baiEnd;
    @Size(max = 30)
    @Column(name = "comp_end")
    private String compEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_end")
    private int numEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private int cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnd")
    private Collection<Alunos> alunosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnd")
    private Collection<Responsaveis> responsaveisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnd")
    private Collection<Professores> professoresCollection;

    public Enderecos() {
    }

    public Enderecos(Integer idEnd) {
        this.idEnd = idEnd;
    }

    public Enderecos(Integer idEnd, String ufEnd, String cidEnd, String localEnd, String baiEnd, int numEnd, int cep) {
        this.idEnd = idEnd;
        this.ufEnd = ufEnd;
        this.cidEnd = cidEnd;
        this.localEnd = localEnd;
        this.baiEnd = baiEnd;
        this.numEnd = numEnd;
        this.cep = cep;
    }

    public Integer getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }

    public String getUfEnd() {
        return ufEnd;
    }

    public void setUfEnd(String ufEnd) {
        this.ufEnd = ufEnd;
    }

    public String getCidEnd() {
        return cidEnd;
    }

    public void setCidEnd(String cidEnd) {
        this.cidEnd = cidEnd;
    }

    public String getLocalEnd() {
        return localEnd;
    }

    public void setLocalEnd(String localEnd) {
        this.localEnd = localEnd;
    }

    public String getBaiEnd() {
        return baiEnd;
    }

    public void setBaiEnd(String baiEnd) {
        this.baiEnd = baiEnd;
    }

    public String getCompEnd() {
        return compEnd;
    }

    public void setCompEnd(String compEnd) {
        this.compEnd = compEnd;
    }

    public int getNumEnd() {
        return numEnd;
    }

    public void setNumEnd(int numEnd) {
        this.numEnd = numEnd;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @XmlTransient
    public Collection<Alunos> getAlunosCollection() {
        return alunosCollection;
    }

    public void setAlunosCollection(Collection<Alunos> alunosCollection) {
        this.alunosCollection = alunosCollection;
    }

    @XmlTransient
    public Collection<Responsaveis> getResponsaveisCollection() {
        return responsaveisCollection;
    }

    public void setResponsaveisCollection(Collection<Responsaveis> responsaveisCollection) {
        this.responsaveisCollection = responsaveisCollection;
    }

    @XmlTransient
    public Collection<Professores> getProfessoresCollection() {
        return professoresCollection;
    }

    public void setProfessoresCollection(Collection<Professores> professoresCollection) {
        this.professoresCollection = professoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnd != null ? idEnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.idEnd == null && other.idEnd != null) || (this.idEnd != null && !this.idEnd.equals(other.idEnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Enderecos[ idEnd=" + idEnd + " ]";
    }
    
}
