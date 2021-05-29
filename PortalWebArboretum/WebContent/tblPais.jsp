<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="entidades.Pais, datos.Dt_Pais, java.util.*;" %>
<!DOCTYPE html>
<%
	//Variable de control de mensajes
	String varMsj = request.getParameter("msj")==null?"":request.getParameter("msj");


%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Paises Registrados</title>

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<!-- <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet"> -->

<!-- DATATABLE -->
<link href="DataTables/DataTables-1.10.21/css/jquery.dataTables.min.css" rel="stylesheet">
<!-- DATATABLE buttons -->
<link href="DataTables/Buttons-1.6.3/css/buttons.dataTables.min.css" rel="stylesheet">
<!-- jAlert css  -->
<link rel="stylesheet" href="jAlert/dist/jAlert.css" />

</head>

<body id="page-top">

<!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fab fa-pagelines"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Arboreto Carmelo Palma</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSeguridad"
                    aria-expanded="true" aria-controls="collapseSeguridad">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Seguridad</span>
                </a>
                <div id="collapseSeguridad" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Usuarios</h6>
                        <a class="collapse-item" href="tblUsuarios.jsp">Usuarios</a>
                        <a class="collapse-item" href="editUsuario.jsp">Editar Usuarios</a>
                        <a class="collapse-item" href="newUsuario.jsp">Agregar Usuarios</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Rol</h6>
                        <a class="collapse-item" href="tblRol.jsp">Roles</a>
                        <a class="collapse-item" href="tblRolUser.jsp">Roles asignados</a>
                        <a class="collapse-item" href="editRol.jsp">Editar rol</a>
                        
                    </div>
                    
                </div>
            </li>

            <hr class="sidebar-divider my-0">

            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseServicios"
                    aria-expanded="true" aria-controls="collapseServicios">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Servicios</span>
                </a>
                <div id="collapseServicios" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h7 class="collapse-header">Servicios</h7>
                        <a class="collapse-item" href="tblServicios.jsp">Servicios</a>
                        <a class="collapse-item" href="tblCatalgServ.jsp">Catalogo Servicios</a>
                        
                    </div>
                    
                </div>
            </li>
            
            <hr class="sidebar-divider my-0">

            <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseArbol"
                    aria-expanded="true" aria-controls="collapseArbol">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Arboles</span>
                </a>
                <div id="collapseArbol" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Arboles</h6>
                        <a class="collapse-item" href="tblArbol.jsp">Árbol</a>
                        <a class="collapse-item" href="tblFloracion.jsp">Floración</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Familia</h6>
                        <a class="collapse-item" href="tblFamilia.jsp">Familia</a>
                        <h6 class="collapse-header">Genero</h6>
                        <a class="collapse-item" href="tblGenero.jsp">Genero</a>
                        <h6 class="collapse-header">País</h6>
                        <a class="collapse-item" href="tblPais.jsp">Pais</a>
                        <h6 class="collapse-header">Región</h6>
                        <a class="collapse-item" href="tblRegion.jsp">Región</a>
                        <h6 class="collapse-header">Distribución</h6>
                        <a class="collapse-item" href="tblDistribucion.jsp">Distribución</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Gestión de Paises</h1>
                    <p class="mb-4">Desde esta pantalla del sistema usted podrá controlar la creación, actualización y el dar de baja a los paises.</p>
					
					<!-- MODAL NUEVA FLORACION -->
					<div class="modal fade" id="modalNewPais" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalCenterTitle">Registrar Nuevo Pais</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					         <form class="user" method="post" action="./Sl_GestionPais" >
								<!-- El valor de este input es para el Servlet opcion guardar -->
                            	<input name="opcion" type="hidden" value="1" />
                            	<div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-flor" name="txtNombre" id="txtNombre"
                                            placeholder="Nombre del Pais" required>
                                    </div>
<!--                                     <div class="col-sm-12">
                                        <input type="text" class="form-control form-control-flor" name="txtTemporada" id="txtTemporada"
                                            placeholder="Temporada de floracion" required>
                                    </div> -->
                                </div>
<!--                                 <div class="form-group row">
                                    <div class="col-sm-12 mb-3">
                                        <input type="text" class="form-control form-control-flor" name="txtDescripcion" id="txtDescripcion"
                                            placeholder="Descripcion de la floracion" required>
                                    </div>
                                </div> -->
	                            <hr>
	                            <div class="text-center">
	                                <input class="btn btn-primary btn-user btn-block" type="submit" value="Guardar" />
	                            </div>
	                            <div class="text-center">
	                                <input class="btn btn-google btn-user btn-block" type="reset" value="Cancelar" />
	                            </div>
                            </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
