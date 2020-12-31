

<%@page import="Logica.Cliente"%>
<%@page import="Logica.Horario"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Entrada"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Administración del Parque</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
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


        <!--"wrap-login100 m-l-25 m-t-175 p-l-55 p-t-40 p-b-30 float-l"-->
        <!--<div class="container-login100">-->
        <div class="wrap-login100 m-l-r-auto m-t-175 p-l-55 p-t-40 p-b-20">

            <form action="CrearCliente" method="post">
                <h2>Añadir Cliente</h2>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>Nombre:</p> <input type="text" name="nombre">
                </div>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>Apellido:</p>
                    <input type="text" name="apellido">
                </div>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>Edad:</p>
                    <input type="number" name="edad">
                </div>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>(Opcional) Asigne el cliente a una entrada:</p>
                    <select name='entrada'>
                        <option value=""></option>
                        <%  Controladora ctrl =(Controladora) sesion.getAttribute("ctrl");
                            List<Entrada> col = ctrl.traerEntradas();
                            for (Entrada elem : col) {
                                if (elem.getCliente()==null) {
                        %>
                        <option value="<%=elem.getId()%>">
                           Entrada para el <%=elem.getHorarioEnFormato()%>
                        </option>
                        <%}}%>
                    </select>
                </div>
                <div class="container-login100-form-btn m-t-50 m-b-50">
                    <!-- Send Button -->
                    <button class="login100-form-btn  m-r-50" type="submit">Añadir</button> 
                </div><!-- End Bottom Submit -->
            </form>
        </div>
        <% }%>
    </body>
</html>
