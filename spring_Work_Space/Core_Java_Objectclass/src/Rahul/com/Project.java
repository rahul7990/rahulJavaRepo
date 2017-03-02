package Rahul.com;

public class Project {}

Utility Class In ePortalService
package com.expressvu.callcentre.common.helper;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


/**
 * This class hold some useful Date manipulation methods.
 * 
 * @author sarguin
 */
public abstract class DateUtil
{
	//Timezone equivalency (IDs used for each defined timezones):
	public static final String TIMEZONE_PACIFIC = "Canada/Pacific";
	public static final String TIMEZONE_MOUNTAIN = "Canada/Mountain"; 
	public static final String TIMEZONE_CENTRAL = "Canada/Central"; 
	public static final String TIMEZONE_EASTERN = "Canada/Eastern";
	public static final String TIMEZONE_ATLANTIC = "Canada/Atlantic"; 
	public static final String TIMEZONE_NEWFOUNDLAND = "Canada/Newfoundland";
	public static final String TIMEZONE_GMT = "Etc/Universal";
	public static final String TIMEZONE_DEFAULT = TIMEZONE_EASTERN;
    
    // ISO 8601 format
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ssZ";
    
    // 
	public static final String NOT_APPLICABLE = "N/A";
	
	
    //-------------------------------------------------------------------[ API ]- 
    /**
     * Format a Date instance to a String.
     * 
     * @param pDate Date to format
     * @param pFormat Date format
     * 
     * @return String representation of the Date.  If the pDate parameter is null, an empty String is returned.
     */
    public static String date2String(final Date pDate, final String pFormat) 
    {
        // Validate format
        if (StringUtil.isEmpty(pFormat)) {
            throw new IllegalArgumentException("You must provided a non-empty date format");
        }
        if (pDate == null) {
            throw new IllegalArgumentException("You must provided a non-null Date");
        }
        
        // Convert date to String
        String lResult = "";
        
        if (pDate != null) {
            final SimpleDateFormat lFormatter = new SimpleDateFormat(pFormat);

            lResult = lFormatter.format(pDate);
        }

        return lResult;
    }
    
	public static Date addMonths( Date date, int months ) {	
		 Calendar calendar = new GregorianCalendar();
	     calendar.setTime( date );
	     calendar.add( Calendar.MONTH, months );	    
	    return calendar.getTime();  
	}
	
	
	

    /**
     * Format a Date instance to an ISO 8601 String format.
     * 
     * @param pDate Date to format
     * 
     * @return ISO 8601 String representation of the Date.  If the pDate parameter is null, an empty String is returned.
     */
    public static String date2ISO8601(final Date pDate) 
    {
        // Validate format
        if (pDate == null) {
            throw new IllegalArgumentException("You must provided a non-null Date");
        }

        return date2String(pDate, ISO_8601);
    }
    
    /**
     * Format a String instance to a Date.
     * 
     * @param pDate Date to format
     * @param pFormat Date format
     * 
     * @return Date instance.
     * 
     * @exception DateException Thrown if it's impossible to parse the date.
     */
    public static Date string2Date(final String pDate, final String pFormat)
        throws DateException
    {
        // Validate parameters
        if (StringUtil.isEmpty(pFormat)) {
            throw new IllegalArgumentException("You must provided a non-empty date format");
        }
        if (StringUtil.isEmpty(pDate)) {
            throw new IllegalArgumentException("You must provided a non-empty String (date)");
        }
        
        // Convert date to String
        Date lResult = null;
        final SimpleDateFormat lFormatter = new SimpleDateFormat(pFormat);

        try {
            lResult = lFormatter.parse(pDate);
        } catch (ParseException e) {
            throw new DateException("Unable to parse date", e);            
        }

        return lResult;
    }

    /**
     * Format a String in ISO 8601 format instance to a Date.
     * 
     * @param pDate Date to format
     * 
     * @return Date instance.
     * 
     * @exception DateException Thrown if it's impossible to parse the date.
     */
    public static Date ISO8601String2Date(final String pDate)
        throws DateException
    {
        // Validate parameters
        if (StringUtil.isEmpty(pDate)) {
            throw new IllegalArgumentException("You must provided a non-empty String (date)");
        }
        
        // Convert date to String
        return string2Date(pDate, ISO_8601);
    }

    /**
     * Format a String instance to a Date.
     * 
     * @param pDate Date to format
     * @param pFormat Date format
     * @param pTimezone Convert using provided timezone
     * 
     * @return Date instance.
     * 
     * @exception DateException Thrown if it's impossible to parse the date.
     */
    public static Date string2Date(final String pDate, final String pFormat, final TimeZone pTimezone)
        throws DateException
    {
        // Validate parameters
        if (StringUtil.isEmpty(pFormat)) {
            throw new IllegalArgumentException("You must provided a non-empty date format");
        }
        if (StringUtil.isEmpty(pDate)) {
            throw new IllegalArgumentException("You must provided a non-empty String (date)");
        }
        if (pTimezone == null) {
            throw new IllegalArgumentException("You must provided a non-empty timezone");
        }
        
        // Convert date to String
        Date lResult = null;
        final SimpleDateFormat lFormatter = new SimpleDateFormat(pFormat);

        try {
            lFormatter.setTimeZone(pTimezone);
            lResult = lFormatter.parse(pDate);
        } catch (ParseException e) {
            throw new DateException("Unable to parse date", e);            
        }

        return lResult;
    }
    
	
	/**
	 * This method will effectively substract pFartherDate - pCloserDate and
	 * give the result in minutes.
	 * 
	 * @param pCloserDate
	 * @param pFartherDate
	 * @return
	 */
	public static long substractDatesInMinutes(final Date pCloserDate,
			final Date pFartherDate) {
		if (pCloserDate == null || pFartherDate == null) {
			throw new IllegalArgumentException(
					"Cannot substract dates that are null.");
		}

		final Calendar lCalendar1 = Calendar.getInstance();
		lCalendar1.setTime(pCloserDate);
		long lMillis1 = lCalendar1.getTimeInMillis();

		final Calendar lCalendar2 = Calendar.getInstance();
		lCalendar2.setTime(pFartherDate);
		long lMillis2 = lCalendar2.getTimeInMillis();

		long lSubstractedInMin = (lMillis2 - lMillis1) / (1000L * 60L);

		return lSubstractedInMin;
	}
	
	/**
     * Format Current Date instance to a String.
     * 
     * @param pFormat Date format
     * 
     * @return String representation of the Date.  If the nowDate is null, an empty String is returned.
     */
    public static String currentDate2String( final String pFormat) 
    {
        // Validate formats
        if (StringUtil.isEmpty(pFormat)) {
            throw new IllegalArgumentException("You must provided a non-empty date format");
        }
        Date nowDate= new Date();      
        // Convert date to String
        String lResult = "";
        
        if (nowDate != null) {
            final SimpleDateFormat lFormatter = new SimpleDateFormat(pFormat);
           
            lResult = lFormatter.format(nowDate);
        }

        return lResult;
    }

	/**
	 * This method checks whether the given date is after or equal to current
	 * date
	 * 
	 * @param date1  - Date to compare
	 * @return <true>- given date is after or equal to current date
	 * 			<false> - otherwise
	 */
	public static boolean isAfterOrEqualToCurrentDate(Date date1) {
		Date date2 = new Date();
		return (after(date1, date2) || equal(date1, date2));
	}

	/**
	 * This method checks whether the given date is after current
	 * date
	 * 
	 * @param date1- Date to compare
	 * @return <true>- given date is after current date
	 * 			<false> - otherwise
	 */
	public static boolean isAfterCurrentDate(Date date1) {
		return (after(date1, new Date()));
	}
    
	/**
	 * This method checks whether the given date is before current
	 * date
	 * 
	 * @param date1- Date to compare
	 * @return <true>- given date is before current date
	 * 			<false> - otherwise
	 */
	public static boolean isBeforeCurrentDate(Date date1) {
		return (before(date1, new Date()));
	}
    
    /**
	 * This method checks whether the date1 is the same date1 as date2.
	 * 
	 * @param date1 
	 * @param date2
	 * @return <true>- if both given dates are equal.
	 * 			<false> - otherwise
	 */
	public static boolean equal(Date date1, Date date2) {
		boolean equal = false;
		Calendar calendar = Calendar.getInstance();
		if (date1 != null && date2 != null) {
			calendar.setTime(date1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH);
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);

			calendar.setTime(date2);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH);
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);

			if (year1 == year2 && month1 == month2 && day1 == day2) {
				equal = true;
			}
		}
		return equal;
	}

	/**
	 * This method checks wehther the date1 is after date2.
	 * 
	 * @param date1
	 * @param date2
	 * @return <true>  - if date1 is after date2
	 * 		   <false> - otherwise
	 */
	public static boolean after(Date date1, Date date2) {
		boolean after = false;
		if (date1 != null && date2 != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH);
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.setTime(date2);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH);
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);

			if (year1 > year2) {
				after = true;
			} else if (year1 == year2 && month1 > month2) {
				after = true;
			} else if (year1 == year2 && month1 == month2 && day1 > day2) {
				after = true;
			}
		}
		return after;
	}

	/**
	 * This method checks whether date1 is before date2.
	 * Comparing dates only without time consideration!!
	 * @param date1
	 * @param date2
	 * @return <true>  - if date1 is before date2
	 * 		   <false> - otherwise
	 */
	public static boolean before(Date date1, Date date2) {
		boolean before = false;
		if (date1 != null && date2 != null) {
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(date1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH);
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);

			calendar.setTime(date2);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH);
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);

			if (year1 < year2) {
				before = true;
			} else if (year1 == year2 && month1 < month2) {
				before = true;
			} else if (year1 == year2 && month1 == month2 && day1 < day2) {
				before = true;
			}
		}
		return before;
	}

	/**
	 * This method adds given days with current date and return date.
	 * 
	 * @param days - the no of days need to add with current date.
	 * @return Date
	 */
	public static Date addDaysToCurrentDate(int days) {
		return addDays(new Date(), days);
	}

	/**
	 * This method adds given days with given date and return date.
	 * 
	 * @param date
	 * @param days
	 * @return result 
	 */
	public static Date addDays(Date date, int days) {
		Date result = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, days);
			result = calendar.getTime();
		}
		return result;
	}
	
	
	public static String calenderToString(Calendar calendar,String format){
		String formattedDate=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			formattedDate = sdf.format(calendar.getTime());
		}catch(Exception e){
		}
		
		return formattedDate;
		
	}
	
	/**
	 * 
	 * @param date
	 * @return formatedDate
	 */
	public static String formatDate(Date date, Locale locale){
		String formatedDate = NOT_APPLICABLE;
		if( date == null )
		{
			return formatedDate;
		}
		else
		{
			return (new SimpleDateFormat("MMMM dd,yyyy", locale).format(date));
		}
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatMonth(Date date){
		String formatedDate = NOT_APPLICABLE;
		if( date == null )
		{
			return formatedDate;
		}
		else
		{
			return (new SimpleDateFormat("MMMM").format(date));
		}
		
	}
	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatMonthYear(Calendar calendar, Locale locale){
		String formatedDate = "N/A";
		if( calendar == null )
		{
			return formatedDate;
		}
		else
		{
			return (new SimpleDateFormat("MMMM, yyyy", locale).format(calendar.getTime()));
		}
	}
	/**
	 * @param calendar
	 * @param calendar2
	 * @return
	 */
	public static int monthElapsed(Calendar calendar, Calendar calendar2)
	{	
		int noOfMonthsDiff = (calendar.get(Calendar.MONTH)-calendar2.get(Calendar.MONTH))+ (12*(calendar.get(Calendar.YEAR)-calendar2.get(Calendar.YEAR)));
		return noOfMonthsDiff;
	}
	/**
	 * @param calendar
	 * @return
	 */
	public static String formatMonth(Calendar calendar){
		String formatedDate = "N/A";
		if( calendar == null )
		{
			return formatedDate;
		}
		else
		{
			return (new SimpleDateFormat("MMMM").format(calendar.getTime()));
		}
	}
	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar, Locale locale){
		String formatedDate = "N/A";
		if( calendar == null )
		{
			return formatedDate;
		}
		else
		{
			return (new SimpleDateFormat("MMMM dd,yyyy", locale).format(calendar.getTime()));
		}
	}
	
	/**
	 * 
	 * @param gmtDate
	 * @return
	 * @throws ParseException
	 */
	public static String gmtToEst(String gmtDate, String dateFormat) throws DateException {
		if (gmtDate == null || "".equals(gmtDate.trim())) {
			return "";
		}else {
	        SimpleDateFormat gmtFormat = new SimpleDateFormat(dateFormat);
	        SimpleDateFormat estFormat = new SimpleDateFormat(dateFormat);
	        TimeZone gmtTime = TimeZone.getTimeZone(TIMEZONE_GMT);
	        gmtFormat.setTimeZone(gmtTime);
	        TimeZone estTime = TimeZone.getTimeZone(TIMEZONE_EASTERN);
	        estFormat.setTimeZone(estTime);
		try {
				return estFormat.format(gmtFormat.parse(gmtDate));
			} catch (ParseException e) {
				throw new DateException("Unable to parse date", e);
			}
		}
  }
	/**
	 * Converts date from EST to GMT format 
	 * @param estDate
	 * @return
	 * @throws ParseException
	 */
	public static String estToGmt(String estDate, String dateFormat) throws DateException {
		if (estDate == null || "".equals(estDate.trim())) {
			return "";
		}
 	else {
	        SimpleDateFormat gmtFormat = new SimpleDateFormat(dateFormat);
	        SimpleDateFormat estFormat = new SimpleDateFormat(dateFormat);
	        TimeZone gmtTime = TimeZone.getTimeZone(TIMEZONE_GMT);
	        gmtFormat.setTimeZone(gmtTime);
	        TimeZone estTime = TimeZone.getTimeZone(TIMEZONE_EASTERN);
	        estFormat.setTimeZone(estTime);
			try {
				return gmtFormat.format(estFormat.parse(estDate));
			} catch (ParseException e) {
				throw new DateException("Unable to parse date", e);
			}
		}
  }
	
	/**
	 * To provide current date
	 * @return Calendar
	 */
	public static Calendar getCurrentDate()
	{
	    final Calendar now = Calendar.getInstance();
	    final Calendar temp = Calendar.getInstance();

	    temp.clear();
	    temp.set(Calendar.YEAR, now.get(Calendar.YEAR));
	    temp.set(Calendar.MONTH, now.get(Calendar.MONTH));
	    temp.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
	    return temp;
	}
}

