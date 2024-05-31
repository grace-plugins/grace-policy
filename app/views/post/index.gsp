<!doctype html>
<html>
<head>
    <title>Post List</title>
    <meta name="layout" content="main">
</head>
<body>

<div class="container">
    <h1>Post List</h1>
    <h5>${flash.message}</h5>

    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Status</th>
                <th>Operations</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${postList}" var="post">
            <tr>
                <td><g:link action="show" id="${post.id}">${post.title}</g:link></td>
                <td>${post?.author?.username}</td>
                <td>${post.status}</td>
                <td><g:link action="edit" id="${post.id}">Edit</g:link></td>
            </tr>
            </g:each>
        </tbody>
    </table>
</div>

</body>
</html>
