

<%@page import="Logica.Juego"%>
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
        <%
            Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
            List<Horario> listaHorarios = ctrl.traerHorarios();
        %>
        <div class="flex-sa">
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-20">
                <form action="EditarHorario" method="post">
                    <h2>Editar Horario</h2>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Seleccione un Horario:</p>
                        <select name="horario" required>
                            <%for (Horario elem : listaHorarios) {
                            %>
                            <option value="<%=elem.getId()%>">Horario de <%=elem.getHoraInicioFormateada()%> a <%=elem.getHoraFinFormateada()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Nueva Hora de Inicio:</p> <input type="time" name="horainicio">
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Nueva Hora de Inicio:</p> <input type="time" name="horafin">
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>(Opcional) Añada el Horario a un Juego:</p>
                        <select name='juego'>
                            <option value="">
                            </option>
                            <%
                                for (Juego elem : ctrl.traerJuegos()) {
                            %>
                            <option value="<%=elem.getId()%>">
                            <%=elem.getNombre()%>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <div class="container-login100-form-btn m-t-50 m-b-50">
                        <button class="login100-form-btn  m-r-50" type="submit">Editar</button> 
                    </div>
                </form>
            </div>
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-30">   
                <form action="BorrarHorario" method="post">
                    <!--Va el tercero a lo maradona-->  
                    <h2>Borrar Horario</h2>
                    <p class="m-r-50">Advertencia, los datos relacionados a pedido de que la profe no quiere que usemos cascadetype, quedarán dando vueltas en la base de datos. No obstante, si se eliminará el horario de el/los juego(s) que lo posean. <b>Pulse el botón bajo su propia responsabilidad.</b></p>
                    <div class="wrap-input100 validate-input m-b-20">
                        <h2 class="fs-16">Seleccione el horario a Borrar:</h2>
                    </div>
                    <select name="horario" required>
                            <%for (Horario elem : listaHorarios) {
                            %>
                            <option value="<%=elem.getId()%>">Horario de <%=elem.getHoraInicioFormateada()%> a <%=elem.getHoraFinFormateada()%></option>
                            <%}%>
                        </select>
                    <div class="container-login100-form-btn m-t-127 m-b-20 float-b">
                        <button class="login100-form-btn  m-r-50" type="submit">Borrar</button> 
                    </div>
                </form>
            </div>
        </div>
        <% }%>
    </body>
</html>
