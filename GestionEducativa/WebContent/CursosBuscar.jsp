<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="Entidad.Usuario" %>
<%@ page import="ModeloDAO.UsuarioDAO" %>
<%@ page import="Entidad.Materia" %>
<%@ page import="ModeloDAO.MateriaDAO" %>

<%@ page import="java.util.List" %>    

<body>

<!--sidebar-menu-->
<%@include file="header.jsp" %>
<!-- fin del slider menu -->

  <!-- MDBootstrap Datatables  -->
  <link href="css/addons/datatables.min.css" rel="stylesheet">



<!--main-container-part-->
<div id="content">
	
<!--breadcrumbs-->
	  <div id="content-header">
	
	    <div id="breadcrumb"> <a href="Index.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>

	  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
	<div class="container-fluid">

		<div class="container-fluid">

		  <table id="dtBasicExample" class="table table-success	 table-bordered table-sm" cellspacing="0" width="100%">
		    <thead>
		      <tr>
		        <th class="th-sm">id</th>
		        <th class="th-sm">descripcion</th>
		        <th class="th-sm">profesor</th>
		        <th class="th-sm">semestre</th>
		        <th class="th-sm">materia</th>
		        <th class="th-sm">instruccion</th>
		      </tr>
		    </thead>
		    <tbody>
		    <%
		    CursoDAO dao = new CursoDAO();
		   List<Curso> lst = dao.listadoCursos();
		   for(Curso curso:lst){
		     Usuario user = new Usuario();
		     Materia materia = new Materia();
		     UsuarioDAO duser = new UsuarioDAO();
		     MateriaDAO dmateria = new MateriaDAO();
             user = duser.buscarUsuarioAdm(curso.getProfesor().getId());
             materia = dmateria.buscarMateria(curso.getMateria().getId());
		    %>
		    
		      <tr>
		        <td><%=curso.getId()%></td>
		        <td><%=curso.getNombre() %></td>
		        <td><%=user.getNombre() + " " + user.getApellido()%></td>
		        <td><%=curso.getSemestre()%></td>
		        <td><%=materia.getNombre()%></td>
		        <td>
				<a  href="ControladorMateria?accion=editarCurso&id=<%=curso.getId()%>" class="btn btn-outline-success" role="button">editar</a>
				<a href="ControladorMateria?accion=eliminarCurso&id=<%=curso.getId()%>" class="btn btn-outline-danger" role="button">eliminar</a>
				</td>
		      </tr>
			<%} %>
		    </tbody>
		    <tfoot>
		      <tr>
		        <th>id</th>
		        <th>descripcion</th>
		        <th>profesor</th>
		        <th>semestre</th>
		        <th>materia</th>
		        <th>instruccion</th>
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
