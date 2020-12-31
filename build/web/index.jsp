<%-- 
    Document   : index
    Created on : 19-dic-2020, 23:36:14
    Author     : lyart
--%>

<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Administración del Parque</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>

        <% HttpSession sesion = request.getSession();

            String usu = (String) sesion.getAttribute("username");

            if (usu == null) {
                response.sendRedirect("Login.jsp");
            } else {

        %>

               <div class="navegacion">
            <nav>
                <ul class="clearfix">
                    <li><a href="#">Juegos</a>
                        <ul>
                            <li><a href="EditarJuego.jsp">Ver / Editar</a></li>
                            <li><a href="CrearJuego.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Entradas</a>
                        <ul>
                            <li><a href="EditarEntrada.jsp">Ver / Editar</a></li>
                            <li><a href="CrearEntrada.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Cliente</a>
                        <ul>
                            <li><a href="EditarCliente.jsp">Ver / Editar</a></li>
                            <li><a href="CrearCliente.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Horarios</a>
                        <ul>
                            <li><a href="EditarHorario.jsp">Ver / Editar</a></li>
                            <li><a href="CrearHorario.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <% if ((boolean) sesion.getAttribute("admin")) {

                    %>

                    <li><a href="#">Empleados</a>
                        <ul>
                            <li><a href="EditarEmpleado.jsp">Ver / Editar</a></li>
                            <li><a href="CrearEmpleado.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Usuarios</a>
                        <ul>
                            <li><a href="EditarUsuario.jsp">Ver / Editar</a></li>
                            <li><a href="CrearUsuario.jsp">Añadir</a></li>
                        </ul>
                    </li>
                    <%                    } %>
                    <li class="float-r"> <a href="Desloguear" class="">Salir</a></li>
                </ul>
            </nav>
        </div>
        <div class="flex-c">
            <p class="fs-58">¡Bienvenido <%=usu%>!</p>
        </div>
        <% }%>

    </body>
</html>
