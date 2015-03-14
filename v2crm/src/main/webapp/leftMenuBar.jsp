<%@ page import="com.v2crm.domain.*,org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    System.out.println(" User us "+ user); System.out.println(" module list "+ user.getUsersModuleAccessLst().size()); request.setAttribute("LoggedInUser",user);  %>
 <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                   
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                                                       
                   <s:iterator value="#request.LoggedInUser.usersModuleAccessLst" status="rowStatus"> 
                   <%-- <s:iterator value="#user.usersModuleAccessLst" status="rowStatus"> --%>
                    
                    
                     <li class="active">
                    	 <a href="<s:property value="link"/>">
                    	 	<i class="<s:property value="cssClass"/>"></i> <span><s:property value="moduleName"/></span>
                    	 </a>                    	 
                    </li>	 
                    </s:iterator>
                        <!-- <li class="active">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        
                        
                         <li>
                            <a href="DisplayLeads">
                                <i class="fa fa-th"></i> <span>Leads</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li>
							<a href="DisplayOrganizations">
                                <i class="fa fa-th"></i> <span>Organizations</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                           
                        </li>
                        <li>
                            <a href="DisplayContacts">
                                <i class="fa fa-laptop"></i>
                                <span>Contacts</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                       <li>
                            <a href="DisplayCampaigns">
                                <i class="fa fa-edit"></i> <span>Campaigns</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                         <li>
                            <a href="DisplayOppurtunities">
                                <i class="fa fa-edit"></i> <span>Oppurtunities</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Documents</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            
                        </li>
                        <li>
                            <a href="pages/calendar.html">
                                <i class="fa fa-calendar"></i> <span>Calendar</span>
                               <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li>
                            <a href="pages/mailbox.html">
                                <i class="fa fa-envelope"></i> <span>MailManager</span>
                               
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>Reports</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/examples/invoice.html"><i class="fa fa-angle-double-right"></i> High Value Leads</a></li>
                                <li><a href="pages/examples/login.html"><i class="fa fa-angle-double-right"></i> High Value Oppurtunities</a></li>
                                <li><a href="pages/examples/register.html"><i class="fa fa-angle-double-right"></i> Hot Leads</a></li>
                                <li><a href="pages/examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Oppurtunities by Industry</a></li>
                                <li><a href="pages/examples/404.html"><i class="fa fa-angle-double-right"></i> Contacts By Organization</a></li>
                                <li><a href="pages/examples/500.html"><i class="fa fa-angle-double-right"></i> Contacts By Oppurtunities</a></li>
                                <li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Closed Oppurtunities</a></li>
								<li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Lost Oppurtunities</a></li>
                            </ul>
                        </li> -->
                        
                       <%--  <li>
                            <a href="DisplayUser">
                                <i class="fa fa-th"></i> <span>Users</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li>
                            <a href="DisplayUserType">
                                <i class="fa fa-th"></i> <span>User Type</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>  --%>
                        
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>