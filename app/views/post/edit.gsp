<!doctype html>
<html>
<head>
    <title>Edit Post</title>
    <meta name="layout" content="main">
</head>
<body>

<div class="container">
    <h1>Edit Post</h1>
    <h5>${flash.message}</h5>
    <g:hasErrors bean="${this.post}">
    <div class="alert alert-danger" role="alert">
        <ul class="errors">
            <g:eachError bean="${this.post}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                <i class="bi bi-exclamation-circle"></i><g:message error="${error}"/>
            </li>
            </g:eachError>
        </ul>
    </div>
    </g:hasErrors>
    <g:form name="postForm" action="update" id="${post.id}">
        <fieldset>
            <label for="title">Title</label>
            <g:textField name="title" value="${post.title}" />
            <label for="content">Content</label>
            <g:textArea name="content" value="${post.content}" rows="3" cols="40"/>
            <g:hiddenField name="id" value="${post.id}" />
            <g:submitButton class="button-primary" name="update" value="Update" />
        </fieldset>
    </g:form>
</div>

</body>
</html>
