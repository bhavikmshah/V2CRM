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
                        Oppurtunity Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Oppurtunity</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
    <!-- <form id="oppurtunityForm" action="SaveOppurtunity"> -->
     <s:form  id="oppurtunityForm" action="SaveOppurtunity">
    <s:push value="oppurtunity"> 
        <div class="row">
			<div class="col-xs-2">
                <label for="oppurtunityName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*Oppurtunity Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="oppurtunityName" name="oppurtunityName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="amount" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*Amount</b></label>
				<s:textfield type="text" cssClass="form-control" id="amount" name="amount"/>
            </div>
           
           <div class="col-xs-2">
                <label for="probability" class="control-label" style="font-weight: normal;">Probability%</label>
				<s:textfield type="text" cssClass="form-control" id="probability" name="probability"/>
            </div>
           
        </div>
        <br>
        <div class="row">
			 <div class="col-xs-2">
                <label for="expectedClosedDate" class="control-label" style="font-weight: normal;"><b>*Expected Closure Date</b></label>
				<s:textfield type="text" cssClass="form-control" id="expectedClosedDate" name="expectedClosedDate">
					<s:param name="value">
						<s:date name="expectedClosedDate" format="MM/dd/yyyy"/>
					</s:param>
				</s:textfield>
            </div>
           
		<div class="col-xs-2">
                <label for="salesStage" class="control-label" style="font-weight: normal;">Select Sales Stage</label>
                <s:select list="salesStagesLst" name="salesStage"  value ="salesStage"  headerKey="-1" headerValue="Select" />
            </div>
           
            <div class="col-xs-2">
                <label for="leadSource" class="control-label" style="font-weight: normal;">Select Lead Source</label>
                <s:select list="leadSourcesLst" name="leadSource"  value ="leadSource"  headerKey="-1" headerValue="Select" />
            </div>
           
        </div>
        <br>
        <div class="row">
			<div class="col-xs-2">
                <label for="oppurtunityType" class="control-label" style="font-weight: normal;">Select Opportunity Type</label>
                <s:select list="oppurtunityTypeLst" name="oppurtunityType"  value ="oppurtunityType"  headerKey="-1" headerValue="Select" />
            </div>
           
			<div class="col-xs-2">
                <label for="oppurtunityStrategy" class="control-label" style="font-weight: normal;">Select Oppurtunity Strategy</label>
                <s:select list="oppurtunityStrategyLst" name="oppurtunityStrategy"  value ="oppurtunityStrategy"  headerKey="-1" headerValue="Select" />
            </div>
           
			<div class="col-xs-2">
                <label for="primaryEmail" class="control-label" style="font-weight: normal;"><b>*Primary Email</b></label>
				<s:textfield type="text" cssClass="form-control" id="primaryEmail" name="primaryEmail"/>
            </div>
           
        </div>
		<br>
        <div class="row">
			<div class="col-xs-2">
                <label for="campaign" class="control-label" style="font-weight: normal;">Campaign</label>
				<%-- <s:textfield type="text" cssClass="form-control" id="campaign" name="campaign"/> --%>
            </div>
          
		    <div class="col-xs-2">
	               
	            </div>
	           
				<div class="col-xs-2">
	               
	            </div>
	           
	           
	     </div>
	     <br>
        <hr>
        
	     <div class="row">
				 <div class="col-xs-6">
	                <label for="description" class="control-label" style="font-weight: normal;">Oppurtunity Description</label>
					<s:textfield type="text" cssClass="form-control" id="description" name="description"/>
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
			$('#oppurtunityForm').bootstrapValidator({
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					oppurtunityName: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							},
							stringLength: {
								min: 3,
								message: '<font color="red">Atleast 3 characters long!</font>'
							}
						}
					},
					amount: {
						validators: {
							integer: {
								message: '<font color="red">Not a number!</font>'
							},
							stringLength: {
								min: 3,
								message: '<font color="red">Atleast in thousands please!</font>'
							}
						}
					},
					probability: {
						validators: {
							integer: {
								message: '<font color="red">Not a number!</font>'
							},
							stringLength: {
								max: 2,
								message: '<font color="red">Should not be 100 or more!</font>'
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
					}
				}
			});
		});
		</script>
               </aside><!-- /.right-side -->
			 
        <!-- </div> --><!-- ./wrapper -->

        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
             $( "#expectedClosedDate" ).datepicker();
             
            });
			
			
        </script>
        
