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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a")
    , @NamedQuery(name = "Alunos.findByMatAlu", query = "SELECT a FROM Alunos a WHERE a.matAlu = :matAlu")
    , @NamedQuery(name = "Alunos.findByNomAlu", query = "SELECT a FROM Alunos a WHERE a.nomAlu = :nomAlu")
    , @NamedQuery(name = "Alunos.findByDtNascAlu", query = "SELECT a FROM Alunos a WHERE a.dtNascAlu = :dtNascAlu")
    , @NamedQuery(name = "Alunos.findBySexoAlu", query = "SELECT a FROM Alunos a WHERE a.sexoAlu = :sexoAlu")
    , @NamedQuery(name = "Alunos.findByLocNascAlu", query = "SELECT a FROM Alunos a WHERE a.locNascAlu = :locNascAlu")
    , @NamedQuery(name = "Alunos.findByFiliAlu", query = "SELECT a FROM Alunos a WHERE a.filiAlu = :filiAlu")
    , @NamedQuery(name = "Alunos.findByProfFiliAlu", query = "SELECT a FROM Alunos a WHERE a.profFiliAlu = :profFiliAlu")
    , @NamedQuery(name = "Alunos.findByFiliAlu2", query = "SELECT a FROM Alunos a WHERE a.filiAlu2 = :filiAlu2")
    , @NamedQuery(name = "Alunos.findByProfFiliAlu2", query = "SELECT a FROM Alunos a WHERE a.profFiliAlu2 = :profFiliAlu2")
    , @NamedQuery(name = "Alunos.findByStatusAlu", query = "SELECT a FROM Alunos a WHERE a.statusAlu = :statusAlu")
    , @NamedQuery(name = "Alunos.findByPathFotoAlu", query = "SELECT a FROM Alunos a WHERE a.pathFotoAlu = :pathFotoAlu")
    , @NamedQuery(name = "Alunos.findByCpfAlu", query = "SELECT a FROM Alunos a WHERE a.cpfAlu = :cpfAlu")
    , @NamedQuery(name = "Alunos.findByRgAlu", query = "SELECT a FROM Alunos a WHERE a.rgAlu = :rgAlu")
    , @NamedQuery(name = "Alunos.findByFoneResp", query = "SELECT a FROM Alunos a WHERE a.foneResp = :foneResp")
    , @NamedQuery(name = "Alunos.findByFoneResp2", query = "SELECT a FROM Alunos a WHERE a.foneResp2 = :foneResp2")})
