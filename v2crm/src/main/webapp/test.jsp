<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html>
<body>
<s:bean name="java.util.HashMap" id="qTableLayout">
    <s:param name="tablecolspan" value="%{8}" />
</s:bean>	
<s:form id="validationForm" action="validation-submit" method="post" theme="qxhtml">

                <s:textfield label="First Name" name="firstName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="LastName" name="lastName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="First Name" name="firstName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="LastName" name="lastName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				<s:textfield label="First Name" name="firstName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="LastName" name="lastName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="First Name" name="firstName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="LastName" name="lastName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="First Name" name="firstName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				<s:textfield label="LastName" name="lastName">
						<s:param name="labelcolspan" value="%{2}" /> 
						<s:param name="inputcolspan" value="%{2}" /> 
                </s:textfield>
				
				 <s:submit value="Create Lead" align="center">
					<s:param name="colspan" value="%{8}" />
					<s:param name="align" value="%{'center'}" />
				</s:submit>

            </s:form>
			</html>
			</body>