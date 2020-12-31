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
                    <%
                    Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
                    Juego juego = ctrl.traerJuego(Integer.parseInt((String)sesion.getAttribute("juego")));
                    List<Entrada> listaEntradas = juego.getListaEntradas();
                    List<Empleado> listaEmpleados = juego.getListaEmpleados();
                    List<Horario> listaHorarios = juego.getListaHorarios();
                    
                    %>
        <h1 class="fs-35 flex-c m-t-40">Juego: <%=juego.getNombre()%></h1>

        <div class="flex-sa">
        <div class="wrap-login100 m-t-100 p-l-55 p-t-40 p-b-20">
            <form action="BorrarEntradaDeJuego" method="post">
                <h2>Borrar Entrada del juego</h2>
                <div class="wrap-input100 validate-input m-b-20 ">
                    <p>Seleccione la entrada a borrar:</p><select  name="entrada">
                        <%
                            if (listaEntradas != null)
                                for (Entrada elem : listaEntradas) {
                        %>
                        <option value="<%=elem.getId()%>">Entrada de <%=elem.getCliente().getNombreApellido()%> para <%=(String) elem.getHorarioEnFormato()%> 
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="container-login100-form-btn m-t-40 m-b-50">
                    <!-- Send Button -->
                    <button class="login100-form-btn  m-r-50" type="submit">Borrar</button> 
                </div><!-- End Bottom Submit -->
            </form>
        </div>
        <div class="wrap-login100 m-t-100 p-l-55 p-t-40 p-b-22">   
            <form action="BorrarHorarioDeJuego" method="post">
                <h2>Borrar Horario del Juego</h2>
                <div class="wrap-input100 validate-input ">
                    <p>Seleccione el horario a Borrar:</p>
                    <select name="horario">
                        <%
                            for (Horario horario : listaHorarios) {
                        %>
                        <option value="<%=horario.getId()%>">Horario de <%=horario.getHoraInicioFormateada()%> a <%=horario.getHoraFinFormateada()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="container-login100-form-btn m-t-40 m-b-50">
                    <button class="login100-form-btn m-r-50" type="submit" action="BorrarJuego" value="Entrar">Borrar</button> 
                </div>
            </form>
        </div>
        <!--</div>-->  
        <!--Va el tercero a lo maradona-->  
        <div class="wrap-login100 m-l-25 m-t-100 p-l-55 p-t-40 p-b-22 float-l">
            <form action="BorrarEmpleadoDeJuego" method="post">
                <h2>Borrar Empleado del Juego</h2>
                <div class="wrap-input100 validate-input ">
        <%
            if ((boolean) sesion.getAttribute("admin")) {
        %>
                    <p>Seleccione el empleado a Borrar:</p>
                    <select name="empleado">
                        <%
                            for (Empleado empleado : listaEmpleados) {
                        %>
                        <option value="<%=empleado.getId()%>"><%=empleado.getNombreApellido()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="container-login100-form-btn m-t-40 m-b-50">
                    <button class="login100-form-btn m-r-50" type="submit" action="EditarJuegoEnDetalle" value="Entrar">Borrar</button> 
                </div>
                            <% } else {%>
                            <h3><br><br>Necesita ser administrador para poder modificar los empleados del juego.</h3>
                            <%}%>
            </form>
        </div>
    </div>
        <% }%>
    </body>
</html>
