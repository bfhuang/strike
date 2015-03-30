<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>This is the title</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/strike.js"></script>
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

                <tr data-id="${id}" data-name="${name}" data-strikeCount="${strikeCount}">
                    <td>
                        <img class="avatar" src="${personWithStrike.person.imgPath}" title="${personWithStrike.person.name}"/>
                    </td>
                    <td>${personWithStrike.person.name}</td>
                    <td>${personWithStrike.strike.strikeCount}</td>
                    <td class="numberOfStar">
                        <c:forEach begin="1" end="${personWithStrike.strike.starCount}">
                            <img src="img/tools/star.png"/>
                        </c:forEach>
                    </td>
                    <td>
                        <span class="hammer"><img src="img/tools/hammer.jpeg"/></span>
                        <span class="star"><img src="img/tools/star.png"/></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>