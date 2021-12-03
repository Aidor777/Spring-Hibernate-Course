<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Customer Registration Form</title>
        <style>
            .error {color: red;}
        </style>
    </head>

    <body>
        <form:form action="processForm" modelAttribute="customer">
            <i>Fill out the form. Asterisk (*) means required.</i>
            <br/><br/>

            <span>First name: </span><form:input path="firstName"/>
            <br/><br/>

            <span>Last name (*): </span><form:input path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
            <br/><br/>

            <span>Free passes (*): </span><form:input path="freePasses"/>
            <form:errors path="freePasses" cssClass="error"/>
            <br/><br/>

            <span>Postal code: </span><form:input path="postalCode"/>
            <form:errors path="postalCode" cssClass="error"/>
            <br/><br/>

            <span>Course code: </span><form:input path="courseCode"/>
            <form:errors path="courseCode" cssClass="error"/>
            <br/><br/>

            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>