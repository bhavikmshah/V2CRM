<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<link href="css/displaytag.css" rel="stylesheet" type="text/css" />
<html>
<body>


<display:table id="studentTable" partialList="true"  size="20" name="data" pagesize="5"  requestURI="">
<display:column property="rollNo" title="Roll No"/>
<display:column property="studentName" title="Student Name"/>
<display:column property="department" title="Department"/>
<display:column property="rank" title="Rank"/>
<display:column title="Edit"></display:column>
<display:column title="Delete"></display:column>
</display:table>



 
</body>
</html>