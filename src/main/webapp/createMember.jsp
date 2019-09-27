<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 9/20/19
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Club Member</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="javascript" src="memberJS.js" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h2>Create Member</h2>
<form id="createMember" action="rest/member/addMember" method="POST">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" id="fisrtName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" id="lastName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" id="email"/></td>
        </tr>
        <tr>
            <td>Mobile Number:</td>
            <td><input type="text" id="moblieNo"/></td>
        </tr>
    </table>

    <button id="submitBtn" type="submit">Add Member</button>


    <input type="hidden" id="jsonData" name="jsonData"/>


</form>


<form>
    <table id="createdMember" border="1">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile Number</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</form>
</body>
</html>
