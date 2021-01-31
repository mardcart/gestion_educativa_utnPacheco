<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="Entidad.Materia" %>
<%@ page import="ModeloDAO.MateriaDAO" %>

<%@ page import="java.util.List" %>    

<body>

<!--sidebar-menu-->
<%@include file="headerProf.jsp" %>
<!-- fin del slider menu -->

  <!-- MDBootstrap Datatables  -->
  <link href="css/addons/datatables.min.css" rel="stylesheet">



<!--main-container-part-->
<div id="content">
	
<!--breadcrumbs-->
	  <div id="content-header">
	
	    <div id="breadcrumb"> <a href="MenuProf.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>

	  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
	<div class="container-fluid">

		<div class="container-fluid">

			<table id="tablax" class="table table-info  text-center" >
		    <thead>
		      <tr>
		        <th class="th-sm">id</th>
		        <th class="th-sm">descripcion</th>
		        <th class="th-sm">materia</th>
		        <th class="th-sm">semestre</th>
		        <th class="th-sm">año</th>
		        <th class="th-sm">instruccion</th>
		      </tr>
		    </thead>
		    <tbody>
     	<%
    	int id;
     	int cantidad=0;
     	if(sesion.getAttribute("user")!=null){
         id= (Integer)sesion.getAttribute("id");
    	 CursoDAO cdao = new CursoDAO();
    	  cantidad= cdao.cantidadCursosProfesor(id);
    	
    	%>
		    
		    <%
		    //EN ESTA PARTE MODIFICAR LA BUSQUEDA SEGUN SESSION PARA MOSTRAR CURSOS
		    //EL BOTON NOS LLEVA A UNA PANTALLA DONDE MUESTRA LOS ALUMNOS QUE ESTAN CURSANDO 
		    //DICHO CURSO  Y SE PROSIGUE  A EVALUAR EN LOTE.
		    CursoDAO dao = new CursoDAO();
		   List<Curso> lst = dao.listadoCursosProfesor(id);
			
		   for(Curso curso:lst){
			   MateriaDAO mdao = new MateriaDAO();
			   Materia materia = mdao.buscarMateria(curso.getMateria().getId());
		    %>
		    
		      <tr>
		        <td class="text-center"><%=curso.getId()%></td>
		        <td class="text-center"><%=curso.getNombre()%></td>
		        <td class="text-center"><%=materia.getNombre()%></td>
		        <td class="text-center"><%=curso.getSemestre()%></td>
		        <td class="text-center"><%=curso.getAnio() %></td>
		        <td>
				<a href="ControladorInscripcion?accion=buscarAlumnos&idListado=<%=curso.getId()%>" class="btn btn-outline-info btn-sm" role="button">EVALUAR</a>

				</td>
		      </tr>
			<%} 
			}%>
		    </tbody>
		    <tfoot>
		      <tr>
		        <th class="th-sm">id</th>
		        <th class="th-sm">descripcion</th>
		        <th class="th-sm">materiaa</th>
		        <th class="th-sm">semestre</th>
		        <th class="th-sm">año</th>
		        <th class="th-sm">instruccion</th>
		      </tr>
		    </tfoot>
		  </table>
		<script>
 			$(document).ready(function() {
 		       // show the alert
 		       setTimeout(function() {
 		           $(".alert").alert('close');
 		       }, 2000);
 			});

		</script>
 
			 <% 
			 if(request.getAttribute("mensaje")!=null){
			 %>
			 	<div class="alert <%=request.getAttribute("tipo") %>"  id="success-alert" >
			 	 <strong>Mensaje !  </strong> <%=request.getAttribute("mensaje") %>
				</div>
			<%} %> 
			
			
		</div>
	</div>
<!--End-Action boxes-->    
</div>

<script src="js/jquery.min.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.tables.js"></script>

  <!-- jQuery -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- Your custom scripts (optional) -->
  <script type="text/javascript"></script>


  <!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
<script>

$(document).ready(function () {
  $('#dtBasicExample').DataTable();
  $('.dataTables_length').addClass('bs-select');
});
</script>
<!--Footer-part-->
<%@include file="footer.jsp" %>
<!--end-Footer-part-->
</body>