=======================================================================

package portlets.searchcustomer;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.scoping.ScopedServletUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.expressvu.callcentre.common.beans.AgentProfile;
import com.expressvu.callcentre.common.beans.AgentProfile.SecurityAgentRole;
import com.expressvu.callcentre.common.beans.calltracking.CategoryAndRfc;
import com.expressvu.callcentre.common.beans.customer.CustomerProfile;
import com.expressvu.callcentre.common.beans.ChannelOrder;
import com.expressvu.callcentre.common.business.BusinessException;
import com.expressvu.callcentre.common.business.BusinessNotice;
import com.expressvu.callcentre.common.business.MessageTypeEnum;
import com.expressvu.callcentre.common.configuration.MultiVuConfigurationFactory;
import com.expressvu.callcentre.common.db.persistence.calltracking.CallTrackingItem;
import com.expressvu.callcentre.common.db.persistence.calltracking.Rfc;
import com.expressvu.callcentre.common.db.persistence.customerprofile.Subscriber;
import com.expressvu.callcentre.common.db.persistence.ivr.IvrCallreason;
import com.expressvu.callcentre.common.db.persistence.ivr.IvrTab;
import com.expressvu.callcentre.common.db.persistence.reporting.ReportingData;
import com.expressvu.callcentre.common.helper.LogHelper;
import com.expressvu.callcentre.common.helper.StringUtil;
import com.expressvu.callcentre.portal.customerManager.CustomerManager;
import com.expressvu.callcentre.portal.esbManager.ESBManager;
import com.expressvu.callcentre.portal.esbManager.ESBManagerReal;
import com.expressvu.callcentre.portal.formbeans.MultiVuBaseFormBean;
import com.expressvu.callcentre.portal.listener.ServletContextHelper;
import com.expressvu.callcentre.portal.util.Constants;
import com.expressvu.callcentre.portal.util.ContentDisplayHelper;
import com.expressvu.callcentre.portal.util.MessageHelper;
import com.expressvu.callcentre.portal.util.NavigationHelper;
import com.expressvu.callcentre.portal.util.ReportingManager;
import com.expressvu.callcentre.portal.util.SessionHelper;
import com.expressvu.callcentre.portal.util.SessionInfo;
import com.expressvu.callcentre.portal.util.WebServiceClientsHelper;
import com.expressvu.callcentre.webservice.accountSearch.AccountInfo;
import com.expressvu.callcentre.webservice.accountSearch.SearchAccountRequest;
import com.expressvu.callcentre.webservice.accountSearch.SearchAccountResponse;
import com.expressvu.callcentre.webservice.accountSearch.SearchFilter;
import com.expressvu.callcentre.webservice.accountSearch.ServiceAddress;
import com.expressvu.callcentre.webservice.accountSearch.frontend.AccountSearchServicePortType;
import com.expressvu.callcentre.webservice.equipmentManagement.frontend.WSExceptionDetail;

import controls.ejb.CallTrackingEJBControl;
import controls.ejb.CustomerEJBControl;
import controls.ejb.ReportingEJBControl;

/**
 * Controller for SearchCustomer.
 *
 * @author sarguin
 */
public class SearchCustomerAction extends Action {
	
	private static final long serialVersionUID = 1L;
	public static final String REQUEST_ATTR_NOT_FOUND = "notFound";
	public static final String REQUEST_ATTR_ACCOUNTS_LIST = "accountsList";
	public static final String MAXPLUS_ACCOUNT_NO = "AN";
	public static final String MAXPLUS_LANGUAGE = "Lang";
	public static final String MAXPLUS_REF_PHONE = "TN";
	public static final String MAXPLUS_CALL_PHONE = "CL";
	public static final String MAXPLUS_CSR_DUMPED = "TRAG";
	public static final String MAXPLUS_DATA = "DATA";
	public static final String MAXPLUS_CALL_ID = "CID";
	private final int MAX_DISPLAYED_RECORDS=20;

	private static final String MAXPLUS_TAB_TECHTOOLS = "techtools";

	private static final String MAXPLUS_TAB_EQUIPMENT = "technical";

	// other possible forward
	private static final String TAB_CUSTOMER_PROFILE = "customerProfile";

	private static final String MULTIVU_CHANNEL = "CD";
	private static final String ERROR_ACCOUNT_NOT_FOUND = "error.search.accountNumberNotFound";

	//Activation Controller session objects --start
	private final String REMOVE_ACTIVATE_ACCOUNT_FLAG="removeActivateAccountFlag";
	private final String REMOVE_LOCATION="removeLocation";
	private final String DISABLE_SERVICE_DEPENDENTS_DATA="disableServiceDependents";
	private final String SEARCH_ADDRESS_LIST="searchAddressList";
	private final String TOTAL_SEARCH_ADDRESS_LIST="totalSearchAddressList";
	//private final String BILLING_UPDATE_REQUIRED ="billUpdateRequired";

	private static final int beginIndexSystem=0;
	private static final int endIndexSystem=4;
	private static final String DEFAULT_SYSTEM_NUMBER="8455";
	private static final String TRAINING_SYSTEM_NUMBER="8459";
	private static final String WL_IPTVLEVEL1_ROLE_ID=SecurityAgentRole.IPTVLEVEL1.toString();
	private static final String WL_IPTVLEVEL2_ROLE_ID=SecurityAgentRole.IPTVLEVEL2.toString();

	public static final String IS_NEW_IPTV_ACCOUNTCREATION = "isNewIPTVAccountCreation";
	//Activation Controller session objects --END
	public static final String IS_ORDER_SEARCH = "isOrderSearch";
	public static final String YES = "Y";
	public static final String NO = "N";

	NonCustFormBean nonCustFormBean = new NonCustFormBean();
	@Control
	private CustomerEJBControl customerEjbControl;

	@Control
	private CallTrackingEJBControl callTrackingEjbControl;

	@Control
	private ReportingEJBControl reportingEjbControl;

