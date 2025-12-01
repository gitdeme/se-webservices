
package xsdgenerated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "a",
    "b"
})
@XmlRootElement(name = "DivideRequest", namespace = "http://example.com/calculator")
public class DivideRequest {

    @XmlElement(namespace = "http://example.com/calculator")
    protected double a;
    @XmlElement(namespace = "http://example.com/calculator")
    protected double b;

    /**
     * Gets the value of the a property.
     * 
     */
    public double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

}
