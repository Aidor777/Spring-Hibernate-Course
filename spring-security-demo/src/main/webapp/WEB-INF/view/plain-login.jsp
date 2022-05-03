<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Custom Login Page</title>

        <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    </head>

    <body>
        <h3>Custom Login Page</h3>

        <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
            <c:if test="${param.error != null}">
                <div>
                    <span class="failed">Sorry! You entered an incorrect username/password.</span>
                </div>
                <br/>
            </c:if>

            <div>
                <span>User name: </span><input type="text" name="username"/>
            </div>
            <br/>

            <div>
                <span>Password: </span><input type="password" name="password"/>
            </div>
            <br/>

            <div>
                <input type="submit" value="Login"/>
            </div>

            <!-- Manually adding CSRF token, only required if using regular form tag -->
            <!--
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            -->
        </form:form>
    </body>
</html>