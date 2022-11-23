package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.src.presentacion.Modelo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public Modelo miApp;

    public void init() throws ServletException {
        // Do required initialization
        miApp = new Modelo();
        miApp.iniciar();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List list = Arrays.asList(1, 2, 3, miApp.getMiSistema().clientes.get(0).mensaje);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
    }
}
