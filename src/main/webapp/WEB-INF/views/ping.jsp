<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Service Ping</title>

    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>


<div class="jumbotron">
    <div class="container">
        <h1>Service Availability</h1>

    </div>
</div>

<div class="container">


<form action="${pageContext.request.contextPath}/serviceping">


    <select name="services">

        <c:if test="${not empty servicesNameList}">

            <c:forEach items="${servicesNameList}" var="name">
                <option value="${name}">${name}</option>
            </c:forEach>

        </c:if>

        <c:if test="${not empty serviceInstance}">

            <c:forEach items="${serviceInstance.getAllServicesName()}" var="name">
                <option value="${name}">${name}</option>
            </c:forEach>

        </c:if>


    </select>

    <input class="btn btn-primary" type="submit" value="Submit">
</form>

<table class="table table-striped">
<thead>

<tr>
    <th><h2>Service Name: ${serviceInstance.getRequestedServiceName()}</h2>
    </th>

    <th><h2>Service State: ${serviceInstance.getServiceState()}</h2>
    </th>
</tr>

<tr>
    <th><h2>Current Instances: ${serviceInstance.getActualServiceInstances()}</h2>
    </th>

    <th><h2>Expected Instances: ${serviceInstance.getExpectedServiceInstances()}</h2>
    </th>


</tr>
<tr>
    <th>InstanceId</th>
    <th>Port</th>
</tr>

</thead>
<tbody>

<c:forEach items="${serviceInstance.getServiceInstanceMap()}" var="instancesMapview" varStatus="status">
    <tr>
        <td>${instancesMapview.key}</td>
        <td>${instancesMapview.value}</td>
        </c:forEach>
        </tr>
        </tbody>
        </table>


        <hr>
        <footer>
        <p>&copy; Cisco internal 2016</p>
        </footer>
        </div>


        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>


        </body>
        </html>