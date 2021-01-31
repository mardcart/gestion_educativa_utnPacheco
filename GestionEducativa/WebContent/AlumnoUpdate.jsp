<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Provincia" %>
<%@ page import="Entidad.Localidad" %>
<%@ page import="Entidad.Alumno" %>
<%@ page import="ModeloDAO.ProvinciaDAO" %>
<%@ page import="ModeloDAO.LocalidadDAO" %>
<%@ page import="ModeloDAO.AlumnoDAO" %>
<%@ page import="java.util.List" %>

<body>
<!-- MENU HEADER -->
<script src="http://code.jquery.com/jquery-latest.js"></script>


<%@include file="header.jsp" %>

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
			<div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
	
	<!--ACTION BOXES-->
		<div class="container-fluid">

		<form  >
			<div class="row-fluid">
				<div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
				          <h5>INFORMACION - PERSONAL</h5>
				        <%
				      		Alumno alumno = new Alumno();
				        	AlumnoDAO dao = new AlumnoDAO();
				        int id = Integer.parseInt((String)request.getAttribute("idAlumno"));
				        alumno = (Alumno)dao.buscarAlumno(id);
				     	%>
				        </div>
				        <div class="widget-content ">
						  <div class="controls controls-row">
						  	<input type="text" readonly name="txtIdUpdate" value="<%=alumno.getId() %>" class="span2 m-wrap">
				            <input type="text" value="<%=alumno.getDni() %>" readonly name="txtDni" class="span10 m-wrap">
				          </div>
				          <div class="controls controls-row">
				            <input type="text" value="<%=alumno.getNombre() %>" name="txtNombre" class="span6 m-wrap">
				            <input type="text" value="<%=alumno.getApellido() %>" name="txtApellido" class="span6 m-wrap">
				          </div>
				          <div class="controls controls-row">
				    		<input type="text" value="<%=alumno.getTelefono() %>" name="txtTelefono" class="span4 m-wrap">
				            <input type="text" value="<%=alumno.getEmail() %>" name="txtEmail" class="span8 m-wrap">
				          </div>
				         
  				        </div>
				    </div>
				</div>
				<div class="span6">
				      <div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
				          <h5>INFORMACION - SECUNDARIA</h5>
				        </div>
				        <div class="widget-content">
				            
				            <div class="control-group">
				              <label class="control-label">Fecha Nacimiento</label>
				              <div class="controls">
				                <input type="date" name="datFechaNac" data-date="2013-02-01" data-date-format="yyyy-mm-dd" value="<%=alumno.getFechaNac() %>" class="datepicker span11">
				              </div>
				            </div>
				            <div class="control ">
				              
				              
				              <div class="controls ">
				                <% if(alumno.getSexo().equals("Masculino")){%>
				                <label>
				                  <input type="radio" name="rbtSexo" checked=true value="Masculino"/>
				                  Masculino
				                </label>
				                <label>
				                  <input type="radio" name="rbtSexo" value="Femenino" />
				                  Femenino
				                </label>
				                <%}else{%>
				                <label>
				                  <input type="radio" name="rbtSexo"  value="Masculino"/>
				                  Masculino
				                </label>
				                <label>
				                  <input type="radio" name="rbtSexo" checked=true value="Femenino" />
				                  Femenino
				                </label>
				                
				                <%}%>
				              </div>
				            </div>
				             
				        </div>
				      </div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
			      <div class="widget-box">
			        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
			          <h5>DOMICILIO</h5>
			        </div>
			        <div class="widget-content">
			          <div class="controls">
			            <input type="text" name="txtDireccion" value="<%=alumno.getDireccion() %>" class="span12 m-wrap">
			          </div>
			          <div class="control controls-row">
		    
			              <div class="controls span6 m-wrap ">
  			              <label class="control-label">Provincia</label>
			                <select  name="Provincia" id="idProvincia">
							<%
							Provincia pr =  alumno.getLocalidad().getIdProvincia();
							ProvinciaDAO dao1 = new ProvinciaDAO();
							List<Provincia> lst = dao1.ListadoProvincias();
							for(Provincia p : lst){
							%>
			                  <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
			                <%} %>
			                </select>
			              </div>
			              <div class="controls span6 m-wrap">
  			              <label class="control-label">Localidad</label>
			                <select  name="localidad" id="idLocalidad">
			            
			                 <%
			                 LocalidadDAO ldao = new LocalidadDAO();
			                 List<Localidad> lt = ldao.listadoLocalidades();
			                 for(Localidad l : lt){
			                	 if(l.getId() == alumno.getLocalidad().getId()){
			                 %>
			            	     <option selected="selected" value="<%=l.getId() %>"><%=l.getNombre() %></option>          
			                 <%
			                	 }else{
			                		 %>
			            	     <option ><%=l.getNombre() %></option>          
			                		 	
			                		 <%
			                	 }
			                 }
			                 %>
			                 
			                 
			                </select>
			              </div>

		              </div>
			          
			        </div>
			      </div>
				</div>
				<div class="span6">
			      <div class="widget-box">
			        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
			          <h5>INSCRIPCION</h5>
			        </div>
			        <div class="widget-content">
			          <div class="controls">
			            <input type="text" value="<%=alumno.getFechaInscripcion() %>" readonly name="txtFechaInscripcion" class="span4 m-wrap">
			          	<input type="text" value="<%=alumno.getLegajo() %>" readonly name="txtLegajo" class="span8 m-wrap">
			          </div>		    
		              <div class="controls  ">
  			            <label class="control-label">Carrera</label>		              
		                <select  name="cbxCarrera">
		                <% if(alumno.getCarrera().equals("Tecnico Superior Programacion")) {%>
		                  <option value="Tecnico Superior Programacion" selected >Tecnico Superior Programacion</option>
		                  <option value="Tecnico Superior Administracion" >Tecnico Superior Administracion</option>
		                  <option value="Tecnico Superior Electronica">Tecnico Superior Electronica</option>

		                  <%}else if (alumno.getCarrera().equals("Tecnico Superior Administracion")){ %>
		                  <option value="Tecnico Superior Programacion"  >Tecnico Superior Programacion</option>
		                  <option value="Tecnico Superior Administracion" selected>Tecnico Superior Administracion</option>
		                  <option value="Tecnico Superior Electronica">Tecnico Superior Electronica</option>

		                  <%}else if(alumno.getCarrera().equals("Tecnico Superior Electronica")){ %>
		                  <option value="Tecnico Superior Programacion"  >Tecnico Superior Programacion</option>
		                  <option value="Tecnico Superior Administracion" >Tecnico Superior Administracion</option>
		                  <option value="Tecnico Superior Electronica" selected>Tecnico Superior Electronica</option>

		                  <%} %>

		                </select>
		              </div>
			          
		            </div>
			      </div>
			    </div>
	        </div>
			<div class="row-fluid">
		        <div class="form-actions">
	              <button type="submit" class="btn btn-warning btn-block" value="btnUpdate" name="accion">ACTUALIZAR</button>
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