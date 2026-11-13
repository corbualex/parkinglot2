<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-borderless">
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td class="text-center">${user.username}</td>
                        <td class="text-center">${user.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</t:pageTemplate>