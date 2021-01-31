<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="java.util.List" %>    
    
<body>
<!-- MENU HEADER -->
<%@include file="header.jsp" %>
<!-- FIN MENU HEADER -->
<script>
	$(document).ready(function(){
		$('#idCurso').click(function(event){
			var idVAR = $('#idCurso').val();
			$.post('ControladorInscripcion',{
				id: idVAR,
			},function(responseText){
				$('#tableta').html(responseText);
			});
		});
		
	});
</script>

<!-- CONTENIDO CENTRAL -->

	<div id="content">
	<!--HOME-->
		<div id="content-header">
			<div id="breadcrumb"> <a href="Index.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
	
	<!--ACTION BOXES-->
		<div class="container-fluid">
        <div class="widget-box">
        <div class="widget-content sm">
          <div  class="form-horizontal">
            <div class="control-group">
              <label class="control-label">CURSOS DISPONIBLES : </label>
              <div class="controls">
                <select name="idCurso" id="idCurso" class="form-control ">
				  <option>--SELECCIONAR CURSO--</option>
                <%
                CursoDAO cdao = new CursoDAO();
                List<Curso> lt = cdao.listadoCursos();
                for(Curso curso: lt){
                %>
                  <option value="<%=curso.getId()%>"><%=curso.getNombre() %></option>
                  <%} %>
                </select>
              </div>
            </div>
 		  </div>
		</div>		
		</div>

        <div class="widget-box">
        <div class="widget-content sm">
		   	<table id="tableta" class="table table-info  text-center" >
		    <thead>
		      <tr>
		        <th class="th-sm">NRO</th>
		        <th class="th-sm">LEGAJO</th>
		        <th class="th-sm">NOMBRE APELLIDO</th>
		        <th class="th-sm">EMAIL</th>
		        <th class="th-sm">TELEFONO</th>
		        <th class="th-sm">FECHA INSCRIPCION</th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    </tbody>
		    <tfoot>
		      <tr>
		        <th class="th-sm">NROS</th>		        
		        <th class="th-sm">LEGAJO</th>
		        <th class="th-sm">NOMBRE APELLIDO</th>
		        <th class="th-sm">EMAIL</th>
		        <th class="th-sm">TELEFONO</th>
		        <th class="th-sm">FECHA INSCRIPCION</th>
		      </tr>
		    </tfoot>
		  </table>
		</div>		
		</div>
	
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
	<!--FIN ACTION BOXES-->    
	</div>

<!-- FIN CONTENIDO CENTRAL -->
    <script>
        $(document).ready(function () {
            $('#tabletax').DataTable({
                language: {
                    processing: "Tratamiento en curso...",
                    search: "Buscar&nbsp;:",
                    lengthMenu: "Agrupar de _MENU_ items",
                    info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                    infoEmpty: "No existen datos.",
                    infoFiltered: "(filtrado de _MAX_ elementos en total)",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron datos con tu busqueda",
                    emptyTable: "No hay datos disponibles en la tabla.",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                    aria: {
                        sortAscending: ": active para ordenar la columna en orden ascendente",
                        sortDescending: ": active para ordenar la columna en orden descendente"
                    }
                },
                scrollY: 240,
                lengthMenu: [ [5, 10, -1], [5, 10, "todos"] ],
            });
        });
    </script>

<!-- MENU FOOTER -->
<%@include file="footer.jsp" %>
<!-- FIN MENU FOOTER -->

</body>