<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>warehouse accounting</title>
</head>
<body>
Add User
<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username" /> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>