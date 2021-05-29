<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="entidades.Mapa, datos.Dt_Mapa, java.util.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <meta name="description" content="">
 <meta name="author" content="">
<title>Nuevo Mapa</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link
    href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
    rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body class="bg-gradient-primary">

<div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Editar Mapa</h1>
                            </div>
                            <%
                            	String us = "";
								us = request.getParameter("mapaID")==null?"0":request.getParameter("mapaID");
														
								Mapa user = new Mapa();
								Dt_Mapa Mp = new Dt_Mapa();
								user = Mp.getMapa(Integer.parseInt(us));
                            %>
                            
                            <form class="user" method="post" action="./Sl_GestionUsuario" >
								<!-- El valor de este input es para el Servlet opcion guardar -->
                            	<input name="mapaID" type="hidden" value="<%=user.getMapaID()%>" />
                            	<input name="opcion" type="hidden" value="2" />
                            	<div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user" name="txtNombres" id="txtNombres"
                                            placeholder="Nombres" required>
                                    </div>
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control form-control-user" name="txtsectorID" id="txtsectorID"
                                            placeholder="txtsectorID" required>
                                    </div>
                               
                                </div>
	                            <hr>
	                            <div class="text-center">
	                                <input class="btn btn-primary btn-user btn-block" type="submit" value="Guardar" />
	                            </div>
	                            <div class="text-center">
	                                <input class="btn btn-google btn-user btn-block" type="reset" value="Cancelar" />
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>



<!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

<script>  
   $(document).ready(function()
	{
		$("#txtNombres").val("<%=user.getNombre()%>");
		$("#txtsectorID").val("<%=user.getMapaID()%>")
		
	});
</script>
    
</body>
</html>