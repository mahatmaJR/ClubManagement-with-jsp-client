<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/23/19
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="updateMember" action="/member/edit" method="PUT">
    Member ID: <input type="text" name="memberId"/>
    First Name: <input type="text" name="fisrtName"/>
    Last Name: <input type="text" name="lastName"/>
    Email: <input type="email" name="email"/>
    Mobile Number: <input type="text" name="moblieNo"/>
</form>

</body>
</html>
