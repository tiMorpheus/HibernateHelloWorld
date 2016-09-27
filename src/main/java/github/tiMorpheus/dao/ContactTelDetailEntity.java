package github.tiMorpheus.dao;

import javax.persistence.*;

@Entity
@Table(name = "contact_tel_detail", schema = "hellohibernate", catalog = "")
public class ContactTelDetailEntity {
    private int id;
    private String telType;
    private String telNumver;
    private int version;
    private ContactEntity contactByContactId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tel_type", nullable = false, length = 20)
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @Basic
    @Column(name = "tel_numver", nullable = false, length = 20)
    public String getTelNumver() {
        return telNumver;
    }

    public void setTelNumver(String telNumver) {
        this.telNumver = telNumver;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetailEntity that = (ContactTelDetailEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;
        if (telNumver != null ? !telNumver.equals(that.telNumver) : that.telNumver != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumver != null ? telNumver.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    public ContactEntity getContactByContactId() {
        return contactByContactId;
    }

    public void setContactByContactId(ContactEntity contactByContactId) {
        this.contactByContactId = contactByContactId;
    }
}
