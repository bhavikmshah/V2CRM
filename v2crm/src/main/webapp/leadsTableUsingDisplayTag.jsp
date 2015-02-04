<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
 <link href="css/locked-column.css" rel="stylesheet" type="text/css" />
  <link href="css/displaytagex.css" rel="stylesheet" type="text/css" />
  
  <!-- Bootstrap css template stuff..-->
       
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
     
        <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
     
        <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
     
        <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
    
        <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
     
        <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
     
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
  <!-- End css template imports-->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students Details</title>
<style type="text/css">

/* for hiding the page banner */
.pagebanner 
{
        display: none;
}
/* for customizing page links */
.pagelinks 
{
        color: maroon;
        margin: 20px 0px 20px 50px;
}
/* for shifting all the Export options*/
.exportlinks 
{
        margin: 20px 0px 20px 30px;
}
/* For changing the spaces between export link */
.export 
{
        margin-left: 30px;
}
/* For Table css */
table 
{
        border: 1px solid #666;
        width: 60%;
        margin: 20px 0 20px 0px;
}
/* For odd and even row decoration */
tr.odd 
{
        background-color: #fff
}
tr.tableRowEven,tr.even 
{
        background-color: #CCCCCC
}
/* Css for table elements */
th,td 
{
        padding: 2px 4px 2px 4px;
        text-align: left;
        vertical-align: top;
}
thead tr 
{
        background-color: #999999;
}
/* For changing the background colour while sorting */
th.sorted 
{
        background-color: #CCCCCC;
}
th.sorted a,th.sortable a 
{
        background-position: right;
        display: block;
        width: 100%;
}
th a:hover 
{
        text-decoration: underline;
        color: black;
}
th a,th a:visited 
{
        color: black;
}
</style>
 
<html>
<body>
		<div class="box-body no-padding">
                                  
            <div class="table-responsive">
                <!-- .table - Uses sparkline charts-->
                <table class="table table-striped">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Industry</th>
                        <th>Organization Name</th>
                    </tr>
                    <tr>
                        <td><a href="#">USA</a></td>
                        <td><div id="sparkline-1"></div></td>
                        <td>209</td>
                        <td>239</td>
                    </tr>
                   
                </table><!-- /.table -->
            </div>
            <div class="box-footer">
	            <button class="btn btn-info"><i class="fa fa-download"></i> Search Leads</button>
	            <button class="btn btn-warning"><i class="fa fa-bug"></i> Get All Leads</button>
       		</div>
       		
       		<div id="tbl-container">
				<display:table id="studentTable" partialList="true"  size="20" name="data" pagesize="5" cellpadding="5px;"
				cellspacing="5px;" style="margin-left:50px;margin-top:20px;" requestURI="">
					<display:column property="rollNo" title="Roll No"/>
					<display:column property="studentName" title="Student Name"/>
					<display:column property="department" title="Department"/>
					<display:column property="rank" title="Rank"/>
					<display:column title="Edit"></display:column>
					<display:column title="Delete"></display:column>
				</display:table>
			</div> 
        </div><!-- /.box-body-->
        




</body>
</html>
