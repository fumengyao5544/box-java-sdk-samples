package com.box.sdk.appusersexample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helpers.BoxHelper;

public class SignInServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        BoxHelper.setBoxAppUserName(request, request.getParameter("username"));
        BoxHelper.setBoxAppUserId(request, null);
        String boxId = BoxHelper.boxIdFromRequest(request);
        if (boxId != null) {
            BoxHelper.setBoxAppUserId(request, boxId);
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("error", "Could not find an App user with that name. ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            // response.sendRedirect("login");
        }

        // request.getRequestDispatcher("dashboard.jsp").forward(request, response);

    }

}