	/**
	 * Search for customer(s) based on phoneNumber or accountNumber. If more
	 * than one customer is returned, the list is stored in the Request scope
	 * (REQUEST_ATTR_ACCOUNTS_LIST).
	 *
	 * @param pForm
	 *            Search criterias
	 *
	 * @return Forward to the next page.
	 *
	 * @exception RemoteException
	 *                Thrown if a fatal EJB error occured.
	 */
	@Jpf.Action(forwards = {
			@Jpf.Forward(name = "success", redirect = true, path = NavigationHelper.TAB_CALL_SUMMARY),
			@Jpf.Forward(name = "many-accounts", path = "index.jsp"),
			@Jpf.Forward(name = "not-found", path = "index.jsp"),
			@Jpf.Forward(name = TAB_CUSTOMER_PROFILE, redirect = true, path = NavigationHelper.BOOK_CUSTOMER_PROFILE),
			@Jpf.Forward(name = MAXPLUS_TAB_BILLING, redirect = true, path = NavigationHelper.BOOK_BILLING),
			@Jpf.Forward(name = MAXPLUS_TAB_TECHTOOLS, redirect = true, path = NavigationHelper.BOOK_TECHTOOLS),
			@Jpf.Forward(name = MAXPLUS_TAB_EQUIPMENT, redirect = true, path = NavigationHelper.BOOK_EQUIPMENT) }, validationErrorForward = @Jpf.Forward(name = "fail", path = "index.jsp"), validatableProperties = {
		@Jpf.ValidatableProperty(propertyName = "accountNumber", validateMask = @Jpf.ValidateMask(regex = "^[0-9]{16}$", messageKey = "error.search.invalid", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.accountNumber") })),
		@Jpf.ValidatableProperty(propertyName = "phoneNumber", validateMask = @Jpf.ValidateMask(regex = "^[0-9]{10}$", messageKey = "error.search.invalid", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.phoneNumber") })),
		@Jpf.ValidatableProperty(propertyName = "receiverNumber", validateMinLength = @Jpf.ValidateMinLength(messageKey = "errors.minlength", messageArgs = {
				@Jpf.MessageArg(argKey = "search.receiverNumber", position = 0),
				@Jpf.MessageArg(arg = "11", position = 1) }, chars = 11), validateMask = @Jpf.ValidateMask(messageKey = "errors.receiver", messageArgs = {
						@Jpf.MessageArg(argKey = "search.receiverNumber", position = 0),
						@Jpf.MessageArg(argKey = "jsp.common.receiverPattern", position = 1) }, regex = "^((.{0})|(R[\\w]{2}[0-9]{8}))$")),
						@Jpf.ValidatableProperty(propertyName = "smartCardNumber", validateMinLength = @Jpf.ValidateMinLength(messageKey = "errors.minlength", messageArgs = {
								@Jpf.MessageArg(argKey = "search.smartCardNumber", position = 0),
								@Jpf.MessageArg(arg = "11", position = 1) }, chars = 11), validateMask = @Jpf.ValidateMask(messageKey = "errors.receiver", messageArgs = {
										@Jpf.MessageArg(argKey = "search.smartCardNumber", position = 0),
										@Jpf.MessageArg(argKey = "jsp.common.smartcardPattern", position = 1) }, regex = "^((.{0})|(S[\\w]{2}[0-9]{8}))$")),
										@Jpf.ValidatableProperty(displayNameKey = "search.lastNameFirstName", propertyName = "lastNameFirstName",
												validateMaxLength = @Jpf.ValidateMaxLength(messageKey = "errors.maxlength", chars = 26)),
												@Jpf.ValidatableProperty(propertyName = "macAddress", validateMask = @Jpf.ValidateMask(regex = "^[0-9A-Z]{12}$", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.macAddress") }, messageKey = "error.search.invalid")),
												@Jpf.ValidatableProperty(propertyName = "b1Number", validateMask = @Jpf.ValidateMask(regex = "^[0-9A-Z]{8}$", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.b1Number") }, messageKey = "error.search.invalid")),
												@Jpf.ValidatableProperty(validateMask = @Jpf.ValidateMask(regex = "^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.postalCode") }, messageKey = "error.search.invalid"), propertyName = "postalCode"),
												@Jpf.ValidatableProperty(propertyName = "streetNumberName", validateMask = @Jpf.ValidateMask(regex = "^[0-9A-Z' ']+$", messageArgs = { @Jpf.MessageArg(position = 0, argKey = "search.streetNumberAndNameLabel") }, messageKey = "error.search.invalid"))
	})
	public Forward search(final SearchFormBean pForm) throws RemoteException,BusinessException {
		Forward lForward = new Forward("success");
		final HttpSession lSession = getSession();
		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(lSession);
		final HttpServletRequest lRequest = getRequest();
		SessionHelper.setIsSearchOrder(getSession(), pForm.getSearchStatus());
		getRequest().getSession().removeAttribute("channelOrderId");
		if ((pForm.getPostalCode() != null && !pForm.getPostalCode().equals("")) && (pForm.getStreetNumberName()==null || pForm.getStreetNumberName().equals(""))) {
			LogHelper.error(this.getClass(), "Failed to search, street number name is empty ");
			MessageHelper.saveMessage(getRequest(),
					MessageTypeEnum.MESSAGE_ERROR, "error.streetNumberName.required", null);
			return new Forward("fail");
		}else if ((pForm.getStreetNumberName() != null && !pForm.getStreetNumberName().equals("")) && (pForm.getPostalCode()==null || pForm.getPostalCode().equals(""))) {
			LogHelper.error(this.getClass(), "Failed to search, postal code is empty ");
			MessageHelper.saveMessage(getRequest(),
					MessageTypeEnum.MESSAGE_ERROR, "error.postalCode.required", null);
			return new Forward("fail");
		}else if(pForm.getStreetNumberName()!=null && pForm.getPostalCode() != null &&
				!pForm.getStreetNumberName().equals("")&& !pForm.getPostalCode().equals("")) {
			//do nothing

		}
		String agentGroupID= ContentDisplayHelper.getGroup(lSession);
		String accountGroupID= ContentDisplayHelper.getAccountGroup(pForm.accountNumber);

		if ((accountGroupID!= null && !accountGroupID.equals("")))
		{
			/*
			 * IPTV single account is not displayed for DTH group agents
			 * DTH single account is not diaplayed for users with TECHNICIAN_IPTV role
			 *
			 */

			boolean isAccountAccessNotAllowed=false;
			if(agentGroupID.equals(Constants.DTH_GROUP) && (!accountGroupID.equals(Constants.DTH_GROUP))){
				isAccountAccessNotAllowed=true;
			}
			
			if(ContentDisplayHelper.isUserTECHNICIANGroup(getSession())&&ContentDisplayHelper.isUserTECHNICIAN_IPTVRole(getSession())
					 && accountGroupID.equals(Constants.DTH_GROUP)){
				isAccountAccessNotAllowed=true;
			}
			if(ContentDisplayHelper.isUserTECHNICIANGroup(getSession())&&ContentDisplayHelper.isUserRT_IPTVRole(getSession())
					 && accountGroupID.equals(Constants.DTH_GROUP)){
				isAccountAccessNotAllowed=true;
			}

			if(	isAccountAccessNotAllowed  )
			{
				LogHelper.error(this.getClass(), "Failed to search, Access Denied ");
				MessageHelper.saveMessage(getRequest(),
						MessageTypeEnum.MESSAGE_ERROR, "error.search.noAccessAllowed", null);
				return new Forward("fail");
			}
			/*
			 * commented  to give access to iptv acc for iptv level 1
			else if(agentGroupID.equals(Constants.IPTV_GROUP) && accountGroupID.equals(Constants.IPTV_GROUP)){
				if(SessionHelper.getAgentProfile(getSession()).getSecurityAgentRole().toString().equals(WL_IPTVLEVEL1_ROLE_ID))
				{
					LogHelper.error(this.getClass(), "Failed to search, Access Denied ");
					MessageHelper.saveMessage(getRequest(),
							MessageTypeEnum.MESSAGE_ERROR, "error.search.noAccessAllowed", null);
					return new Forward("fail");
				}
				else{
					//Allow to access.
				}


			}*/
		}
		// Start session timer (one time per session)
		/*
		if (lSessionInfo.getSessionStartTime() == 0) {
			lSessionInfo.setSessionStartTime(System.currentTimeMillis());
		}
		*/
		lSessionInfo.setSessionStartTime(System.currentTimeMillis());

		// reset the Non-Customer Tracking form upon a new search
		nonCustFormBean.clear();

		try {
			// Process information sent by Max+ (one time per session)
			if (lSessionInfo.getIvrCallReasonCode() == null) {
				final HttpServletRequest lOuterRequest = ScopedServletUtils
				.getOuterRequest(lRequest);
				if (!processMaxPlusInfo(lOuterRequest, pForm)) {
					return new Forward("fail");
				}
			}

			// Search : Handle the AccountNumber first if provided, else use the
			// phone number.
			String lAccountNumber = pForm.getAccountNumber();
			final String lPhoneNumber = pForm.getPhoneNumber();
			if (lAccountNumber != null && lAccountNumber.trim().length() > 0)
			{
				//Defect : 564 fix.
				if(lRequest.getParameter("customerNameClicked")!=null &&
						lRequest.getParameter("customerNameClicked").equals("true")){
					return singleSubscriberRecordFound(lAccountNumber);

				}else{
					return retrieveAccountSearchResults(null, lAccountNumber,null, null, null, null, null, null, null,pForm);
				}


			} else if (pForm.getSmartCardNumber() != null && pForm.getSmartCardNumber().trim().length() > 0)
			{
				String smartCardNumber = pForm.getSmartCardNumber().trim();
				return retrieveAccountSearchResults(null, null,null, smartCardNumber, null, null, null, null, null, pForm);
			} else if (pForm.getReceiverNumber() != null && pForm.getReceiverNumber().trim().length() > 0)
			{
				String receiverNumber = pForm.getReceiverNumber().trim();
				return retrieveAccountSearchResults(null, null,receiverNumber, null, null,null, null, null, null,pForm);
			} else if (lPhoneNumber != null && lPhoneNumber.trim().length() > 0)
			{
				return retrieveAccountSearchResults(lPhoneNumber, null,null, null, null,null, null, null, null,pForm);
			} else if (pForm.getLastNameFirstName() != null	&& pForm.getLastNameFirstName().trim().length() > 0) {
				String name = pForm.getLastNameFirstName().trim();
				return retrieveAccountSearchResults(null, null,	null, null, name,null, null, null, null,pForm);
			}
			else if (pForm.getB1Number() != null && pForm.getB1Number().trim().length() > 0) {
				String b1Number = pForm.getB1Number().trim();
				return retrieveAccountSearchResults(null, null,null, null, null,null, b1Number, null, null, pForm);
			}
			else if ((pForm.getStreetNumberName() != null && pForm.getStreetNumberName().trim().length() > 0)
					&& (pForm.getPostalCode() != null && pForm.getPostalCode().trim().length() > 0)) {
				String streetNumberName = pForm.getStreetNumberName().trim();
				String postalCode = pForm.getPostalCode().trim();
				return retrieveAccountSearchResults(null, null,null, null, null,null, null, streetNumberName, postalCode, pForm);
			}
			else if (pForm.getMacAddress() != null && pForm.getMacAddress().trim().length() > 0) {
				String macAddress = pForm.getMacAddress().trim();
				return retrieveAccountSearchResults(null, null,null, null, null,macAddress, null, null, null,pForm);
			}
		} catch (BusinessException e) {
			LogHelper.debug(this.getClass(), "Unable to find customer", e);
			MessageHelper.saveMessage(lRequest, e);
			lForward = new Forward("fail");
		} catch (RemoteException e) {
			LogHelper.critical(this.getClass(),
					"Problem with remote EJB call.", e);
			throw e;
		}

		return lForward;
	}


	/**
	 * Add a Non-Customer note.
	 *
	 * @param pForm
	 *            The optional SearchFormBean for this request (if any).
	 *
	 * @return Returns an <code>Forward</code>.
	 *
	 * @throws Exception
	 *             if an error occurs.
	 */
	@Jpf.Action(useFormBean = "nonCustFormBean", forwards = { @Jpf.Forward(name = "success", navigateTo = Jpf.NavigateTo.currentPage) }, validationErrorForward = @Jpf.Forward(name = "fail", navigateTo = Jpf.NavigateTo.currentPage), validatableProperties = {
		@Jpf.ValidatableProperty(propertyName = "noCategory", validateRequired = @Jpf.ValidateRequired(messageKey = "errors.required", messageArgs = { @Jpf.MessageArg(argKey = "search.noSeqCategory", position = 0) })),
		@Jpf.ValidatableProperty(propertyName = "noReason", validateRequired = @Jpf.ValidateRequired(messageKey = "errors.required", messageArgs = { @Jpf.MessageArg(argKey = "search.noSeqReason", position = 0) })) })
		public Forward addNote(
				portlets.searchcustomer.SearchCustomerController.NonCustFormBean pForm) {

		// Add note for Non-Customer (need Reporting framework)
		saveReporting(Long.valueOf(pForm.getNoReason()));

		// send RFC to Max+ using cross site scripting.
		updateMaxPlus(pForm.getNoCategory());

		// clear all forms
		pForm.clear();

		return new Forward("success");
	}

	/**
	 * Fetch reason list for selected category.
	 *
	 * @param pForm
	 *            The optional SearchFormBean for this request (if any).
	 *
	 * @return Returns an <code>Forward</code>.
	 */
	@Jpf.Action(useFormBean = "nonCustFormBean", forwards = { @Jpf.Forward(name = "success", navigateTo = Jpf.NavigateTo.currentPage) }, validationErrorForward = @Jpf.Forward(name = "fail", navigateTo = Jpf.NavigateTo.currentPage))
	public Forward fetchReasons(
			portlets.searchcustomer.SearchCustomerController.NonCustFormBean pForm) {
		LogHelper.debug(this.getClass(), "fetchReasons()");

		CategoryAndRfc lCategory = null;

		final String lCatNo = pForm.getNoCategory();

		if (lCatNo != null && !"".equals(lCatNo)) {
			lCategory = getCategory(lCatNo);
		}

		// Ensure that Non-customer page is shown.
		getRequest().setAttribute(REQUEST_ATTR_NOT_FOUND, "1");

		if (lCategory != null) {
			pForm.setNonCustReasonsList(lCategory.getCategory()
					.getCallTrackingItems());
		} else {
			pForm.setNoReason("");
			pForm.setNonCustReasonsList(null);
		}

		return new Forward("success");
	}

	// --------------------------------------------------------------[ Internal
	// ]-
	/**
	 * Process information sent by Max+.
	 *
	 * @param pRequest
	 *            HTTP Request
	 * @param pForm
	 *            Search form bean
	 *
	 * @return boolean false if there is an error in the Max+ param, true
	 *         otherwise.
	 * @exception RemotException
	 *                Thrown if EJB call fails.
	 */
	private boolean processMaxPlusInfo(final HttpServletRequest pRequest,
			final SearchFormBean pForm) throws RemoteException {
		boolean lResult = true;

		final HttpSession lSession = getSession();
		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(lSession);
		final String lLanguage = pRequest.getParameter(MAXPLUS_LANGUAGE);
		final String lAccountNumber = pRequest.getParameter(MAXPLUS_ACCOUNT_NO);
		final String lCallPhoneNumber = pRequest
		.getParameter(MAXPLUS_CALL_PHONE);
		final String lRefPhoneNumber = pRequest.getParameter(MAXPLUS_REF_PHONE);
		final String lCsrDumpedId = pRequest.getParameter(MAXPLUS_CSR_DUMPED);
		final String lCallId = pRequest.getParameter(MAXPLUS_CALL_ID);
		String lIvrCode = pRequest.getParameter(MAXPLUS_DATA);

		// Set default values if no value is provided.
		if (lIvrCode == null) {
			lIvrCode = "";
		}

		// Load IVR call information
		lSessionInfo.setIvrCallReasonCode(lIvrCode);
		lSessionInfo.setIvrCallReasonInfo(callTrackingEjbControl
				.fetchIvrCallReason(lIvrCode));

		// Set user language
		if (Locale.FRENCH.getLanguage().equals(lLanguage)) {
			SessionHelper.setLocale(lSession, Locale.FRENCH);
		} else if (Locale.ENGLISH.getLanguage().equals(lLanguage)
				|| SessionHelper.getLocale(lSession) == null) // Just in case
			// the Locale is
			// not already
			// set.
		{
			SessionHelper.setLocale(lSession, Locale.ENGLISH);
		} else {
			// Change nothing : use Locale already set in the Session.
		}

		// Use account number sent by Max+ if any, else use the phone number
		if (!StringUtil.isEmpty(lAccountNumber)) {
			if (!isValidAccountNumber(lAccountNumber)) {
				MessageHelper.saveMessage(getRequest(),
						MessageTypeEnum.MESSAGE_ERROR,
						"jsp.search.invalidAccount", null);
				lResult = false;
			}
			pForm.setAccountNumber(lAccountNumber);
		} else if (!StringUtil.isEmpty(lRefPhoneNumber)) {
			if (!isValidPhoneNumber(lRefPhoneNumber)) {
				MessageHelper.saveMessage(getRequest(),
						MessageTypeEnum.MESSAGE_ERROR,
						"jsp.search.invalidPhone", null);
				lResult = false;
			}
			pForm.setPhoneNumber(lRefPhoneNumber);
		} else if (!StringUtil.isEmpty(lCallPhoneNumber)) {
			if (!isValidPhoneNumber(lCallPhoneNumber)) {
				MessageHelper.saveMessage(getRequest(),
						MessageTypeEnum.MESSAGE_ERROR,
						"jsp.search.invalidPhone", null);
				lResult = false;
			}
			pForm.setPhoneNumber(lCallPhoneNumber);
		}

		// Initialize reporting infos
		final ReportingData lReport = SessionHelper.getReportingManager(
				lSession).getReportingData();

		lReport.setCsrDumpedId(lCsrDumpedId);
		lReport.setCallId(lCallId);

		return lResult;
	}

	/**
	 * Check if phone number is of valid format.
	 *
	 * @param pPhoneNumber
	 *            the phone number
	 * @return true if valid, false otherwise
	 */
	private boolean isValidPhoneNumber(final String pPhoneNumber) {

		final String patternStr = "^[0-9]{10}$";
		final Pattern pattern = Pattern.compile(patternStr);
		final Matcher matcher = pattern.matcher(pPhoneNumber);
		return matcher.matches();
	}

	/**
	 * Check if account number is of valid format.
	 *
	 * @param pAccountNumber
	 *            the account number
	 * @return true if valid, false otherwise
	 */
	private boolean isValidAccountNumber(final String pAccountNumber) {

		final String patternStr = "^[0-9]{16}$";
		final Pattern pattern = Pattern.compile(patternStr);
		final Matcher matcher = pattern.matcher(pAccountNumber);
		return matcher.matches();
	}

	/**
	 * Fetch customer information using his account number
	 *
	 * @param pAccountNumber
	 *            Account number
	 *
	 * @return Customer profile
	 *
	 * @exception RemoteException
	 *                Thrown if an error occured.
	 * @exception BusinessException
	 *                Thrown if a problem occured when fetching customer
	 *                profile.
	 */
	private CustomerProfile fetchCustomer(final String pAccountNumber)
	throws BusinessException, RemoteException {

		// String partyGroup =
		// AppPreferences.getProperty("Application.PartyGroup");
		CustomerProfile customerProfile = null;

		// ToDo fetching partyGroup
		if (customerEjbControl.fetchPartyGroup(pAccountNumber)) {
			String operatorID = SessionHelper.getAgentProfile(getSession()).getCsrId();
			customerProfile = CustomerManager.retrieveActivatedCustomerprofile(pAccountNumber, operatorID);
		}

		return customerProfile;
	}


	/**
	 * Get a CategoryAndRfc instance for the wanted category no.
	 *
	 * @param pCategoryNo
	 *            Category no.
	 *
	 * @return Returns a <code>CategoryAndRfc<code>
	 */
	private CategoryAndRfc getCategory(final String pCategoryNo) {
		CategoryAndRfc lCategory = null;
		final Long noCategoryLong = Long.valueOf(pCategoryNo);
		final List<CategoryAndRfc> lNcCategoryList = ServletContextHelper
		.getCallSummaryNonCustomerCategories(getServletContext());

		for (CategoryAndRfc o : lNcCategoryList) {
			if (o.getCategory().getCategoryNo().equals(noCategoryLong)) {
				lCategory = o;
				break;
			}
		}

		return lCategory;
	}

	/**
	 * Start a reporting session.
	 *
	 * @param pAccountNumber
	 *            Account number
	 *
	 * @exception RemoteException
	 *                Thrown if a problem occured in the remote EJB.
	 */
	private void startReportingSession(final String pAccountNumber)
	throws RemoteException {
		final HttpSession lSession = getSession();
		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(lSession);
		final AgentProfile lAgentProfile = SessionHelper
		.getAgentProfile(lSession);
		final IvrCallreason lIvrInfo = lSessionInfo.getIvrCallReasonInfo();
		final ReportingManager lReportManager = SessionHelper
		.getReportingManager(getSession());

		// Prepare ReportingData instance
		ReportingData lReport = lReportManager.getReportingData();

		lReport.setAccountNumber(pAccountNumber);
		lReport.setOperId(lAgentProfile.getCsrId());

		Boolean lIndicator = null;

		if (lIvrInfo != null) {
			lIndicator = lIvrInfo.getIvrSelfServe();
		}

		// initialize reporting default values
		lReport.setIvrSelfServeIndic((lIndicator == null) ? Boolean.FALSE
				: lIndicator);
		lReport.setSaveOfferIndic(Boolean.FALSE);
		lReport.setSaveSuccessfulIndic(Boolean.FALSE);
		lReport.setIvrCallreasonDiffIndic(Boolean.FALSE);
		lReport.setCallDumpedIndic(Boolean.FALSE);

		// Start reporting
		lReport = reportingEjbControl.startReporting(lReport);

		lReportManager.setReportingData(lReport);
	}

	/**
	 * Save reporting information.
	 *
	 * @param pReasonNo
	 *            a Long.
	 */
	private void saveReporting(final Long pReasonNo) {

		final List<Long> lTypes = new ArrayList<Long>();
		lTypes.add(pReasonNo);

		try {
			// account number is set to 0 for Non Customer
			startReportingSession("0"); // Start a reporting session
			final ReportingManager lReportManager = SessionHelper
			.getReportingManager(getSession());

			reportingEjbControl.saveCallReportTypes(lReportManager
					.getReportingData(), lTypes);
			MessageHelper.saveMessage(getRequest(),
					MessageTypeEnum.MESSAGE_INFO, "success.saved", null);
		} catch (RemoteException e) { // don't crash MultiVu if this happens
			LogHelper.error(this.getClass(), "saveCallReportTypes failed", e);
		}
	}

	/**
	 * Add the RFC to send to Max+.
	 *
	 * @param pCategoryNo
	 *            the categry number.
	 */
	private void updateMaxPlus(final String pCategoryNo) {

		// get the rfc no associated to the selected category
		final CategoryAndRfc lCategoryAndRfc = getCategory(pCategoryNo);
		final Rfc lRfc = lCategoryAndRfc.getRfc();

		// put the RFC description in the request for MaxPlus
		getRequest().setAttribute("rfc", lRfc.getRfcDescription());

	}

	/**
	 * Redirect to the tab requested by Max+.
	 *
	 * @param pIvrCallReason
	 *            the IvrCallreason.
	 * @return Forward matching the IVR_TAB, default is Call Summary.
	 */
	private Forward redirectMaxPlusTab(final IvrCallreason pIvrCallReason) {

		final Forward lForward = new Forward("success");

		final IvrTab lTab = pIvrCallReason.getTab();

		if (lTab != null) {
			final String lTabName = lTab.getTabName();
			if (lTabName != null && !"".equals(lTabName)) {
				if (MAXPLUS_TAB_BILLING.equals(lTabName) // go to Call
						// Tracking if none
						// of those values
						|| MAXPLUS_TAB_TECHTOOLS.equals(lTabName)
						|| MAXPLUS_TAB_EQUIPMENT.equals(lTabName)) {
					lForward.setName(lTabName);
				}
			}
		}

		return lForward;
	}

	/**
	 * Redirect to a specific tab according to some business validations. This
	 * should prevails over the Max+ redirection mechanism (as per legacy code).
	 *
	 * @param pProfile
	 *            the CustomerProfile
	 * @return Forward to a specific tab, null if no need to redirect to a
	 *         specific tab.
	 */
	private Forward redirectTab(CustomerProfile pProfile) {
		Forward lForward = new Forward("success");

		// Check if secret question has been set on Customer's account.
		// If its missing we need to redirect to Customer Profile.
		// This prevails over Max+ redirection mechanism.
		if (pProfile.isSecretQuestionMissing() || pProfile.isSecretAnswerMissing() || pProfile.isPinMissing()) {
			lForward.setName(TAB_CUSTOMER_PROFILE);
		}

		return lForward;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
	}

	/**
	 * Callback that is invoked when this controller instance is destroyed.
	 */
	@Override
	protected void onDestroy(HttpSession session) {
	}

	/**
	 *
	 * @return
	 */
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = NavigationHelper.BOOK_ACTIVATION, redirect = true) })
	public Forward createNewDTHAccount(portlets.searchcustomer.SearchCustomerController.SearchFormBean form) throws RemoteException {

		// Note : Though SearchFormBean object is unused here we are passing as input object to avoid
		//  beehive framework binding console errors.Beehive Framework always expects to attach formbean to action.



		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(getSession());
		// Start session timer (one time per session)
		if (lSessionInfo.getSessionStartTime() == 0) {
			lSessionInfo.setSessionStartTime(System.currentTimeMillis());
		}

//		Activation Controller session objects --start
		getSession().removeAttribute("activateAccountNumber");
		getSession().removeAttribute("activateWorkOrderNumber");
		getSession().removeAttribute("activateAccountFlag");
		SessionHelper.clearActivationProfileFlags(getSession());
		getSession().removeAttribute(IS_NEW_IPTV_ACCOUNTCREATION);
//		Activation Controller session objects --END


		Forward forward = new Forward("success");

		SessionHelper.removeActivationProfile(getSession());
		SessionHelper.removeCustomerProfile(getSession());

		SessionHelper.setHideActivationMemos(getSession(), true);
		SessionHelper.setHideActivationCustInfoHeader(getSession(), true);
		getSession().removeAttribute("ActvationCP");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = NavigationHelper.BOOK_ACTIVATION, redirect = true) })
	public Forward createNewIPTVAccount(portlets.searchcustomer.SearchCustomerController.SearchFormBean form) throws RemoteException {
		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(getSession());
		if (lSessionInfo.getSessionStartTime() == 0) {
			lSessionInfo.setSessionStartTime(System.currentTimeMillis());
		}
		getSession().removeAttribute("activateAccountNumber");
		getSession().removeAttribute("activateWorkOrderNumber");
		getSession().removeAttribute("activateAccountFlag");
		SessionHelper.clearActivationProfileFlags(getSession());
		Forward forward = new Forward("success");

		SessionHelper.removeActivationProfile(getSession());
		SessionHelper.removeCustomerProfile(getSession());

		SessionHelper.setHideActivationMemos(getSession(), true);
		SessionHelper.setHideActivationCustInfoHeader(getSession(), true);
		getSession().removeAttribute("ActvationCP");

		getSession().setAttribute(IS_NEW_IPTV_ACCOUNTCREATION,"true");

		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = NavigationHelper.BOOK_ACTIVATION, redirect = true) })
	public Forward activateAccount(
			portlets.searchcustomer.SearchCustomerController.SearchFormBean form)
	throws RemoteException, BusinessException {


		final HttpSession lSession = getSession();
		final SessionInfo lSessionInfo = SessionHelper.getSessionInfo(lSession);

		Forward forward = new Forward("success");

		HttpServletRequest request = getRequest();
		HttpSession pSession = request.getSession();

		String accountNumber = form.getActivateAccountNumber(); //request.getParameter("activateAccountNumber");
		String activateWorkOrderNumber = form.getActivateWorkOrderNumber(); // request.getParameter("activateWorkOrderNumber");

		startReportingSession(accountNumber); // Start a reporting

		//activateWorkOrderNumber check
		if(activateWorkOrderNumber != null && activateWorkOrderNumber.length() > 0){
			pSession.setAttribute("activateWorkOrderNumber", activateWorkOrderNumber);
			pSession.setAttribute("activateAccountNumber", accountNumber);
			getSession().removeAttribute(IS_NEW_IPTV_ACCOUNTCREATION);

			String group=ContentDisplayHelper.getAccountGroup(accountNumber);
			if(group!=null && group.equals(Constants.IPTV_GROUP)){
				getSession().setAttribute(IS_NEW_IPTV_ACCOUNTCREATION,"true");
			}
		}else {
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.customersearch.workordernumber.notfound", null);
		}

		pSession.setAttribute("activateAccountFlag", "true");
		SessionHelper.clearActivationProfileFlags(pSession);
		AgentProfile agentProfile = SessionHelper.getAgentProfile(pSession);
		SessionHelper.setHideActivationMemos(getSession(), true);
		SessionHelper.setHideActivationCustInfoHeader(getSession(), true);

		lSessionInfo.setSessionStartTime(System.currentTimeMillis());

		SessionHelper.removeActivationProfile(getSession());
		SessionHelper.removeCustomerProfile(getSession());

		return forward;
	}


	/**
	 * Retrieve Channel Order Details based on Channel Order Id.
	 *
	 * @param pForm
	 *            Search criterias
	 *
	 * @return Forward to the the Channel Order Controller.
	 *
	 * @exception RemoteException
	 *                Thrown if a fatal EJB error occured.
	 */
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "/portlets/channelorders/ChannelOrdersController.jpf") })
	public Forward retrieveOrdersDetails(
			portlets.searchcustomer.SearchCustomerController.SearchFormBean form) {
		Forward forward = new Forward("success");
		return forward;
	}

	/**
	 * Retrieves Channel Orders based on accountNumber.
	 *
	 * @param pForm
	 *            Search criterias
	 *
	 * @return Forward to the Channel Order Controller.
	 *
	 * @exception RemoteException
	 *                Thrown if a fatal EJB error occured.
	 */


	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "/portlets/channelorders/ChannelOrdersController.jpf") })
	public Forward retrieveOrders(
			portlets.searchcustomer.SearchCustomerController.SearchFormBean form) {
			HttpServletRequest request = getRequest();
			HttpSession pSession = request.getSession();
			String accountNumber= request.getParameter("searchAccountNumber");
			pSession.setAttribute("searchAccountNumber", accountNumber);
			Forward forward = new Forward("success");
			return forward;
	}

	/**
	 * Search for Order based on Channel Order Id and will keep the Order object in the Request scope
	 *
	 * @param pForm
	 *            Search criterias
	 *
	 * @return Forward to the next page.
	 *
	 * @exception RemoteException
	 *                Thrown if a fatal EJB error occured.
	 */


	@Jpf.Action(forwards = {
			@Jpf.Forward(name = "success", redirect = true, path = NavigationHelper.TAB_CALL_SUMMARY),
			@Jpf.Forward(name = "account-found", path = "index.jsp"),
			@Jpf.Forward(name = "not-found", path = "index.jsp"),
			@Jpf.Forward(name = TAB_CUSTOMER_PROFILE, redirect = true, path = NavigationHelper.BOOK_CUSTOMER_PROFILE) }, validationErrorForward = @Jpf.Forward(name = "fail", path = "index.jsp")
			/*validatableProperties = { @Jpf.ValidatableProperty(validateMinLength = @Jpf.ValidateMinLength(messageKey = "errors.minlength", messageArgs = {
			@Jpf.MessageArg(argKey = "search.channelOrderId", position = 0),
			@Jpf.MessageArg(arg = "20", position = 1) }, chars = 11), validateMask = @Jpf.ValidateMask(regex = "^OMX[A-Z][0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]$", messageKey = "errors.channelOrderId", messageArgs = {
			@Jpf.MessageArg(position = 0, argKey = "search.channelOrderId"),
			@Jpf.MessageArg(position = 1, argKey = "jsp.common.channelOrderIdPattern") }), propertyName = "channelOrderId") }*/)

	public Forward searchOrder(
			portlets.searchcustomer.SearchCustomerController.SearchFormBean pForm) throws RemoteException,BusinessException {

		Forward lForward = new Forward("success");
		final HttpServletRequest lRequest = getRequest();

		Subscriber subscriber = null;


		String lAccountNumber = pForm.getAccountNumber();

		try {

			//When customer name clicked
			if (lAccountNumber != null && lAccountNumber.trim().length() > 0) {

				if(lRequest.getParameter("customerNameClicked")!=null &&
						lRequest.getParameter("customerNameClicked").equals("true")){
					return singleSubscriberRecordFound(lAccountNumber);
				}

			}

			//ESBManager esbManager = new ESBManager();
			ESBManagerReal managerReal = new ESBManagerReal();

			//ESB Call to get the Channel Order details
			ChannelOrder channelOrder = managerReal.getOrderDetailByChannelOrderID(StringUtil.trim(pForm.channelOrderId),null,Constants.ORDERLIST_PAGE);
			if(channelOrder!=null && channelOrder.getStatus()!=null &&  channelOrder.getOrderChannel()!=null &&
					managerReal.isValidChannelOrderForProcessing(channelOrder.getOrderChannel()) &&
					( channelOrder.getStatus().equals(Constants.PA_CHANNELORDER_STATUS) ||
							channelOrder.getStatus().equals(Constants.CA_CHANNELORDER_STATUS)))
			{
				boolean isEditable = false;
				pForm.setChannelOrder(channelOrder);
				SessionHelper.setIsSearchOrder(getSession(), pForm.getSearchStatus());
				getRequest().getSession().setAttribute("channelOrderId", pForm.getChannelOrderId());

				if(channelOrder.getAccountNo() == null || channelOrder.getAccountNo().trim().length() == 0) {
					LogHelper.error(this.getClass(), "Failed to search, Account Number is empty ");
					MessageHelper.saveMessage(getRequest(),
							MessageTypeEnum.MESSAGE_ERROR, "error.searchOrder.accountNumberNotFound", null);
					return new Forward("not-found");
				}

				String agentGroupID= ContentDisplayHelper.getGroup(getSession());
				String accountGroupID = ContentDisplayHelper.getAccountGroup(channelOrder.getAccountNo());
				boolean isAccountAccessNotAllowed=false;
				if(agentGroupID.equals(Constants.DTH_GROUP) && !accountGroupID.equals(Constants.DTH_GROUP)){
					isAccountAccessNotAllowed=true;
				}
				if(ContentDisplayHelper.isUserTECHNICIANGroup(getSession())&&ContentDisplayHelper.isUserTECHNICIAN_IPTVRole(getSession())
						&& accountGroupID.equals(Constants.DTH_GROUP)){
					isAccountAccessNotAllowed=true;
				}
				if(ContentDisplayHelper.isUserTECHNICIANGroup(getSession())&&ContentDisplayHelper.isUserRT_IPTVRole(getSession())
						&& accountGroupID.equals(Constants.DTH_GROUP)){
					isAccountAccessNotAllowed=true;
				}

				if(!isAccountAccessNotAllowed)
				{
					if(channelOrder.getAccountNo()!=null && channelOrder.getStatus().equals(Constants.PA_CHANNELORDER_STATUS))
					{
						subscriber = getSubscriberByAccountNumber(channelOrder.getAccountNo()); // ChIP call to get the Subscriber
						if(subscriber!=null)
						{
							pForm.setSubscriber(subscriber);
						}
					}
					isEditable=true;
				}
				pForm.setEditable(isEditable);
				lForward = new Forward("account-found");
			}
			else
			{
				MessageHelper.saveMessage(getRequest(), new BusinessNotice(MessageTypeEnum.MESSAGE_ERROR, "error.channelOrderId.NotFound", null));
				lForward = new Forward("not-found");
			}

		} catch (BusinessException e) {
			LogHelper.debug(this.getClass(), "Unable to find customer", e);
			MessageHelper.saveMessage(lRequest, e);
			lForward = new Forward("fail");
		} catch (RemoteException e) {
			LogHelper.critical(this.getClass(),
					"Problem with remote EJB call.", e);
			throw e;
		}

		return lForward;
	}


	// ----------------------------------------------------------------[ Inner
	// ]-
	/**
	 * Search Form Bean
	 *
	 * @author sarguin
	 */
	@Jpf.FormBean
	public static class SearchFormBean extends MultiVuBaseFormBean implements
	java.io.Serializable {
		// ----------------------------------------------------------------[
		// Member ]-
		private static final long serialVersionUID = 1L;

		private String phoneNumber;

		private String accountNumber;

		private String smartCardNumber;

		private String receiverNumber;

		private String lastNameFirstName;

		private String b1Number;

		private String macAddress;

		private String streetNumberName;

		private String postalCode;

		private List accountsList;

		private String hdnLineOfBusiness;

		private ChannelOrder channelOrder;

		private String channelOrderId;

		private String searchStatus;

		private String activateAccountNumber;

		private String activateWorkOrderNumber;

		private boolean editable;

		private Subscriber subscriber;



		public String getChannelOrderId() {
			return channelOrderId;
		}

		public void setChannelOrderId(String orderId) {
			this.channelOrderId = orderId;
		}
		// -------------------------------------------------------------------[
		// API ]-
		/**
		 * @return the accountsList
		 */
		public List getAccountsList() {
			return accountsList;
		}

		/**
		 * @param accountsList
		 *            the accountsList to set
		 */
		public void setAccountsList(List accountsList) {
			this.accountsList = accountsList;
		}

		public String getHdnLineOfBusiness() {
			return hdnLineOfBusiness;
		}

		public void setHdnLineOfBusiness(String hdnLineOfBusiness) {
			this.hdnLineOfBusiness = hdnLineOfBusiness;
		}

		/**
		 * @return the lastNameFirstName
		 */
		public String getLastNameFirstName() {
			return lastNameFirstName;
		}

		/**
		 * @param lastNameFirstName
		 *            the lastNameFirstName to set
		 */
		public void setLastNameFirstName(String lastNameFirstName) {
			this.lastNameFirstName = lastNameFirstName;
		}

		/**
		 * @return the receiverNumber
		 */
		public String getReceiverNumber() {
			return receiverNumber;
		}

		/**
		 * @param receiverNumber
		 *            the receiverNumber to set
		 */
		public void setReceiverNumber(String receiverNumber) {
			this.receiverNumber = receiverNumber;
		}

		/**
		 * @return the smartCardNumber
		 */
		public String getSmartCardNumber() {
			return smartCardNumber;
		}

		/**
		 * @param smartCardNumber
		 *            the smartCardNumber to set
		 */
		public void setSmartCardNumber(String smartCardNumber) {
			this.smartCardNumber = smartCardNumber;
		}

		/**
		 * @return Returns the accountNumber.
		 */
		public String getAccountNumber() {
			return accountNumber;
		}

		/**
		 * @param accountNumber
		 *            The accountNumber to set.
		 */
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		/**
		 * @return Returns the phoneNumber.
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}

		/**
		 * @param phoneNumber
		 *            The phoneNumber to set.
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		/**
		 * Ensure phoneNumber OR accountNumber is provided.
		 *
		 * @param pMapping
		 *            Action mapping
		 * @param pRequest
		 *            HTTP Request
		 * @param pErrors
		 *            Errors list
		 */
		public void validate(ActionMapping pMapping,
				HttpServletRequest pRequest, ActionMessages pErrors) {
			// Mandatory : Call super implementation.
			super.validate(pMapping, pRequest, pErrors);

			final HttpServletRequest lOuterRequest = ScopedServletUtils
			.getOuterRequest(pRequest);
			if(searchStatus !=null && searchStatus.equals(YES)){
				if (StringUtil.isEmpty(channelOrderId)){
					MessageHelper
					.saveMessageCustomValidate(
							pRequest,
							MessageTypeEnum.MESSAGE_ERROR,
							"error.search.missing.orderId",
							null, pErrors);

				}
			}
			else{

				String loggedGroupID= SessionHelper.getAgentProfile(pRequest.getSession()).getSecuritAgentGroupString();

				if(loggedGroupID.equals(Constants.IPTV_GROUP) || loggedGroupID.equals(Constants.TECHNICIAN_GROUP) )
				{
					if ((StringUtil.isEmpty(accountNumber)
							&& StringUtil.isEmpty(lOuterRequest
									.getParameter(MAXPLUS_ACCOUNT_NO))
									&& StringUtil.isEmpty(lOuterRequest
											.getParameter(MAXPLUS_CALL_PHONE))
											&& StringUtil.isEmpty(lOuterRequest
													.getParameter(MAXPLUS_REF_PHONE)) && StringUtil
													.isEmpty(phoneNumber))
													&& StringUtil.isEmpty(lastNameFirstName)
													&& StringUtil.isEmpty(receiverNumber)
													&& StringUtil.isEmpty(smartCardNumber)
													&& StringUtil.isEmpty(macAddress)
													&& StringUtil.isEmpty(b1Number)
													&& StringUtil.isEmpty(postalCode)
													&& StringUtil.isEmpty(streetNumberName)) {
						MessageHelper
						.saveMessageCustomValidate(
								pRequest,
								MessageTypeEnum.MESSAGE_ERROR,
								"error.search.missing.accountAndReceiverAndSmartCardAndPhoneAndLastNameFirstNameAndServiceAddressAndMacAddressAndB1Number",
								null, pErrors);


					}
				}
				else if(loggedGroupID.equals(Constants.DTH_GROUP))
				{

					if ((StringUtil.isEmpty(accountNumber)
							&& StringUtil.isEmpty(lOuterRequest
									.getParameter(MAXPLUS_ACCOUNT_NO))
									&& StringUtil.isEmpty(lOuterRequest
											.getParameter(MAXPLUS_CALL_PHONE))
											&& StringUtil.isEmpty(lOuterRequest
													.getParameter(MAXPLUS_REF_PHONE)) && StringUtil
													.isEmpty(phoneNumber))
													&& StringUtil.isEmpty(lastNameFirstName)
													&& StringUtil.isEmpty(receiverNumber)
													&& StringUtil.isEmpty(smartCardNumber)
													&& StringUtil.isEmpty(postalCode)
													&& StringUtil.isEmpty(streetNumberName))
					{
						MessageHelper
						.saveMessageCustomValidate(
								pRequest,
								MessageTypeEnum.MESSAGE_ERROR,
								"error.search.missing.accountAndReceiverAndSmartCardAndPhoneAndLastNameFirstNameAndServiceAddress",
								null, pErrors);

					}


				}
			}
		}
		public String getB1Number() {
			return b1Number;
		}

		public void setB1Number(String number) {
			b1Number = number;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getStreetNumberName() {
			return streetNumberName;
		}

		public void setStreetNumberName(String streetNumberName) {
			this.streetNumberName = streetNumberName;
		}

		public String getMacAddress() {
			return macAddress;
		}

		public void setMacAddress(String macAddress) {
			this.macAddress = macAddress;
		}



		public String getSearchStatus() {
			return searchStatus;
		}

		public void setSearchStatus(String searchStatus) {
			this.searchStatus = searchStatus;
		}

		public ChannelOrder getChannelOrder() {
			return channelOrder;
		}

		public void setChannelOrder(ChannelOrder channelOrder) {
			this.channelOrder = channelOrder;
		}

		public String getActivateAccountNumber() {
			return activateAccountNumber;
		}

		public void setActivateAccountNumber(String activateAccountNumber) {
			this.activateAccountNumber = activateAccountNumber;
		}

		public String getActivateWorkOrderNumber() {
			return activateWorkOrderNumber;
		}

		public void setActivateWorkOrderNumber(String activateWorkOrderNumber) {
			this.activateWorkOrderNumber = activateWorkOrderNumber;
		}

		public boolean isEditable() {
			return editable;
		}

		public void setEditable(boolean editable) {
			this.editable = editable;
		}

		/**
		 * @return the subscriber
		 */
		public Subscriber getSubscriber() {
			return subscriber;
		}

		/**
		 * @param subscriber the subscriber to set
		 */
		public void setSubscriber(Subscriber subscriber) {
			this.subscriber = subscriber;
		}

	}

	@Jpf.FormBean
	public static class NonCustFormBean extends MultiVuBaseFormBean implements
	java.io.Serializable {
		// ----------------------------------------------------------------[
		// Member ]-
		private static final long serialVersionUID = 1L;

		private String noCategory;

		private String noReason;

		private Collection<CallTrackingItem> nonCustReasonsList;

		/**
		 * @param noCategory
		 *            The noCategory to set.
		 */
		public void setNoCategory(String noCategory) {
			this.noCategory = noCategory;
		}

		/**
		 * @return Returns the noCategory.
		 */
		public String getNoCategory() {
			return noCategory;
		}

		/**
		 * @param noReason
		 *            the noReason to set
		 */
		public void setNoReason(String noReason) {
			this.noReason = noReason;
		}

		/**
		 * @return the noReason
		 */
		public String getNoReason() {
			return noReason;
		}

		/**
		 * Validate category and reason selected.
		 *
		 * @param pMapping
		 *            Action mapping
		 * @param pRequest
		 *            HTTP Request
		 * @param pErrors
		 *            Errors list
		 */
		public void validate(ActionMapping pMapping,
				HttpServletRequest pRequest, ActionMessages pErrors) {
			// Mandatory : Call super implementation.
			super.validate(pMapping, pRequest, pErrors);

			// be sure to display the Non Customer Tracking section if any error
			// occurs
			if (!pErrors.isEmpty()) {
				pRequest.setAttribute(REQUEST_ATTR_NOT_FOUND, "1");
			}
		}

		/**
		 * @return the nonCustReasonsList
		 */
		public Collection<CallTrackingItem> getNonCustReasonsList() {
			return nonCustReasonsList;
		}

		/**
		 * @param pNonCustReasonsList
		 *            the nonCustReasonsList to set
		 */
		public void setNonCustReasonsList(
				Collection<CallTrackingItem> pNonCustReasonsList) {
			nonCustReasonsList = pNonCustReasonsList;
		}

		public void clear() {

			noCategory = "";
			noReason = "";
			nonCustReasonsList = null;
		}
	}

	private Forward retrieveAccountSearchResults(String homePhone,
			String accountNumber, String receiverNumber,
			String smartCardNumber, String customerName,String macAddress, String b1Number, String streetNumberName,
			String postalCode, SearchFormBean searchFormBean )
	throws BusinessException {
		// Call AL method to retrieve equipment list - Start.
		List<Subscriber> subscriberList = new ArrayList<Subscriber>();
		LogHelper.debug(this.getClass(),
		"Entering retrieveAccountSearchResults() ");
		Forward lForward=null;
		try {
			AccountSearchServicePortType acoountSearchPortType = WebServiceClientsHelper.getAccountSearchService();
			SearchAccountRequest searchAccountRequest = createAccountSearchRequest(
					homePhone, accountNumber, receiverNumber, smartCardNumber,
					customerName, macAddress, b1Number, streetNumberName, postalCode);

			if (acoountSearchPortType != null) {
				SearchAccountResponse searchAccountResponse = acoountSearchPortType.searchAccount(searchAccountRequest);

				subscriberList = convertALSearchResultToMVSearchResult(searchAccountResponse);

				if(subscriberList!=null ){
					if (subscriberList.size() == 0)
					{
						if(accountNumber!=null || homePhone!=null){
							getRequest().setAttribute(REQUEST_ATTR_NOT_FOUND, "1");
						}
						MessageHelper.saveMessage(getRequest(), new BusinessNotice(MessageTypeEnum.MESSAGE_ERROR, "error.search.NotFound", null));
						lForward = new Forward("not-found");
					} else if (subscriberList.size() == 1)
					{
						//Defect : 564 fix.
						String connectStatus = subscriberList.get(0).getConnectStatus();
						if(connectStatus!=null && connectStatus.equals("1")){
							searchFormBean.setAccountsList(subscriberList);
							lForward = new Forward("many-accounts");
						}else{
							lForward = singleSubscriberRecordFound((Subscriber) subscriberList.get(0));
						}
					} else {
						subscriberList = sortSearchResults(subscriberList);
						searchFormBean.setAccountsList(subscriberList);
						lForward = new Forward("many-accounts");
					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
			LogHelper.error(this.getClass(), "MalformedURLException: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.accountsearch.ws.system.failed", null);
		} catch (WSExceptionDetail e) {
			e.printStackTrace();
			LogHelper.error(this.getClass(),
					"WSExceptionDetail: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR,
					"errors.accountsearch.ws.system.failed", null);
		} catch (RemoteException e) {
			e.printStackTrace();
			LogHelper.error(this.getClass(),
					"RemoteException: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR,
					"errors.accountsearch.ws.system.failed", null);
		} catch (ServiceException e) {
			e.printStackTrace();
			LogHelper.error(this.getClass(),
					"ServiceException: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR,
					"errors.accountsearch.ws.system.failed", null);
		} catch (Exception e) {
			e.printStackTrace();
			LogHelper.error(this.getClass(),
					"Exception: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR,
					"errors.accountsearch.ws.system.failed", null);
		}
		return lForward;
	}

	private SearchAccountRequest createAccountSearchRequest(String homePhone,
			String accountNumber, String receiverNumber,
			String smartCardNumber, String customerName, String macAddress,
			String b1Number, String streetNumberName,
			String postalCode) {
		LogHelper.debug(this.getClass(),
		"Entering createAccountSearchRequest()");

		SearchAccountRequest searchAccountRequest = new SearchAccountRequest();
		searchAccountRequest.setOperatorID("Z97");
		searchAccountRequest.setRequestTimestamp(Calendar.getInstance());
		searchAccountRequest.setSearchFilter(createSearchFilter(homePhone,
				accountNumber, receiverNumber, smartCardNumber, customerName,
				macAddress, b1Number, streetNumberName, postalCode));
		searchAccountRequest.setSource(MULTIVU_CHANNEL);

		LogHelper.debug(this.getClass(),
		"Leaving the createAccountSearchRequest()");

		return searchAccountRequest;
	}

	private SearchFilter createSearchFilter(String homePhone,
			String accountNumber, String receiverNumber,
			String smartCardNumber, String customerName, String macAddress,
			String b1Number, String streetNumberName,
			String postalCode) {
		SearchFilter searchFilter = new SearchFilter();

		if (accountNumber != null) {
			searchFilter.setAccountNumber(accountNumber);
		}
		if (homePhone != null) {
			searchFilter.setPhoneNumber(homePhone);
		}
		if (customerName != null) {

			searchFilter.setName(customerName);
		}

		if (receiverNumber != null) {

			searchFilter.setEquipmentNumber(receiverNumber);
		} else if (smartCardNumber != null) {

			searchFilter.setEquipmentNumber(smartCardNumber);
		}else if (macAddress != null) {

			searchFilter.setEquipmentNumber(macAddress);
		}
		if (b1Number != null) {

			searchFilter.setB1Number(b1Number);
		}

		if (streetNumberName != null && postalCode != null) {

			ServiceAddress serviceAddress = new ServiceAddress();
			serviceAddress.setAddressLine1(streetNumberName);
			serviceAddress.setPostCode(postalCode);
			searchFilter.setServiceAddress(serviceAddress);
		}

		return searchFilter;
	}

	private List<Subscriber> convertALSearchResultToMVSearchResult(SearchAccountResponse searchAccountResponse) {

		List<Subscriber> subscriberList = new ArrayList<Subscriber>();
		AccountInfo[] accountInfoArray =  searchAccountResponse.getAccounts();
        boolean moreRecordsFound=false;

        String loggedGroupID= ContentDisplayHelper.getGroup(getSession());


		if (accountInfoArray != null) {

			for (int i = 0; i < accountInfoArray.length; i++) {
				AccountInfo accountInfo = accountInfoArray[i];
				String accountNumber = accountInfo.getAccountNumber();
				String systemNumber =
					(accountNumber!=null&&accountNumber.length()==16)?
							accountNumber.substring(beginIndexSystem,endIndexSystem):null;

							//MVR12.3 - UAT - Enhancement#602
							//filter out account search results with system number not 8455 and not 8459
							//if (DEFAULT_SYSTEM_NUMBER.equals(systemNumber)||TRAINING_SYSTEM_NUMBER.equals(systemNumber)) {
							if(isAllowedSystemNumber(systemNumber)){
								String accountGroup = ContentDisplayHelper.getAccountGroup(accountNumber);
								/*
								 * Implementation for hiding the DTH accounts for TECHNICIAN_IPTV role
								 */
									if((ContentDisplayHelper.isUserTECHNICIANGroup(getSession())
										&& ContentDisplayHelper.isUserTECHNICIAN_IPTVRole(getSession()))
										&& Constants.DTH_GROUP.equals( accountGroup ))
									{
										continue;
									}else  if((ContentDisplayHelper.isUserTECHNICIANGroup(getSession())
											&& ContentDisplayHelper.isUserRT_IPTVRole(getSession()))
											&& Constants.DTH_GROUP.equals( accountGroup ))
										{
											continue;
										}
								/*
								 *
								 */
								Subscriber subscriber = new Subscriber();
								subscriber.setAcctNo(accountNumber);
								subscriber.setConnectStatus(accountInfo.getConnectStatus());
								subscriber.setCreationDate(accountInfo.getCreationDate());
								subscriber.setName(accountInfo.getName());
								subscriber.setWorkOrderID(accountInfo.getWorkOrderID());
								subscriber.setIdNo(accountInfo.getPIN());
								subscriber.setWorkOrderStatus(accountInfo.getWorkOrderStatus());

								if(	loggedGroupID.equals(Constants.DTH_GROUP) && !(Constants.DTH_GROUP.equals(accountGroup))){
									subscriber.setEditable(false);
								}
								/*else if(loggedGroupID.equals(Constants.IPTV_GROUP)
										&& (Constants.IPTV_GROUP.equals(accountGroup))
										&& SessionHelper.getAgentProfile(getSession()).getSecurityAgentRole().toString().equals(WL_IPTVLEVEL1_ROLE_ID))
								{
									subscriber.setEditable(false);
								}*/
								else{

									subscriber.setEditable(true);
								}
								subscriberList.add(subscriber);
								subscriber = null;
								if(i == (MAX_DISPLAYED_RECORDS-1) ){
									moreRecordsFound=true;
									break;
								}
							}
			}


		}
		/*
		if(accountInfoArray!=null &&
				accountInfoArray.length >= MAX_DISPLAYED_RECORDS ){

			LogHelper.error(this.getClass(), "Please refine search criteria..error.customerprofile.refineSearchData");
			MessageHelper.saveMessage(getRequest(), MessageTypeEnum.MESSAGE_INFO,"error.customerprofile.refineSearchData", null);
		}
		*/
		if(moreRecordsFound){
			LogHelper.error(this.getClass(), "Please refine search criteria..error.customerprofile.refineSearchData");
			MessageHelper.saveMessage(getRequest(), MessageTypeEnum.MESSAGE_INFO,"error.customerprofile.refineSearchData", null);
		}



		return subscriberList;
	}

	private boolean isAllowedSystemNumber(String systemNumber)
	{
		boolean success=false;
		final Configuration lConfig = MultiVuConfigurationFactory.getConfiguration();
        String allowedSystemNumbers = lConfig.getString("search.account.systems.allowed");
        final String COMMA_DELIMETER=",";

        if (allowedSystemNumbers!= null)
        {
        	allowedSystemNumbers=allowedSystemNumbers.trim();
        }

        if (allowedSystemNumbers== null || allowedSystemNumbers.equals(""))
        {
        	allowedSystemNumbers=DEFAULT_SYSTEM_NUMBER;
        }

    	StringTokenizer stringTokenizer = new StringTokenizer(allowedSystemNumbers,COMMA_DELIMETER);

    	if (stringTokenizer != null){
    		while(stringTokenizer.hasMoreTokens())
    		{
    			String definedSystemValue=stringTokenizer.nextToken();
    			if(definedSystemValue.equals(systemNumber)){
    				success=true;
    				break;
    			}
    		}
    	}
		return success;
	}

	private Forward singleSubscriberRecordFound(Subscriber subscriber) throws RemoteException,BusinessException{
		return singleSubscriberRecordFound(subscriber.getAcctNo());
	}

	private Forward singleSubscriberRecordFound(String lAccountNumber) throws RemoteException,BusinessException{
		// Fetch customer
		try {
			// We must display the Non Customer Tracking section if the
			// account is not
			// found in SUBSCRIBER table.
			String loggedGroupID= ContentDisplayHelper.getGroup(getSession());
			String accountGroupID= ContentDisplayHelper.getAccountGroup(lAccountNumber);
			if ((accountGroupID!= null && !accountGroupID.equals("")))
			{
				if(	(loggedGroupID.equals(Constants.DTH_GROUP)
						&& !accountGroupID.equals(Constants.DTH_GROUP))
						||
						((ContentDisplayHelper.isUserTECHNICIANGroup(getSession())
								&&ContentDisplayHelper.isUserTECHNICIAN_IPTVRole(getSession()))
								&& accountGroupID.equals(Constants.DTH_GROUP)))
								//Implementation for TECHNICIAN_IPTV role
				{
					LogHelper.error(this.getClass(), "Failed to search, Access Denied ");
					MessageHelper.saveMessage(getRequest(),
							MessageTypeEnum.MESSAGE_ERROR, "error.search.noAccessAllowed", null);
					return new Forward("fail");
				}
				/*
				 * else if(loggedGroupID.equals(Constants.IPTV_GROUP) && accountGroupID.equals(Constants.IPTV_GROUP)){
					if(SessionHelper.getAgentProfile(getSession()).getSecurityAgentRole().toString().equals(WL_IPTVLEVEL1_ROLE_ID))
					{
						LogHelper.error(this.getClass(), "Failed to search, Access Denied ");
						MessageHelper.saveMessage(getRequest(),
								MessageTypeEnum.MESSAGE_ERROR, "error.search.noAccessAllowed", null);
						return new Forward("fail");
					}
				}*/
			}

			CustomerProfile customerProfile = fetchCustomer(lAccountNumber);
			if(customerProfile !=null){
				SessionHelper.setCustomerProfile(getSession(),customerProfile );
			}else{
				throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, ERROR_ACCOUNT_NOT_FOUND, null);
			}
			LogHelper.debug(this.getClass(),"search() account number = " + lAccountNumber);

		} catch (BusinessException e) {
			if ("error.search.accountNumberNotFound".equals(e
					.getMessageKey())) {
				getRequest().setAttribute(REQUEST_ATTR_NOT_FOUND, "1");
			}
			throw e;
		}

		// Release12 Changes - Sets false for customer profile page
		SessionHelper.setHideActivationMemos(getSession(), false);
		SessionHelper.setHideActivationCustInfoHeader(getSession(),false);
		startReportingSession(lAccountNumber); // Start a reporting
		// session

		// Check if we need to redirect the agent to a specific tab.
		// This is determined by business check and prevails over Max+
		// redirection.

		Forward lForward = redirectTab(SessionHelper
				.getCustomerProfile(getSession()));

		// If we don't need to forward to a specific tab according to
		// our business logic,
		// check if we need to redirect to a tab specified by Max+.
		if ("success".equals(lForward.getName())) {
			// Forward to WANTED PAGE FROM MAX+
			final IvrCallreason lIvrCallreason = SessionHelper.getSessionInfo(getSession()).getIvrCallReasonInfo();
			if (lIvrCallreason != null) {
				lForward = redirectMaxPlusTab(lIvrCallreason);
			}
		}

		return lForward;

	}


	private List sortSearchResults(final List searchResults){
		List<Subscriber> tempList = new ArrayList<Subscriber>();

		// Adding Active accounts in the temp list
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("A")){
				tempList.add(subscriber);
			}
		}

		// Adding Pending disconnect in the temp list
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("2")){
				tempList.add(subscriber);
			}
		}

		//	Adding Pending connect, previously disconnected in the temp list
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("3")){
				tempList.add(subscriber);
			}
		}