public class Alunos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_alu")
    private Integer matAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nom_alu")
    private String nomAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_nasc_alu")
    @Temporal(TemporalType.DATE)
    private Date dtNascAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo_alu")
    private Character sexoAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loc_nasc_alu")
    private String locNascAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "fili_alu")
    private String filiAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prof_fili_alu")
    private String profFiliAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "fili_alu2")
    private String filiAlu2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prof_fili_alu2")
    private String profFiliAlu2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status_alu")
    private String statusAlu;
    @Size(max = 100)
    @Column(name = "path_foto_alu")
    private String pathFotoAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf_alu")
    private int cpfAlu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rg_alu")
    private String rgAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fone_resp")
    private int foneResp;
    @Column(name = "fone_resp2")
    private Integer foneResp2;
    @Lob
    @Size(max = 65535)
    @Column(name = "obs_alu")
    private String obsAlu;
    @JoinTable(name = "alu_tur", joinColumns = {
        @JoinColumn(name = "mat_alu", referencedColumnName = "mat_alu")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tur", referencedColumnName = "id_tur")})
    @ManyToMany
    private Collection<Turmas> turmasCollection;
    @JoinColumn(name = "id_end", referencedColumnName = "id_end")
    @ManyToOne(optional = false)
    private Enderecos idEnd;
    @JoinColumn(name = "id_resp", referencedColumnName = "id_resp")
    @ManyToOne(optional = false)
    private Responsaveis idResp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matAlu")
    private Collection<Boletins> boletinsCollection;

    public Alunos() {
    }

    public Alunos(Integer matAlu) {
        this.matAlu = matAlu;
    }

    public Alunos(Integer matAlu, String nomAlu, Date dtNascAlu, Character sexoAlu, String locNascAlu, String filiAlu, String profFiliAlu, String filiAlu2, String profFiliAlu2, String statusAlu, int cpfAlu, String rgAlu, int foneResp) {
        this.matAlu = matAlu;
        this.nomAlu = nomAlu;
        this.dtNascAlu = dtNascAlu;
        this.sexoAlu = sexoAlu;
        this.locNascAlu = locNascAlu;
        this.filiAlu = filiAlu;
        this.profFiliAlu = profFiliAlu;
        this.filiAlu2 = filiAlu2;
        this.profFiliAlu2 = profFiliAlu2;
        this.statusAlu = statusAlu;
        this.cpfAlu = cpfAlu;
        this.rgAlu = rgAlu;
        this.foneResp = foneResp;
    }

    public Integer getMatAlu() {
        return matAlu;
    }

    public void setMatAlu(Integer matAlu) {
        this.matAlu = matAlu;
    }

    public String getNomAlu() {
        return nomAlu;
    }

    public void setNomAlu(String nomAlu) {
        this.nomAlu = nomAlu;
    }

    public Date getDtNascAlu() {
        return dtNascAlu;
    }

    public void setDtNascAlu(Date dtNascAlu) {
        this.dtNascAlu = dtNascAlu;
    }

    public Character getSexoAlu() {
        return sexoAlu;
    }

    public void setSexoAlu(Character sexoAlu) {
        this.sexoAlu = sexoAlu;
    }

    public String getLocNascAlu() {
        return locNascAlu;
    }

    public void setLocNascAlu(String locNascAlu) {
        this.locNascAlu = locNascAlu;
    }

    public String getFiliAlu() {
        return filiAlu;
    }

    public void setFiliAlu(String filiAlu) {
        this.filiAlu = filiAlu;
    }

    public String getProfFiliAlu() {
        return profFiliAlu;
    }

    public void setProfFiliAlu(String profFiliAlu) {
        this.profFiliAlu = profFiliAlu;
    }

    public String getFiliAlu2() {
        return filiAlu2;
    }

    public void setFiliAlu2(String filiAlu2) {
        this.filiAlu2 = filiAlu2;
    }

    public String getProfFiliAlu2() {
        return profFiliAlu2;
    }

    public void setProfFiliAlu2(String profFiliAlu2) {
        this.profFiliAlu2 = profFiliAlu2;
    }

    public String getStatusAlu() {
        return statusAlu;
    }

    public void setStatusAlu(String statusAlu) {
        this.statusAlu = statusAlu;
    }

    public String getPathFotoAlu() {
        return pathFotoAlu;
    }

    public void setPathFotoAlu(String pathFotoAlu) {
        this.pathFotoAlu = pathFotoAlu;
    }

    public int getCpfAlu() {
        return cpfAlu;
    }

    public void setCpfAlu(int cpfAlu) {
        this.cpfAlu = cpfAlu;
    }

    public String getRgAlu() {
        return rgAlu;
    }

    public void setRgAlu(String rgAlu) {
        this.rgAlu = rgAlu;
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

    public String getObsAlu() {
        return obsAlu;
    }

    public void setObsAlu(String obsAlu) {
        this.obsAlu = obsAlu;
    }

    @XmlTransient
    public Collection<Turmas> getTurmasCollection() {
        return turmasCollection;
    }

    public void setTurmasCollection(Collection<Turmas> turmasCollection) {
        this.turmasCollection = turmasCollection;
    }

    public Enderecos getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Enderecos idEnd) {
        this.idEnd = idEnd;
    }

    public Responsaveis getIdResp() {
        return idResp;
    }

    public void setIdResp(Responsaveis idResp) {
        this.idResp = idResp;
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
        hash += (matAlu != null ? matAlu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.matAlu == null && other.matAlu != null) || (this.matAlu != null && !this.matAlu.equals(other.matAlu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Alunos[ matAlu=" + matAlu + " ]";
    }
    
}
