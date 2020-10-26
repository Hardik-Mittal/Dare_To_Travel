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
@Table(name = "train_details", catalog = "daretotravel", schema = "")
@NamedQueries({
    @NamedQuery(name = "TrainDetails.findAll", query = "SELECT t FROM TrainDetails t")
    , @NamedQuery(name = "TrainDetails.findById", query = "SELECT t FROM TrainDetails t WHERE t.id = :id")
    , @NamedQuery(name = "TrainDetails.findByTrainNo", query = "SELECT t FROM TrainDetails t WHERE t.trainNo = :trainNo")
    , @NamedQuery(name = "TrainDetails.findByTrainName", query = "SELECT t FROM TrainDetails t WHERE t.trainName = :trainName")
    , @NamedQuery(name = "TrainDetails.findByTrainSource", query = "SELECT t FROM TrainDetails t WHERE t.trainSource = :trainSource")
    , @NamedQuery(name = "TrainDetails.findByTrainDest", query = "SELECT t FROM TrainDetails t WHERE t.trainDest = :trainDest")
    , @NamedQuery(name = "TrainDetails.findByTrainRoute", query = "SELECT t FROM TrainDetails t WHERE t.trainRoute = :trainRoute")
    , @NamedQuery(name = "TrainDetails.findByTrainTime", query = "SELECT t FROM TrainDetails t WHERE t.trainTime = :trainTime")
    , @NamedQuery(name = "TrainDetails.findByTrainStatus", query = "SELECT t FROM TrainDetails t WHERE t.trainStatus = :trainStatus")
    , @NamedQuery(name = "TrainDetails.findByACIISeats", query = "SELECT t FROM TrainDetails t WHERE t.aCIISeats = :aCIISeats")
    , @NamedQuery(name = "TrainDetails.findByACIIPrice", query = "SELECT t FROM TrainDetails t WHERE t.aCIIPrice = :aCIIPrice")
    , @NamedQuery(name = "TrainDetails.findBySleeperSeats", query = "SELECT t FROM TrainDetails t WHERE t.sleeperSeats = :sleeperSeats")
    , @NamedQuery(name = "TrainDetails.findBySleeperPrice", query = "SELECT t FROM TrainDetails t WHERE t.sleeperPrice = :sleeperPrice")})
public class TrainDetails implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "train_no")
    private int trainNo;
    @Basic(optional = false)
    @Column(name = "train_name")
    private String trainName;
    @Basic(optional = false)
    @Column(name = "train_source")
    private String trainSource;
    @Basic(optional = false)
    @Column(name = "train_dest")
    private String trainDest;
    @Basic(optional = false)
    @Column(name = "train_route")
    private String trainRoute;
    @Basic(optional = false)
    @Column(name = "train_time")
    private String trainTime;
    @Basic(optional = false)
    @Column(name = "train_status")
    private String trainStatus;
    @Basic(optional = false)
    @Column(name = "ACII_Seats")
    private String aCIISeats;
    @Basic(optional = false)
    @Column(name = "ACII_Price")
    private String aCIIPrice;
    @Basic(optional = false)
    @Column(name = "Sleeper_Seats")
    private String sleeperSeats;
    @Basic(optional = false)
    @Column(name = "Sleeper_Price")
    private String sleeperPrice;

    public TrainDetails() {
    }

    public TrainDetails(Integer id) {
        this.id = id;
    }

    public TrainDetails(Integer id, int trainNo, String trainName, String trainSource, String trainDest, String trainRoute, String trainTime, String trainStatus, String aCIISeats, String aCIIPrice, String sleeperSeats, String sleeperPrice) {
        this.id = id;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.trainSource = trainSource;
        this.trainDest = trainDest;
        this.trainRoute = trainRoute;
        this.trainTime = trainTime;
        this.trainStatus = trainStatus;
        this.aCIISeats = aCIISeats;
        this.aCIIPrice = aCIIPrice;
        this.sleeperSeats = sleeperSeats;
        this.sleeperPrice = sleeperPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        int oldTrainNo = this.trainNo;
        this.trainNo = trainNo;
        changeSupport.firePropertyChange("trainNo", oldTrainNo, trainNo);
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        String oldTrainName = this.trainName;
        this.trainName = trainName;
        changeSupport.firePropertyChange("trainName", oldTrainName, trainName);
    }

    public String getTrainSource() {
        return trainSource;
    }

    public void setTrainSource(String trainSource) {
        String oldTrainSource = this.trainSource;
        this.trainSource = trainSource;
        changeSupport.firePropertyChange("trainSource", oldTrainSource, trainSource);
    }

    public String getTrainDest() {
        return trainDest;
    }

    public void setTrainDest(String trainDest) {
        String oldTrainDest = this.trainDest;
        this.trainDest = trainDest;
        changeSupport.firePropertyChange("trainDest", oldTrainDest, trainDest);
    }

    public String getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(String trainRoute) {
        String oldTrainRoute = this.trainRoute;
        this.trainRoute = trainRoute;
        changeSupport.firePropertyChange("trainRoute", oldTrainRoute, trainRoute);
    }

    public String getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(String trainTime) {
        String oldTrainTime = this.trainTime;
        this.trainTime = trainTime;
        changeSupport.firePropertyChange("trainTime", oldTrainTime, trainTime);
    }

    public String getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(String trainStatus) {
        String oldTrainStatus = this.trainStatus;
        this.trainStatus = trainStatus;
        changeSupport.firePropertyChange("trainStatus", oldTrainStatus, trainStatus);
    }

    public String getACIISeats() {
        return aCIISeats;
    }

    public void setACIISeats(String aCIISeats) {
        String oldACIISeats = this.aCIISeats;
        this.aCIISeats = aCIISeats;
        changeSupport.firePropertyChange("ACIISeats", oldACIISeats, aCIISeats);
    }

    public String getACIIPrice() {
        return aCIIPrice;
    }

    public void setACIIPrice(String aCIIPrice) {
        String oldACIIPrice = this.aCIIPrice;
        this.aCIIPrice = aCIIPrice;
        changeSupport.firePropertyChange("ACIIPrice", oldACIIPrice, aCIIPrice);
    }

    public String getSleeperSeats() {
        return sleeperSeats;
    }

    public void setSleeperSeats(String sleeperSeats) {
        String oldSleeperSeats = this.sleeperSeats;
        this.sleeperSeats = sleeperSeats;
        changeSupport.firePropertyChange("sleeperSeats", oldSleeperSeats, sleeperSeats);
    }

    public String getSleeperPrice() {
        return sleeperPrice;
    }

    public void setSleeperPrice(String sleeperPrice) {
        String oldSleeperPrice = this.sleeperPrice;
        this.sleeperPrice = sleeperPrice;
        changeSupport.firePropertyChange("sleeperPrice", oldSleeperPrice, sleeperPrice);
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
        if (!(object instanceof TrainDetails)) {
            return false;
        }
        TrainDetails other = (TrainDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frontPage.TrainDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
