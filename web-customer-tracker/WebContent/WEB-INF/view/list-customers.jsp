<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.lovetocode.springdemo.utils.SortColumnEnum" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Customers List</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>

    <body>
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Management</h2>
            </div>
        </div>

        <div id="container">
            <div id="content">
                <input type="button" value="Add Customer"
                       onclick="window.location.href='showAddCustomerForm'; return false;" class="add-button"/>

                <form:form action="search" method="GET">
                    Search customer: <input type="text" name="searchName"/>
                    <input type="submit" value="Search" class="add-button"/>
                </form:form>

                <table>
                    <tr>
                        <c:url var="sortByFirstNameLink" value="list">
                            <c:param name="sortColumn" value="<%= SortColumnEnum.FIRST_NAME.name() %>"/>
                        </c:url>

                        <c:url var="sortByLastNameLink" value="list">
                            <c:param name="sortColumn" value="<%= SortColumnEnum.LAST_NAME.name() %>"/>
                        </c:url>

                        <c:url var="sortByEmailLink" value="list">
                            <c:param name="sortColumn" value="<%= SortColumnEnum.EMAIL.name() %>"/>
                        </c:url>

                        <th><a href="${sortByFirstNameLink}">First Name</a></th>
                        <th><a href="${sortByLastNameLink}">Last Name</a></th>
                        <th><a href="${sortByEmailLink}">Email</a></th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="customer" items="${customers}">
                        <c:url var="updateLink" value="showUpdateCustomerForm">
                            <c:param name="customerId" value="${customer.id}"/>
                        </c:url>

                        <c:url var="deleteLink" value="delete">
                            <c:param name="customerId" value="${customer.id}"/>
                        </c:url>

                        <tr>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>
                                <a href="${updateLink}">Update</a> |
                                <a href="${deleteLink}"
                                   onclick="if (!confirm('Are you sure you want to delete this customer?')) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>