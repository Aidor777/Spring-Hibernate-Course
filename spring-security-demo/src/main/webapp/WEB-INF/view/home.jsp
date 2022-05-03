<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <title>LoveToCode Company Home Page</title>
    </head>

    <body>
        <h2>LoveToCode Company Home Page</h2>
        <hr/>
        <span>Welcome to the LoveToCode company home page!</span>
        <hr/>

        <div>
            <span>User: <security:authentication property="principal.username"/></span>
            <br/>
            <span>Roles: <security:authentication property="principal.authorities"/></span>
        </div>

        <security:authorize access="hasRole('MANAGER')">
            <div>
                <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>&nbsp;
                <span>(Only for manager peeps)</span>
            </div>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <div>
                <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>&nbsp;
                <span>(Only for admin peeps)</span>
            </div>
        </security:authorize>
        <hr/>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <div>
                <input type="submit" value="Logout"/>
            </div>
        </form:form>
    </body>
</html>