//		Pending connect, never connected
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("1")){
				tempList.add(subscriber);
			}
		}

//		Disconnect
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("D")){
				tempList.add(subscriber);
			}
		}

//		Never connected
		for (int i = 0; i < searchResults.size(); i++) {
			Subscriber subscriber = (Subscriber)searchResults.get(i);
			if(subscriber.getConnectStatus().equals("N")){
				tempList.add(subscriber);
			}
		}
		return tempList;
	}

	/**
	 * Get the Subscriber based on Account Number
	 *
	 * @param accountNumber
	 *
	 * @return Subscriber.
	 *
	 * @exception BusinessException
	 *                Thrown if accountNumber is not found.
	 */
	private Subscriber getSubscriberByAccountNumber(final String accountNumber) throws BusinessException{

		List<Subscriber> subscriberList = new ArrayList<Subscriber>();
		Subscriber subscriber = null;

		try{
			AccountSearchServicePortType acoountSearchPortType = WebServiceClientsHelper.getAccountSearchService();
			SearchAccountRequest searchAccountRequest = createAccountSearchRequest(
					null, accountNumber, null, null, null, null, null, null, null);

			if (acoountSearchPortType != null) {
				SearchAccountResponse searchAccountResponse = acoountSearchPortType.searchAccount(searchAccountRequest);
				subscriberList = convertALSearchResultToMVSearchResult(searchAccountResponse);

				if(subscriberList!=null ){
					if (subscriberList.size() == 0)
					{
						if(accountNumber!=null){
							getRequest().setAttribute(REQUEST_ATTR_NOT_FOUND, "1");
						}
						MessageHelper.saveMessage(getRequest(), new BusinessNotice(MessageTypeEnum.MESSAGE_ERROR, "error.search.NotFound", null));
					} else if (subscriberList.size() == 1)
					{
						//Defect : 564 fix.
						subscriber = subscriberList.get(0);
					}
				}

			}else{
				LogHelper.error(this.getClass(), "AccountSearchServicePortType is not available.");
			}
		}catch (Exception e) {
			LogHelper.error(this.getClass(),
					"Exception: retrieveAccountSearchResults() failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR,
					"errors.accountsearch.ws.system.failed", null);
		}

		return subscriber;
	}
}
=====================================
Sample EJB file and DAO files.
=====================================