<!-- 					        <button type="button" class="btn btn-primary">Save changes</button> -->
					      </div>
					    </div>
					  </div>
					</div>
					<!-- FIN Modal -->
					
                    <!-- DataTables Pais -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Paises Registrados</h6>
                        </div>
                        <div class="card-body">
                        	<div align="right">
                        		<a href="newPais.jsp">
                        			<i class="fas fa-user-plus fa-2x" title="Registrar Nuevo Pais"></i>
                        		</a>
                        		&nbsp;&nbsp;
                        		<!-- Button trigger modal -->
                        		<a href="#" data-toggle="modal" data-target="#modalNewPais">
                        			<i class="fas fa-plus-square fa-2x" title="Registrar Nuevo Pais"></i>
                        		</a>
                        		<!-- FIN Button trigger modal -->
                        		&nbsp;&nbsp;
                        		<a href="#">
                        			<i class="fas fa-print fa-2x" title="Imprimir Lista de Paises Activos"></i>
                        		</a>
                        		
                        	</div>
                        	
                            <div class="table-responsive">
                                <table class="table table-bordered" id="tblPais" width="100%" cellspacing="0">
                                <%
                                	ArrayList<Pais> listPais = new ArrayList<Pais>();
                                	Dt_Pais dtp = new Dt_Pais();
                                	listPais = dtp.listaPaisActivos();
                                	
                                %>
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Estado</th>
                                            <th>Opciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Estado</th>
                                            <th>Opciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                   		<%
                                       		for(Pais pa: listPais){
                                       	%>
                                       <tr>
                                           <td><%=pa.getPaisID() %></td>
                                           <td><%=pa.getNombre() %></td>
                                           <td><%=pa.getEstado()==1||pa.getEstado()==2?"ACTIVO":"INACTIVO" %></td>
                                           <td>
                                           		<a id="btn-edita-abrir" href="editPais.jsp?paisID=<%=pa.getPaisID() %>">
                        							<i class="fas fa-edit" title="Modificar datos de la pais"></i>
                        						</a>
                                           		<a href="Sl_GestionPais?idP=<%=pa.getPaisID()%>">
                        							<i class="fas fa-trash-alt" title="Eliminar pais"></i>
                        						</a>
                                           		<a href="#">
                        							<i class="fas fa-eye" title="Visualizar pais"></i>
                        						</a><%-- 
                                           		<a href="fotoUser.jsp?idUsuario=<%=us.getIdUser()%>">
                        							<i class="fas fa-camera" title="Registrar Foto del Usuario"></i>
                        						</a> --%>
                                           
                                           </td>
                                       </tr>
                                       		<%
                                       		}
                                           %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
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

<!-- Page level plugins -->
<!-- <script src="vendor/datatables/jquery.dataTables.min.js"></script> -->
<!-- <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script> -->

<!-- Page level custom scripts -->
<!-- <script src="js/demo/datatables-demo.js"></script> -->

<!-- DATATABLE -->
<script src="DataTables/DataTables-1.10.21/js/jquery.dataTables.js"></script>

<!-- DATATABLE buttons -->
<script src="DataTables/Buttons-1.6.3/js/dataTables.buttons.min.js"></script>

<!-- js Datatable buttons print -->
<script src="DataTables/Buttons-1.6.3/js/buttons.html5.min.js"></script>
<script src="DataTables/Buttons-1.6.3/js/buttons.print.min.js"></script>

<!-- js Datatable buttons pdf -->
<script src="DataTables/pdfmake-0.1.36/pdfmake.min.js"></script>
<script src="DataTables/pdfmake-0.1.36/vfs_fonts.js"></script>

<!-- js Datatable buttons excel -->
<script src="DataTables/JSZip-2.5.0/jszip.min.js"></script>

<!-- jAlert js -->
<script src="jAlert/dist/jAlert.min.js"></script>
<script src="jAlert/dist/jAlert-functions.min.js"> //optional!!</script>

<script>
    $(document).ready(function ()
    {
        ////// APLICAMOS FORMATO Y BOTONES A LA TABLA //// INICIAMOS EL PLUGIN DATATABLE
        $('#tblPais').DataTable({
            dom: 'Bfrtip',
            buttons: [
//             'pdf',
            'excel',
            'print'
            ]

        });

		/////////// VARIABLE DE CONTROL MSJ ///////////
        var mensaje = "";
        mensaje = "<%=varMsj%>";

        if(mensaje == "1")
        {
            successAlert('Éxito', 'Los datos han sido registrados exitosamente!');
        }
        if(mensaje == "2")
        {
            errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
        }

    });
</script>


</body>
</html>