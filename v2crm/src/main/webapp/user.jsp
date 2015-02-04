 <%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

        
         <script src="js/jquery-1.8.2.js"></script> 
		    <link href="css/basic.css" rel="stylesheet" type="text/css" />
		    <script> 
		    function goToOppurtunityForm(){
		    	window.location="EditUser";
		    	
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
                        <th>User Name</th>
                        <th>User Type</th>
						<th>Get All Users</th>
						<th>Search Users</th>
						<th>Create Users</th>
                    </tr>
                    <tr>
                        <td><input type="text" name="userName" class="form-control" placeholder="User Name"/></td>
                        <td><input type="text" name="userType" class="form-control" placeholder="User Type"/></td>
						 <td><button class="btn btn-info"><i class="fa fa-download"></i> Get Users</button></td>
						 <td><button class="btn btn-warning"><i class="fa fa-bug"></i> Search Users</button></td>
						 <td><button class="btn btn-info"  onclick="goToOppurtunityForm()"><i class="fa fa-download"></i> Create User</button></td>
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
				<display:table id="userTable" decorator="com.v2crm.web.displaytag.decorators.DisplayTableDecorator" partialList="true"  size="20" name="data" pagesize="10"  requestURI="">
					<display:column property="userName" title="User Name"/>
					<display:column property="userUserType" title="User Type"/>
					<display:column property="editUserLink" title="Edit" />
					<display:column property="deleteUserLink" title="Delete" />
				</display:table>
				</div>
               </aside><!-- /.right-side -->
			 

