package model;

public class Model {

private String fn;
private String ln;
private String hrname;
private String hremail;
private String empemail;
private String phn;
private String add;
private String pass;
private String dob;
private String subject;
private String message;
private String area;
private final String hrheademail="rohitmittal1028@gmail.com";
private final String hrheadpassword="ibmintern";



public String getHrheademail() {
	return hrheademail;
}
public String getHrheadpassword() {
	return hrheadpassword;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getHrName() {
	return hrname;
}
public void setHrName(String hrname) {
	this.hrname = hrname;
}

public String getFn() {
	return fn;
}
public void setFn(String fn) {
	this.fn = fn;
}
public String getLn() {
	return ln;
}
public void setLn(String ln) {
	this.ln = ln;
}
public String getPhn() {
	return phn;
}
public void setPhn(String con) {
	this.phn = con;
}
public String getAdd() {
	return add;
}
public void setAdd(String add) {
	this.add = add;
}
public String getEmpEmail() {
	return empemail;
}
public void setEmpEmail(String email) {
	this.empemail = email;
}
public String getHrEmail() {
	return hremail;
}
public void setHrEmail(String email) {
	this.hremail = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}



}
