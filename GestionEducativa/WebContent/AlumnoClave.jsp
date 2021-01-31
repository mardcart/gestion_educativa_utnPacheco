<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matrix Admin</title>
<!--  <meta charset="UTF-8" />-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--sidebar-menu-->
<%@include file="headerAlumno.jsp" %>
<!-- fin del slider menu -->


<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="MenuAlumno.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home : Alumno</a>
      	<%
    	int id=0;
     	int cantidad;
     	if(sesion.getAttribute("user")!=null){
         id= (Integer)sesion.getAttribute("id");
     	}
    	%>
    	
    </div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
<!--End-Action boxes-->    
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


<!--Chart-box-->    
    <div class="row-fluid">
     <div class="row-fluid">
        <div class="span12">
          <div class="widget-box">
            <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
              <h5>Cambiar Password</h5>
            </div>
            <div class="widget-content nopadding">
              <form class="form-horizontal" >
                <div class="control-group">
                  <label class="control-label">Id</label>
                  <div class="controls">
                    <input type="text" readonly name="idAl" value="<%=id %>" />
                  </div>
                </div>

                <div class="control-group">
                  <label class="control-label">Password</label>
                  <div class="controls">
                    <input type="password" name="pwd" id="pwd" />
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">Confirm password</label>
                  <div class="controls">
                    <input type="password" name="pwd2" id="pwd2" />
                  </div>
                </div>
                <div class="form-actions ">
     	              <button type="submit" class="btn btn-success btn-block" value="confirmar" name="accion">CONFIRMAR</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
     </div>

<!--End-Chart-box--> 
    
    
</div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->
<%@include file="footer.jsp" %>

<!--end-Footer-part-->



</body>

</html>