package com.expressvu.callcentre.portal.notesmanager;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import com.expressvu.callcentre.business.ejb.calltracking.CallTrackingEJBHome;
import com.expressvu.callcentre.business.ejb.calltracking.CallTrackingEJBRemote;
import com.expressvu.callcentre.business.ejb.notesmanager.NoteAssociationEJBHome;
import com.expressvu.callcentre.business.ejb.notesmanager.NoteAssociationEJBRemote;
import com.expressvu.callcentre.common.beans.AgentProfile;
import com.expressvu.callcentre.common.beans.calltracking.CategoryAndRfc;
import com.expressvu.callcentre.common.beans.customer.CustomerProfile;
import com.expressvu.callcentre.common.beans.notesmanager.NoteAssociationEnum;
import com.expressvu.callcentre.common.business.BusinessException;
import com.expressvu.callcentre.common.business.MessageTypeEnum;
import com.expressvu.callcentre.common.db.persistence.calltracking.*;
import com.expressvu.callcentre.common.helper.LogHelper;
import com.expressvu.callcentre.common.util.Tuple;
import com.expressvu.callcentre.portal.listener.ServletContextHelper;
import com.expressvu.callcentre.portal.tokensManager.TokenValues;
import com.expressvu.callcentre.portal.util.ContentDisplayHelper;
import com.expressvu.callcentre.portal.util.ReportingManager;
import com.expressvu.callcentre.portal.util.SessionHelper;
import com.expressvu.callcentre.portal.util.Constants;

