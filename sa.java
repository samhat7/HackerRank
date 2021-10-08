

Reponame: egis
Filepath: https://main.gitlab.in.here.com/wall-e/services/asset-management/egis/egis/blob/master/EgisServices/src/main/java/com/here/egis/services/certificate/CertificateManager.java#L159
Data Category: Contact Data
Data Element: Email Address
Sensitivity: medium
Confidence: high
Matching string: email
Code: `
}

if (StringUtils.isEmpty(certificate.getDefaultEmail())) {
throw new ValidationException("Default email can't be empty");
}
if (certificate.getDefaultEmail().length() > 40) {
throw new ValidationException("Default email can be maximum 40 chars long");

`
✅

----------------------------------------------------------------------------------------------------

Reponame: egis
Filepath: https://main.gitlab.in.here.com/wall-e/services/asset-management/egis/egis/blob/master/EgisTypes/src/main/java/com/here/egis/constants/FieldNames.java#L29
Data Category: Account Data
Data Element: Account Name
Sensitivity: medium
Confidence: high
Matching string: USER_NAME
Code: `
public static final String ES_INDEX_STATE = "index";
public static final String ES_IN_SYNC = "ES_IN_SYNC";
public static final String ASSET_ID = "ASSET_ID";
public static final String SAVED_QUERY_USER_NAME = "USER_NAME";
public static final String SAVED_QUERY_SEARCH_NAME = "SEARCH_NAME";
public static final String SAVED_QUERY_SEARCH_VALUE = "SEARCH_VALUE";
public static final String SAVED_QUERY_WKT_GEOMETRY = "WKT_GEOMETRY";

`
✅


Reponame: egis
Filepath: https://main.gitlab.in.here.com/wall-e/services/asset-management/egis/egis/blob/master/EgisServices/src/main/java/com/here/egis/services/converters/certificate/CertificateConverter.java#L21
Data Category: Account Data
Data Element: Account Password
Sensitivity: high
Confidence: high
Matching string: password
Code: `
private static final String DEFAULT_EMAIL = "defaultEmail";
private static final String DEFAULT_DISPLAY_NAME = "defaultDisplayName";

private static final String SYMMETRIC_KEY = "password";
private static final String ENABLED = "enabled";
private static final String CREATE_DATE = "createDate";
private static final String UPDATE_DATE = "updateDate";

`
✅


Reponame: egis
Filepath: https://main.gitlab.in.here.com/wall-e/services/asset-management/egis/egis/blob/master/EgisWeb/src/main/java/com/navteq/egis/web/shared/Constants.java#L5
Data Category: Personal Identification
Data Element: Employee Code
Sensitivity: low
Confidence: high
Matching string: EmployeeId
Code: `

public class Constants {
public static final String USER_LOGIN_COOKIE = "UserLogin";
public static final String USER_EMPLOYEE_ID = "EmployeeId";
public static final String USER_EMAIL = "user-email";
public static final String BOOLEAN_TRUE = "true";
public static final String BOOLEAN_FALSE = "false";

`
✅



Reponame: egis
Filepath: https://main.gitlab.in.here.com/wall-e/services/asset-management/egis/egis/blob/master/EgisCommon/src/main/java/com/nokia/ot3d/utils/handlers/SystemBoundaryErrorHandler.java#L135
Data Category: Online Identifiers
Data Element: IP Address
Sensitivity: medium
Confidence: high
Matching string: ipAddress
Code: `
* @param ipAddress - client IP address
* @return EgisRuntimeException wrapping the triggering exception (if required)
*/
public static CustomRuntimeException logError(Exception causedBy, String ipAddress) {
return logError(causedBy, "", ipAddress);
}


`

Incorrect 5 occ of above
----------------------------------------------------------------------------------------------------
