/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.persistence.JoinTable;
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
 * @author Igor
 */
@Entity
@Table(name = "EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")
    , @NamedQuery(name = "Events.findById", query = "SELECT e FROM Events e WHERE e.id = :id")
    , @NamedQuery(name = "Events.findByName", query = "SELECT e FROM Events e WHERE e.name = :name")
    , @NamedQuery(name = "Events.findByDescription", query = "SELECT e FROM Events e WHERE e.description = :description")
    , @NamedQuery(name = "Events.findByStartdt", query = "SELECT e FROM Events e WHERE e.startdt = :startdt")
    , @NamedQuery(name = "Events.findByEnddt", query = "SELECT e FROM Events e WHERE e.enddt = :enddt")
    , @NamedQuery(name = "Events.findByMaxguests", query = "SELECT e FROM Events e WHERE e.maxguests = :maxguests")
    , @NamedQuery(name = "Events.findByStatus", query = "SELECT e FROM Events e WHERE e.status = :status")})
public class Events implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAXGUESTS")
    private int maxguests;
    @Column(name = "STATUS")
    private StatusEvent status;
    @JoinTable(name = "EVENTUSERTYPES", joinColumns = {
        @JoinColumn(name = "EVENTID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERTYPEID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usertypes> usertypesCollection;
    @JoinTable(name = "EVENTRESOURCES", joinColumns = {
        @JoinColumn(name = "EVENTID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RESOURCEID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Resources> resourcesCollection;
    @JoinColumn(name = "EVENTTYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Eventtypes eventtypeid;
    @JoinColumn(name = "ROOMID", referencedColumnName = "ID")
    @ManyToOne
    private Rooms roomid;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private Collection<Eventguests> eventguestsCollection;

    public Events() {
    }

    public Events( String name, String description, StatusEvent status, Date startdt, Date enddt, int maxguests) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.startdt = startdt;
        this.enddt = enddt;
        this.maxguests = maxguests;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    public int getMaxguests() {
        return maxguests;
    }

    public void setMaxguests(int maxguests) {
        this.maxguests = maxguests;
    }

    public StatusEvent getStatus() {
        return status;
    }

    public void setStatus(StatusEvent status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Usertypes> getUsertypesCollection() {
        return usertypesCollection;
    }

    public void setUsertypesCollection(Collection<Usertypes> usertypesCollection) {
        this.usertypesCollection = usertypesCollection;
    }

    @XmlTransient
    public Collection<Resources> getResourcesCollection() {
        return resourcesCollection;
    }

    public void setResourcesCollection(Collection<Resources> resourcesCollection) {
        this.resourcesCollection = resourcesCollection;
    }

    public Eventtypes getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(Eventtypes eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public Rooms getRoomid() {
        return roomid;
    }

    public void setRoomid(Rooms roomid) {
        this.roomid = roomid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Eventguests> getEventguests() {
        return eventguestsCollection;
    }

    public void setEventguestsCollection(Collection<Eventguests> eventguestsCollection) {
        this.eventguestsCollection = eventguestsCollection;
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
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Events[ id=" + id + " ]";
    }
    
}
