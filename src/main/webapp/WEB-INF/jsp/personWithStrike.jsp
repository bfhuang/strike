<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>This is the title</title>
    <style>
        table th, td {
            border: 1px solid
        }
    </style>
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/strike.js"></script>
</head>

    <body>
        <table align="center" cellPadding='5px' cellSpace='0' style="border-collapse: collapse;">
            <th>Head portrait</th>
            <th>Name</th>
            <th>strike count</th>
            <th>start count</th>
            <th>operation</th>

            <c:forEach items="${persons}" var="personWithStrike" varStatus="status">
                <c:set var="id" value="${personWithStrike.person.id}"/>
                <c:set var="name" value="${personWithStrike.person.name}"/>
                <c:set var="strikeCount" value="${personWithStrike.strike.strikeCount}"/>

                <tr>
                    <td>
                        <img src="${personWithStrike.person.imgPath}" title="${personWithStrike.person.name}" height="42" width="42"/>
                    </td>
                    <td>${personWithStrike.person.name}</td>
                    <td>${personWithStrike.strike.strikeCount}</td>
                    <td>
                        <c:forEach begin="1" end="${personWithStrike.strike.starCount}">
                            <img id="star" src="img/tools/star.png" style="width:15px;height:15px"/>
                        </c:forEach>
                    </td>
                    <td>
                        <span onclick="strike(${id}, '${name}');">
                            <img src="img/tools/hammer.jpeg" style="width:40px;height:40px;cursor:pointer"></span>
                        <span onclick="punish(${id}, '${name}', ${strikeCount})">
                            <img src="img/tools/star.png" style="width:30px;height:30px;cursor:pointer">
                        </span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>