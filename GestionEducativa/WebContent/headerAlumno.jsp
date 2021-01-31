<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Escolar Mc</title>
<!--  <meta charset="UTF-8" />-->
        <script src = "jquery-1.7.1.js"></script>
        <script src = "ajax.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="css/bootstrap.min.css" />

<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<!-- SE AGREGO AL FINAL POSIBLES ERRORES -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 -->
<link rel="stylesheet" href="css/matrix-media.css" />

<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />

<script src="http://code.jquery.com/jquery-latest.js"></script>

<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="Index.jsp">Sistema Escolar</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">
    
       	<%
    	 HttpSession sesion = request.getSession();
    	 String usuario ;
    	if(sesion.getAttribute("user")!=null){
    	%>
    		<Strong style="color:#FF0000;"> bienvenido : <%=sesion.getAttribute("user") %></Strong>
    	<%
    	}
    	%>
      </span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        
        <li><a href="ControladorLoguearse?accion=CerrarSession"><i class="icon-key"></i> Salir</a></li>
      </ul>
    </li>
    <!-- 
    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li>
     
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  	 -->
    <li class=""><a title="" href="ControladorLoguearse?accion=CerrarSession"><i class="icon icon-share-alt"></i> <span class="text">Salir</span></a></li>

  </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<!-- 
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
 -->
<!--close-top-serch-->
<!--sidebar-menu-->
<div id="sidebar"><a href="MenuAlumno.jsp" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class="active"><a href="MenuAlumno.jsp"><i class="icon icon-home"></i> <span>home</span></a> </li>
    <!--
    <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>GRAFICOS</span></a> </li>

    <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>Materias</span></a> </li>
    <li><a href="tables.html"><i class="icon icon-th"></i> <span>Profesores</span></a></li>
    <li><a href="grid.html"><i class="icon icon-fullscreen"></i> <span>Alumnos</span></a></li>
     -->
     <li class="submenu"> <a href="#"><i class="icon icon-user"></i> <span>USUARIO</span> </a>
      <ul>
        <li><a href="ControladorAlumno?accion=cambiarClave">CAMBIAR CONTRASENA</a></li>
        


      </ul>
    </li>
    
    
    <!--  
    <li><a href="buttons.html"><i class="icon icon-tint"></i> <span>Buttons &amp; icons</span></a></li>
    <li><a href="interface.html"><i class="icon icon-pencil"></i> <span>Eelements</span></a></li>
     
    <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Addons</span> <span class="label label-important">5</span></a>
      <ul>
        <li><a href="index2.html">Dashboard2</a></li>
        <li><a href="gallery.html">Gallery</a></li>
        <li><a href="calendar.html">Calendar</a></li>
        <li><a href="invoice.html">Invoice</a></li>
        <li><a href="chat.html">Chat option</a></li>
      </ul>
    </li>
    -->
    <!--  
    <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>Error</span> <span class="label label-important">4</span></a>
      <ul>
        <li><a href="error403.html">Error 403</a></li>
        <li><a href="error404.html">Error 404</a></li>
        <li><a href="error405.html">Error 405</a></li>
        <li><a href="error500.html">Error 500</a></li>
      </ul>
    </li>
     
    <li class="content"> <span>Monthly Bandwidth Transfer</span>
      <div class="progress progress-mini progress-danger active progress-striped">
        <div style="width: 77%;" class="bar"></div>
      </div>
      <span class="percent">77%</span>
      <div class="stat">21419.94 / 14000 MB</div>
    </li>
    <li class="content"> <span>Disk Space Usage</span>
      <div class="progress progress-mini active progress-striped">
        <div style="width: 87%;" class="bar"></div>
      </div>
      <span class="percent">87%</span>
      <div class="stat">604.44 / 4000 MB</div>
    </li>
    -->
  </ul>
</div>

</body>

</html>
