<%-- 
    Document   : editnote
    Created on : Oct 1, 2020, 10:26:12 AM
    Author     : 813017
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Notes</title>
    </head>
    <body>
        <h1>Simple Notes Keeper</h1>
        <h1>${editing}</h1>
        <h3>Edit Notes</h3><br>
        <form method="post" action="note">
        <label for="title">Title: </label>
        <input type="text" name="title" value="${notes.title}">
        <br>
        <br>
        <label for="textarea">Contents: </label>
        <textarea name="note" rows="6" cols="30" value="">${notes.text}</textarea>
        <br>
        <br>
        <input type="submit" value="Save" name="save">
        </form>
    </body>
</html>
