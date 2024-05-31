<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grace</title>
</head>
<body>

<div id="content" role="main">
    <div class="container">
        <h1>Welcome to Blog</h1>
        <span>
            <g:if test="${session?.current_user}">
                <g:if test="${session?.current_user?.isAdmin()}">
                    You are Administrator
                </g:if>
                <g:else>
                    You are User
                </g:else>
                <g:link controller="auth" action="logout">logout</g:link>
            </g:if>
            <g:else>
                <g:link controller="auth" action="index">login</g:link>
            </g:else>
        </span>
        <ul>
            <li><g:link controller="post" action="index">Post List</g:link></li>
        </ul>
    </div>
</div>

</body>
</html>
