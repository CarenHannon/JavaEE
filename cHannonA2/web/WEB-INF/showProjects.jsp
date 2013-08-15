<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : showProjects
    Created on : Oct 2, 2012, 12:50:01 PM
    Author     : Acer
--%>


<%--<sql:query var="projs" dataSource="jdbc/company">
    SELECT pnumber, pname FROM project order by pnumber
</sql:query>--%>

    <h2> Show All Projects of the Lehman Company</h2>
    <h2> Projects of the Company </h2>
    
    <table>
        <th>Project Number</th>
        <th>Project Name</th>
    <c:forEach var ="project" items ="${projects}">
        <tr>
            <td>
                <a href="projView?pno=${project.pnumber}"> ${project.pnumber}</a>
                
            </td>
            <td>
                ${project.pname}
            </td>
        </tr>
    </c:forEach>
    </table>