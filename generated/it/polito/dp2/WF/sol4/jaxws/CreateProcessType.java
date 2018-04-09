
package it.polito.dp2.WF.sol4.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createProcessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createProcessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instanceOf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userIDType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Premium"/>
 *               &lt;enumeration value="Basic"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createProcessType", propOrder = {
    "instanceOf",
    "userIDType"
})
public class CreateProcessType {

    @XmlElement(required = true)
    protected String instanceOf;
    @XmlElement(required = true)
    protected String userIDType;

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
     * Gets the value of the userIDType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIDType() {
        return userIDType;
    }

    /**
     * Sets the value of the userIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIDType(String value) {
        this.userIDType = value;
    }

}
