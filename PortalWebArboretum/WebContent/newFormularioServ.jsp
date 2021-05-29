<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <meta name="description" content="">
 <meta name="author" content="">
<title>Nueva Solicitud de Servicio</title>
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
                                <h1 class="h4 text-gray-900 mb-4">Solicitud de servicios</h1>
                            </div>
                            <form class="user" method="post" action="./Sl_GestionFormulario" >
								<!-- El valor de este input es para el Servlet opcion guardar -->
                            	<input name="opcion" type="hidden" value="1" />
                            	<div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                    	<%
                                    	ArrayList<Servicios> listServ = new ArrayList<Servicios>();
                                    	Dt_Servicios dts = new Dt_Servicios();
                                    	listServ = dts.listaServiciosActivos();
                                		%>
                                    	<select class="form-control" name="cbxServ" id="cbxServ" required>
                                    	<option value="">Seleccione el Servicio que desea solicitar...</option>
                                    	<%
                                    	for(Servicios serv: listServ){
                                    	%>	
                                    		<option value="<%=serv.getIdServ()%>"><%=serv.getNombre()%></option>
                                    	<%
                                    		}
                                    	%>
                                    	
                                    	</select>
                                    </div>
                                </div>   
                            	<div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user" name="txtNombre" id="txtNombre"
                                            placeholder="Nombre del Solicitante" required>
                                    </div>
                                 <div class="col-sm-12 mb-3">
                                        <input type="email" class="form-control form-control-user" name="txtEmail" id="txtEmail"
                                            placeholder="Correo Electronico" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user" name="txtDesc" id="txtDesc"
                                            placeholder="Describa su solicitud" required>
                                    </div>
                                    
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-user" name="txtNumero" id="txtNumero"
                                            placeholder="Numero telefonico" required>
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
</body>
</html>