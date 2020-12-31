<%-- 
    Document   : AñadirJuego
    Created on : 20-dic-2020, 3:18:26
    Author     : lyart
--%>

<%@page import="javax.persistence.Parameter"%>
<%@page import="Logica.Juego"%>
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
        <div class="flex-sa">
            <div class="wrap-login100 m-t-250 p-l-55 p-t-40 p-b-20">
                <form action="BorrarJuego" method="post"> 
                    <h2>Borrar Juego</h2>
                    <p class="m-r-50">Advertencia, los datos relacionados a pedido de que la profe no quiere que usemos cascadetype, quedarán dando vuelta en la base de datos. <b>Pulse el botón bajo su propia responsabilidad.</b></p>
                    <h2 class="fs-16">Seleccione el juego a Borrar:</h2>
                    <select class="p-r-50" name="juego" required>
                        <%
                            Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
                            List<Juego> listaJuegos = ctrl.traerJuegos();
                            List<Entrada> listaEntradas = ctrl.traerEntradas();
                            List<Horario> listaHorarios = ctrl.traerHorarios();
                            List<Empleado> listaEmpleados = ctrl.traerEmpleados();
                            for (Juego juego : listaJuegos) {
                        %>
                        <option value="<%=juego.getId()%>"><%=juego.getNombre()%></option>
                        <%}%>
                    </select>
                    <div class="container-login100-form-btn m-t-15 m-b-40 ">
                        <button class="login100-form-btn  m-r-50" type="submit" action="BorrarJuego">Borrar</button> 
                    </div>
                </form>
            </div>
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-30">   
                <form action="EditarJuego" method="post">
                    <h2>Editar</h2>
                    <p>Seleccione el juego a Editar:</p>
                    <select class="p-r-150" name="juego" required>
                        <option value=""> </option>
                        <%
                            for (Juego juego : listaJuegos) {
                        %>
                        <option value="<%=juego.getId()%>"><%=juego.getNombre()%></option>
                        <%}%>
                    </select>
                    <p>Nuevo Nombre:</p> <input type="text" name="nombre">
                    <p>Nueva Edad Mínima:</p><input type="number" name="edad">
                    <p>Opcional, añada un empleado:</p> 
                    <% if ((boolean) sesion.getAttribute("admin")) {

                    %>
                    <select class="p-r-150" name="empleado">
                        <option> </option>
                        <%                            if (listaEmpleados != null)
                                for (Empleado empleado : listaEmpleados) {
                        %>
                        <option value="<%=empleado.getId()%>" ><%=empleado.getNombreApellido()%></option>
                        <% } %>
                    </select>
                    <%} else {%>
                    <h4>Necesita ser usuario admin para gestionar Empleados.</h4>
                    <%}%>
                    <p>Opcional, añada una entrada:</p><select class="" name="entrada">
                        <option> </option>
                        <%
                            if (listaEntradas != null)
                                for (Entrada elem : listaEntradas) {
                        %>
                        <option value="<%=elem.getId()%>">Entrada de <%=elem.getCliente().getNombreApellido()%> para el 
                            <%=(String) elem.getHorarioEnFormato()%> 
                        </option>
                        <% } %>
                    </select>
                    <p>Opcional, añada un horario:</p><select class="p-r-100 m-r-auto" name="horario">
                        <option> </option>
                        <%
                            if (listaHorarios != null)
                                for (Horario elem : listaHorarios) {
                        %>
                        <option value="<%=elem.getId()%>">  
                            Horario de <%=(String) elem.getHoraInicioFormateada()%> a 
                            <%=(String) elem.getHoraFinFormateada()%>></option>
                            <% }%>
                    </select>
                    <div class="container-login100-form-btn m-t-40 m-b-50">
                        <button class="login100-form-btn  m-r-50" type="submit">Editar</button> 
                    </div>
                </form>
            </div>
            <div class="wrap-login100 m-t-250 p-l-55 p-t-40 p-b-30">
                <form action="EditarJuegoEnDetalle" method="post">
                    <!--Va el tercero a lo maradona-->  
                    <h2>Editar Juego en Detalle</h2>
                    <p class="m-r-50">Visualice los empleados, entradas y horarios de un juego para desvincular en detalle.</p>
                    <h2 class="fs-16">Seleccione el juego a Editar:</h2>
                    <select name="juego" required>
                        <%
                            for (Juego juego : listaJuegos) {
                        %>
                        <option value="<%=juego.getId()%>"><%=juego.getNombre()%></option>
                        <%}     %>
                    </select>
                    <div class="container-login100-form-btn m-t-50 m-b-40 float-b">
                        <button class="login100-form-btn  m-r-50" type="submit">Editar</button> 
                    </div>
                </form>
            </div>
        </div>
        <% }%>
    </body>
</html>
