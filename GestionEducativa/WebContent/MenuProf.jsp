<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="Entidad.AlumnoCurso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="ModeloDAO.AlumnoCursoDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matrix Admin</title>
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
<%@include file="headerProf.jsp" %>
<!-- fin del slider menu -->


<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="MenuProf.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home : profesor</a>
     	<%
    	int id;
     	int cantidad=0;
     	int total=0;
		int regular = 0;
		int libre = 0;
		int cursosPrimero = 0;
		int cursosSegundo=0;
     	if(sesion.getAttribute("user")!=null){
         id= (Integer)sesion.getAttribute("id");
    	 CursoDAO cdao = new CursoDAO();
    	  cantidad= cdao.cantidadCursosProfesor(id);
    	
    	%>
       
    	
    </div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="ControladorInscripcion?accion=MisCursos"> <i class="icon-pencil"></i> <span class="label label-important"><%= cantidad= cdao.cantidadCursosProfesor(id)%></span> CARGAR NOTAS </a> </li>
		 
		 <%
		    CursoDAO dao = new CursoDAO();
		   List<Curso> lst = dao.listadoCursosProfesor(id);
			
		   for(Curso curso:lst){
				AlumnoCursoDAO acDAO = new AlumnoCursoDAO();
				int cantidadAlumnos = acDAO.cantidadAlumnos(curso.getId());
				
				if(curso.getSemestre().equals("PRIMERO")){
					cursosPrimero++;
				}else{
					cursosSegundo++;		
				}
				total += cantidadAlumnos;
				
	            List<AlumnoCurso> lstac= acDAO.filtradoCurso(curso.getId());
			    for(AlumnoCurso ac:lstac){
					if(ac.getNota1()>=4 && ac.getNota2()>=4){
						regular++;
					}else if(ac.getNota2()>=4 && ac.getNota3()>=4){ 
						regular++;
					}else if(ac.getNota3()>=4 && ac.getNota4()>=4){
						regular++;	
					}else{ 
						libre ++;
					} 

			    }

				
		 %>
        <li class="bg_lg span3"> <a href="ControladorInscripcion?accion=EstadoAcademico&id=<%=curso.getId()%>"> <i class="icon-folder-open"></i><span class="label label-important"><%=cantidadAlumnos%></span><%=curso.getNombre() %></a> </li>
<!--    
        <li class="bg_lg span3"> <a href="charts.html"> <i class="icon-signal"></i> Charts</a> </li>
        <li class="bg_ly"> <a href="widgets.html"> <i class="icon-inbox"></i><span class="label label-success">101</span> Widgets </a> </li>
        <li class="bg_lo"> <a href="tables.html"> <i class="icon-th"></i> Tables</a> </li>
        <li class="bg_ls"> <a href="grid.html"> <i class="icon-fullscreen"></i> Full width</a> </li>
        <li class="bg_lo span3"> <a href="form-common.html"> <i class="icon-th-list"></i> Forms</a> </li>
        <li class="bg_ls"> <a href="buttons.html"> <i class="icon-tint"></i> Buttons</a> </li>
        <li class="bg_lb"> <a href="interface.html"> <i class="icon-pencil"></i>Elements</a> </li>
        <li class="bg_lg"> <a href="calendar.html"> <i class="icon-calendar"></i> Calendar</a> </li>
        <li class="bg_lr"> <a href="error404.html"> <i class="icon-info-sign"></i> Error</a> </li>

 -->

		<%
		   		}
		  } %>
      </ul>
    </div>
<!--End-Action boxes-->    

<!--Chart-box-->    
 
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Estado Academico</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span12">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong><%=total %></strong> <small>TOTAL INSCRIPTOS</small></li>
                <li class="bg_lb"><i class="icon-book"></i> <strong><%=cantidad %></strong> <small>MATERIAS A CARGO</small></li>
                <li class="bg_ls"><i class="icon-ok"></i> <strong><%=regular %></strong> <small>NRO ALUMNOS REGULAR</small></li>
                <li class="bg_lr"><i class="icon-remove"></i> <strong><%=libre %></strong> <small>NRO ALUMNOS LIBRES</small></li>
                <li class="bg_lo"><i class="icon-star-empty"></i> <strong><%=cursosPrimero %></strong> <small>CURSOS PRIMER CUATRIMESTRE</small></li>
                <li class="bg_ly"><i class="icon-star-empty"></i> <strong><%=cursosSegundo %></strong> <small>CURSOS SEGUNDO CUATRIMESTRE</small></li>
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
