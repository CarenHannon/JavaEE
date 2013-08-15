<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : projView
    Created on : Oct 3, 2012, 7:33:28 PM
    Author     : Acer
--%>

<sql:query var="projects" dataSource="jdbc/company">
    SELECT pname, plocation, dnum,dname
    FROM project, department where pnumber = ? and dnum = dnumber
    <sql:param value="${param.pno}"/>
</sql:query>
    
<sql:query var="employees" dataSource="jdbc/company">
    SELECT ssn, lname, fname, hours
    FROM employee, works_on where pno = ? and essn = ssn
    <sql:param value="${param.pno}"/>
</sql:query>
    

    <h2>Information about the Selected Project</h2>
    <h2>Project Information</h2>
    <table>
        <th>Project Name</th>
        <th>Project Location</th>
        <th>Controlling Department</th>
        <c:forEach var="proj" items="${projects.rows}">
            <tr>
                <td>${proj.pname}</td>
                <td>${proj.plocation}</td>
                <td><a href="deptView?dno=${proj.dnum}">${proj.dname}</a></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Employees Working in the Project</h2>
    <table>
        <th>Employee SSN</th>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Hours</th>
        <c:forEach var = "emp" items="${employees.rows}">
            <tr>
                <td><a href="empView?ssn=${emp.ssn}">${emp.ssn}</a></td>
                <td>${emp.lname}</td>
                <td>${emp.fname}</td>
                <td>${emp.hours}</td>
            </tr>
        </c:forEach>
    </table>