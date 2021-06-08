<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Tipo documento</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://unpkg.com/tailwindcss/dist/tailwind.min.css" rel="stylesheet">
	<style>
	    @import url('https://fonts.googleapis.com/css?family=Karla:400,700&display=swap');
	    .font-family-karla { font-family: karla; }
	    .bg-sidebar { background: red; }
	    .cta-btn { color: red; }
	    .upgrade-btn { background: red; }
	    .upgrade-btn:hover { background: rgb(146, 1, 1); }
	    .active-nav-link { background: rgb(226, 2, 2); }
	    .nav-item:hover { background: rgb(200, 3, 3);; }
	    .account-link:hover { background: rgb(226, 2, 2);; }
	</style>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>
<body class="bg-gray-100 font-family-karla flex">
<jsp:include page="header.jsp"/>
    
        <div class="w-full h-screen overflow-x-hidden border-t flex flex-col">
            <main class="w-full flex-grow p-6">
                <h1 class="w-full text-3xl text-black pb-6 text-center">
                	Registrar Tipo documento
                </h1>

                <div class="flex flex-wrap">
                    <div class="w-full lg:w-1/2 my-6 pr-0 lg:pr-2 mx-auto">
                        <p class="text-xl pb-6 justify-center flex items-center">
                            <i class="fas fa-list mr-3 "></i>Formulario
                        </p>
                        <div class="leading-loose">
                            <form class="p-10 bg-white rounded shadow-xl"  action="RegistrarTipodocumentoController" method="post">
                                <div class="">
                                    <label class="block text-sm text-gray-600" for="name">Descripcion</label>
                                    <input class="w-full px-5 py-1 text-gray-700 bg-gray-200 rounded" id="descripcion" name="descripcion" type="text" required="" placeholder="C�dula de Ciudadan�a" aria-label="Name">
                                </div>
                                <div class="mt-6">
                                    <button class="px-4 py-1 text-white font-light tracking-wider bg-gray-900 rounded" type="submit">
                                    	Registrar
                               		</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
    
            <footer class="w-full bg-white p-4 text-center">
                2021 � All Rights Reserved. Desarrollado por <b> Santiago Caballero & Gerson Fernando</b>.
            </footer>
        </div>
        
    </div>

    <!-- AlpineJS -->
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <!-- Font Awesome -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
</body>
</html>