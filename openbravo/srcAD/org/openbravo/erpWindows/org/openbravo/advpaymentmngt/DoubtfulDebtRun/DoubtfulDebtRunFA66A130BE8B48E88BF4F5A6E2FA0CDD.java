
package org.openbravo.erpWindows.org.openbravo.advpaymentmngt.DoubtfulDebtRun;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;


import org.codehaus.jettison.json.JSONObject;
import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import org.openbravo.database.SessionInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;

// Generated old code, not worth to make i.e. java imports perfect
@SuppressWarnings("unused")
public class DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "681E982F747A48A6AF328A236A067559";
  private static final String tabId = "FA66A130BE8B48E88BF4F5A6E2FA0CDD";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
  private static final String moduleId = "A918E3331C404B889D69AA9BFAFB23AC";
  
  @Override
  public void init(ServletConfig config) {
    setClassInfo("W", tabId, moduleId);
    super.init(config);
  }
  
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String command = vars.getCommand();
    
    boolean securedProcess = false;
    if (command.contains("BUTTON")) {
     List<String> explicitAccess = Arrays.asList( "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      if (command.contains("017312F51139438A9665775E3B5392A1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("017312F51139438A9665775E3B5392A1");
        SessionInfo.setModuleId("A918E3331C404B889D69AA9BFAFB23AC");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("017312F51139438A9665775E3B5392A1") || (securedProcess && command.contains("017312F51139438A9665775E3B5392A1"))) {
        classInfo.type = "P";
        classInfo.id = "017312F51139438A9665775E3B5392A1";
      }
     
    }
    if (!securedProcess) {
      setClassInfo("W", tabId, moduleId);
    }
    super.service(request, response);
  }
  

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strfinDoubtfulDebtRunId = request.getParameter("inpfinDoubtfulDebtRunId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strfinDoubtfulDebtRunId.equals(""))
              total = saveRecord(vars, myError, 'U');
          else
              total = saveRecord(vars, myError, 'I');
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strFIN_Doubtful_Debt_Run_ID.equals("")) strFIN_Doubtful_Debt_Run_ID = firstElement(vars, tableSQL);
          if (strFIN_Doubtful_Debt_Run_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strFIN_Doubtful_Debt_Run_ID, tableSQL);

      else printPageDataSheet(response, vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);
    } else if (vars.commandIn("DIRECT")) {
      String strFIN_Doubtful_Debt_Run_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strFIN_Doubtful_Debt_Run_ID.equals("")) strFIN_Doubtful_Debt_Run_ID = vars.getRequiredGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID");
      else vars.setSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID", strFIN_Doubtful_Debt_Run_ID);
      
      vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view", "EDIT");

      printPageEdit(response, request, vars, false, strFIN_Doubtful_Debt_Run_ID, tableSQL);

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view");
      String strFIN_Doubtful_Debt_Run_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strFIN_Doubtful_Debt_Run_ID = firstElement(vars, tableSQL);
          if (strFIN_Doubtful_Debt_Run_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strFIN_Doubtful_Debt_Run_ID.equals("")) strFIN_Doubtful_Debt_Run_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strFIN_Doubtful_Debt_Run_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamRundate", tabId + "|paramRundate");
