<%-- 
    Document   : AñadirJuego
    Created on : 20-dic-2020, 3:18:26
    Author     : lyart
--%>

<%@page import="Logica.Cliente"%>
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
        <link rel="stylesheet" type="text/css" href="css/estilos_form.css">
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

                    <%      Controladora ctrl = (Controladora) sesion.getAttribute("ctrl");
                                List<Entrada> listaEntradas = ctrl.traerEntradas();
                                List<Cliente> listaClientes = ctrl.traerClientes();
                    %>
                    
        <div class="flex-sa">
            <div class="wrap-login100 m-t-250 p-l-55 p-t-40 p-b-45">
                <form action="EditarEntrada" method="post">
                    <h2>Editar</h2>
                    <p>Seleccione la entrada a Editar:</p>
                    <select name="entrada" required>
                        <option> </option>
                        <%
                                for (Entrada elem : listaEntradas) {
                        %>
                        <option class="max-w-full" value="<%=elem.getId()%>">Entrada 
                        <%if (null!=elem.getCliente()){%> de <%=elem.getCliente().getNombreApellido()%> <%}%> para el <%=(String) elem.getHorarioEnFormato()%> 
                        </option>
                        <%}%>
                    </select>
                    <p>Modifique la fecha y hora de entrada (Opcional):</p>
                    <input type="datetime-local" name="horario">
                    <p>Cambie el Cliente (Opcional):</p>
                    <select class="" name="cliente">
                        <option> </option>
                        <%
                            if (listaClientes != null)
                                for (Cliente client : listaClientes) {
                                    if (null!=client) {
                        %>
                        <option class="" value="<%=client.getId()%>" ><%=client.getNombreApellido()%></option>
                        <% }} %>
                    </select>
                    <div class="container-login100-form-btn m-t-40 m-b-50">
                        <!-- Send Button -->
                        <button class="login100-form-btn  m-r-50" type="submit">Editar</button> 
                    </div>
                </form>
            </div>                      
            <!--Va el segundo form-->         
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-30">   
                <form action="BorrarEntrada" method="post">
                    <!--Va el tercero a lo maradona-->  
                    <h2>Borrar Entrada</h2>
                    <p class="m-r-50">Advertencia, los datos relacionados a pedido de que la profe no quiere que usemos cascadetype, quedarán dando vueltas en la base de datos. No obstante, si se eliminará la entrada de el/los juego(s) que la posean. <b>Pulse el botón bajo su propia responsabilidad.</b></p>
                    <div class="wrap-input100 validate-input m-b-20">
                        <h2 class="fs-16">Seleccione la entrada a Borrar:</h2>
                    </div>
                    <select class="p-r-auto" name="entrada" required>
                        <%
                            for (Entrada elem : listaEntradas) {
                        %>
                        <option class="max-w-full" value="<%=elem.getId()%>">Entrada 
                        <%if (null!=elem.getCliente()){%> de <%=elem.getCliente().getNombreApellido()%> <%}%> para el <%=(String) elem.getHorarioEnFormato()%> 
                        </option>
                        <%}%>
                    </select>
                    <div class="container-login100-form-btn m-t-15 m-b-20 float-b">
                        <button class="login100-form-btn  m-r-50" type="submit" action="BorrarJuego">Borrar</button> 
                    </div>
                </form>
            </div>
            <div class="wrap-login100 m-t-250 p-l-55 p-t-120 p-b-32">   
                <h2> Contador de entradas </h2>
                <p class="m-r-50">Visualice, cuente y añada entradas filtradas por juego, día y horario.</p>
                <div class="container-login100-form-btn m-t-55 m-b-60 float-b">
                    <form action="AdministrarEntradas.jsp">
                    <button class="login100-form-btn  m-r-50" type="submit">Administrar</button> 
                    </form>
                </div>
            </div>
        </div>

    <% }%>
</body>
</html>
