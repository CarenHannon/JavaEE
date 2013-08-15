<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : empView
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<%--<sql:query var="employees" dataSource="jdbc/company">
    SELECT lname,fname, bdate, address, salary,dno, dname FROM employee,department where ssn = ? and dno = dnumber order by lname, fname;
    <sql:param value="${param.ssn}"/>
</sql:query>

    <sql:query var ="projects" dataSource="jdbc/company">
        SELECT pnumber, pname,hours FROM project, works_on where pno=pnumber and essn=?
        <sql:param value = "${param.ssn}"/>
    </sql:query>--%>

        <h2> Information about the Selected Employee </h2>
    <h2> Employee Information</h2>
    
    <table>
        <th>Employee Name</th>
        <th>Birth Date</th>
        <th>Address</th>
        <th>Salary</th>
        <th>Department</th>
    <c:forEach var ="emp" items ="${selectedEmployee}">
        <tr>
            <td>
                ${emp.lname}, ${emp.fname}
            </td>
            <td>${emp.bdate}</td>
            <td>${emp.address}</td>
            <td>${emp.salary}</td>
            <td><a href="deptView?dno=${emp.dno.dnumber}">${emp.dno.dname}</a></td>
        </tr>
    </c:forEach>
    </table>
    
    <h2>Projects Involved In</h2>
    <table>
        <th>Project Number</th>
        <th>Project Name</th>
        <th>Hours</th>
    
        <c:forEach var = "proj" items = "${employeeProjects}">
            <tr>
                <td>${proj.worksOnPK.pno}</td>
                <td>${proj.project.pname}</td>
                <td>${proj.hours}</td>
            </tr>
        </c:forEach>
    </table>