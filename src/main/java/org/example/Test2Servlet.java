package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {

    private TestServlet testServlet;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List list = Arrays.asList(1, 2, 3, 4, testServlet.miApp.getMiSistema().clientes.get(0).mensaje);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
    }
}