vars.getRequestGlobalVariable("inpParamPercentage", tabId + "|paramPercentage");
vars.getRequestGlobalVariable("inpParamDaysoverdue", tabId + "|paramDaysoverdue");
vars.getRequestGlobalVariable("inpParamRundate_f", tabId + "|paramRundate_f");
vars.getRequestGlobalVariable("inpParamPercentage_f", tabId + "|paramPercentage_f");
vars.getRequestGlobalVariable("inpParamDaysoverdue_f", tabId + "|paramDaysoverdue_f");

        vars.getRequestGlobalVariable("inpParamUpdated", tabId + "|paramUpdated");
        vars.getRequestGlobalVariable("inpParamUpdatedBy", tabId + "|paramUpdatedBy");
        vars.getRequestGlobalVariable("inpParamCreated", tabId + "|paramCreated");
        vars.getRequestGlobalVariable("inpparamCreatedBy", tabId + "|paramCreatedBy");
      
      
      vars.removeSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID");
      String strFIN_Doubtful_Debt_Run_ID="";

      String strView = vars.getSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strFIN_Doubtful_Debt_Run_ID = firstElement(vars, tableSQL);
        if (strFIN_Doubtful_Debt_Run_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strFIN_Doubtful_Debt_Run_ID, tableSQL);

      else printPageDataSheet(response, vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strFIN_Doubtful_Debt_Run_ID = vars.getGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID", "");
      vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view", "RELATION");
      printPageDataSheet(response, vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID", "");
      vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strFIN_Doubtful_Debt_Run_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getRequiredStringParameter("inpfinDoubtfulDebtRunId");
      
      String strNext = nextElement(vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getRequiredStringParameter("inpfinDoubtfulDebtRunId");
      
      String strPrevious = previousElement(vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {

      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {

      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {

      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I');      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getRequiredGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U');      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strFIN_Doubtful_Debt_Run_ID, tableSQL);
          vars.setSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("DELETE")) {

      String strFIN_Doubtful_Debt_Run_ID = vars.getRequiredStringParameter("inpfinDoubtfulDebtRunId");
      //DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasNotDeleteAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.delete(this, strFIN_Doubtful_Debt_Run_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|finDoubtfulDebtRunId");
        vars.setSessionValue(tabId + "|DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

    } else if (vars.commandIn("BUTTONEM_APRM_Process017312F51139438A9665775E3B5392A1")) {
        vars.setSessionValue("button017312F51139438A9665775E3B5392A1.stremAprmProcess", vars.getStringParameter("inpemAprmProcess"));
        vars.setSessionValue("button017312F51139438A9665775E3B5392A1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button017312F51139438A9665775E3B5392A1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button017312F51139438A9665775E3B5392A1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("EM_APRM_Process", vars.getStringParameter("inpemAprmProcess"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button017312F51139438A9665775E3B5392A1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "017312F51139438A9665775E3B5392A1", request.getServletPath());
      } else if (vars.commandIn("BUTTON017312F51139438A9665775E3B5392A1")) {
        String strFIN_Doubtful_Debt_Run_ID = vars.getGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID", "");
        String stremAprmProcess = vars.getSessionValue("button017312F51139438A9665775E3B5392A1.stremAprmProcess");
        String strProcessing = vars.getSessionValue("button017312F51139438A9665775E3B5392A1.strProcessing");
        String strOrg = vars.getSessionValue("button017312F51139438A9665775E3B5392A1.strOrg");
        String strClient = vars.getSessionValue("button017312F51139438A9665775E3B5392A1.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_APRM_Process017312F51139438A9665775E3B5392A1(response, vars, strFIN_Doubtful_Debt_Run_ID, stremAprmProcess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_APRM_Process017312F51139438A9665775E3B5392A1")) {
        String strFIN_Doubtful_Debt_Run_ID = vars.getGlobalVariable("inpKey", windowId + "|FIN_Doubtful_Debt_Run_ID", "");
        
        ProcessBundle pb = new ProcessBundle("017312F51139438A9665775E3B5392A1", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("FIN_Doubtful_Debt_Run_ID", strFIN_Doubtful_Debt_Run_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);





    } else if (vars.commandIn("SAVE_XHR")) {
      
      OBError myError = new OBError();
      JSONObject result = new JSONObject();
      String commandType = vars.getStringParameter("inpCommandType");
      char saveType = "NEW".equals(commandType) ? 'I' : 'U';
      try {
        int total = saveRecord(vars, myError, saveType);
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          myError.setType("Success");
        }
        result.put("oberror", myError.toMap());
        result.put("tabid", vars.getStringParameter("tabID"));
        result.put("redirect", strDireccion + request.getServletPath() + "?Command=" + commandType);
      } catch (Exception e) {
        log4j.error("Error saving record (XHR request): " + e.getMessage(), e);
        myError.setType("Error");
        myError.setMessage(e.getMessage());
      }

      response.setContentType("application/json");
      PrintWriter out = response.getWriter();
      out.print(result.toString());
      out.flush();
      out.close();
    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
  private DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData data = new DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequiredGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.finDoubtfulDebtMethodId = vars.getStringParameter("inpfinDoubtfulDebtMethodId");     data.finDoubtfulDebtMethodIdr = vars.getStringParameter("inpfinDoubtfulDebtMethodId_R");     data.description = vars.getStringParameter("inpdescription");     data.rundate = vars.getRequiredGlobalVariable("inprundate", windowId + "|Rundate");     data.dateacct = vars.getRequiredStringParameter("inpdateacct");    try {   data.daysoverdue = vars.getRequiredNumericParameter("inpdaysoverdue", vars.getSessionValue(windowId + "|Daysoverdue"));  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.percentage = vars.getRequiredNumericParameter("inppercentage");  } catch (ServletException paramEx) { ex = paramEx; }     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_Bpartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cBpGroupId = vars.getRequestGlobalVariable("inpcBpGroupId", windowId + "|C_Bp_Group_ID");     data.cBpGroupIdr = vars.getStringParameter("inpcBpGroupId_R");     data.processDebt = vars.getRequiredStringParameter("inpprocessDebt");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.emAprmProcess = vars.getRequiredGlobalVariable("inpemAprmProcess", windowId + "|EM_APRM_Process");     data.finDoubtfulDebtRunId = vars.getRequestGlobalVariable("inpfinDoubtfulDebtRunId", windowId + "|FIN_Doubtful_Debt_Run_ID");     data.adClientId = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }




    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Rundate", data[0].getField("rundate"));    vars.setSessionValue(windowId + "|Daysoverdue", data[0].getField("daysoverdue"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BP_Group_ID", data[0].getField("cBpGroupId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|EM_APRM_Process", data[0].getField("emAprmProcess"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID", data[0].getField("finDoubtfulDebtRunId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData[] data = DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpfinDoubtfulDebtRunId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strFIN_Doubtful_Debt_Run_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamRundate = vars.getSessionValue(tabId + "|paramRundate");
String strParamPercentage = vars.getSessionValue(tabId + "|paramPercentage");
String strParamDaysoverdue = vars.getSessionValue(tabId + "|paramDaysoverdue");
String strParamRundate_f = vars.getSessionValue(tabId + "|paramRundate_f");
String strParamPercentage_f = vars.getSessionValue(tabId + "|paramPercentage_f");
String strParamDaysoverdue_f = vars.getSessionValue(tabId + "|paramDaysoverdue_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamRundate) && ("").equals(strParamPercentage) && ("").equals(strParamDaysoverdue) && ("").equals(strParamRundate_f) && ("").equals(strParamPercentage_f) && ("").equals(strParamDaysoverdue_f)) || !(("").equals(strParamRundate) || ("%").equals(strParamRundate))  || !(("").equals(strParamPercentage) || ("%").equals(strParamPercentage))  || !(("").equals(strParamDaysoverdue) || ("%").equals(strParamDaysoverdue))  || !(("").equals(strParamRundate_f) || ("%").equals(strParamRundate_f))  || !(("").equals(strParamPercentage_f) || ("%").equals(strParamPercentage_f))  || !(("").equals(strParamDaysoverdue_f) || ("%").equals(strParamDaysoverdue_f)) ;
    String strOffset = vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strFIN_Doubtful_Debt_Run_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strFIN_Doubtful_Debt_Run_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/advpaymentmngt/DoubtfulDebtRun/DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Relation", discard).createXmlDocument();

    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    ToolBar toolbar = new ToolBar(this, true, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD", false, "document.frmMain.inpfinDoubtfulDebtRunId", "grid", "..", "".equals("Y"), "DoubtfulDebtRun", strReplaceWith, false, false, false, false, !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    
    toolbar.setDeleteable(true && !hasReadOnlyAccess);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());



    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "finDoubtfulDebtRunId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Relation.html", "DoubtfulDebtRun", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"));
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }


    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean _boolNew, String strFIN_Doubtful_Debt_Run_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    // copy param to variable as will be modified later
    boolean boolNew = _boolNew;

    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamRundate = vars.getSessionValue(tabId + "|paramRundate");
String strParamPercentage = vars.getSessionValue(tabId + "|paramPercentage");
String strParamDaysoverdue = vars.getSessionValue(tabId + "|paramDaysoverdue");
String strParamRundate_f = vars.getSessionValue(tabId + "|paramRundate_f");
String strParamPercentage_f = vars.getSessionValue(tabId + "|paramPercentage_f");
String strParamDaysoverdue_f = vars.getSessionValue(tabId + "|paramDaysoverdue_f");

    boolean hasSearchCondition=false;
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamRundate) && ("").equals(strParamPercentage) && ("").equals(strParamDaysoverdue) && ("").equals(strParamRundate_f) && ("").equals(strParamPercentage_f) && ("").equals(strParamDaysoverdue_f)) || !(("").equals(strParamRundate) || ("%").equals(strParamRundate))  || !(("").equals(strParamPercentage) || ("%").equals(strParamPercentage))  || !(("").equals(strParamDaysoverdue) || ("%").equals(strParamDaysoverdue))  || !(("").equals(strParamRundate_f) || ("%").equals(strParamRundate_f))  || !(("").equals(strParamPercentage_f) || ("%").equals(strParamPercentage_f))  || !(("").equals(strParamDaysoverdue_f) || ("%").equals(strParamDaysoverdue_f)) ;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strFIN_Doubtful_Debt_Run_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strFIN_Doubtful_Debt_Run_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("finDoubtfulDebtRunId") == null || dataField.getField("finDoubtfulDebtRunId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars);
        data = DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.set(Utility.getDefault(this, vars, "Processed", "N", "681E982F747A48A6AF328A236A067559", "N", dataField), Utility.getDefault(this, vars, "EM_APRM_Process", "P", "681E982F747A48A6AF328A236A067559", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "798239EB069F41A9BA8EE040C63DDBBC", Utility.getDefault(this, vars, "EM_APRM_Process", "P", "681E982F747A48A6AF328A236A067559", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "798239EB069F41A9BA8EE040C63DDBBC", Utility.getDefault(this, vars, "EM_APRM_Process", "P", "681E982F747A48A6AF328A236A067559", "N", dataField))), Utility.getDefault(this, vars, "Daysoverdue", "0", "681E982F747A48A6AF328A236A067559", "0", dataField), Utility.getDefault(this, vars, "Description", "", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "Percentage", "100", "681E982F747A48A6AF328A236A067559", "0", dataField), Utility.getDefault(this, vars, "Updatedby", "", "681E982F747A48A6AF328A236A067559", "", dataField), DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.selectDef7EF22ECE491B4285BAA3AAFA12CE165D_0(this, Utility.getDefault(this, vars, "Updatedby", "", "681E982F747A48A6AF328A236A067559", "", dataField)), Utility.getDefault(this, vars, "Dateacct", "@#Date@", "681E982F747A48A6AF328A236A067559", "", dataField), "", "Y", Utility.getDefault(this, vars, "Rundate", "@#Date@", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "C_Bp_Group_ID", "", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "681E982F747A48A6AF328A236A067559", "", dataField), DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.selectDefD68088FB742A4925AD7EF196FE51E0BA_1(this, Utility.getDefault(this, vars, "Createdby", "", "681E982F747A48A6AF328A236A067559", "", dataField)), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "681E982F747A48A6AF328A236A067559", "", dataField), DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.selectDefE0C3D55C3A354C8096D0FB27F8147970_2(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "681E982F747A48A6AF328A236A067559", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "FIN_Doubtful_Debt_Method_ID", "", "681E982F747A48A6AF328A236A067559", "", dataField), Utility.getDefault(this, vars, "Process_Debt", "Y", "681E982F747A48A6AF328A236A067559", "N", dataField));
        
      }
     }
      
    
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    boolean editableTab = (!hasReadOnlyAccess && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (editableTab)
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/advpaymentmngt/DoubtfulDebtRun/DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Edition",discard).createXmlDocument();
    else
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/advpaymentmngt/DoubtfulDebtRun/DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_NonEditable",discard).createXmlDocument();

    xmlDocument.setParameter("tabId", tabId);
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpfinDoubtfulDebtRunId", "", "..", "".equals("Y"), "DoubtfulDebtRun", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strFIN_Doubtful_Debt_Run_ID), !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    toolbar.setDeleteable(true);
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    // set updated timestamp to manage locking mechanism
    if (!boolNew) {
      xmlDocument.setParameter("updatedTimestamp", (dataField != null ? dataField
          .getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp")));
    }
    
    boolean concurrentSave = vars.getSessionValue(tabId + "|concurrentSave").equals("true");
    if (concurrentSave) {
      //after concurrent save error, force autosave
      xmlDocument.setParameter("autosave", "Y");
    } else {
      xmlDocument.setParameter("autosave", "N");
    }
    vars.removeSessionValue(tabId + "|concurrentSave");

    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      // if (!strFIN_Doubtful_Debt_Run_ID.equals("")) xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  // else xmlDocument.setParameter("childTabContainer", tabs.childTabs(true));
	  xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Relation.html", "DoubtfulDebtRun", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"), !concurrentSave);
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.editionTemplate(strCommand.equals("NEW")));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
		
    
    
    xmlDocument.setParameter("commandType", strCommand);
    xmlDocument.setParameter("buscador",buscador);
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("changed", "");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    final String strMappingName = Utility.getTabURL(tabId, "E", false);
    xmlDocument.setParameter("mappingName", strMappingName);
    xmlDocument.setParameter("confirmOnChanges", Utility.getJSConfirmOnChanges(vars, windowId));
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));

    xmlDocument.setParameter("paramSessionDate", strParamSessionDate);

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    OBError myMessage = vars.getMessage(tabId);
    vars.removeMessage(tabId);
    if (myMessage!=null) {
      xmlDocument.setParameter("messageType", myMessage.getType());
      xmlDocument.setParameter("messageTitle", myMessage.getTitle());
      xmlDocument.setParameter("messageMessage", myMessage.getMessage());
    }
    xmlDocument.setParameter("displayLogic", getDisplayLogicContext(vars, boolNew));
    
    
     if (dataField==null) {
      xmlDocument.setData("structure1",data);
      
    } else {
      
        FieldProvider[] dataAux = new FieldProvider[1];
        dataAux[0] = dataField;
        
        xmlDocument.setData("structure1",dataAux);
      
    }
    
      
   
    try {
      ComboTableData comboTableData = null;
String userOrgList = "";
if (editableTab) 
  userOrgList=Utility.getContext(this, vars, "#User_Org", windowId, accesslevel); //editable record 
else 
  userOrgList=currentOrg;
comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", userOrgList, Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("adOrgId"):dataField.getField("adOrgId")));
xmlDocument.setData("reportAD_Org_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "19", "FIN_Doubtful_Debt_Method_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("finDoubtfulDebtMethodId"):dataField.getField("finDoubtfulDebtMethodId")));
xmlDocument.setData("reportFIN_Doubtful_Debt_Method_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("Rundate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
xmlDocument.setParameter("Dateacct_Format", vars.getSessionValue("#AD_SqlDateFormat"));
comboTableData = new ComboTableData(vars, this, "19", "C_Bp_Group_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("cBpGroupId"):dataField.getField("cBpGroupId")));
xmlDocument.setData("reportC_Bp_Group_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("Process_Debt_BTNname", Utility.getButtonName(this, vars, "5519FEE5F9E042CFAD01946509EF8996", "Process_Debt_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalProcess_Debt = org.openbravo.erpCommon.utility.Utility.isModalProcess(""); 
xmlDocument.setParameter("Process_Debt_Modal", modalProcess_Debt?"true":"false");
xmlDocument.setParameter("EM_APRM_Process_BTNname", Utility.getButtonName(this, vars, "798239EB069F41A9BA8EE040C63DDBBC", (dataField==null?data[0].getField("emAprmProcess"):dataField.getField("emAprmProcess")), "EM_APRM_Process_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalEM_APRM_Process = org.openbravo.erpCommon.utility.Utility.isModalProcess("017312F51139438A9665775E3B5392A1"); 
xmlDocument.setParameter("EM_APRM_Process_Modal", modalEM_APRM_Process?"true":"false");
xmlDocument.setParameter("Created_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Created_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
xmlDocument.setParameter("Updated_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Updated_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new ServletException(ex);
    }

    xmlDocument.setParameter("scriptOnLoad", getShortcutScript(usedButtonShortCuts, reservedButtonShortCuts));
    
    final String refererURL = vars.getSessionValue(tabId + "|requestURL");
    vars.removeSessionValue(tabId + "|requestURL");
    if(!refererURL.equals("")) {
    	final Boolean failedAutosave = (Boolean) vars.getSessionObject(tabId + "|failedAutosave");
		vars.removeSessionValue(tabId + "|failedAutosave");
    	if(failedAutosave != null && failedAutosave) {
    		final String jsFunction = "continueUserAction('"+refererURL+"');";
    		xmlDocument.setParameter("failedAutosave", jsFunction);
    	}
    }

    if (strCommand.equalsIgnoreCase("NEW")) {
      vars.removeSessionValue(tabId + "|failedAutosave");
      vars.removeSessionValue(strMappingName + "|hash");
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }



    void printPageButtonEM_APRM_Process017312F51139438A9665775E3B5392A1(HttpServletResponse response, VariablesSecureApp vars, String strFIN_Doubtful_Debt_Run_ID, String stremAprmProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 017312F51139438A9665775E3B5392A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_APRM_Process017312F51139438A9665775E3B5392A1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strFIN_Doubtful_Debt_Run_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "017312F51139438A9665775E3B5392A1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("017312F51139438A9665775E3B5392A1");
        vars.removeMessage("017312F51139438A9665775E3B5392A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button017312F51139438A9665775E3B5392A1.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }


    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.finDoubtfulDebtRunId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDDData.getCurrentDBTimestamp(this, data.finDoubtfulDebtRunId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.finDoubtfulDebtRunId = "";
                }
                else {                    
                    
                        //BUTTON TEXT FILLING
                    data.emAprmProcessBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "798239EB069F41A9BA8EE040C63DDBBC", data.getField("EM_APRM_Process"));
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|FIN_Doubtful_Debt_Run_ID", data.finDoubtfulDebtRunId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet DoubtfulDebtRunFA66A130BE8B48E88BF4F5A6E2FA0CDD. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
