/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Igor
 */
@Entity
@Table(name = "USERTYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertypes.findAll", query = "SELECT u FROM Usertypes u")
    , @NamedQuery(name = "Usertypes.findById", query = "SELECT u FROM Usertypes u WHERE u.id = :id")
    , @NamedQuery(name = "Usertypes.findByName", query = "SELECT u FROM Usertypes u WHERE u.name = :name")
    , @NamedQuery(name = "Usertypes.findByPermission", query = "SELECT u FROM Usertypes u WHERE u.permission = :permission")})
public class Usertypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERMISSION")
    private int permission;
    @ManyToMany(mappedBy = "usertypesCollection")
    private Collection<Events> eventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertypeid")
    private Collection<Users> usersCollection;

    public Usertypes() {
    }

    public Usertypes(Integer id) {
        this.id = id;
    }

    public Usertypes(Integer id, String name, int permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @XmlTransient
    public Collection<Events> getEventsCollection() {
        return eventsCollection;
    }

    public void setEventsCollection(Collection<Events> eventsCollection) {
        this.eventsCollection = eventsCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
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
        if (!(object instanceof Usertypes)) {
            return false;
        }
        Usertypes other = (Usertypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usertypes[ id=" + id + " ]";
    }
    
}
