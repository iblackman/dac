/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Igor
 */
@Embeddable
public class EventguestsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENTID")
    private int eventid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;

    public EventguestsPK() {
    }

    public EventguestsPK(int eventid, int userid) {
        this.eventid = eventid;
        this.userid = userid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventid;
        hash += (int) userid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventguestsPK)) {
            return false;
        }
        EventguestsPK other = (EventguestsPK) object;
        if (this.eventid != other.eventid) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.EventguestsPK[ eventid=" + eventid + ", userid=" + userid + " ]";
    }
    
}
