package com.baselogic.tutorials.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Object Type
 */
@Embeddable
public class ObjectTypeEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    private com.baselogic.tutorials.domain.enums.ObjectType type;

    @Column
    String creator;
    String text;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    protected Calendar timestamp;

    public ObjectTypeEntity() {
    }

    public ObjectTypeEntity(String creator, String text, Calendar timestamp) {
        this.creator = creator;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }
}


/*
@XmlRootElement(name = "Customer")
@Entity
@Table
@NamedQuery(name = Constants.FINDALLFINDERNAME,
            query = Constants.FINDALLQUERY)
public class Customer extends AuditableEntity {

    //-----------------------------------------------------------------------//
    // Attributes
    //-----------------------------------------------------------------------//
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;
    private String firstName;
    private String lastName;
    private Double discount;

    @ElementCollection
    @CollectionTable(name = Constants.HOBBIES, joinColumns = @JoinColumn(name = Constants.SUD_ID))
    @Column(name = Constants.HOBBY_NAME, nullable = true)
    private Collection<String> hobbies = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = Constants.RELEASE_NOTES, joinColumns = @JoinColumn(name = Constants.SUD_ID))
    @Column(name = Constants.SUD_RELEASE_NOTES, nullable = true)
    private List<Phone> phones;

    @ElementCollection
    @CollectionTable(name = Constants.CUSTOMER_ADDRESSES,
            joinColumns = @JoinColumn(name = Constants.SUD_ID))
    @MapKeyColumn(name = Constants.ADDRESS_KEY)
    private Map<String, Address> addresses = new HashMap<String, Address>();

    @OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            mappedBy = Constants.CONTACT_ENTRY)
    private Collection<Contact> contacts;

    @Column(length = 2000, nullable = true)
    private String description;




@Embeddable
public class Phone  implements Serializable {

    //-----------------------------------------------------------------------//
    // Attributes
    //-----------------------------------------------------------------------//

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Column
    private String areaCode;

    @Column(name = Constants.PHONE_NUMBER)
    private String number;

    //-----------------------------------------------------------------------//
    // Constructors
    //-----------------------------------------------------------------------//

    public Phone() {
    }

    public Phone(PhoneType type, String areaCode, String number) {
        this.type = type;
        this.areaCode = areaCode;
        this.number = number;
    }

    //-----------------------------------------------------------------------//
    // Setters / Getters
    //-----------------------------------------------------------------------//

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
*/