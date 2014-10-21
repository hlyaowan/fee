package com.aoyetech.fee.domain.webserver;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.eclipse.persistence.oxm.annotations.XmlMarshalNullRepresentation;
import org.eclipse.persistence.oxm.annotations.XmlNullPolicy;

@XmlRootElement(name="webserverinfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class WebServerInfo implements Serializable {

    public static final String JSON_ROOT_NAME   = "webserverinfo";

    /**
     * 
     */
    private static final long  serialVersionUID = 1L;

    @XmlElement(name = "server_ip", required = true, nillable = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    private String             serverIp;                          // 服务器ip
    @XmlElement(name = "server_name", required = true, nillable = true)
    @XmlNullPolicy(emptyNodeRepresentsNull = true, nullRepresentationForXml = XmlMarshalNullRepresentation.EMPTY_NODE)
    private String             serverName;                        // 服务器名

    @JsonProperty("server_ip")
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @JsonProperty("server_name")
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

}
