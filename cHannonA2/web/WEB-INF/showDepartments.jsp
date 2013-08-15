<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : showDepartments
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<%--<sql:query var="departments" dataSource="jdbc/company">
    SELECT dnumber, dname FROM department order by dnumber
</sql:query>--%>

    <h2> Show All Departments in Lehman Company</h2>
    
    <table>
        <th>Department Number</th>
        <th>Department Name</th>
    <c:forEach var ="department" items ="${departments}">
        <tr>
            <td>
                <a href="deptView?dno=${department.dnumber}"> ${department.dnumber}</a>
                
            </td>
            <td>
                ${department.dname}
            </td>
        </tr>
    </c:forEach>
    </table>