/**
 * This class is used to handle the creation, saving, and deletion of CIT notes.
 */
public class CitNotesManager implements Serializable 
{
    //----------------------------------------------------------------[ Member ]- 
	private static final long serialVersionUID = 1L;
    private static transient InitialContext ejbContext;
    
	private List<Tuple<CitNotes, NoteViewInfo>> citNotes = new ArrayList<Tuple<CitNotes, NoteViewInfo>>();
	private List<CitNotes> citNotesHistory = new ArrayList<CitNotes>();
    
    // used to check if at least one CIT note has been saved during the session before existing MultiVu
    private boolean noteSubmitted = false;
    
    private static final String CREATE_NOTE_MISSING_PARAMS = "createCitNote: Missing required parameters";
    
    static {
        // Create EJB Context.
        try {
            ejbContext = new InitialContext();
        } catch (final NamingException e) {
            LogHelper.critical(CitNotesManager.class, "Unable to create InitialContext for EJBs", e);
            throw new RuntimeException("Unable to create InitialContext for EJBs", e);
        }
    }
    
    
    //-----------------------------------------------------------[ Constructor ]- 
    /**
     * Constructor
     * 
     * @param pSessionb the HttpSession
     */
    public CitNotesManager(final HttpSession pSession)
    {
        // add the container for note templates token's value in session
        SessionHelper.setTokenValues(pSession, new TokenValues());
    }

    
    //-------------------------------------------------------------------[ API ]- 
	/**
	 * Create a CitNote object using the CallTrackingItem (Reason) and its Reason template and
	 * add it to the list of notes to be submitted by the CitNotes.portlet.
	 * 
	 * The tokens in the note template will be replaced by their current values in session.
	 * 
	 * @param pEnum a NoteAssociationEnum with the name used in NOTE_ASSOCIATION table 
	 * in order to retretive the associated CallTrackingItem (Reason).
	 * @param pSession the HttpSession to retreive the customer and agent profile
	 */
	public void createCitNote(final NoteAssociationEnum pEnum, final HttpSession pSession) throws BusinessException {
		
        if (pEnum == null || pSession == null) {
            throw new IllegalArgumentException(CREATE_NOTE_MISSING_PARAMS);
        }
        
		try {
			// get the CallTrackingItem
            final NoteAssociationEJBHome home = (NoteAssociationEJBHome)ejbContext.lookup("NoteAssociationEJB");
            final NoteAssociationEJBRemote noteAssociationEJBRemote = home.create();
			final CallTrackingItem callTrackingItem = noteAssociationEJBRemote.getAssociatedNote(pEnum);
			
			// create the CitNote object and add it to the to be submitted list
			createCitNote(callTrackingItem, pSession);

		} catch (Exception e) { // be sure the user knows there was an error but do not interrupt the session
			LogHelper.error(this.getClass(), "createCitNote(final NoteAssociationEnum pEnum, final HttpSession pSession) failed", e);
			throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.citnotes.createFailed", null);
        }
	}
	
