

<%@page import="Logica.Usuario"%>
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
            List<Usuario> listaUsuarios = ctrl.traerUsuarios();
            List<Empleado> listaEmpleados = ctrl.traerEmpleados();
        %>
        <div class="flex-sa">
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-20">
                <form action="EditarUsuario" method="post">
                    <h2>Editar Usuario</h2>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Seleccione un usuario</p>
                        <select name="usuario" required>
                            <option> </option>
                            <%for (Usuario user : listaUsuarios) {
                            %>
                            <option value="<%=user.getName()%>"><%=user.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Nuevo Nombre de Usuario:</p> <input type="text" name="name">
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>Nueva Contraseña:</p>
                        <input type="password" name="password">
                    </div>
                        <div class="wrap-input100 validate-input m-b-20">
                            <p>¿Será <b>Administrador</b>?</p>
                            <select name="bool-admin">
                                <option value="0">NO Administrador</option>
                                <option value="1">SI Administrador</option>
                            </select>
                    </div>
                    <div class="wrap-input100 validate-input m-b-20">
                        <p>(Opcional) Cambie el Empleado del Usuario:</p>
                        <select name='empleado'>
                            <option value="">
                            </option>
                            <%
                                for (Empleado emple : listaEmpleados) {
                            %>
                            <option value="<%=emple.getId()%>">
                                Empleado <%=emple.getNombreApellido()%>
                            </option>
                            <%
                            }%>
                        </select>
                    </div>
                    <div class="container-login100-form-btn m-t-50 m-b-50">
                        <!-- Send Button -->
                        <button class="login100-form-btn  m-r-50" type="submit">Editar</button> 
                    </div><!-- End Bottom Submit -->
                </form>
            </div>
            <div class="wrap-login100 m-t-175 p-l-55 p-t-40 p-b-30">   
                <form action="BorrarUsuario" method="post">
                    <!--Va el tercero a lo maradona-->  
                    <h2>Borrar Usuario</h2>
                    <p class="m-r-50">Advertencia, los datos relacionados a pedido de que la profe no quiere que usemos cascadetype, quedarán dando vueltas en la base de datos. <b>Pulse el botón bajo su propia responsabilidad.</b></p>
                    <div class="wrap-input100 validate-input m-b-20">
                        <h2 class="fs-16">Seleccione el usuario a Borrar:</h2>
                    </div>
                    <select class="p-r-auto" name="usuario" required>
                        <%
                            for (Usuario elem : listaUsuarios) {
                        %>
                        <option value="<%=elem.getName()%>"> Usuario <%=elem.getName()%>
                        </option>
                        <%}%>
                    </select>
                    <div class="container-login100-form-btn m-t-135 m-b-20 float-b">
                        <button class="login100-form-btn  m-r-50" type="submit">Borrar</button> 
                    </div>
                </form>
            </div>
        </div>
        <% }%>
    </body>
</html>
