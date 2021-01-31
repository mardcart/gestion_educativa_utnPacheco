<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Curso" %>
<%@ page import="ModeloDAO.CursoDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="Entidad.Materia" %>
<%@ page import="ModeloDAO.MateriaDAO" %>
<%@ page import="Entidad.Usuario" %>
<%@ page import="ModeloDAO.UsuarioDAO" %>

   
<body>
<!-- MENU HEADER -->
<%@include file="header.jsp" %>
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
				<form>
				<div class="row-fluid">
				  <div class="span12">
				  	<div class="widget-box">
				  		<div class="widget-title"> <span class="icon"> <i class="icon-book"></i></span>
				  			<h5>ACTUALIZAR CURSO</h5>
				  		</div>
				  	</div>
				  </div>	
				</div>
			    <div class="row-fluid">
			      <div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-pencil"></i> </span>
				          <h5>COMPLETAR</h5>
				        </div>
						<%
						Curso curso = new Curso();
						CursoDAO cdao = new CursoDAO();
						int id = Integer.parseInt((String)request.getAttribute("idCurso"));
						curso =  cdao.buscarCurso(id);
						%>
				        <div class="widget-content nopadding">
				          <div  class="form-horizontal">
				            <div class="control-group">
				              <label class="control-label">Id :</label>
				              <div class="controls">
								   <input type="text" value="<%=curso.getId() %>" class="span11" id="codigo" name="txtId" readonly placeholder="ID CURSO" />
				              </div>
				            </div>
				            <div class="control-group">
				              <label class="control-label">Descripcion :</label>
				              <div class="controls">
								   <input type="text" value="<%=curso.getNombre() %>" class="span11" id="nombre" name="txtDescripcion" placeholder="NOMBRE CURSO" />
				              </div>
				            </div>
				            <div class="control-group">
				              <label class="control-label">Seleccione Materia</label>
				              <div class="controls">
				                <select name="cbxMateria">
				              <%
				              MateriaDAO dao =  new MateriaDAO();
				              List<Materia> lst = dao.listadoMaterias();
				              for(Materia m : lst){
				            	  if(m.getId() == curso.getMateria().getId()){
				              %>
				                  <option selected="selected" value="<%=m.getId()%>"><%=m.getNombre() %></option>
				                  
 							<%
			                	 }else{
			                 %>
			            	     <option value="<%=m.getId()%>" ><%=m.getNombre() %></option>          
			                		 	
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
			      </div>
			      <div class="span6">
					<div class="widget-box">
				        <div class="widget-title"> <span class="icon"> <i class="icon-pencil"></i> </span>
				          <h5></h5>
				        </div>
				        <div class="widget-content nopadding">
				          <div  class="form-horizontal">
				            <div class="control-group">
				              <label class="control-label">Seleccione semestre</label>
				              <div class="controls">
				              <%if(curso.getSemestre().equals("PRIMERO")){ %>
				                <label>
				                  <input type="radio" name="rdSemestre" checked  value="PRIMERO"/>
				                  Primero</label>
				                <label>
				                  <input type="radio" name="rdSemestre" value="SEGUNDO"/>
				                  Segundo</label>
				                  <%}else{ %>
				                <label>
				                  <input type="radio" name="rdSemestre"   value="PRIMERO"/>
				                  Primero</label>
				                <label>
				                  <input type="radio" name="rdSemestre" checked value="SEGUNDO"/>
				                  Segundo</label>
				                  
				                  <%} %>
				              </div>
				            </div>
				            <div class="control-group">
				              <label class="control-label">Seleccione Profesor</label>
				              <div class="controls">
				                <select name="cbxProfesor">
				                <%
				                UsuarioDAO dai =  new UsuarioDAO();
				                List<Usuario> lt = dai.listadoProfesores();
				            	for(Usuario u : lt){
				       				if(u.getId() == curso.getProfesor().getId()){
				            	%>
				                  <option value="<%=u.getId() %>" selected="selected"><%=u.getNombre() + " "+ u.getApellido()%></option>
								<%}else{ %>
								<option value="<%=u.getId() %>" ><%=u.getNombre() + " "+ u.getApellido()%></option>
								
								<%
				       				}
				       			} %>
				                </select>
				              </div>
				            </div>
				          </div>
				        </div>
			      	</div>        
			      </div>

			    </div>
				<div class="row-fluid">
				  <div class="span12">
				  	<div class="widget">
				            <div class="form-actions">
				              <button type="submit" id="submit" class="btn btn-success btn-block" name="accion" value="btnUpdateCurso" >ACTUALIZAR</button>
				            </div>
				  	</div>
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

</body>