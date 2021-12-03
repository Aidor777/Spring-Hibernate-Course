<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Customer Confirmation</title>
    </head>

    <body>
        <span>The customer is confirmed: ${customer.firstName} ${customer.lastName}</span>
        <br/><br/>

        <span>Free passes: ${customer.freePasses}</span>
        <br/><br/>

        <span>Postal code: ${customer.postalCode}</span>
        <br/><br/>

        <span>Course code: ${customer.courseCode}</span>
        <br/><br/>
    </body>
</html>