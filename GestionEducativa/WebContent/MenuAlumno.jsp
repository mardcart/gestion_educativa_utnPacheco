<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ page import="Entidad.Alumno" %>
<%@ page import="Entidad.AlumnoCurso" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="ModeloDAO.AlumnoCursoDAO" %>
<%@ page import="ModeloDAO.CursoDAO" %>

<%@ page import="java.util.List" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Educativa</title>
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
<%@include file="headerAlumno.jsp" %>
<!-- fin del slider menu -->


<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="MenuAlumno.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home : Alumno</a>
      	<%
    	int id=0;
     	if(sesion.getAttribute("user")!=null){
         id= (Integer)sesion.getAttribute("id");
     	}
    	%>
    	
    </div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
<!--End-Action boxes-->    

<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-book"></i></span>
          <h5>CURSOS	</h5>
        </div>
		<%
		AlumnoCursoDAO acDao = new AlumnoCursoDAO();
		List<AlumnoCurso> lst = acDao.listaCursosDelAlumno(id);
					
		%>

        <div class="widget-content" >
          <div class="row-fluid">
             <div class="span12">
              <ul class="site-stats">
            <%
            for(AlumnoCurso ac:lst){
            	Curso curso = new Curso();
            	CursoDAO cDao = new CursoDAO();
            	curso = cDao.buscarCurso(ac.getCurso().getId());
            %>
                <li class="bg_ly"><i class=" icon-folder-open"></i> <strong><%=curso.getNombre() %></strong> 
                <small >PARCIALES</small>                	
                
                </li>
	         <% 
	         }	
              %>
	          </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

<!--End-Chart-box--> 
    
    
</div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->
<%@include file="footer.jsp" %>

<!--end-Footer-part-->



</body>

</html>
