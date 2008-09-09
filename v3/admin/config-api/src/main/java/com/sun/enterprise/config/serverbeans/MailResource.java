/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */



package com.sun.enterprise.config.serverbeans;

import org.jvnet.hk2.config.Attribute;
import org.jvnet.hk2.config.ConfigBeanProxy;
import org.jvnet.hk2.component.Injectable;
import org.jvnet.hk2.config.Configured;
import org.jvnet.hk2.config.Element;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.util.List;


import org.glassfish.api.amx.AMXConfigInfo;


/* @XmlType(name = "", propOrder = {
    "description",
    "property"
}) */
@AMXConfigInfo( amxInterfaceName="com.sun.appserv.management.config.MailResourceConfig")
@Configured
public interface MailResource extends ConfigBeanProxy, Injectable, Resource, PropertyBag {

    /**
     * Gets the value of the jndiName property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute(required = true, key=true)
    public String getJndiName();

    /**
     * Sets the value of the jndiName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setJndiName(String value) throws PropertyVetoException;

    /**
     * Gets the value of the storeProtocol property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="imap")
    public String getStoreProtocol();

    /**
     * Sets the value of the storeProtocol property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStoreProtocol(String value) throws PropertyVetoException;

    /**
     * Gets the value of the storeProtocolClass property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="com.sun.mail.imap.IMAPStore")
    public String getStoreProtocolClass();

    /**
     * Sets the value of the storeProtocolClass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStoreProtocolClass(String value) throws PropertyVetoException;

    /**
     * Gets the value of the transportProtocol property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="smtp")
    public String getTransportProtocol();

    /**
     * Sets the value of the transportProtocol property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransportProtocol(String value) throws PropertyVetoException;

    /**
     * Gets the value of the transportProtocolClass property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="com.sun.mail.smtp.SMTPTransport")
    public String getTransportProtocolClass();

    /**
     * Sets the value of the transportProtocolClass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransportProtocolClass(String value) throws PropertyVetoException;

    /**
     * Gets the value of the host property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute(required = true)
    public String getHost();

    /**
     * Sets the value of the host property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHost(String value) throws PropertyVetoException;

    /**
     * Gets the value of the user property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute(required = true)
    public String getUser();

    /**
     * Sets the value of the user property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUser(String value) throws PropertyVetoException;

    /**
     * Gets the value of the from property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute(required = true)
    public String getFrom();

    /**
     * Sets the value of the from property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFrom(String value) throws PropertyVetoException;

    /**
     * Gets the value of the debug property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="false")
    public String getDebug();

    /**
     * Sets the value of the debug property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDebug(String value) throws PropertyVetoException;

    /**
     * Gets the value of the objectType property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="user")
    public String getObjectType();

    /**
     * Sets the value of the objectType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setObjectType(String value) throws PropertyVetoException;

    /**
     * Gets the value of the enabled property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute (defaultValue="true")
    public String getEnabled();

    /**
     * Sets the value of the enabled property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEnabled(String value) throws PropertyVetoException;

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute
    public String getDescription();

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) throws PropertyVetoException;
}
