<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Student Registration Form</title>
    </head>

    <body>
        <form:form action="processForm" modelAttribute="student">
            <span>First name: </span><form:input path="firstName"/>
            </br></br>

            <span>Last name: </span><form:input path="lastName"/>
            </br></br>

            <span>Country: </span>
            <form:select path="country">
                <form:options items="${countryOptions}"/>

                <!-- <form:option value="Brazil" label="Brazil"/>
                <form:option value="France" label="France"/>
                <form:option value="Germany" label="Germany"/>
                <form:option value="India" label="India"/> -->
            </form:select>
            <br/><br/>

            <span>Favorite Programming Language:</span>
            <br/>
            <form:radiobuttons path="favoriteProgrammingLanguage" items="${programmingLanguageOptions}"/>

            <!-- <form:radiobutton path="favoriteProgrammingLanguage" value="Java"/><span>Java</span>
            <form:radiobutton path="favoriteProgrammingLanguage" value="C#"/><span>C#</span>
            <form:radiobutton path="favoriteProgrammingLanguage" value="PHP"/><span>PHP</span>
            <form:radiobutton path="favoriteProgrammingLanguage" value="Ruby"/><span>Ruby</span> -->
            <br/><br/>

            <span>Operating Systems:</span>
            <br/>
            <span>Linux</span><form:checkbox path="operatingSystems" value="Linux"/>
            <span>Mac OS</span><form:checkbox path="operatingSystems" value="Mac OS"/>
            <span>MS Windows</span><form:checkbox path="operatingSystems" value="MS Windows"/>
            <br/><br/>

            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>