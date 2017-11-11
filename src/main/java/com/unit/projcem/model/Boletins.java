/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unit.projcem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "boletins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletins.findAll", query = "SELECT b FROM Boletins b")
    , @NamedQuery(name = "Boletins.findByAno", query = "SELECT b FROM Boletins b WHERE b.ano = :ano")
    , @NamedQuery(name = "Boletins.findByProva", query = "SELECT b FROM Boletins b WHERE b.prova = :prova")
    , @NamedQuery(name = "Boletins.findByAcordo", query = "SELECT b FROM Boletins b WHERE b.acordo = :acordo")
    , @NamedQuery(name = "Boletins.findByOutro", query = "SELECT b FROM Boletins b WHERE b.outro = :outro")
    , @NamedQuery(name = "Boletins.findBySimulado", query = "SELECT b FROM Boletins b WHERE b.simulado = :simulado")
    , @NamedQuery(name = "Boletins.findByFaltas", query = "SELECT b FROM Boletins b WHERE b.faltas = :faltas")
    , @NamedQuery(name = "Boletins.findByUnidade", query = "SELECT b FROM Boletins b WHERE b.unidade = :unidade")})
public class Boletins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private Integer ano;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prova")
    private BigDecimal prova;
    @Column(name = "acordo")
    private BigDecimal acordo;
    @Column(name = "outro")
    private BigDecimal outro;
    @Column(name = "simulado")
    private BigDecimal simulado;
    @Column(name = "faltas")
    private BigDecimal faltas;
    @Lob
    @Size(max = 65535)
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidade")
    private int unidade;
    @JoinColumn(name = "mat_alu", referencedColumnName = "mat_alu")
    @ManyToOne(optional = false)
    private Alunos matAlu;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(optional = false)
    private Disciplinas idDisc;
    @JoinColumn(name = "mat_prof", referencedColumnName = "mat_prof")
    @ManyToOne(optional = false)
    private Professores matProf;

    public Boletins() {
    }

    public Boletins(Integer ano) {
        this.ano = ano;
    }

    public Boletins(Integer ano, int unidade) {
        this.ano = ano;
        this.unidade = unidade;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getProva() {
        return prova;
    }

    public void setProva(BigDecimal prova) {
        this.prova = prova;
    }

    public BigDecimal getAcordo() {
        return acordo;
    }

    public void setAcordo(BigDecimal acordo) {
        this.acordo = acordo;
    }

    public BigDecimal getOutro() {
        return outro;
    }

    public void setOutro(BigDecimal outro) {
        this.outro = outro;
    }

    public BigDecimal getSimulado() {
        return simulado;
    }

    public void setSimulado(BigDecimal simulado) {
        this.simulado = simulado;
    }

    public BigDecimal getFaltas() {
        return faltas;
    }

    public void setFaltas(BigDecimal faltas) {
        this.faltas = faltas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public Alunos getMatAlu() {
        return matAlu;
    }

    public void setMatAlu(Alunos matAlu) {
        this.matAlu = matAlu;
    }

    public Disciplinas getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(Disciplinas idDisc) {
        this.idDisc = idDisc;
    }

    public Professores getMatProf() {
        return matProf;
    }

    public void setMatProf(Professores matProf) {
        this.matProf = matProf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ano != null ? ano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boletins)) {
            return false;
        }
        Boletins other = (Boletins) object;
        if ((this.ano == null && other.ano != null) || (this.ano != null && !this.ano.equals(other.ano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Boletins[ ano=" + ano + " ]";
    }
    
}
