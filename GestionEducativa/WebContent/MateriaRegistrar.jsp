<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body>
<!-- MENU HEADER -->

<%@include file="header.jsp" %>
<!-- FIN MENU HEADER -->
<Script>
	$(document).ready(function(){
		$('#submit').click(function(event){
			var VARnombre = $('#nombre').val();
			var VARestado = $('#estado').val();
			
			$.post('ControladorMateria',{
				nombre: VARnombre,
				estado: VARestado
			},function(responseText){
				$('#tabla').html(responseText);
			});
		});
	});
</Script>

<!-- CONTENIDO CENTRAL -->

	<div id="content">
	<!--HOME-->
		<div id="content-header">
			<div id="breadcrumb"> <a href="Index.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
	
	<!--ACTION BOXES-->
		<div class="container-fluid">
		<script>
 			$(document).ready(function() {
 		       // show the alert
 		       setTimeout(function() {
 		           $(".alert").alert('close');
 		       }, 3000);
 		});

		</script>
 
			 <% 
			 if(request.getAttribute("mensaje")!=null){
			 %>
			 	<div class="alert <%=request.getAttribute("tipo") %>"  id="success-alert" >
			 	 <strong>Mensaje !  </strong> <%=request.getAttribute("mensaje") %>
				</div>
			<%} %> 
		
			    <div class="row-fluid">
			      <div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-book"></i> </span>
				          <h5>REGISTRAR MATERIA</h5>
				        </div>
				        <div class="widget-content nopadding">
				          <form  class="form-horizontal">
				            <div class="control-group">
				              <label class="control-label">ID :</label>
				              <div class="controls">
								   <input type="text" class="span11" id="codigo" name="txtId" readonly placeholder="Id materia" />
				              </div>
				            </div>
				            <div class="control-group">
				              <label class="control-label">NOMBRE :</label>
				              <div class="controls">
								   <input type="text" class="span11" id="nombre" name="txtNombre" placeholder="Nombre materia" />
				              </div>
				            </div>
				            <div class="form-actions">
				              <button type="submit" id="submit" class="btn btn-success btn-block" name="accion" value="btnGuardar" >REGISTRAR</button>
				            </div>
				          </form>
				        </div>
			      	</div>        
			      </div>
			    </div>

		</div>
	<!--FIN ACTION BOXES-->    
	</div>

<!-- FIN CONTENIDO CENTRAL -->

<!-- MENU FOOTER -->
<%@include file="footer.jsp" %>
<!-- FIN MENU FOOTER -->

</body>