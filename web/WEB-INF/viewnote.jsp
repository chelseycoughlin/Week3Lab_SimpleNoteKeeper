<%-- 
    Document   : viewnote
    Created on : Oct 1, 2020, 10:26:04 AM
    Author     : 813017
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Notes</title>
    </head>
    <body>
        <h1>Simple Notes Keeper</h1>
        <h3>View Notes</h3><br>
        <form method="post" action="note">
        <label>Title: </label>
        ${notes.title} 
        <br>
        <br>
        <label>Contents: </label>
        ${notes.text}
        <br>
        <br>
        <a href="note?edit" value="Edit" name="edit">Edit</a>
        </form>
    </body>
</html>
