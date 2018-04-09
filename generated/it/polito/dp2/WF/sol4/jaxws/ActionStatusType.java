
package it.polito.dp2.WF.sol4.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ActionStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instanceOf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Actor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="isTakenInCharge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isTerminated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionStatusType", propOrder = {
    "instanceOf",
    "actor",
    "terminationTime",
    "isTakenInCharge",
    "isTerminated"
})
public class ActionStatusType {

    @XmlElement(required = true)
    protected String instanceOf;
    @XmlElement(name = "Actor")
    protected String actor;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar terminationTime;
    @XmlElement(defaultValue = "false")
    protected boolean isTakenInCharge;
    @XmlElement(defaultValue = "false")
    protected boolean isTerminated;

    /**
     * Gets the value of the instanceOf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceOf() {
        return instanceOf;
    }

    /**
     * Sets the value of the instanceOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceOf(String value) {
        this.instanceOf = value;
    }

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActor(String value) {
        this.actor = value;
    }

    /**
     * Gets the value of the terminationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationTime() {
        return terminationTime;
    }

    /**
     * Sets the value of the terminationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationTime(XMLGregorianCalendar value) {
        this.terminationTime = value;
    }

    /**
     * Gets the value of the isTakenInCharge property.
     * 
     */
    public boolean isIsTakenInCharge() {
        return isTakenInCharge;
    }

    /**
     * Sets the value of the isTakenInCharge property.
     * 
     */
    public void setIsTakenInCharge(boolean value) {
        this.isTakenInCharge = value;
    }

    /**
     * Gets the value of the isTerminated property.
     * 
     */
    public boolean isIsTerminated() {
        return isTerminated;
    }

    /**
     * Sets the value of the isTerminated property.
     * 
     */
    public void setIsTerminated(boolean value) {
        this.isTerminated = value;
    }

}
