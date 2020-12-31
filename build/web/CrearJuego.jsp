

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
                    <li class="float-r">
                    <a href="Desloguear">
                    Salir
                    </a>
                    </li>
                </ul>
            </nav>
        </div>


<!--"wrap-login100 m-l-25 m-t-175 p-l-55 p-t-40 p-b-30 float-l"-->
        <!--<div class="container-login100">-->
        <div class="wrap-login100 m-l-r-auto m-t-175 p-l-55 p-t-40 p-b-20">

            <form action="CrearJuego" method="post">

                <h2>Añadir Juego</h2>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>Nombre del juego:</p> <input type="text" name="nombre">
                </div>
                <div class="wrap-input100 validate-input m-b-20">
                    <p>Edad Mínima del juego:</p><input type="number" name="edad">
                </div>
                <p>Opcional, añada un empleado:</p> 
                <% Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
                    if ((boolean) sesion.getAttribute("admin")) {
                    %>
                <select name="empleado">
                    <option> </option>
                    <%  List<Empleado> listaEmpleados = ctrl.traerEmpleados();
                        if (listaEmpleados != null)
                            for (Empleado empleado : listaEmpleados) {
                    %>
                    <option value="<%=empleado.getId()%>" ><%=empleado.getNombreApellido()%></option>
                    <% } %>

                </select>
                    <%} else {%>
                            <h3>Necesita ser administrador para poder modificar los empleados del juego.</h3>
                    <%}%>
                <p>Opcional, añada una entrada:</p><select  name="entrada">
                    <option> </option>
                    <%
                        List<Entrada> listaEntradas = ctrl.traerEntradas();
                        if (listaEntradas != null)
                            for (Entrada elem : listaEntradas) {
                    %>
                    <option value="<%=elem.getId()%>">Entrada de <%=elem.getCliente().getNombreApellido()%> para el 
                        <%=(String) elem.getHorarioEnFormato()%> 
                    </option>
                    <% } %>

                </select>
                <p>Opcional, añada un horario:</p><select name="horario">
                    <option> </option>
                    <%
                        List<Horario> listaHorarios = ctrl.traerHorarios();
                        if (listaHorarios != null)
                            for (Horario elem : listaHorarios) {
                    %>
                    <option value="<%=elem.getId()%>">  
                        Horario de <%=(String) elem.getHoraInicioFormateada()%> a 
                        <%=(String) elem.getHoraFinFormateada()%>></option>
                        <% }%>

                </select>

                <div class="container-login100-form-btn m-t-50 m-b-50">
                    <!-- Send Button -->
                    <button class="login100-form-btn  m-r-50" type="submit">Añadir</button> 
                </div><!-- End Bottom Submit -->

            </form>

        </div>
        <!--</div>-->  


        <% } %>


    </body>
</html>
