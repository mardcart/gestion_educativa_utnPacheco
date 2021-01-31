<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Provincia" %>
<%@ page import="ModeloDAO.ProvinciaDAO" %>
<%@ page import="java.util.List" %>

<body>
<!-- MENU HEADER -->
<script src="http://code.jquery.com/jquery-latest.js"></script>


<%@include file="header.jsp" %>


<!-- FIN MENU HEADER -->

<!-- CONTENIDO CENTRAL -->

	<div id="content">
	<!--HOME-->
		<div id="content-header">
			<div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
		</div>
	<!--FIN HOME-->
                <script>
                window.onload= function() {
                alert( "Mensaje :  <%=request.getAttribute("mensaje")%>")
                };
                </script>
	
	<!--ACTION BOXES-->
		<div class="container-fluid">
		<form >
			<div class="row-fluid">
				<div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
				          <h5>INFORMACION - PERSONAL</h5>
				        </div>
				        <div class="widget-content ">
						  <div class="controls controls-row">
						  	<input type="text" placeholder="ID" disabled name="txtId" class="span2 m-wrap">
				          </div>
				          <div class="controls controls-row">
				            <input type="text" placeholder="NOMBRE" name="txtNombre" class="span6 m-wrap">
				            <input type="text" placeholder="APELLIDO" name="txtApellido" class="span6 m-wrap">
				          </div>
				         
  				        </div>
				    </div>
				</div>
				
			</div>
			<div class="row-fluid">
		        <div class="form-actions">
	              <button type="submit" class="btn btn-success btn-block" value="btnAgregar" name="accion">REGISTRAR</button>
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