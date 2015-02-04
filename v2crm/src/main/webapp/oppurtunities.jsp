 <%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
        
         <script src="js/jquery-1.8.2.js"></script> 
		    <link href="css/basic.css" rel="stylesheet" type="text/css" />
		    <script> 
		    function goToOppurtunityForm(){
		    	window.location="EditOppurtunity";
		    	
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
                        <th>Oppurtunity Name</th>
                        <th>Contact</th>
                        <th>Sales Stage</th>
                        <th>Oppurtunity Strategy</th>
						<th>Oppurtunity Type</th>
						<th>Get All Oppurtunities</th>
						<th>Search Oppurtunities</th>
						<th>Create Oppurtunity</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="oppurtunityName" class="form-control" placeholder="Oppurtunity Name"/></td>
                        <td><input type="text" name="ontactForOppurtunity" class="form-control" placeholder="FirstName LastName"/></td>
                        <td><input type="text" name="salesStage" class="form-control" placeholder="Sales Stage"/></td>
                        <td><input type="text" name="oppurtunityStrategy" class="form-control" placeholder="Oppurtunity Strategy"/></td>
                        <td><input type="text" name="oppurtunityType" class="form-control" placeholder="Oppurtunity Type"/></td>
						 <td><button class="btn btn-warning"><i class="fa fa-bug"></i> Get Oppurtunities</button></td>
						 <td><button class="btn btn-info"><i class="fa fa-download"></i> Search Oppurtunities</button> </td>
						 <td><button class="btn btn-info"  onclick="goToOppurtunityForm()"><i class="fa fa-download"></i> Create Oppurtunity</button></td>
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
				<display:table id="oppurtunitiesTable" decorator="com.v2crm.web.displaytag.decorators.DisplayTableDecorator" partialList="true"  size="20" name="data" pagesize="10"  requestURI="">
				<display:column property="oppurtunityName" title="Oppurtunity Name"/>
				<display:column property="salesStage" title="Sales Stage"/>
				<display:column property="oppurtunityStrategy" title="Oppurtunity Strategy"/>
				<display:column property="oppurtunityType" title="Oppurtunity Type"/>
				<display:column property="contactForOppurtunity" title="Contact"/>
				
				 <display:column property="editOppurtunityLink" title="Edit" />
				 <display:column property="deleteOppurtunityLink" title="Delete" />
				</display:table>
				</div>
               </aside><!-- /.right-side -->
			 
        <!-- </div> --><!-- ./wrapper -->

        <!-- add new calendar event modal -->

