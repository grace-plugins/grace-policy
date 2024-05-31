<!doctype html>
<html>
    <head>
        <title>Page Not Found</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <h1>Error: 404</h1>
            <p>Path: ${request.forwardURI}</p>
        </div>
    </div>
    </body>
</html>
