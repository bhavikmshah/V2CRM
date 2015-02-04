<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.v2crm.domain.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>



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
                        User Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Lead</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
   <!--  <form id="orgForm" action="SaveOrganization"> -->
    <s:form  id="userForm" action="SaveUser">
    <s:push value="user"> 
        <div class="row">
			<div class="col-xs-2">
                <label for="user.firstName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*First Name</b></label>
                
				<s:textfield type="text" cssClass="form-control" id="firstName" name="firstName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="user.lastName" class="control-label" style="font-weight: normal;" style="font-weight: normal;">*Last Name</label>
				<s:textfield type="text" cssClass="form-control" id="lastName" name="lastName"/>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="user.userName" class="control-label" style="font-weight: normal;"><b>*User Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="userName" name="userName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="user.password" class="control-label" style="font-weight: normal;"><b>*Password</b></label>
				<s:textfield type="text" cssClass="form-control" id="password" name="password"/>
            </div>
            
        </div>
        <div class="row">
			
            
           <div class="col-xs-2">
                <label for="user.UserType" class="control-label" style="font-weight: normal;">*UserType</label>
                 <s:select list="userTypeLst" listKey="id" cssClass="form-control"  listValue="userType"  name="userType.id"  value ="userType.id"  headerKey="-1" headerValue="Select" />
				
            </div>
           
        </div>
        
        <!-- check select tag and bootstrap validator -->
		
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
   <!--  </form> -->
</div>
<script>
		$(document).ready(function() {
			$('#orgForm').bootstrapValidator({
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					orgName: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							},
							stringLength: {
								min: 2,
								message: '<font color="red">The Organization name must be more than 2 characters long</font>'
							}
						}
					},
					primaryPhone: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							},
							
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
					}
				}
			});
		});
		</script>
        </aside><!-- /.right-side -->