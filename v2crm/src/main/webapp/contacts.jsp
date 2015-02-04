<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
        
         <script src="js/jquery-1.8.2.js"></script> 
		    <link href="css/basic.css" rel="stylesheet" type="text/css" />
		    <script> 
		    function goToContactForm(){
		    	window.location="EditContact";
		    	
		    }
		    
		    
		    $(function(){
		    //  $("#leadsTableContent").load("displayStudentList"); 
		    });
		    
		    
		 </script> 

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
           
                <!-- .table - Uses sparkline charts-->
                <table class="table table-striped">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Company</th>
                        <th>Contact Source Type</th>
						<th>Assigned By</th>
						<th>Get All Contacts</th>
						<th>Search Contacts</th>
						<th>Create Contact</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="firstName" class="form-control" placeholder="First Name"/></td>
                        <td><input type="text" name="lastName" class="form-control" placeholder="Last Name"/></td>
                        <td><input type="text" name="company" class="form-control" placeholder="Company"/></td>
                        <td><input type="text" name="contactSource" class="form-control" placeholder="Contact Source Type"/></td>
                        <td><input type="text" name="assignedBy" class="form-control" placeholder="Assigned By"/></td>
						 <td><button class="btn btn-info"><i class="fa fa-download"></i> Get All Contacts</button></td>
						 <td><button class="btn btn-warning"><i class="fa fa-bug"></i> Search Contacts</button></td>
						 <td><button class="btn btn-info"  onclick="goToContactForm()"><i class="fa fa-download"></i> Create Contact</button></td>
                    </tr>
                   
                </table><!-- /.table -->
				 <table  style="border:1px solid black;width:90%">
			 <tr>
			 <td style="border:1px solid black;"><A HREF="#A">A</A>  </td> 
			 <td style="border:1px solid black;"><A HREF="#B">B</A></td>
			 <td style="border:1px solid black;"><A HREF="#C">C</A></td>
			 <td style="border:1px solid black;"><A HREF="#D">D</A></td>
			 <td style="border:1px solid black;"><A HREF="#E">E</A></td>
			 <td style="border:1px solid black;"><A HREF="#F">F</A></td>
			 <td style="border:1px solid black;"><A HREF="#G">G</A></td>
			 <td style="border:1px solid black;"><A HREF="#H">H</A></td>
			 <td style="border:1px solid black;"><A HREF="#I">I</A></td>
			 <td style="border:1px solid black;"><A HREF="#J">J</A></td>
			 <td style="border:1px solid black;"><A HREF="#K">K</A></td>
			 <td style="border:1px solid black;"><A HREF="#L">L</A></td>
			 <td style="border:1px solid black;"><A HREF="#M">M</A></td>
			 <td style="border:1px solid black;"><A HREF="#N">N</A></td>
			 <td style="border:1px solid black;"><A HREF="#O">O</A></td>
			 <td style="border:1px solid black;"><A HREF="#P">P</A></td>
			 <td style="border:1px solid black;"><A HREF="#Q">Q</A></td>
			 <td style="border:1px solid black;"><A HREF="#R">R</A></td>
			 <td style="border:1px solid black;"><A HREF="#S">S</A></td>
			 <td style="border:1px solid black;"><A HREF="#T">T</A></td>
			 <td style="border:1px solid black;"><A HREF="#U">U</A></td>
			 <td style="border:1px solid black;"><A HREF="#V">V</A></td>
			 <td style="border:1px solid black;"><A HREF="#W">W</A></td>
			 <td style="border:1px solid black;"><A HREF="#X">X</A></td>
			 <td style="border:1px solid black;"><A HREF="#Y">Y</A></td>
			 <td style="border:1px solid black;"><A HREF="#Z">Z</A></td>
		   </tr>
		   </table>
	            
				<div>
				<display:table id="contactsTable" decorator="com.v2crm.web.displaytag.decorators.DisplayTableDecorator" partialList="true"  size="20" name="data" pagesize="10"  requestURI="">
				<display:column property="firstName" title="First Name"/>
				<display:column property="lastName" title="Last Name"/>
				<display:column property="company" title="Company"/>
				<display:column property="officePhone" title="Office Phone"/>
				<display:column property="mobilePhone" title="Mobile Phone"/>
				 <display:column property="editLinkForContact" title="Edit" />
				 <display:column property="deleteLinkForContact" title="Delete" />
				</display:table>
				</div>
               </aside><!-- /.right-side -->
			 
