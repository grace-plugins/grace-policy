<!doctype html>
<html>
<head>
    <title>Auth</title>
    <meta name="layout" content="main">
</head>
<body>

<div class="container">
    <h1>Welcome to Blog</h1>
    <g:if test="${params.fail}">
    <h3 style="color: red">Oooh, wrong username or password!</h3>
    </g:if>
    <form action="login" method="post">
        <fieldset>
            <label for="username">Username</label>
            <input id="username" name="username" type="text" placeholder="">
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="">
            <input class="button-primary" type="submit" value="Login">
        </fieldset>
    </form>
</div>

</body>
</html>
