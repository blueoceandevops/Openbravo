/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.retail.posterminal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
/**
 * Entity class for entity OBPOS_App_Cashup (stored in table OBPOS_App_Cashup).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OBPOSAppCashup extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "OBPOS_App_Cashup";
    public static final String ENTITY_NAME = "OBPOS_App_Cashup";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_POSTERMINAL = "pOSTerminal";
    public static final String PROPERTY_CASHUPDATE = "cashUpDate";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_CASHUPREPORT = "cashupreport";
    public static final String PROPERTY_NETSALES = "netsales";
    public static final String PROPERTY_GROSSSALES = "grosssales";
    public static final String PROPERTY_NETRETURNS = "netreturns";
    public static final String PROPERTY_GROSSRETURNS = "grossreturns";
    public static final String PROPERTY_TOTALRETAILTRANSACTIONS = "totalretailtransactions";
    public static final String PROPERTY_ISBEINGPROCESSED = "isbeingprocessed";
    public static final String PROPERTY_ISPROCESSED = "isProcessed";
    public static final String PROPERTY_ISPROCESSEDBO = "isprocessedbo";
    public static final String PROPERTY_OBPOSPARENTCASHUP = "obposParentCashup";
    public static final String PROPERTY_JSONCASHUP = "jsoncashup";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMOBPOSAPPCASHUPIDLIST = "fINFinaccTransactionEMObposAppCashupIDList";
    public static final String PROPERTY_OBPOSAPPCASHRECONCILLIST = "oBPOSAppCashReconcilList";
    public static final String PROPERTY_OBPOSAPPCASHUPOBPOSPARENTCASHUPIDLIST = "oBPOSAppCashupObposParentCashupIDList";
    public static final String PROPERTY_OBPOSCASHUPAPPROVALLIST = "oBPOSCashupApprovalList";
    public static final String PROPERTY_OBPOSPAYMENTMETHODCASHUPLIST = "oBPOSPaymentmethodcashupList";
    public static final String PROPERTY_OBPOSTAXCASHUPLIST = "oBPOSTaxcashupList";

    public OBPOSAppCashup() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CASHUPREPORT, false);
        setDefaultValue(PROPERTY_ISBEINGPROCESSED, false);
        setDefaultValue(PROPERTY_ISPROCESSED, false);
        setDefaultValue(PROPERTY_ISPROCESSEDBO, false);
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMOBPOSAPPCASHUPIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPCASHRECONCILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPCASHUPOBPOSPARENTCASHUPIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCASHUPAPPROVALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSPAYMENTMETHODCASHUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSTAXCASHUPLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public OBPOSApplications getPOSTerminal() {
        return (OBPOSApplications) get(PROPERTY_POSTERMINAL);
    }

    public void setPOSTerminal(OBPOSApplications pOSTerminal) {
        set(PROPERTY_POSTERMINAL, pOSTerminal);
    }

    public Date getCashUpDate() {
        return (Date) get(PROPERTY_CASHUPDATE);
    }

    public void setCashUpDate(Date cashUpDate) {
        set(PROPERTY_CASHUPDATE, cashUpDate);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Boolean isCashupreport() {
        return (Boolean) get(PROPERTY_CASHUPREPORT);
    }

    public void setCashupreport(Boolean cashupreport) {
        set(PROPERTY_CASHUPREPORT, cashupreport);
    }

    public BigDecimal getNetsales() {
        return (BigDecimal) get(PROPERTY_NETSALES);
    }

    public void setNetsales(BigDecimal netsales) {
        set(PROPERTY_NETSALES, netsales);
    }

    public BigDecimal getGrosssales() {
        return (BigDecimal) get(PROPERTY_GROSSSALES);
    }

    public void setGrosssales(BigDecimal grosssales) {
        set(PROPERTY_GROSSSALES, grosssales);
    }

    public BigDecimal getNetreturns() {
        return (BigDecimal) get(PROPERTY_NETRETURNS);
    }

    public void setNetreturns(BigDecimal netreturns) {
        set(PROPERTY_NETRETURNS, netreturns);
    }

    public BigDecimal getGrossreturns() {
        return (BigDecimal) get(PROPERTY_GROSSRETURNS);
    }

    public void setGrossreturns(BigDecimal grossreturns) {
        set(PROPERTY_GROSSRETURNS, grossreturns);
    }

    public BigDecimal getTotalretailtransactions() {
        return (BigDecimal) get(PROPERTY_TOTALRETAILTRANSACTIONS);
    }

    public void setTotalretailtransactions(BigDecimal totalretailtransactions) {
        set(PROPERTY_TOTALRETAILTRANSACTIONS, totalretailtransactions);
    }

    public Boolean isBeingprocessed() {
        return (Boolean) get(PROPERTY_ISBEINGPROCESSED);
    }

    public void setBeingprocessed(Boolean isbeingprocessed) {
        set(PROPERTY_ISBEINGPROCESSED, isbeingprocessed);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_ISPROCESSED);
    }

    public void setProcessed(Boolean isProcessed) {
        set(PROPERTY_ISPROCESSED, isProcessed);
    }

    public Boolean isProcessedbo() {
        return (Boolean) get(PROPERTY_ISPROCESSEDBO);
    }

    public void setProcessedbo(Boolean isprocessedbo) {
        set(PROPERTY_ISPROCESSEDBO, isprocessedbo);
    }

    public OBPOSAppCashup getObposParentCashup() {
        return (OBPOSAppCashup) get(PROPERTY_OBPOSPARENTCASHUP);
    }

    public void setObposParentCashup(OBPOSAppCashup obposParentCashup) {
        set(PROPERTY_OBPOSPARENTCASHUP, obposParentCashup);
    }

    public String getJsoncashup() {
        return (String) get(PROPERTY_JSONCASHUP);
    }

    public void setJsoncashup(String jsoncashup) {
        set(PROPERTY_JSONCASHUP, jsoncashup);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMObposAppCashupIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMOBPOSAPPCASHUPIDLIST);
    }

    public void setFINFinaccTransactionEMObposAppCashupIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMObposAppCashupIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMOBPOSAPPCASHUPIDLIST, fINFinaccTransactionEMObposAppCashupIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSAppCashReconcil> getOBPOSAppCashReconcilList() {
      return (List<OBPOSAppCashReconcil>) get(PROPERTY_OBPOSAPPCASHRECONCILLIST);
    }

    public void setOBPOSAppCashReconcilList(List<OBPOSAppCashReconcil> oBPOSAppCashReconcilList) {
        set(PROPERTY_OBPOSAPPCASHRECONCILLIST, oBPOSAppCashReconcilList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSAppCashup> getOBPOSAppCashupObposParentCashupIDList() {
      return (List<OBPOSAppCashup>) get(PROPERTY_OBPOSAPPCASHUPOBPOSPARENTCASHUPIDLIST);
    }

    public void setOBPOSAppCashupObposParentCashupIDList(List<OBPOSAppCashup> oBPOSAppCashupObposParentCashupIDList) {
        set(PROPERTY_OBPOSAPPCASHUPOBPOSPARENTCASHUPIDLIST, oBPOSAppCashupObposParentCashupIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCashupApproval> getOBPOSCashupApprovalList() {
      return (List<OBPOSCashupApproval>) get(PROPERTY_OBPOSCASHUPAPPROVALLIST);
    }

    public void setOBPOSCashupApprovalList(List<OBPOSCashupApproval> oBPOSCashupApprovalList) {
        set(PROPERTY_OBPOSCASHUPAPPROVALLIST, oBPOSCashupApprovalList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSPaymentMethodCashup> getOBPOSPaymentmethodcashupList() {
      return (List<OBPOSPaymentMethodCashup>) get(PROPERTY_OBPOSPAYMENTMETHODCASHUPLIST);
    }

    public void setOBPOSPaymentmethodcashupList(List<OBPOSPaymentMethodCashup> oBPOSPaymentmethodcashupList) {
        set(PROPERTY_OBPOSPAYMENTMETHODCASHUPLIST, oBPOSPaymentmethodcashupList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSTaxCashup> getOBPOSTaxcashupList() {
      return (List<OBPOSTaxCashup>) get(PROPERTY_OBPOSTAXCASHUPLIST);
    }

    public void setOBPOSTaxcashupList(List<OBPOSTaxCashup> oBPOSTaxcashupList) {
        set(PROPERTY_OBPOSTAXCASHUPLIST, oBPOSTaxcashupList);
    }

}