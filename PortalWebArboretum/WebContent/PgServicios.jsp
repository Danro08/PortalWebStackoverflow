<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "no-store" );
	response.setDateHeader( "Expires", 0 );
	response.setDateHeader( "Expires", -1 );
%>

<!DOCTYPE html>
<%
	//Variable de control de mensajes
	String varMsj = request.getParameter("msj")==null?"":request.getParameter("msj");


%>

<html lang="en">
    <head>
		<meta charset="ISO-8859-1">
  		  <meta http-equiv="X-UA-Compatible" content="IE=edge">
   		 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	 <meta name="description" content="">
    	<meta name="author" content="">

        <title>Arboreto Carmelo Palma</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/uca.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="index2.jsp"><img src="assets/img/UCA.svg" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="PgServicios.jsp">Servicios</a></li>
                        <li class="nav-item"><a class="nav-link" href="#portfolio">Portfolio</a></li>
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">¡Bienvenido Los servicios del PWACP!</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="newFormularioServicio">Solicitar Servicio</a>
            </div>
        </header>

        <!-- About-->
        <section class="page-section" id="about">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Servicios que ofrecemos actualmente</h2>
                    
                </div>
                 <!-- Portfolio Grid-->
        <section class="page-section bg-#111a33" id="portfolio">
            <div class="container">

                </div>
                <div class="row">
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <!-- Portfolio item 1-->
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal1">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="https://i.imgur.com/a3kUkJD.jpg" alt="..." />
                            </a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">AQUI VAN LOS SERVICIOS</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <!-- Portfolio item 2-->
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal2">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="https://i.imgur.com/flWkDKn.jpg" alt="..." />
                            </a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">AQUI VAN LOS SERVICIOS</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <!-- Portfolio item 3-->
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal3">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="https://i.imgur.com/KCuU36m.jpg" alt="..." />
                            </a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">AQUI VAN LOS SERVICIOS</div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </section>
               
        <!-- Footer-->
        <footer class="footer py-3">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12 text-lg-start">
                        Arboreto Carmelo Palma &copy; 
                        <!-- This script automatically adds the current year to your website footer-->
                        <!-- (credit: https://updateyourfooter.com/)-->
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                    </div>
                   <div class="timeline-image"><img src="https://i.imgur.com/le3c8vs.jpg" alt="..." /> </div>
                   <div class="col-lg-12 text-lg-end">
                    <a class="link-dark text-decoration-none me-3" >Privacy Policy</a>

                </div>
                </div>
            </div>
        </footer>
        
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<!-- jAlert js -->
<script src="jAlert/dist/jAlert.min.js"></script>
<script src="jAlert/dist/jAlert-functions.min.js"> //optional!!</script>

<script>
/////////// VARIABLE DE CONTROL MSJ ///////////
		var mensaje = "";
		mensaje = "<%=varMsj%>";
		
		if(mensaje == "1")
		{
		    successAlert('Éxito', 'La solicitud ha sido enviada y guardada Exitosamente!!');
		}
		if(mensaje == "2")
		{
		    errorAlert('Error', 'Revise los datos e intente nuevamente o contacte con el administrador del sistema!!!');
		}
		if(mensaje == "3")
		{
		    successAlert('Éxito', 'El servicio se ha ingresado correctamente!!');
		}
		if(mensaje == "4")
		{
		    errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
		}
		if(mensaje == "5")
		{
		    successAlert('Éxito', 'Se ha eliminado Exitosamente!!');
		}
		if(mensaje == "6")
		{
		    errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
		}
		
		});
</script>
    </body>
</html>