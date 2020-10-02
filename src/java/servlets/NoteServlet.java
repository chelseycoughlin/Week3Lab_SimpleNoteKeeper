/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Notes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String edit = request.getParameter("edit");
        String title = "";
        String note = "";

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        Notes notes = new Notes(title, note);
        
        int count = 0;
        
         ArrayList<String> list = new ArrayList();

        if (edit != null) {
            if (request.getParameter("edit") != null) {

                String line;            
                while((line = br.readLine()) != null){
                   list.add(line);
                    }
                br.close();
                title = list.get(0);
                note = list.get(1);
                

                notes.setTitle(title);
                notes.setText(note);
                
            }
            request.setAttribute("notes", notes);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        String title = request.getParameter("title");
        String note = request.getParameter("note");

        /*
        if (title == null || title.equals("") ||
                note == null || note.equals("")) {
            request.setAttribute("title", title);
            request.setAttribute("notes", note);
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            
            return;
        }
         */
        Notes notes = new Notes(title, note);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        if (request.getParameter("save") != null) {

            //pass person object to the JSP
            pw.println(notes.getTitle());
            pw.println(notes.getText());
            pw.close();

        }

        request.setAttribute("notes", notes);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
