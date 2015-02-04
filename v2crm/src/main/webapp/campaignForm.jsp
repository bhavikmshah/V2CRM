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
                        Campaign Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Lead</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
    <!-- <form id="campaignForm" action="SaveCampaign"> -->
    <s:form  id="campaignForm" action="SaveCampaign">
    <s:push value="campaign"> 
        <div class="row">
			<div class="col-xs-2">
                <label for="campaignName" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*Campaign Name</b></label>
				<s:textfield type="text" cssClass="form-control" id="campaignName" name="campaignName"/>
            </div>
           
			<div class="col-xs-2">
                <label for="ownedBy" class="control-label" style="font-weight: normal;" style="font-weight: normal;"><b>*OwnedBy</b></label>
				<s:textfield type="text" cssClass="form-control" id="ownedBy" name="ownedBy"/>
            </div>
           
           <div class="col-xs-2">
                <label for="estimatedCost" class="control-label" style="font-weight: normal;"><b>*Estimated Cost</b></label>
				<s:textfield type="text" cssClass="form-control" id="estimatedCost" name="estimatedCost"/>
            </div>
           
        </div>
        <br>
        <div class="row">
			 <div class="col-xs-2">
                <label for="startDate" class="control-label" style="font-weight: normal;"><b>*Campaign Start Date</b></label>
				 <s:textfield type="text" cssClass="form-control" id="startDate" name="startDate">
					<s:param name="value">
						<s:date name="startDate" format="MM/dd/yyyy"/>
					</s:param>
				</s:textfield> 
            </div>
           
		<div class="col-xs-2">
                <label for="endDate" class="control-label" style="font-weight: normal;">Campaign End Date</label>
				 <s:textfield type="text" cssClass="form-control" id="endDate" name="endDate">
					<s:param name="value">
						<s:date name="endDate" format="MM/dd/yyyy"/>
					</s:param>
				</s:textfield> 
            </div>
           
            <div class="col-xs-2">
                <label for="actualCost" class="control-label" style="font-weight: normal;">Actual Cost</label>
				<s:textfield type="text" cssClass="form-control" id="actualCost" name="actualCost" placeholder="Actual Cost" />
            </div>
           
        </div>
        <br>
        <div class="row">
			<div class="col-xs-2">
                <label for="expectedRevenue" class="control-label" style="font-weight: normal;"><b>*Expected Revenue</b></label>
				<s:textfield type="text" cssClass="form-control" id="expectedRevenue" name="expectedRevenue"/>
            </div>
           
			<div class="col-xs-2">
                <label for="actualRevenue" class="control-label" style="font-weight: normal;">Actual Revenue</label>
				<s:textfield type="text" cssClass="form-control" id="actualRevenue" name="actualRevenue"/>
            </div>
           
			<div class="col-xs-2">
                <label for="campaignType" class="control-label" style="font-weight: normal;">Select Campaign Type</label>
                 <s:select list="campaignTypeLst" name="campaignType"  value ="campaignType"  headerKey="-1" headerValue="Select" />
				
            </div>
           
        </div>
		<br>
        <div class="row">
			<div class="col-xs-2">
                <label for="campaignStatus" class="control-label" style="font-weight: normal;">Select Campaign Status</label>
                <s:select list="campaignStatusLst" name="campaignStatus"  value ="campaignStatus"  headerKey="-1" headerValue="Select" />
            </div>
           
			<div class="col-xs-2">
                <label for="campaignResponseType" class="control-label" style="font-weight: normal;">Select Response Type</label>
                <s:select list="campaignResponseTypeLst" name="campaignResponseType"  value ="campaignResponseType"  headerKey="-1" headerValue="Select" />
            </div>
			
			<div class="col-xs-2">
                <label for="expectedResponseCount" class="control-label" style="font-weight: normal;">Expected Response Count</label>
				<s:textfield type="text" cssClass="form-control" id="expectedResponseCount" name="expectedResponseCount"/>
            </div>
          
	    </div>
		<br>
        <div class="row">
			
           
			<div class="col-xs-2">
                <label for="actualResponseCount" class="control-label" style="font-weight: normal;">Actual Response Count</label>
				<s:textfield type="text" cssClass="form-control" id="actualResponseCount" name="actualResponseCount"/>
            </div>
            
           <div class="col-xs-4">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
        <br>
        <hr>
        <br>
        <div class="row">
        <div class="col-xs-6">
                <label for="description" class="control-label" style="font-weight: normal;">Campaign Description</label>
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
   <!--  </form> -->
   </s:push>
   </s:form>
</div>


<script>
		$(document).ready(function() {
			$('#campaignForm').bootstrapValidator({
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					campaignName: {
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
					ownedBy: {
						validators: {
							notEmpty: {
								message: '<font color="red">Required!</font>'
							},
							stringLength: {
								min: 2,
								message: '<font color="red">Atleast 2 digits long</font>'
							}
							
						}
					},
					estimatedCost: {
						validators: {
							integer: {
								message: '<font color="red">Not a Number!</font>'
							},
							stringLength: {
								min: 2,
								message: '<font color="red">Atleast 2 digits long</font>'
							}
						}
					},
					expectedRevenue: {
						validators: {
							integer: {
								message: '<font color="red">Not a Number!</font>'
							},
							stringLength: {
								min: 2,
								message: '<font color="red">Atleast 2 digits long</font>'
							}
						}
					},
					actualCost: {
					validators: {
							integer: {
								message: '<font color="red">Not a Number!</font>'
							}
							
						}
					},
					actualRevenue: {
					validators: {
							integer: {
								message: '<font color="red">Not a Number!</font>'
							}
							
						}
					},
					expectedResponseCount: {
					validators: {
							integer: {
								message: '<font color="red">Not a Number!</font>'
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
                
             $( "#startDate" ).datepicker();
             
             $( "#endDate" ).datepicker();
  
				
            
            });
			
			
        </script>
        
