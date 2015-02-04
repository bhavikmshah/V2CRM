package com.v2crm.web.actions;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.v2crm.domain.StudentBean;
import com.v2crm.util.DataList;

public class StudentsAction extends ActionSupport implements ServletRequestAware
{
private static final long serialVersionUID = 1L;
private DataList dataList;
private List<StudentBean> students = new ArrayList<StudentBean>();
HttpServletRequest request = null;  
public String displayStudentList() 
{
        students.add(new StudentBean("o7bb002", "Gokul", "ECE", 4));
        students.add(new StudentBean("o7bc074", "Muthu Vijay", "CSE", 6));
        students.add(new StudentBean("o7bb040", "Jaya Prakash", "ECE", 10));
        students.add(new StudentBean("o7bc055", "Mohiadeen", "CSE", 7));
        students.add(new StudentBean("o7bd047", "HariPriya", "IT", 1));
        students.add(new StudentBean("o7bd024", "Pavithra", "IT", 3));
        students.add(new StudentBean("o7bb009", "Aswin", "ECE", 8));
        students.add(new StudentBean("o7ba029", "Sharmila", "IT", 11));
        students.add(new StudentBean("o7ba027", "Nilafar", "IT", 2));
        students.add(new StudentBean("o7bd081", "Dinesh Babu", "MECH", 13));
        students.add(new StudentBean("o7ba062", "Lourde", "MECH", 9));
        students.add(new StudentBean("o7bc079", "Nisha", "CSC", 5));
        students.add(new StudentBean("o7bb039", "Guru Prasad", "MECH", 12));
        students.add(new StudentBean("o7bc033", "Gowtham Raj", "CSE", 15));
        students.add(new StudentBean("o7bb039", "Ibrahim Sha", "ECE", 14));
        students.add(new StudentBean("o7bd081", "Dinesh Babu", "MECH", 16));
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(request != null){
        	dataList = new DataList(request);
        	dataList.setList(students);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(students);
        }
        
        request.setAttribute( "data", dataList );
        return SUCCESS;
}

public String editStudent(){
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){
		System.out.println("param "+en.nextElement());
	}
	
	en = request.getAttributeNames();
	while(en.hasMoreElements()){
		System.out.println(en.nextElement());
	}
    return "edit_success";
}

public String deleteStudent(){
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){
		System.out.println("param "+en.nextElement());
	}
	
	en = request.getAttributeNames();
	while(en.hasMoreElements()){
		System.out.println(en.nextElement());
	}
    return "delete_success";
}



public List<StudentBean> getStudents() 
{
        return students;
}

public void setStudents(List<StudentBean> students) 
{
        this.students = students;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	this.request = arg0;  
}
}