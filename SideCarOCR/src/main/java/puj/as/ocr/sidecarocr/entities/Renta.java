/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.sidecarocr.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "RENTA", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r"),
    @NamedQuery(name = "Renta.findById", query = "SELECT r FROM Renta r WHERE r.id = :id"),
    @NamedQuery(name = "Renta.findByPrecio", query = "SELECT r FROM Renta r WHERE r.precio = :precio"),
    @NamedQuery(name = "Renta.findByFecha", query = "SELECT r FROM Renta r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Renta.findByTiempoDias", query = "SELECT r FROM Renta r WHERE r.tiempoDias = :tiempoDias")})
public class Renta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "TIEMPO_DIAS")
    private int tiempoDias;
    @JoinColumn(name = "IDCARRO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Carro idcarro;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private Cliente idcliente;

    public Renta() {
    }

    public Renta(Integer id) {
        this.id = id;
    }

    public Renta(Integer id, int precio, String fecha, int tiempoDias) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.tiempoDias = tiempoDias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTiempoDias() {
        return tiempoDias;
    }

    public void setTiempoDias(int tiempoDias) {
        this.tiempoDias = tiempoDias;
    }

    public Carro getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Carro idcarro) {
        this.idcarro = idcarro;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
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
        if (!(object instanceof Renta)) {
            return false;
        }
        Renta other = (Renta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.ocr.sidecarocr.entities.Renta[ id=" + id + " ]";
    }
    
}
