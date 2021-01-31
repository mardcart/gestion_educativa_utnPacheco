<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="ModeloDAO.ConteoDAO" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Educativaa</title>
<!--  <meta charset="UTF-8" />-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--sidebar-menu-->
<%@include file="header.jsp" %>
<!-- fin del slider menu -->


<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="Index.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home: Administracion</a>
     	<%
    	int id;
     	int cantidad;
     	if(sesion.getAttribute("user")!=null){
         id= (Integer)sesion.getAttribute("id");
    	 CursoDAO cdao = new CursoDAO();
    	  cantidad= cdao.cantidadCursosProfesor(id);
     	}
    	%>
       
    	
    </div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  
  <div class="container-fluid">
  <!--
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="index.html"> <i class="icon-book"></i> <span class="label label-important"></span> Mis cursos </a> </li>
        <li class="bg_lg span3"> <a href="charts.html"> <i class="icon-signal"></i> Charts</a> </li>
        <li class="bg_ly"> <a href="widgets.html"> <i class="icon-inbox"></i><span class="label label-success">101</span> Widgets </a> </li>
        <li class="bg_lo"> <a href="tables.html"> <i class="icon-th"></i> Tables</a> </li>
        <li class="bg_ls"> <a href="grid.html"> <i class="icon-fullscreen"></i> Full width</a> </li>
        <li class="bg_lo span3"> <a href="form-common.html"> <i class="icon-th-list"></i> Forms</a> </li>
        <li class="bg_ls"> <a href="buttons.html"> <i class="icon-tint"></i> Buttons</a> </li>
        <li class="bg_lb"> <a href="interface.html"> <i class="icon-pencil"></i>Elements</a> </li>
        <li class="bg_lg"> <a href="calendar.html"> <i class="icon-calendar"></i> Calendar</a> </li>
        <li class="bg_lr"> <a href="error404.html"> <i class="icon-info-sign"></i> Error</a> </li>
      </ul>
    </div>
    -->
<!--End-Action boxes-->    

<!--Chart-box-->    
	<%
	ConteoDAO cdao = new ConteoDAO();
	%>
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span4">
              <ul class="site-stats">
                <li class="bg_lb"><i class="icon-user"></i> <strong></strong> <small>EMPLEADOS</small></li>
                <li class="bg_lh"><i class="icon-group"></i> <strong><%=cdao.ConteoAdministracion() + cdao.ConteoProfesores() %></strong> <small>TOTAL </small></li>
                <li class="bg_lh"><i class="icon-user"></i> <strong><%=cdao.ConteoAdministracion() %></strong> <small>ADMINISTRADOR</small></li>
                <li class="bg_lh"><i class="icon-user"></i> <strong><%=cdao.ConteoProfesores() %></strong> <small>DOCENTE </small></li>
                <li class="bg_lh"><i class="icon-bookmark"></i> <strong><%=cdao.ConteoMasculinosAdm() %></strong> <small>MASCULINO</small></li>
                <li class="bg_lh"><i class="icon-bookmark-empty"></i> <strong><%=cdao.ConteoFemeninoAdm() %></strong> <small>FEMENINO</small></li>
              </ul>
            </div>
            <div class="span4">
              <ul class="site-stats">
                <li class="bg_lg"><i class="icon-user"></i> <strong></strong> <small>ALUMNOS</small></li>
                <li class="bg_lh"><i class="icon-group"></i> <strong><%=cdao.ConteoAlumnos() %></strong> <small>TOTAL </small></li>
                <li class="bg_lh"><i class="icon-hand-up"></i> <strong><%=cdao.ConteoAlumnosActivos() %></strong> <small>ACTIVOS</small></li>
                <li class="bg_lh"><i class="icon-hand-down"></i> <strong><%=cdao.ConteoAlumnosInactivos()%></strong> <small>INACTIVOS</small></li>
                <li class="bg_lh"><i class="icon-bookmark"></i> <strong><%=cdao.ConteoMasculinosAlm() %></strong> <small>MASCULINO</small></li>
                <li class="bg_lh"><i class="icon-bookmark-empty"></i> <strong><%=cdao.ConteoFemeninoAlm() %></strong> <small>FEMENINO</small></li>

              </ul>
            </div>
            <div class="span4">
              <ul class="site-stats">
              	<li class="bg_ly"><i class="icon-bar-chart"></i> <strong></strong> <small>MATERIAS</small></li>
                <li class="bg_lh"><i class="icon-book"></i> <strong><%=cdao.ConteoMaterias() %></strong> <small>TOTAL</small></li>
                <li class="bg_lh"><i class="icon-folder-open"></i> <strong><%=cdao.ConteoCursos() %></strong> <small>CURSOS </small></li>
                <li class="bg_lh"><i class="icon-check"></i> <strong><%=cdao.ConteoInscriptos() %></strong> <small>INSCRIPTO MATERIAS</small></li>
                <li class="bg_lh"><i class="icon-star-empty"></i> <strong><%=cdao.ConteoMateriasPrimer() %></strong> <small>PRIMER SEMESTRE</small></li>
                <li class="bg_lh"><i class="icon-star-empty"></i> <strong><%=cdao.ConteoCursos() - cdao.ConteoMateriasPrimer() %></strong> <small>SEGUNDO SEMESTRE</small></li>
              </ul>
            </div>
            

          </div>
        </div>
      </div>
    </div>


<!--End-Chart-box--> 
    <hr/>
  </div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->
<%@include file="footer.jsp" %>

<!--end-Footer-part-->



</body>

</html>
