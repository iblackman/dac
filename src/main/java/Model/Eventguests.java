/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "EVENTGUESTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventguests.findAll", query = "SELECT e FROM Eventguests e")
    , @NamedQuery(name = "Eventguests.findByEventid", query = "SELECT e FROM Eventguests e WHERE e.eventguestsPK.eventid = :eventid")
    , @NamedQuery(name = "Eventguests.findByUserid", query = "SELECT e FROM Eventguests e WHERE e.eventguestsPK.userid = :userid")
    , @NamedQuery(name = "Eventguests.findByStatus", query = "SELECT e FROM Eventguests e WHERE e.status = :status")
    , @NamedQuery(name = "Eventguests.findByPresence", query = "SELECT e FROM Eventguests e WHERE e.presence = :presence")})
public class Eventguests implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventguestsPK eventguestsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private StatusEventGuest status;
    @Column(name = "PRESENCE")
    private Integer presence;
    @JoinColumn(name = "EVENTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Events events;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Eventguests() {
    }

    public Eventguests(EventguestsPK eventguestsPK) {
        this.eventguestsPK = eventguestsPK;
    }

    public Eventguests(EventguestsPK eventguestsPK, StatusEventGuest status) {
        this.eventguestsPK = eventguestsPK;
        this.status = status;
    }

    public Eventguests(int eventid, int userid) {
        this.eventguestsPK = new EventguestsPK(eventid, userid);
    }

    public EventguestsPK getEventguestsPK() {
        return eventguestsPK;
    }

    public void setEventguestsPK(EventguestsPK eventguestsPK) {
        this.eventguestsPK = eventguestsPK;
    }

    public StatusEventGuest getStatus() {
        return status;
    }

    public void setStatus(StatusEventGuest status) {
        this.status = status;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventguestsPK != null ? eventguestsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventguests)) {
            return false;
        }
        Eventguests other = (Eventguests) object;
        if ((this.eventguestsPK == null && other.eventguestsPK != null) || (this.eventguestsPK != null && !this.eventguestsPK.equals(other.eventguestsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Eventguests[ eventguestsPK=" + eventguestsPK + " ]";
    }
    
}
