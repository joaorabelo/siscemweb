/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unit.projcem.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "responsaveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsaveis.findAll", query = "SELECT r FROM Responsaveis r")
    , @NamedQuery(name = "Responsaveis.findByIdResp", query = "SELECT r FROM Responsaveis r WHERE r.idResp = :idResp")
    , @NamedQuery(name = "Responsaveis.findByNomResp", query = "SELECT r FROM Responsaveis r WHERE r.nomResp = :nomResp")
    , @NamedQuery(name = "Responsaveis.findByDtNascResp", query = "SELECT r FROM Responsaveis r WHERE r.dtNascResp = :dtNascResp")
    , @NamedQuery(name = "Responsaveis.findByCpfResp", query = "SELECT r FROM Responsaveis r WHERE r.cpfResp = :cpfResp")
    , @NamedQuery(name = "Responsaveis.findByRgResp", query = "SELECT r FROM Responsaveis r WHERE r.rgResp = :rgResp")
    , @NamedQuery(name = "Responsaveis.findBySexoResp", query = "SELECT r FROM Responsaveis r WHERE r.sexoResp = :sexoResp")
    , @NamedQuery(name = "Responsaveis.findByFoneResp", query = "SELECT r FROM Responsaveis r WHERE r.foneResp = :foneResp")
    , @NamedQuery(name = "Responsaveis.findByFoneResp2", query = "SELECT r FROM Responsaveis r WHERE r.foneResp2 = :foneResp2")})
public class Responsaveis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resp")
    private Integer idResp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nom_resp")
    private String nomResp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_nasc_resp")
    @Temporal(TemporalType.DATE)
    private Date dtNascResp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf_resp")
    private int cpfResp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rg_resp")
    private String rgResp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo_resp")
    private Character sexoResp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fone_resp")
    private int foneResp;
    @Column(name = "fone_resp2")
    private Integer foneResp2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResp")
    private Collection<Alunos> alunosCollection;
    @JoinColumn(name = "id_end", referencedColumnName = "id_end")
    @ManyToOne(optional = false)
    private Enderecos idEnd;

    public Responsaveis() {
    }

    public Responsaveis(Integer idResp) {
        this.idResp = idResp;
    }

    public Responsaveis(Integer idResp, String nomResp, Date dtNascResp, int cpfResp, String rgResp, Character sexoResp, int foneResp) {
        this.idResp = idResp;
        this.nomResp = nomResp;
        this.dtNascResp = dtNascResp;
        this.cpfResp = cpfResp;
        this.rgResp = rgResp;
        this.sexoResp = sexoResp;
        this.foneResp = foneResp;
    }

    public Integer getIdResp() {
        return idResp;
    }

    public void setIdResp(Integer idResp) {
        this.idResp = idResp;
    }

    public String getNomResp() {
        return nomResp;
    }

    public void setNomResp(String nomResp) {
        this.nomResp = nomResp;
    }

    public Date getDtNascResp() {
        return dtNascResp;
    }

    public void setDtNascResp(Date dtNascResp) {
        this.dtNascResp = dtNascResp;
    }

    public int getCpfResp() {
        return cpfResp;
    }

    public void setCpfResp(int cpfResp) {
        this.cpfResp = cpfResp;
    }

    public String getRgResp() {
        return rgResp;
    }

    public void setRgResp(String rgResp) {
        this.rgResp = rgResp;
    }

    public Character getSexoResp() {
        return sexoResp;
    }

    public void setSexoResp(Character sexoResp) {
        this.sexoResp = sexoResp;
    }

    public int getFoneResp() {
        return foneResp;
    }

    public void setFoneResp(int foneResp) {
        this.foneResp = foneResp;
    }

    public Integer getFoneResp2() {
        return foneResp2;
    }

    public void setFoneResp2(Integer foneResp2) {
        this.foneResp2 = foneResp2;
    }

    @XmlTransient
    public Collection<Alunos> getAlunosCollection() {
        return alunosCollection;
    }

    public void setAlunosCollection(Collection<Alunos> alunosCollection) {
        this.alunosCollection = alunosCollection;
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
        hash += (idResp != null ? idResp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsaveis)) {
            return false;
        }
        Responsaveis other = (Responsaveis) object;
        if ((this.idResp == null && other.idResp != null) || (this.idResp != null && !this.idResp.equals(other.idResp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Responsaveis[ idResp=" + idResp + " ]";
    }
    
}
