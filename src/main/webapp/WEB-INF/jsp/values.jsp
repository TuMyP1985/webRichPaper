<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Ц.Б.</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>


<br/><br/>
<div>
    <section>
        <form method="post" action="${pageContext.request.contextPath}/currentval">
            Выберите ЦБ: <select name="listname">
            <c:forEach  items="${lists}" var ="list">
            <option value=${list.name} selected>${list.description}</option>
            </c:forEach>
        </select>
            <button type="submit">Получить курс</button>
        </form>
        <p></p>
        ${currentvalue}
    </section>

<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>First Name</th>--%>
<%--            <th>Last Name</th>--%>
<%--        </tr>--%>
<%--        --%>
<%--            <tr>--%>
<%--                <td>${list.name}</td>--%>
<%--                <td>${list.description}</td>--%>
<%--            </tr>--%>
<%--        --%>
<%--    </table>--%>
</div>
</body>

</html>