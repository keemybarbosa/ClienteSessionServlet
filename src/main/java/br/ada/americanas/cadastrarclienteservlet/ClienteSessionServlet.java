package br.ada.americanas.cadastrarclienteservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastrarClienteServlet", value = "/cadastrar-cliente")
public class ClienteSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        Cliente cliente = new Cliente(nome, cpf);

        var listaClientes = recuperaClientes(request);
        listaClientes.add(cliente);

        request.setAttribute("historico_clientes", listaClientes);
        response.sendRedirect("/app/historico.jsp");
        //request.getRequestDispatcher("/historico.jsp").forward(request, response);
    }

    private List<Cliente> recuperaClientes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Cliente> listaClientes = (List<Cliente>) session.getAttribute("historico_clientes");
        if (listaClientes == null) {
            listaClientes = new ArrayList<>();
            session.setAttribute("historico_clientes", listaClientes);
        }
        return listaClientes;
    }

}
