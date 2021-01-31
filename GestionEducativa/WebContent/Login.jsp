<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Matrix Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
		<!-- script para que se borre el mensaje -->
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<!-- fin script -->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/matrix-login.css" />
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    </head>

    <body>
  
        <div id="loginbox">            
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
        
            <form id="loginform" class="form-vertical" >
				 <div class="control-group normal_text"> <h3><img src="img/logo.png" alt="Logo" /></h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"> </i></span><input type="text" placeholder="Username" name="username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" placeholder="Password" name="password"/>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <div class="control-group">
                    <span ><button type="submit" value="loguearse" name="accion" class="btn btn-success btn-block " /> LOGIN</button></span>
                    </div>
                    
                    
                </div>
            </form>
        </div>
        <!--SCRIPT BORRAR MENSAJE-->
		<script src="js/bootstrap.min.js"></script> 
		<!-- FIN SCRIPT BORRAR MENSAJE -->
        
    
    </body>

</html>
