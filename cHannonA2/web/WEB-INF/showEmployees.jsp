<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : showEmployees
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<%--<sql:query var="employees" dataSource="jdbc/company">
    SELECT ssn, lname,fname FROM employee order by lname, fname;
</sql:query>--%>

    <h2> Show All Employees in our Company</h2>
    
    <table>
        <th>Employee SSN</th><th>Last Name</th><th>First Name</th>
    <c:forEach var ="emp" items ="${employees}" varStatus ="iter">
        <tr>
            <td>
                <a href="empView?ssn=${emp.ssn}"> ${emp.ssn}</a>
                
            </td>
            <td>
                ${emp.lname}
            </td>
            <td>
                ${emp.fname}
            </td>
        </tr>
    </c:forEach>
    </table>