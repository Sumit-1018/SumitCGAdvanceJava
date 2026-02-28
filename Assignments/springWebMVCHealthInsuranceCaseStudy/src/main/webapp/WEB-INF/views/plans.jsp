<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Plans</title>
</head>
<body>
<h2>Available Insurance Plans</h2>

<form action="apply" method="post">
    Your Name: <input type="text" name="name"/><br><br>

    Select Plan:
    <select name="planName">
        <option value="Basic Health Plan">Basic Health Plan</option>
        <option value="Premium Health Plan">Premium Health Plan</option>
        <option value="Family Coverage Plan">Family Coverage Plan</option>
    </select><br><br>

    <input type="submit" value="Apply"/>
</form>
</body>
</html>