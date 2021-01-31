<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Usuario" %>
<%@ page import="ModeloDAO.UsuarioDAO" %>
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

			<table id="tablax" class="table table-info  text-center" >
		    <thead>
		      <tr>
		        <th class="th-sm">id</th>
		        <th class="th-sm">dni</th>
		        <th class="th-sm">nombre apellido</th>
		        <th class="th-sm">fecha nacimiento</th>
		        <th class="th-sm">area</th>
		        
		        <th class="th-sm">instruccion</th>
		      </tr>
		    </thead>
		    <tbody>
		    <%
		    UsuarioDAO dao = new UsuarioDAO();
		   List<Usuario> lst = dao.listadoUsuarioAdm();
		   for(Usuario usuario1:lst){
		    %>
		    
		      <tr>
		        <td><%=usuario1.getId()%></td>
		        <td><%=usuario1.getDni()%></td>
		        <td><%=usuario1.getNombre() + " " + usuario1.getApellido()%></td>
		        <td><%=usuario1.getFechaNac()%></td>
		        <td><%=usuario1.getArea()%></td>
		        <td>
				<a href="ControladorAdmin?accion=editar&id=<%=usuario1.getId()%>" class="btn btn-outline-info btn-sm" role="button">editar</a>
				<a href="ControladorAdmin?accion=eliminar&id=<%=usuario1.getId()%>" class="btn btn-outline-danger btn-sm" role="button">eliminar</a>
				</td>
		      </tr>
			<%} %>
		    </tbody>
		    <tfoot>
		      <tr>
		        <th>id</th>
		        <th>dni</th>
		        <th>nombre apellido</th>
		        <th>fecha nacimiento</th>
		        <th>area</th>
		        
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

