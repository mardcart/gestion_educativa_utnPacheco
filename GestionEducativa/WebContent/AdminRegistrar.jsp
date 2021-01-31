<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Provincia" %>
<%@ page import="ModeloDAO.ProvinciaDAO" %>
<%@ page import="java.util.List" %>

<body>
<!-- MENU HEADER -->


<%@include file="header.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$( document ).ready(function() {

    var now = new Date();

    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);

    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
    $("#fecha").val(today);
});
</script>
<script>
	$(document).ready(function(){
		$('#idProvincia').click(function(event){
			var idVAR = $('#idProvincia').val();
			$.post('ControladorCargarLocalidad',{
				id: idVAR,
			},function(responseText){
				$('#idLocalidad').html(responseText);
			});
		});
		
	});
</script>

<!-- FIN MENU HEADER -->

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

		<form >
		  <div class="row-fluid">
		    <div class="widget-box">
		      <div class="widget-title"> <span class="icon"> <i class="icon-user"></i> </span>
		        <h5 class="text-center">COMPLETAR DATOS DEL EMPLEADO</h5>
		      </div>
		    </div>
		  </div>

			<div class="row-fluid">
				<div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-star"></i> </span>
				          <h5>INFORMACION</h5>
				        </div>
				        <div class="widget-content ">
  			              <label class="control-label">DATOS PRINCIPALES</label>

						  <div class="controls controls-row">
						  	<input type="text" placeholder="ID" readonly name="txtId" class="span2 m-wrap">
				            <input type="text" placeholder="DNI"  onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="txtDni" class="span10 m-wrap">
				          </div>
				          <div class="controls controls-row">
				            <input type="text" placeholder="NOMBRE" name="txtNombre" class="span6 m-wrap">
				            <input type="text" placeholder="APELLIDO" name="txtApellido" class="span6 m-wrap">
				          </div>
				          <div class="controls controls-row">
				    		<input type="text" placeholder="TELEFONO" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="txtTelefono" class="span4 m-wrap">
				            <input type="email" placeholder="EMAIL" name="txtEmail" class="span8 m-wrap">
				          </div>
				         
  				        </div>
				    </div>
				</div>
				<div class="span6">
				      <div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-calendar"></i> </span>
				          <h5></h5>
				        </div>
				        <div class="widget-content">
				            
				            <div class="control-group">
				              <label class="control-label">Fecha Nacimiento</label>
				              <div class="controls">
				                <input type="date" name="datFechaNac" data-date="2013-02-01" data-date-format="yyyy-mm-dd" value="2013-02-01" class="datepicker span11">
				              </div>
				            </div>
				            <div class="control ">
				              <label class="control-label">Sexo</label>
				              
				              <div class="controls ">
				              
				                <label>
				                  <input type="radio" name="rbtSexo" checked=true value="Masculino"/>
				                  Masculino</label>
				                <label>
				                  <input type="radio" name="rbtSexo" value="Femenino" />
				                  Femenino</label>
				              </div>
				            </div>
				             
				        </div>
				      </div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
			      <div class="widget-box">
			        <div class="widget-title"> <span class="icon"> <i class="icon-sitemap"></i> </span>
			          <h5>DOMICILIO</h5>
			        </div>
			        <div class="widget-content">
			          <div class="controls">
			            <input type="text" name="txtDireccion" placeholder="DIRECCION" class="span12 m-wrap">
			          </div>
			          <div class="control controls-row">
		    
			              <div class="controls span6 m-wrap ">
  			              <label class="control-label">Provincia</label>
			                <select  name="Provincia" id="idProvincia" class="form-control form-control-sm">
			                
							<%
							ProvinciaDAO dao = new ProvinciaDAO();
							List<Provincia> lst = dao.ListadoProvincias();
							for(Provincia p : lst){
							%>
			                  <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
			                <%} %>
			                </select>
			                
			              </div>
			              
			              <div class="controls span6 m-wrap">
			               	<label class="control-label">Localidad</label>
			                <select  name="localidad" id="idLocalidad" class="form-control form-control-sm">
			                 <option selected="selected">--seleccionar provincia--</option>
			                </select>
			              </div>

		              </div>
			          
			        </div>
			      </div>
				</div>
				<div class="span6">
			      <div class="widget-box">
			        <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
			          <h5>AREA DE DESARROLLO</h5>
			        </div>
			        <div class="widget-content">
			          <div class="control controls-row">
		    
			              <div class="controls span6 m-wrap ">
  			              <label class="control-label">Profesion</label>
			                <select  name="cbxProfesion" class="form-control form-control-sm">
			                  <option value="INGENIERO EN SISTEMAS" >INGENIERO EN SISTEMAS</option>
			                  <option value="LICENCIADO EN INFORMATICA">LICENCIADO EN INFORMATICA</option>
			                  <option value="ADM CONTABLE">ADM CONTABLE</option>
			                  <option value="LICENCIADO EN ELECTRONICA">LICENCIADO EN ELECTRONICA</option>
			                </select>
			              </div>
			              
			              <div class="controls span6 m-wrap">
				          <label class="control-label">Area</label>
			                <select  name="cbxArea"  class="form-control form-control-sm">
			                 <option value="DOCENTE">DOCENTE</option>
			                 <option value="ADMINISTRACION">ADMINISTRACION</option>
			                </select>
			              </div>

		              </div>
			          
		            </div>

			      </div>
			    </div>
	        </div>
			<div class="row-fluid">
		        <div class="form-actions">
	              <button type="submit" class="btn btn-success btn-block" value="btnRegistrarAdm" name="accion">REGISTRAR</button>
	            </div>			        
			</div>
			</form>
		</div>
	<!--FIN ACTION BOXES-->    
	</div>

<!-- FIN CONTENIDO CENTRAL -->

<!-- MENU FOOTER -->
<%@include file="footer.jsp" %>
<!-- FIN MENU FOOTER -->

<!--end-Footer-part--> 



</body>