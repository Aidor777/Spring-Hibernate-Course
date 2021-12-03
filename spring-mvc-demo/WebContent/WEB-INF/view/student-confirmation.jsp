<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Student Confirmation</title>
    </head>

    <body>
        <span>The student is confirmed: ${student.firstName} ${student.lastName}</span>
        <br/><br/>
        <span>Country: ${student.country}</span>
        <br/><br/>
        <span>Favorite programming language: ${student.favoriteProgrammingLanguage}</span>
        <br/><br/>
        <span>Operating systems:</span>
        <ul>
            <c:forEach var="operatingSystem" items="${student.operatingSystems}">
                <li>${operatingSystem}</li>
            </c:forEach>
        </ul>
    </body>
</html>