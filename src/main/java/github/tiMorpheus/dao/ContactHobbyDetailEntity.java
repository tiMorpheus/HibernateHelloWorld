package github.tiMorpheus.dao;

import javax.persistence.*;

@Entity
@Table(name = "contact_hobby_detail", schema = "hellohibernate", catalog = "")
@IdClass(ContactHobbyDetailEntityPK.class)
public class ContactHobbyDetailEntity {
    private int contactId;
    private String hobbyId;
    private ContactEntity contactByContactId;

    @Id
    @Column(name = "contact_id", nullable = false)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Id
    @Column(name = "hobby_id", nullable = false, length = 20)
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactHobbyDetailEntity that = (ContactHobbyDetailEntity) o;

        if (contactId != that.contactId) return false;
        if (hobbyId != null ? !hobbyId.equals(that.hobbyId) : that.hobbyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (hobbyId != null ? hobbyId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ContactEntity getContactByContactId() {
        return contactByContactId;
    }

    public void setContactByContactId(ContactEntity contactByContactId) {
        this.contactByContactId = contactByContactId;
    }
}
