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
                        Lead Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Lead</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
  <s:form  id="leadForm" action="SaveLead">
    <!-- <form id="leadForm" action="SaveLead"> -->
     <s:push value="lead"> 
        <div class="row">
			<div class="col-xs-2">
                <label for="lead.firstName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*First Name<b></label>
				<s:textfield type="text" cssClass="form-control" id="firstName" name="firstName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="lead.lastName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*Last Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="lastName" name="lastName"/>
            </div>
           <div class="col-xs-2">
                <label for="lead.company" class="control-label" style="font-weight: normal;"><b>*Company<b></label>
				<s:textfield type="text" cssClass="form-control" id="company" name="company"/>
				
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="lead.primaryEmail" class="control-label" style="font-weight: normal;"><b>*Primary Email</b></label>
				<s:textfield type="text" cssClass="form-control" id="primaryEmail" name="primaryEmail"/>
            </div>
           
			<div class="col-xs-2">
                <label for="lead.primaryPhone" class="control-label" style="font-weight: normal;"><b>*Phone</b></label>
				<s:textfield type="text" cssClass="form-control" id="primaryPhone" name="primaryPhone"/>
            </div>
           <div class="col-xs-2">
                <label for="lead.company" class="control-label" style="font-weight: normal;">Designation</label>
				<s:textfield type="text" cssClass="form-control" id="designation" name="designation"/>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="lead.firstName" class="control-label" style="font-weight: normal;">Mobile</label>
				<s:textfield type="text" cssClass="form-control" id="mobile" name="mobile"/>
            </div>
           
			<div class="col-xs-2">
                <label for="lead.website" class="control-label" style="font-weight: normal;">Website</label>
				<s:textfield type="text" cssClass="form-control" id="website" name="website"/>
            </div>
           <div class="col-xs-2">
                <label for="lead.fax" class="control-label" style="font-weight: normal;">Fax</label>
				<s:textfield type="text" cssClass="form-control" id="fax" name="fax"/>
            </div>
           
        </div>
		
        <div class="row">
			<div class="col-xs-2">
                <label for="lead.firstName" class="control-label" style="font-weight: normal;">~Number of Employers</label>
				<s:textfield type="text" cssClass="form-control" id="numOfEmployers" name="numOfEmployers"/>
            </div>
           
			<div class="col-xs-2">
                <label for="lead.industry" class="control-label" style="font-weight: normal;">Industry</label>
                
                <s:select list="industriesLst" name="industry"  value ="industry"  headerKey="-1" headerValue="Select" />
                
            </div>
			
			<div class="col-xs-2">
                <label for="leadSource" class="control-label" style="font-weight: normal;">Lead Source</label>
                
                 <s:select list="leadSourcesLst" name="leadSource"  value ="leadSource"  headerKey="-1" headerValue="Select" />
            </div>
          
	    </div>
        <div class="row">
			<div class="col-xs-2">
                <label for="lead.leadStatus" class="control-label" style="font-weight: normal;">Lead Status</label>
                 <s:select list="leadStatussLst" name="leadStatus"  value ="leadStatus"  headerKey="-1" headerValue="Select" />
            </div>
           
			<div class="col-xs-2">
                <label for="lead.rating" class="control-label" style="font-weight: normal;">Lead Rating</label>
                 <s:select list="ratingsLst" name="rating"  value ="rating"  headerKey="-1" headerValue="Select" />
            </div>
           <div class="col-xs-2">
               
            </div>
           
        </div>
		
		<b><hr></b><br>
		<h4>
	<u><ul>Address<ul></u>
			
		</h4>
		
		<div class="row">
			<div class="col-xs-2">
                <label for="city" class="control-label" style="font-weight: normal;">City</label>
				<s:textfield type="text" cssClass="form-control" id="address.city" name="address.city"/>
            </div>
           
			<div class="col-xs-2">
                <label for="street" class="control-label" style="font-weight: normal;">Street</label>
				<s:textfield type="text" cssClass="form-control" id="address.street" name="address.street"/>
            </div>
           <div class="col-xs-2">
                <label for="building" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Building</label>
				<s:textfield type="text" cssClass="form-control" id="address.bldg" name="address.bldg"/>
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="officeNumber" class="control-label" style="font-weight: normal;">Office Number</label>
				<s:textfield type="text" cssClass="form-control" id="address.officeNumber" name="address.officeNumber"/>
             </div>
           
			<div class="col-xs-2">
                <label for="zip" class="control-label" style="font-weight: normal;">Zip</label>
				<s:textfield type="text" cssClass="form-control" id="address.pin" name="address.pin"/>
            </div>
           <div class="col-xs-2">
                <label for="state" class="control-label" style="font-weight: normal;">State</label>
                <s:select list="statesLst" name="address.state"  value ="address.state"  headerKey="-1" headerValue="Select" />
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="country" class="control-label" style="font-weight: normal;">Country</label>
				<s:textfield type="text" cssClass="form-control" id="address.country" name="address.country"/>
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
    <!-- </form> -->
     </s:push>
    </s:form>
</div>
<script>
		$(document).ready(function() {
			$('#leadForm').bootstrapValidator({
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
								message: '<font color="red">The username must be more than 2 characters</font>'
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
					primaryPhone: {
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
					noOfEmployers: {
						validators: {
							integer: {
								message: '<font color="red">Not a number!</font>'
							}
							
						}
					},
				}
			});
		});
		</script>
               </aside><!-- /.right-side -->
			 


