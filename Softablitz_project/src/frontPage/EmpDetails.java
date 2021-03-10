/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ABHINAV ANAND
 */
@Entity
@Table(name = "emp_details", catalog = "daretotravel", schema = "")
@NamedQueries({
    @NamedQuery(name = "EmpDetails.findAll", query = "SELECT e FROM EmpDetails e")
    , @NamedQuery(name = "EmpDetails.findById", query = "SELECT e FROM EmpDetails e WHERE e.id = :id")
    , @NamedQuery(name = "EmpDetails.findByFName", query = "SELECT e FROM EmpDetails e WHERE e.fName = :fName")
    , @NamedQuery(name = "EmpDetails.findByLName", query = "SELECT e FROM EmpDetails e WHERE e.lName = :lName")
    , @NamedQuery(name = "EmpDetails.findByPhoneNo", query = "SELECT e FROM EmpDetails e WHERE e.phoneNo = :phoneNo")
    , @NamedQuery(name = "EmpDetails.findByDesg", query = "SELECT e FROM EmpDetails e WHERE e.desg = :desg")})
public class EmpDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fName")
    private String fName;
    @Basic(optional = false)
    @Column(name = "lName")
    private String lName;
    @Basic(optional = false)
    @Column(name = "phoneNo")
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "Desg")
    private String desg;

    public EmpDetails() {
    }

    public EmpDetails(Integer id) {
        this.id = id;
    }

    public EmpDetails(Integer id, String fName, String lName, String phoneNo, String desg) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.desg = desg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        String oldFName = this.fName;
        this.fName = fName;
        changeSupport.firePropertyChange("FName", oldFName, fName);
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        String oldLName = this.lName;
        this.lName = lName;
        changeSupport.firePropertyChange("LName", oldLName, lName);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        String oldPhoneNo = this.phoneNo;
        this.phoneNo = phoneNo;
        changeSupport.firePropertyChange("phoneNo", oldPhoneNo, phoneNo);
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        String oldDesg = this.desg;
        this.desg = desg;
        changeSupport.firePropertyChange("desg", oldDesg, desg);
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
        if (!(object instanceof EmpDetails)) {
            return false;
        }
        EmpDetails other = (EmpDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frontPage.EmpDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
