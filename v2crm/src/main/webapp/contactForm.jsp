 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<%@ page import="com.v2crm.domain.*" %> 

        <style type="text/css">
		 .bs-example{
			margin: 20px;
		  }
		  
		  

		.bs-example  input[type="text"] {
		   height: 24px;
		   font-size: 15px;
		   line-height: 24px;
		}
		.bs-example  input::-webkit-input-placeholder {
	color: rgba(255,0,255,1); /* white color with alpha = 1 (alpha = opacity varies on a scale of 0 to 1 with decimal values in between) */
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: lighter;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink; /* blink property doesn't work in chrome right now */
}
input::-moz-placeholder {
	color: rgba(255,0,255,1);
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 25px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}
input:-moz-placeholder {   /* Older versions of Firefox */
	color: rgba(255,0,255,1);    /* alpha property doesn't properly work Firefox */
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}
input:-ms-input-placeholder { 
	color: rgba(255,0,255,1);
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}

		</style>
         
             <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
           
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Contact Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Lead</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
    <s:form  id="contactForm" action="SaveContact">
    <s:push value="contact"> 
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.firstName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*First Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="firstName" name="firstName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="contact.lastName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*Last Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="lastName" name="lastName"/>
            </div>
           <div class="col-xs-2">
                <label for="contact.company" class="control-label" style="font-weight: normal;"><b>*Company</b></label>
				<s:textfield type="text" cssClass="form-control" id="company" name="company"/>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.primaryEmail" class="control-label" style="font-weight: normal;"><b>*Primary Email</b></label>
				<s:textfield type="text" cssClass="form-control" id="primaryEmail" name="primaryEmail"/>
            </div>
           
			<div class="col-xs-2">
                <label for="contact.officePhone" class="control-label" style="font-weight: normal;">Office Phone</label>
				<s:textfield type="text" cssClass="form-control" id="officePhone" name="officePhone"/>
            </div>
           <div class="col-xs-2">
                <label for="contact.mobilePhone" class="control-label" style="font-weight: normal;">Mobile Phone</label>
				<s:textfield type="text" cssClass="form-control" id="mobilePhone" name="mobilePhone"/>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.homePhone" class="control-label" style="font-weight: normal;">Home Phone</label>
				<s:textfield type="text" cssClass="form-control" id="homePhone" name="homePhone"/>
            </div>
           
			<div class="col-xs-2">
                <label for="contact.designation" class="control-label" style="font-weight: normal;">Designation</label>
				<s:textfield type="text" cssClass="form-control" id="designation" name="designation"/>
            </div>
           <div class="col-xs-2">
                <label for="contact.dateOfBirth" class="control-label" style="font-weight: normal;">Date Of Birth</label>
				<s:textfield type="text" cssClass="form-control" id="dateOfBirth" name="dateOfBirth">
					<s:param name="value">
						<s:date name="dateOfBirth" format="MM/dd/yyyy"/>
					</s:param>
				</s:textfield>
				
            </div>
           
        </div>
		
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.messengerID" class="control-label" style="font-weight: normal;">Messenger ID</label>
				<s:textfield type="text" cssClass="form-control" id="messengerID" name="messengerID"/>
            </div>
           
			<div class="col-xs-2">
                <label for="contact.messengerType" class="control-label" style="font-weight: normal;">Select Messenger Type</label>
                <s:select list="messengerTypeLst" name="messengerType"  value ="messengerType"  headerKey="-1" headerValue="Select" />
            </div>
			
			<div class="col-xs-2">
                <label for="contact.department" class="control-label" style="font-weight: normal;">Department</label>
				<s:textfield type="text" cssClass="form-control" id="department" name="department"/>
            </div>
          
	    </div>
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.reference" class="control-label" style="font-weight: normal;">Reference</label><br>
				<%-- <input type="radio"  name="reference" value="true"  <% if(contact.isReference()){ %> checked<% } %> > Yes
				<input type="radio"  name="reference" value="false" <% if(!contact.isReference()){ %> checked<% } %> > No --%>
				<s:radio name="reference" list="#{true:'Yes',false:'No'}" value="reference" />
            </div>
           
			<div class="col-xs-2">
                <label for="contact.reportsTo" class="control-label" style="font-weight: normal;">Reports To</label>
				<s:textfield type="text" cssClass="form-control" id="reportsTo" name="reportsTo"/>
            </div>
            
           <div class="col-xs-2">
                <label for="contact.fax" class="control-label" style="font-weight: normal;">Fax</label>
				<s:textfield type="text" cssClass="form-control" id="fax" name="fax"/>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.doNotCall" class="control-label" style="font-weight: normal;">Do Not Call          </label><br>
                <s:radio name="doNotCall" list="#{true:'Yes',false:'No'}" value="doNotCall" />
				<%-- <input type="radio"  name="doNotCall" value="true"  <% if(contact.isDoNotCall()){ %> checked<% } %>> Yes
				<input type="radio"  name="doNotCall" value="false" <% if(!contact.isDoNotCall()) { %> checked<% } %>> No --%>
            </div>
           
			<div class="col-xs-2">
                <label for="contact.contactSource" class="control-label" style="font-weight: normal;">Contact Type</label>
                <s:select list="leadSourceLst" name="contactSource"  value ="contactSource"  headerKey="-1" headerValue="Select" />
            </div>
            
           <div class="col-xs-2">
              
            </div>
           
        </div>
		
		<b><hr></b>
		<h4>
	<u><ul>Office Address<ul></u>
			
		</h4>
		
		<div class="row">
			<div class="col-xs-2">
                <label for="city" class="control-label" style="font-weight: normal;">City</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.city" name="officeAddress.city"/>
            </div>
           
			<div class="col-xs-2">
                <label for="street" class="control-label" style="font-weight: normal;">Street</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.street" name="officeAddress.street"/>
            </div>
           <div class="col-xs-2">
                <label for="building" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Building</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.bldg" name="officeAddress.bldg"/>
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="officeNumber" class="control-label" style="font-weight: normal;">Office Number</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.officeNumber" name="officeAddress.officeNumber"/>
             </div>
           
			<div class="col-xs-2">
                <label for="zip" class="control-label" style="font-weight: normal;">Zip</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.pin" name="officeAddress.pin"/>
            </div>
           <div class="col-xs-2">
                <label for="state" class="control-label" style="font-weight: normal;">State</label>
                <s:select list="statesLst" name="officeAddress.state"  value ="officeAddress.state"  headerKey="-1" headerValue="Select" />
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="country" class="control-label" style="font-weight: normal;">Country</label>
				<s:textfield type="text" cssClass="form-control" id="officeAddress.country" name="officeAddress.country"/>
            </div>
           
			<div class="col-xs-2">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
		<br>
		
		
		<b><hr></b>
		<h4>
	<u><ul>Home Address<ul></u>
			
		</h4>
		
		
		
			<div class="row">
			<div class="col-xs-2">
                <label for="city" class="control-label" style="font-weight: normal;">City</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.city" name="homeAddress.city"/>
            </div>
           
			<div class="col-xs-2">
                <label for="street" class="control-label" style="font-weight: normal;">Street</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.street" name="homeAddress.street"/>
            </div>
           <div class="col-xs-2">
                <label for="building" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Building</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.bldg" name="homeAddress.bldg"/>
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="officeNumber" class="control-label" style="font-weight: normal;">Office Number</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.officeNumber" name="homeAddress.officeNumber"/>
             </div>
           
			<div class="col-xs-2">
                <label for="zip" class="control-label" style="font-weight: normal;">Zip</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.pin" name="homeAddress.pin"/>
            </div>
           <div class="col-xs-2">
                <label for="state" class="control-label" style="font-weight: normal;">State</label>
                <s:select list="statesLst" name="homeAddress.state"  value ="homeAddress.state"  headerKey="-1" headerValue="Select" />
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="country" class="control-label" style="font-weight: normal;">Country</label>
				<s:textfield type="text" cssClass="form-control" id="homeAddress.country" name="homeAddress.country"/>
            </div>
           
			<div class="col-xs-2">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
           
			<div class="col-xs-4">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
        
        
        
        
        </s:push>
        </s:form>
  <!--   </form> -->
</div>


<script>
		$(document).ready(function() {
			$('#contactForm').bootstrapValidator({
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					firstName: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							},
							stringLength: {
								min: 2,
								message: '<font color="red">The username must be atleast 2 characters long</font>'
							}
						}
					},
					lastName: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							}
						}
					},
					company: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							}
						}
					},
					primaryEmail: {
						validators: {
							notEmpty: {
								message: '<font color="red">The email address is required and cannot be empty</font>'
							},
							emailAddress: {
								message: '<font color="red">The email address is not a valid</font>'
							}
						}
            },
				}
			});
		});
		</script>
               </aside><!-- /.right-side -->
			 
        <!-- </div> --><!-- ./wrapper -->

        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
             $( "#dateOfBirth" ).datepicker();
  
				
            
            });
			
			
        </script>
        
