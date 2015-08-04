package com.baselogic.tutorials.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Image
 */
@Embeddable
public class Image implements Serializable {

    @Column
    String creator;
    String text;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    protected Calendar timestamp;

    public Image() {
    }

    //--- Common methods ----------------------------------------------------//

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
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