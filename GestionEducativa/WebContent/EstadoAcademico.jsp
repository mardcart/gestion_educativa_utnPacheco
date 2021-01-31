<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Usuario" %>
<%@ page import="ModeloDAO.UsuarioDAO" %>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>

<%@ page import="Entidad.AlumnoCurso" %>
<%@ page import="ModeloDAO.AlumnoCursoDAO" %>
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
          <%
		    AlumnoCursoDAO dao = new AlumnoCursoDAO();
	        int id = Integer.parseInt((String)request.getAttribute("idEstadoAcademico"));
            List<AlumnoCurso> lst= dao.filtradoCurso(id);
            
          %>

			<table id="tablax" class="table table-info  text-center" >
		    <thead>
		      <tr>
		        <th class="th-sm text-center">LEGAJO</th>
		        <th class="th-sm text-center">NOMBRE APELLIDO</th>
		        <th class="th-sm text-center">NOTAS 1</th>
		        <th class="th-sm text-center">NOTAS 2</th>
		        <th class="th-sm text-center">RECUP 1</th>
		        <th class="th-sm text-center">RECUP 2</th>

		        <th class="th-sm text-center">ESTADO ACADEMICO</th>
		     
		      </tr>
		    </thead>
		    <tbody>
		    <%
			
		    for(AlumnoCurso ac:lst){
		    	Alumno al = new Alumno();
		    	AlumnoDAO aDao =new  AlumnoDAO();
		    	al = aDao.buscarAlumno(ac.getAlumno().getId());
		    	int promedio = (ac.getNota1() + ac.getNota2() + ac.getNota3() + ac.getNota4())/4;
		    	
		    %>
		    
		      <tr>
		        <td class="text-center"><%=al.getLegajo()%></td>
		        <td class="text-center"><%=al.getNombre() + " "+ al.getApellido() %></td>
		        <td class="text-center"><%=ac.getNota1()  %></td>
		        <td class="text-center"><%=ac.getNota2()  %></td>
		        <td class="text-center"><%=ac.getNota3()  %></td>
		        <td class="text-center"><%=ac.getNota4()  %></td>
				<%
				if(ac.getNota1()>=4 && ac.getNota2()>=4){
				%>
				<td class="text-center text-success"><strong>REGULAR</strong></td>				
				<%}else if(ac.getNota2()>=4 && ac.getNota3()>=4){ %>
				<td class="text-center text-success"><strong>REGULAR</strong></td>												
				<%}else if(ac.getNota3()>=4 && ac.getNota4()>=4){%>
				<td class="text-center text-success"><strong>REGULAR</strong></td>				
				<%}else{ %>
				<td class="text-center text-danger"><strong>LIBRE</strong></td>				
				<%} %>
		      </tr>
			<% }%>
		    </tbody>
		    <tfoot>
		      <tr>
		        <th class="th-sm text-center">LEGAJO</th>
		        <th class="th-sm text-center">NOMBRE APELLIDO</th>
		        <th class="th-sm text-center">NOTAS 1</th>
		        <th class="th-sm text-center">NOTAS 2</th>
		        <th class="th-sm text-center">RECUP 1</th>
		        <th class="th-sm text-center">RECUP 2</th>

		        <th class="th-sm text-center">ESTADO ACADEMICO</th>
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

