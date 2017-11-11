/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unit.projcem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "turmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turmas.findAll", query = "SELECT t FROM Turmas t")
    , @NamedQuery(name = "Turmas.findByIdTur", query = "SELECT t FROM Turmas t WHERE t.idTur = :idTur")
    , @NamedQuery(name = "Turmas.findByAnoTur", query = "SELECT t FROM Turmas t WHERE t.anoTur = :anoTur")
    , @NamedQuery(name = "Turmas.findByMedTru", query = "SELECT t FROM Turmas t WHERE t.medTru = :medTru")
    , @NamedQuery(name = "Turmas.findByTotAprTur", query = "SELECT t FROM Turmas t WHERE t.totAprTur = :totAprTur")
    , @NamedQuery(name = "Turmas.findByTotRepTur", query = "SELECT t FROM Turmas t WHERE t.totRepTur = :totRepTur")
    , @NamedQuery(name = "Turmas.findBySerTur", query = "SELECT t FROM Turmas t WHERE t.serTur = :serTur")
    , @NamedQuery(name = "Turmas.findByTurTur", query = "SELECT t FROM Turmas t WHERE t.turTur = :turTur")
    , @NamedQuery(name = "Turmas.findByCarHorTur", query = "SELECT t FROM Turmas t WHERE t.carHorTur = :carHorTur")})
public class Turmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tur")
    private Integer idTur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_tur")
    private int anoTur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "med_tru")
    private BigDecimal medTru;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_apr_tur")
    private int totAprTur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_rep_tur")
    private int totRepTur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ser_tur")
    private int serTur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tur_tur")
    private String turTur;
    @Column(name = "car_hor_tur")
    private Integer carHorTur;
    @ManyToMany(mappedBy = "turmasCollection")
    private Collection<Alunos> alunosCollection;
    @ManyToMany(mappedBy = "turmasCollection")
    private Collection<Professores> professoresCollection;

    public Turmas() {
    }

    public Turmas(Integer idTur) {
        this.idTur = idTur;
    }

    public Turmas(Integer idTur, int anoTur, BigDecimal medTru, int totAprTur, int totRepTur, int serTur, String turTur) {
        this.idTur = idTur;
        this.anoTur = anoTur;
        this.medTru = medTru;
        this.totAprTur = totAprTur;
        this.totRepTur = totRepTur;
        this.serTur = serTur;
        this.turTur = turTur;
    }

    public Integer getIdTur() {
        return idTur;
    }

    public void setIdTur(Integer idTur) {
        this.idTur = idTur;
    }

    public int getAnoTur() {
        return anoTur;
    }

    public void setAnoTur(int anoTur) {
        this.anoTur = anoTur;
    }

    public BigDecimal getMedTru() {
        return medTru;
    }

    public void setMedTru(BigDecimal medTru) {
        this.medTru = medTru;
    }

    public int getTotAprTur() {
        return totAprTur;
    }

    public void setTotAprTur(int totAprTur) {
        this.totAprTur = totAprTur;
    }

    public int getTotRepTur() {
        return totRepTur;
    }

    public void setTotRepTur(int totRepTur) {
        this.totRepTur = totRepTur;
    }

    public int getSerTur() {
        return serTur;
    }

    public void setSerTur(int serTur) {
        this.serTur = serTur;
    }

    public String getTurTur() {
        return turTur;
    }

    public void setTurTur(String turTur) {
        this.turTur = turTur;
    }

    public Integer getCarHorTur() {
        return carHorTur;
    }

    public void setCarHorTur(Integer carHorTur) {
        this.carHorTur = carHorTur;
    }

    @XmlTransient
    public Collection<Alunos> getAlunosCollection() {
        return alunosCollection;
    }

    public void setAlunosCollection(Collection<Alunos> alunosCollection) {
        this.alunosCollection = alunosCollection;
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
        hash += (idTur != null ? idTur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turmas)) {
            return false;
        }
        Turmas other = (Turmas) object;
        if ((this.idTur == null && other.idTur != null) || (this.idTur != null && !this.idTur.equals(other.idTur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Turmas[ idTur=" + idTur + " ]";
    }
    
}
