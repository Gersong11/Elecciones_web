<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista elecciones</title>
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
                <h1 class="text-3xl text-black pb-6">Lista</h1>

                <div class="w-full mt-6">
                    <p class="text-xl pb-3 flex items-center">
                        <i class="fas fa-list mr-3"></i> Elección
                    </p>
                    <div class="bg-white overflow-auto">
                        <table class="min-w-full bg-white">
                            <thead class="bg-gray-800 text-white">
                                <tr>
                                    <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Nombre</th>
                                    <th class="w-1/3 text-left py-3 px-4 uppercase font-semibold text-sm">Fecha inicio</th>
                                    <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Fecha fin</th>
                                    <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Cargo</th>
                                    <th class="text-left py-3 px-4 uppercase font-semibold text-sm">Acciones</th>
                                </tr>
                            </thead>
                            <tbody class="text-gray-700">
                            	<c:forEach var="c" items="${listaEleccion}">
                                <tr>
                                    <td class="w-1/3 text-left py-3 px-4"><c:out value="${c.nombre}" /></td>
                                    <td class="w-1/3 text-left py-3 px-4"><c:out value="${c.fechainicio}" /></td>
                                    <td class="text-left py-3 px-4"><c:out value="${c.fechafin}" /></td>
                                    <td class="text-left py-3 px-4"><c:out value="${c.cargo}" /></td>
                                    <td class="text-left py-3 px-4">
                                        <a href="ActualizarEleccionController?id=${c.id}"><i class="far fa-edit"></i></a>
                                        <a href="EliminarEleccionController?id=${c.id}"><i class="fas fa-trash"></i></a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
        </div>
        
    </div>

    <!-- AlpineJS -->
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <!-- Font Awesome -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" integrity="sha256-KzZiKy0DWYsnwMF+X1DvQngQ2/FxF7MF3Ff72XcpuPs=" crossorigin="anonymous"></script>
</body>
</html>