	/**
	 * Create a CitNote object using the CallTrackingItem (Reason) and its Reason template and
	 * add it to the list of notes to be submitted by the CitNotes.portlet.
	 * 
	 * The tokens in the note template will be replaced by their current values in session.
	 * 
	 * @param pReasonId a String with the reasonId to retreive the CallTrackingItem.
	 * @param pSession the HttpSession to retreive the customer and agent profile
	 */
	public void createCitNote(final String pReasonId, final HttpSession pSession) throws BusinessException {
		
        if (pReasonId == null || pSession == null) {
            throw new IllegalArgumentException(CREATE_NOTE_MISSING_PARAMS);
        }
        
        try {
		// get the CallTrackingItem
		final CallTrackingItem callTrackingItem = retreiveReasonById(pSession, pReasonId);
		
        // create the CitNote object and add it to the to be submitted list
        createCitNote(callTrackingItem, pSession);
 
        } catch (Exception e) {
            LogHelper.error(this.getClass(), "createCitNote(final String pReasonId, final HttpSession pSession) failed", e);
            throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.citnotes.createFailed", null);
        }

	}
    
    /**
     * Create a CitNote object using the CallTrackingItem (Reason) and its Reason template and
     * add it to the list of notes to be submitted by the CitNotes.portlet.
     * 
     * Note origin will also be added.
     * 
     * The tokens in the note template will be replaced by their current values in session.
     * 
     * @param pReasonId a String with the reasonId to retreive the CallTrackingItem.
     * @param pSession the HttpSession to retreive the customer and agent profile
     * @param pNoteOrigin the enum NoteOrigin (inner class in CitNotesManager).
     */
    public void createCitNote(final String pReasonId, final HttpSession pSession, final NoteOrigin pNoteOrigin) throws BusinessException {
        
        if (pReasonId == null || pSession == null || pNoteOrigin == null) {
            throw new IllegalArgumentException(CREATE_NOTE_MISSING_PARAMS);
        }
        
        // create the note
        createCitNote(pReasonId, pSession);
        
        // add note origin to reporting
        final ReportingManager lReportManager = SessionHelper.getReportingManager(pSession);
        
        lReportManager.addNoteOriginStat(pNoteOrigin.getValue());
    }
    
    /**
     * Create a CitNote object using the CallTrackingItem (Reason) and its Reason template and
     * add it to the list of notes to be submitted by the CitNotes.portlet.
     * 
     * Note origin will also be added.
     * 
     * The tokens in the note template will be replaced by their current values in session.
     * 
     * @param pEnum a NoteAssociationEnum with the name used in NOTE_ASSOCIATION table 
     * in order to retretive the associated CallTrackingItem (Reason).
     * @param pSession the HttpSession to retreive the customer and agent profile
     * @param pNoteOrigin the enum NoteOrigin (inner class in CitNotesManager).
     */
    public void createCitNote(final NoteAssociationEnum pEnum, final HttpSession pSession, final NoteOrigin pNoteOrigin) throws BusinessException {
        
        if (pEnum == null || pSession == null || pNoteOrigin == null) {
            throw new IllegalArgumentException(CREATE_NOTE_MISSING_PARAMS);
        }
        
        // create the note
        createCitNote(pEnum, pSession);
        
        // add note origin to reporting
        final ReportingManager lReportManager = SessionHelper.getReportingManager(pSession);
        
        lReportManager.addNoteOriginStat(pNoteOrigin.getValue());
    }
	
	/**
	 * Create a CitNote object using the CallTrackingItem (Reason) and its Reason template and
	 * add it to the list of notes to be submitted by the CitNotes.portlet.
	 * 
	 * The tokens in the note template will be replaced by their current values in session.
	 * 
	 * @param pCallTrackingItem the Reason that hold the note template.
	 * @param pSession the HttpSession to retreive the customer and agent profile
	 */
	private void createCitNote(final CallTrackingItem pCallTrackingItem, final HttpSession pSession) 
        throws Exception {
		
        LogHelper.debug(this.getClass(), "Entering: createCitNote()");
        
		Template lTemplate = null;
		// get customer and agent profile from session
		final CustomerProfile lCustomerProfile = SessionHelper.getCustomerProfile(pSession);
		final AgentProfile lAgentProfile = SessionHelper.getAgentProfile(pSession);
		
        if (pCallTrackingItem == null) {
            LogHelper.error(this.getClass(), "createCitNote(): No Matching CALLTRACKINGITEM found");
            throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.citnotes.createFailed", null);
        }

        final CallTrackingEJBHome home = (CallTrackingEJBHome)ejbContext.lookup("CallTrackingEJB");
        final CallTrackingEJBRemote callTrackingEJBRemote = home.create();
		// fetch the associated template for the reason (CallTrackingItem)
		lTemplate = callTrackingEJBRemote.getTemplate(pCallTrackingItem.getItemNo(), ContentDisplayHelper.getGroup(pSession));
			

		// set the default CitNote value from the selected reason
		final CitNotes lNote = new CitNotes();
        lNote.setRetention(pCallTrackingItem.getDefaultDuration()); // note duration Short, Long, Permanent
        lNote.setSubject(lTemplate.getSubject());

        
        // build reason text (must contains leaf reason AND their parents)
        final StringBuilder lReasonText=  new StringBuilder();
        CallTrackingItem lCurrentItem = pCallTrackingItem;
        
        while (lCurrentItem != null) {
            lReasonText.insert(0, lCurrentItem.getDescription());
            lReasonText.insert(0, ", ");
            
            if (lCurrentItem.getParentReason() == null) {
                lCurrentItem = null;
            } else {
                lCurrentItem = retreiveReasonById(pSession, lCurrentItem.getParentReason().toString());
            }
        }
        
        // Add Extra UI info to CIT Note
        final NoteViewInfo lExtraInfo = new NoteViewInfo();
        final CallTrackingCategory lCategory = pCallTrackingItem.getCallTrackingCategory();
        lExtraInfo.setCategoryText(lCategory.getDescription());
        lExtraInfo.setCategoryNo(lCategory.getCategoryNo());
        lExtraInfo.setReasonText(lReasonText.toString());
        lExtraInfo.setReasonNo(pCallTrackingItem.getItemNo());
        
		// fetch the CitNotesTokenValues object from Session
		final TokenValues lTokenValues = SessionHelper.getTokenValues(pSession);

		// add base account information
        lTokenValues.setCustomerProfileInfo(lCustomerProfile);
        lTokenValues.setAgentProfileInfo(lAgentProfile);
		
		final String parsedNoteText = lTokenValues.replaceTemplateTokens(lTemplate);
        lNote.setNoteText(parsedNoteText);
		
		// add the new note at the beginning of the to be added list
        final Tuple<CitNotes, NoteViewInfo> noteAllInfo = new Tuple<CitNotes, NoteViewInfo>(lNote, lExtraInfo);
        
        citNotes.add(0, noteAllInfo);
        
        LogHelper.debug(this.getClass(), "Leaving: createCitNote()");
	}
	
	
	/**
	 * Retreive CallTrackingItem for a given reasonId. The object is fetched in Context not directlty from database.
	 * 
	 * @param pSession the HttpSession.
	 * @param pReasonId the id of the reaons (also known as the itemNo in CALLTRACKINGITEM table)
	 * @return CallTrackingItem that matches the pReasonId
	 */
	@SuppressWarnings("unchecked")
    private CallTrackingItem retreiveReasonById( final HttpSession pSession, final String pReasonId ) {
        CallTrackingItem lResult = null;
        
    	//final List<CategoryAndRfc> categoriesList = ServletContextHelper.getCallSummaryCategories(pSession.getServletContext());
    	List<CategoryAndRfc> categoriesList = null;
        if (ContentDisplayHelper.getGroup(pSession).equals(Constants.IPTV_GROUP)) {
        	categoriesList = ServletContextHelper.getCallSummaryIptvCategories(pSession.getServletContext()); 
        }else if(ContentDisplayHelper.getGroup(pSession).equals(Constants.DTH_GROUP)) {
        	categoriesList = ServletContextHelper.getCallSummaryDthCategories(pSession.getServletContext());
        }
    	
        if(categoriesList!=null) { 
        	for(CategoryAndRfc categoryAndRfc: categoriesList) {
        		final CallTrackingCategory category = categoryAndRfc.getCategory();
        		final Collection<CallTrackingItem> items = category.getCallTrackingItems();

        		for (CallTrackingItem item: items ){
        			if( pReasonId.trim().equals(item.getItemNo().toString()) ){
        				lResult = item;
        				break;
        			}
        		}
        	}
        }
      
        if (lResult == null) {
            LogHelper.critical(this.getClass(), "Unable to retrieve the CallTrackingItem for itemNo = " + pReasonId);
        }
        
        return lResult;
    }
	
	/**
	 * Save the list of CitNotes into CIT Note database.
	 * @param pNotes the List<CitNotes> to be persisted.
	 * @param pSession the HttpSession.
	 */
	public void saveNotes(final HttpSession pSession) throws BusinessException {
		
        LogHelper.debug(this.getClass(), "saveNotes() begin");
		final CustomerProfile customerProfile = SessionHelper.getCustomerProfile(pSession);
		final AgentProfile agentProfile = SessionHelper.getAgentProfile(pSession);
        final List<CitNotes> notes = new ArrayList<CitNotes>();
        
        // extract the list of CIT notes from the Tuple list.
        for(Tuple<CitNotes, NoteViewInfo> tuple: this.citNotes) {
            notes.add(tuple.getFirstValue());
        }

		try {
            final CallTrackingEJBHome home = (CallTrackingEJBHome)ejbContext.lookup("CallTrackingEJB");
            final CallTrackingEJBRemote callTrackingEJBRemote = home.create();
            callTrackingEJBRemote.saveNote(notes, customerProfile, agentProfile);
			
		} catch (Exception e) {
			LogHelper.error(this.getClass(), "saveNotes(List<CitNotes> pNotes, final HttpSession pSession) failed", e);
            throw new BusinessException(MessageTypeEnum.MESSAGE_ERROR, "errors.citnotes.saveFailed", null);
		}
		
		// remove the saved notes
        if (this.citNotes != null) {
            this.citNotes.clear();
        }

		// at least one note has been saved
        noteSubmitted = true;
        
		// update the notes history list
		refreshCitNotesHistory(customerProfile.getAccountNumber());
        LogHelper.debug(this.getClass(), "saveNotes() end");
	}
    
    /**
     * Remove a CIT note from session.
     * 
     * @param pIndex index of the note to be removed.
     */
    public void removeNote(final Integer pIndex) {
        this.citNotes.remove(pIndex.intValue());
    }
	

	/**
	 * @return the citNotes
	 */
	public List<Tuple<CitNotes, NoteViewInfo>> getCitNotes() {
		return citNotes;
	}

	/**
	 * @param pCitNotes the citNotes to set
	 */
	public void setCitNotes(final List<Tuple<CitNotes, NoteViewInfo>> pCitNotes) {
        citNotes = pCitNotes;
	}

	/**
     * Get the list of CitNotes for the Transactions History.
     * 
	 * @return the citNotesHistory
	 */
	public List<CitNotes> getCitNotesHistory() {

		return citNotesHistory;
	}


	/**
     * Get the list size of CitNotes for the Transactions History.
     * 
	 * @return the citNotesHistorySize
	 */
	public int getCitNotesHistorySize() {
		if(citNotesHistory != null && citNotesHistory.size()>0)
		{
			return citNotesHistory.size();
		}
		return 0;
	}
	

	
	/**
	 * Fetch the list of saved CitNotes and set it in history list.
	 * 
	 * @param pAccountNumber the customer's account number.
	 * @return List<CitNotes> to be displayed in the Transaction History list.
	 */
	public void refreshCitNotesHistory(final String pAccountNumber) {

		try {
            final CallTrackingEJBHome home = (CallTrackingEJBHome)ejbContext.lookup("CallTrackingEJB");
            final CallTrackingEJBRemote callTrackingEJBRemote = home.create();
            citNotesHistory = callTrackingEJBRemote.getCitNotesHistory(pAccountNumber);
			
		} catch (Exception e) {
			LogHelper.error(this.getClass(), "refreshCitNotesHistory(final String pAccountNumber) failed", e);
		}
	}
	
