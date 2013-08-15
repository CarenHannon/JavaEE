<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : showDepartments
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<sql:query var="dpts" dataSource="jdbc/company">
    SELECT dnumber, dname FROM department order by dnumber
</sql:query>

    <h2> Show All Departments in Lehman Company</h2>
    
    <table>
        <th>Department Number</th>
        <th>Deparment Name</th>
    <c:forEach var ="dpt" items ="${dpts.rows}">
        <tr>
            <td>
                <a href="deptView?dno=${dpt.dnumber}"> ${dpt.dnumber}</a>
                
            </td>
            <td>
                ${dpt.dname}
            </td>
        </tr>
    </c:forEach>
    </table>