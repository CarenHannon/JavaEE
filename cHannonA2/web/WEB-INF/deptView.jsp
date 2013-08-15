<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : deptView
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<%--<sql:query var="departments" dataSource="jdbc/company">
    SELECT dname, mgrssn, mgrstartdate, lname,fname
    FROM department, employee where dnumber = ? and mgrssn=ssn
    <sql:param value="${param.dno}"/>
</sql:query>

<sql:query var ="location" dataSource="jdbc/company">
    SELECT dlocation FROm dept_locations where dnumber = ?
    <sql:param value = "${param.dno}"/>
</sql:query>
    
<sql:query var ="employees" dataSource="jdbc/company">
    SELECT ssn,lname,fname FROM employee where dno = ?
    <sql:param value = "${param.dno}"/>
</sql:query>
    
<sql:query var ="projects" dataSource="jdbc/company">
    SELECT pnumber, pname, plocation FROM project where dnum = ?
    <sql:param value = "${param.dno}"/>
</sql:query>--%>


        <h2> Information about the Selected Department </h2>
    <h2> Department Name and Manager</h2>
    
    <table>
        <th>Department Name</th>
        <th>Manager Name</th>
        <th>Manager Start Date</th>
        <c:forEach var ="dpt" items ="${selectedManager}" varStatus ="iter">
        <tr>
            <td>${dpt.dno.dname}</td>
            <td><a href="empView?ssn=${dpt.ssn}">${dpt.lname},${dpt.fname}</td>
            <td>${dpt.dno.mgrstartdate}</td>
        </tr>
        </c:forEach>
    </table>
        
    <h2>Department Location</h2>
    <table>
        <th>Department Location</th>
    <c:forEach var = "loc" items = "${Location}">
        <tr>
            <td>${loc.deptLocationsPK.dlocation}</td>
        </tr>
    </c:forEach>
    </table>
    
    
    
    <h2>Employees in the Department</h2>
    <table>
        <th>Employee SSN</th>
        <th>Last Name</th>
        <th>First Name</th>
    <c:forEach var = "emp" items = "${dEmployees}">
        <tr>
            <td><a href="empView?ssn=${emp.ssn}">${emp.ssn}</a></td>
            <td>${emp.lname}</td>
            <td>${emp.fname}</td>
        </tr>
    </c:forEach>
    </table>
    
    <h2>Projects controlled by the Department</h2>
    <table>
        <th>Project Number</th>
        <th>Project Name</th>
        <th>Project Location</th>
    <c:forEach var = "proj" items = "${dProjects}">
        <tr>
            <td><a href="projView?pno=${proj.pnumber}">${proj.pnumber}</td>
            <td>${proj.pname}</td>
            <td>${proj.plocation}</td>
        </tr>
    </c:forEach>
    </table>