    /**
     * Replace all tokens in the Note Template with their actuals values and return the resulting String.
     * 
     * @param ptemplate the Template which hold the default text of the CitNote with the unparsed tokens.
     * @param pValues the CitNotesTokenValues which hold the session values to replace the tokens.
     * @return String that holds the text with parsed tokens to be set in the CitNotes
     */
    private String replaceTemplateTokens(final Template ptemplate, final TokenValues pValues) 
    {
        final String temContent = ptemplate.getDescription();
        final Iterator colIter = ptemplate.getTemplateTokenMappings().iterator();
        final Map<String, TokenMapping> allMap = new HashMap<String, TokenMapping>();
        final Map<String, String> allDefaultValueMap = new HashMap<String, String>();

        final StringBuffer result = new StringBuffer();
        final StringBuffer curKey = new StringBuffer();
        boolean inKey = false;
        boolean tokenValueFound = false;

            //first transform collection in map
            while (colIter.hasNext()) {
                final TemplateTokenMapping token = (TemplateTokenMapping) colIter.next();
                allMap.put(token.getTokenMapping().getDescription(), token.getTokenMapping());
                allDefaultValueMap.put(token.getTokenMapping().getDescription(), token.getDefaultText());
            }

            final StringCharacterIterator iterator = new StringCharacterIterator(temContent);
            char character = iterator.current();
            while (character != CharacterIterator.DONE) {
                if (inKey) {
                    if (character == '%') {
                        inKey = false;
                            try {
                                tokenValueFound = false;
                                LogHelper.debug(this.getClass(), "Template " + ptemplate.getTemplateNo()
                                    + ", method mapping \"" + curKey.toString() + "\"");
                                final String methodCall = (allMap.get(curKey.toString())).getMapping();
                                curKey.toString();
                                final Class klass = pValues.getClass();
                                final Method klassMethod = klass.getMethod(methodCall, (Class[]) null);
                                LogHelper.info(this.getClass(), "Calling method " + klassMethod.getName());
                                final Object val = klassMethod.invoke(pValues, (Object[])null);
                                
                                if (val == null) {
                                    LogHelper.info(this.getClass(), "replaceTemplateTokens: method " 
                                        + klassMethod.getName() + " result was null");
                                } else {
                                    result.append(val.toString());
                                    tokenValueFound = true;
                                }
                            } catch (final NoSuchMethodException e) {
                                //No such method could be found.  This is a possiblity as provided
                                //container may be missing some method to fill the template.
                                LogHelper.info(this.getClass(), "Cannot retrieve information for template "
                                    + ptemplate.getTemplateNo() + ", missing method mapping \"" + curKey.toString()
                                    + "\"");
                            } catch (final NullPointerException e) {
                                //This template is not correctly formated.
                                LogHelper.error(this.getClass(), "Malformed template #"
                                    + ptemplate.getTemplateNo() + ", missing method mapping \"" + curKey.toString()
                                    + "\"", e);
                            } catch (final Exception e) {
                                //You should not see that one as we are only using getter without
                                //parameters
                                LogHelper.error(this.getClass(), "Exception occured in replaceTemplateTokens() - see stack trace for details", e);
                            }
                        
                        
                        //-- When no value is found we took the default one --
                        if (!tokenValueFound) {
                            final TokenMapping lMapping = allMap.get(curKey.toString());
                            if (lMapping != null && Boolean.TRUE.equals(lMapping.getDefaultValue())) {
                                final String defaultText = allDefaultValueMap.get(lMapping.getDescription());

                                if (defaultText != null) {
                                    result.append(defaultText);
                                }
                            }
                        }
                        
                        curKey.delete(0, curKey.length());
                    } else {
                        curKey.append(character);
                    }
                } else {
                    if (character == '%') {
                        inKey = true;
                    } else {
                        result.append(character);
                    }
                }
                character = iterator.next();
            }
            
        return result.toString();
    }
    
    
    /**
     * Check if a note has been saved during the session.
     * 
     * @return true of at least one note was saved in database, false otherwise.
     */
    public boolean getNoteSubmitted()
    {
        return noteSubmitted;
    }
    
    /**
     * Used to store extra info needed by the UI only.
     * 
     */
    public class NoteViewInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        private String categoryText = "";
        private String reasonText = "";
        private Long reasonNo;
        private Long categoryNo;
        
        /**
         * @return the categoryText
         */
        public String getCategoryText()
        {
            return categoryText;
        }
        
        /**
         * @param categoryText the categoryText to set
         */
        public void setCategoryText(final String pCategoryText)
        {
            categoryText = pCategoryText;
        }
        
        /**
         * @return the reasonText
         */
        public String getReasonText()
        {
            return reasonText;
        }
        
        /**
         * @param reasonText the reasonText to set
         */
        public void setReasonText(final String pReasonText)
        {
            reasonText = pReasonText;
        }

        /**
         * @return the reasonNo
         */
        public Long getReasonNo()
        {
            return reasonNo;
        }

        /**
         * @param reasonNo the reasonNo to set
         */
        public void setReasonNo(final Long pReasonNo)
        {
            reasonNo = pReasonNo;
        }

        /**
         * @return the categoryNo
         */
        public Long getCategoryNo()
        {
            return categoryNo;
        }

        /**
         * @param categoryNo the categoryNo to set
         */
        public void setCategoryNo(final Long pCategoryNo)
        {
            categoryNo = pCategoryNo;
        }
    }
    
    /**
     * This class is used for reporting data.
     */
    public enum NoteOrigin implements Serializable {
        
        BILLING_TRANSACTION("BILLING TRANSACTION"),
        BILLING_WIZARD("BILLING WIZARD"),
        TROUBLESHOOTING("TROUBLESHOOTING"); // TUX diagnostic 
        
        final String value; // field in RD_VIEWING_STATS
        
        /**
         * @param value field the in RD_VIEWING_STATS
         */
        private NoteOrigin(final String pValue){
            this.value = pValue;
            
        }
        
        /**
         * @return String the value.
         */
        public String getValue() {
            return this.value;
        }
    }
}

package com.expressvu.callcentre.common.db.persistence.calltracking;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bludo1
 */
public class CitNotes implements Serializable {

    // Needed for Serializable interface
    private static final long serialVersionUID = 1L;
    // private CitNotesPK citNotesPK;
    private Long siteId;
    private Long noteId;
    private Long updCnt;
    private String accountId;
    private String customerId;
    private String externalId;
    private String subject;
    private String retention = "L"; // default Long
    private Date createDatetime;
    private String createOper; // agent user id
    private String noteText;
    private Date loadDate;
    private String lastChgOper;
    private Date lastChgDateTime;
	/setters and getters
	=====================================
/*
 * Created on : 3-Aug-06
 * File name : CallTrackingDAO.java
 * 
 * 
 */
package com.expressvu.callcentre.business.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.expressvu.callcentre.business.helper.HibernateHelper;
import com.expressvu.callcentre.common.beans.customer.CustomerProfile;
import com.expressvu.callcentre.common.beans.customer.Name;
import com.expressvu.callcentre.common.db.persistence.calltracking.CitInteraction;
import com.expressvu.callcentre.common.db.persistence.calltracking.CitInteractionPK;
import com.expressvu.callcentre.common.db.persistence.calltracking.CitIntractivity;
import com.expressvu.callcentre.common.db.persistence.calltracking.CitIntractivityPK;
import com.expressvu.callcentre.common.db.persistence.calltracking.CitNotes;
import com.expressvu.callcentre.common.db.persistence.calltracking.Rfc;
import com.expressvu.callcentre.common.db.persistence.calltracking.RfcCallTrackingCategory;
import com.expressvu.callcentre.common.db.persistence.calltracking.Template;

/**
 * @author legge1
 */
public final class CallTrackingDAO 
{
    
	private final static String QUERY_TEMPLATE_BY_ITEMNO = "from Template t1, CallTrackItemLobMapping t2 where t2.itemNo = :itemNo and t1.templateNo = t2.templateNo and t2.lineOfBusiness = :lineOfBusiness";
   
    /**
     * Private constructor
     */
    private CallTrackingDAO() {

    }

    /**
     * Will return rfc association for selected category no
     * @param pDb DbRequest object
     * @param pCategoryNo Category no 
     * 
     * @throws HibernateException if error
     * @return rfc no or null if not association 
     */
    public static Rfc getRfcCategory(final Session pSession, final Long pCategoryNo)
    {
        Rfc retVal = null;
         
        final Query lQuery = pSession.createQuery("FROM RfcCallTrackingCategory where categoryNo = :categoryNo");

        lQuery.setLong("categoryNo", pCategoryNo);

        final RfcCallTrackingCategory rfcCallCategory = (RfcCallTrackingCategory) lQuery.uniqueResult();

        if (rfcCallCategory != null) {            
            retVal = rfcCallCategory.getRfc();
        }
        return retVal;
    }
     
    /**
     * Save note in Intractivity table
     * @param pSession Session handle
     * @param pConnection Connection handle
     * @param pCurNote the CitNotes to save
     * @param pInterKey prevouisly saved <code>CitInteraction</code>
     * 
     * @throws HibernateException if error
     * @throws SQLException if error
     */
    public static void saveIntractivity(final Session pSession, 
                                        final Connection pConnection, 
                                        final CitNotes pCurNote, 
                                        final Long pInterKey)
        throws HibernateException, SQLException 
    {
        CallableStatement lStatement = null;
        ResultSet lResultSet = null;
        
        try {
            lStatement = pConnection.prepareCall("SELECT frame.getidgn_pkg.getidgen('actv') FROM DUAL");
            lResultSet = lStatement.executeQuery();
            lResultSet.next();
            
            final Long key = new Long(lResultSet.getLong(1));
            final CitIntractivity newInter = new CitIntractivity();
            final CitIntractivityPK newInterPK = new CitIntractivityPK();
    
            newInterPK.setSiteId(new Long(10080));
            newInterPK.setActvId(key);
            newInter.setCitIntractivityPK(newInterPK);
    
            newInter.setIntrId(pInterKey);
            newInter.setNoteId(pCurNote.getNoteId());
            newInter.setAccountId(pCurNote.getAccountId());
            newInter.setCustomerId(pCurNote.getCustomerId());
            newInter.setAdefRefNum("6001");
            newInter.setDescription(pCurNote.getSubject() + " note added.");
            newInter.setCreateDatetime(pCurNote.getLoadDate());
            newInter.setCreateOper(pCurNote.getCreateOper());
            newInter.setLastChgOper(pCurNote.getCreateOper());
            newInter.setExternalId(null);
            newInter.setLastChgDatetime(pCurNote.getLoadDate());
            newInter.setLoadDate(pCurNote.getLoadDate());
    
            pSession.save(newInter);
        } finally {
            if (lResultSet != null) {
                lResultSet.close();
            }
            if (lStatement != null) {
                lStatement.close();
            }
        }
    }

    /**
     * Save note in Interaction table
     * @param pSession Session handle
     * @param pConnection Connection handle
     * @param pProfile profile of current customer
     * @param pCurNote current note already saved
     * 
     * @return the new <code>CitInteraction</code>
     * @throws SQLException if error
     */
    public static Long saveInteraction(final Session pSession, final Connection pConnection, final CustomerProfile pProfile, final CitNotes pCurNote)
        throws SQLException 
    {
        Long lResult = null;
        CallableStatement lStatement = null;
        ResultSet lResultSet = null;
        
        try {
            lStatement = pConnection.prepareCall("SELECT frame.getidgn_pkg.getidgen('intr') FROM DUAL");
            
            final CitInteraction newInter = new CitInteraction();
            final CitInteractionPK newInterPK = new CitInteractionPK();
            
            lResultSet = lStatement.executeQuery();
            lResultSet.next();
            lResult = new Long(lResultSet.getLong(1));
    
            newInterPK.setSiteId(new Long(10080));
            newInterPK.setIntrId(lResult);
            newInter.setCitInteractionPK(newInterPK);
            newInter.setAccountId(pCurNote.getAccountId());
            final Name name = pProfile.getName();
            
            if (name == null) {
                newInter.setCallerName("");
            }
            else { // name is not null
                newInter.setCallerName(name.getLastName() + ", " + name.getFirstName());
            }
            
            newInter.setCreateDatetime(pCurNote.getLoadDate());
            newInter.setCreateOper(pCurNote.getCreateOper());
            newInter.setLastChgOper(pCurNote.getCreateOper());
            newInter.setCustomerId(pCurNote.getCustomerId());
            newInter.setExternalId(null);
            newInter.setFinishDatetime(pCurNote.getLoadDate());
            newInter.setLastChgDatetime(pCurNote.getLoadDate());
            newInter.setIntrType("Other");
            newInter.setLoadDate(pCurNote.getLoadDate());
            newInter.setSource("ACSR");
            newInter.setStartDatetime(pCurNote.getLoadDate());
            newInter.setSubject("Other");
    
            pSession.save(newInter);
        } finally {
            if (lResultSet != null) {
                lResultSet.close();
            }
            if (lStatement != null) {
                lStatement.close();
            }
        }

        return lResult;
    }

    /**
     * This function retrieves the last 10 notes history for an account.
     * 
     * @param pAccountNumber String for the customer's account number.
     * 
     * @return List<CitNotes> of notes ordered by last changed date
     * 
     * @throws HibernateException if error
     */
    @SuppressWarnings("unchecked")
	public static List<CitNotes> getCitNotesHistory(final String pAccountNumber)        
    {
    	Session lSession = null;
    	List<CitNotes> lResult = null;        
        
    	lSession = HibernateHelper.getSessionCITNotes();
        final Criteria lCrit = lSession.createCriteria(CitNotes.class);
        
        lCrit.add(Expression.eq("accountId", pAccountNumber));
        lCrit.addOrder(Order.desc("createDatetime"));
        lCrit.setFirstResult(0);
        lCrit.setMaxResults(10);
        
        lResult = lCrit.list();       
        
        return lResult;
    }
    
    /**
     * Returns the Template object matching the itemNo (i.e. the note Template for a Reason).
     * 
     * @param pItemNo the itemNo of the Template (i.e. also often refered as the reasonNo).
     * @param pSession the hibernat Session.
     * @return Template object.
     */
    public static Template getTemplateByItemNo(final Long pItemNo, final Session pSession, final String lineOfBusiness) {

    	Template lTemplate = null;

        final Query lQuery = pSession.createQuery(QUERY_TEMPLATE_BY_ITEMNO);

        lQuery.setLong("itemNo", pItemNo);
        lQuery.setString("lineOfBusiness", lineOfBusiness);
        
        final Object[] lArray = (Object[]) lQuery.uniqueResult();
        
        if (lArray != null && lArray.length == 2) {
            lTemplate = (Template) lArray[0];
        }
        
		return lTemplate;
	}

}
