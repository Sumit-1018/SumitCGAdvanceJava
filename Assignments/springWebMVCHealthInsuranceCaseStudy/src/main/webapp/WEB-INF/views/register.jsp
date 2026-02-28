<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>
<h2>Customer Registration</h2>

<form action="saveCustomer" method="post">
    Name: <input type="text" name="name"/><br><br>
    Age: <input type="number" name="age"/><br><br>
    Email: <input type="email" name="email"/><br><br>
    City: <input type="text" name="city"/><br><br>

    <input type="submit" value="Register"/>
</form>
</body>
</html>