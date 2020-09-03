/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASimiyu
 */
@Entity
@Table(name = "tUSERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUSERS.findAll", query = "SELECT t FROM TUSERS t"),
    @NamedQuery(name = "TUSERS.findById", query = "SELECT t FROM TUSERS t WHERE t.id = :id"),
    @NamedQuery(name = "TUSERS.findByUsername", query = "SELECT t FROM TUSERS t WHERE t.username = :username"),
    @NamedQuery(name = "TUSERS.findByPassword", query = "SELECT t FROM TUSERS t WHERE t.password = :password"),
    @NamedQuery(name = "TUSERS.findByPhone", query = "SELECT t FROM TUSERS t WHERE t.phone = :phone"),
    @NamedQuery(name = "TUSERS.findByEmail", query = "SELECT t FROM TUSERS t WHERE t.email = :email"),
    @NamedQuery(name = "TUSERS.findByGender", query = "SELECT t FROM TUSERS t WHERE t.gender = :gender"),
    @NamedQuery(name = "TUSERS.findByFirstname", query = "SELECT t FROM TUSERS t WHERE t.firstname = :firstname"),
    @NamedQuery(name = "TUSERS.findBySurname", query = "SELECT t FROM TUSERS t WHERE t.surname = :surname"),
    @NamedQuery(name = "TUSERS.findByDateCreated", query = "SELECT t FROM TUSERS t WHERE t.dateCreated = :dateCreated"),
    @NamedQuery(name = "TUSERS.findByDateUpdated", query = "SELECT t FROM TUSERS t WHERE t.dateUpdated = :dateUpdated")})
public class TUSERS implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    public TUSERS() {
    }

    public TUSERS(Integer id, String username, String password, String phone, String email, String gender, String firstname, String surname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.firstname = firstname;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
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
        if (!(object instanceof TUSERS)) {
            return false;
        }
        TUSERS other = (TUSERS) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ke.co.seatec.fullTestSpingBoot.entity.TUSERS[ id=" + id + " ]";
    }

}
