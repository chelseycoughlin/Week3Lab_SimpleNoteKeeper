/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Notes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chels
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String note = request.getParameter("note");
       
        
        if (title == null || title.equals("") ||
                note == null || note.equals("")) {
            request.setAttribute("title", title);
            request.setAttribute("notes", note);
            request.setAttribute("error", "both");
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            
            return;
        }

        // construct person object
        Notes notes = new Notes(title, note);
        
        // pass person object to the JSP
        request.setAttribute("notes", notes);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
    }

}
