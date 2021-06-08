<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Header</title>
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
<body>
	<aside class="relative bg-sidebar h-screen w-64 hidden sm:block shadow-xl">
        <div class="p-6">
            <a href="index.html" class="text-white text-3xl font-semibold uppercase hover:text-gray-300">Elecciones</a>
        </div>
        <nav class="text-white text-base font-semibold pt-3">
            <a href="RegistrarVotanteController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-user mr-3"></i>
                Registrar votante
            </a>
            <a href="ListaVotanteController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-book-open mr-3"></i>
                Lista votantes
            </a>
            <a href="RegistrarCandidatoController" class="flex items-center active-nav-link text-white py-4 pl-6 nav-item">
                <i class="fas fa-user-tie mr-3"></i>
                Registrar candidato
            </a>
            <a href="ListaCandidatoController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-book-open mr-3"></i>
                Lista candidatos
            </a>
            <a href="RegistrarEleccionController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-vote-yea mr-3"></i>
                Registrar elección
            </a>
            <a href="ListaEleccionController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-book-open mr-3"></i>
                Lista elecciones
            </a>
             <a href="RegistrarVotoController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-vote-yea mr-3"></i>
                Registrar voto
            </a>
            <a href="ListaVotoController" class="flex items-center text-white opacity-75 hover:opacity-100 py-4 pl-6 nav-item">
                <i class="fas fa-book-open mr-3"></i>
                Lista votos
            </a>
        </nav>
        <a href=RegistrarTipodocumentoController class="absolute w-full upgrade-btn bottom-0 active-nav-link text-white flex items-center justify-center py-4">
            Registrar Tipo documento
        </a>
    </aside>

    <div class="relative w-full flex flex-col h-screen overflow-y-hidden">
        <header class="w-full items-center bg-white py-2 px-6 hidden sm:flex">
            <div class="w-1/2"></div>
            <div x-data="{ isOpen: false }" class="relative w-1/2 flex justify-end">
                <button @click="isOpen = !isOpen" class="realtive z-10 w-12 h-12 rounded-full overflow-hidden border-4 border-gray-400 hover:border-gray-300 focus:border-gray-300 focus:outline-none">
                    <img src="https://source.unsplash.com/uJ8LNVCBjFQ/400x400">
                </button>
                <button x-show="isOpen" @click="isOpen = false" class="h-full w-full fixed inset-0 cursor-default"></button>
                <div x-show="isOpen" style="display: none" class="absolute w-32 bg-white rounded-lg shadow-lg py-2 mt-16">
                    <a href="#" class="block px-4 py-2 account-link hover:text-white">Account</a>
                    <a href="#" class="block px-4 py-2 account-link hover:text-white">Support</a>
                    <a href="#" class="block px-4 py-2 account-link hover:text-white">Sign Out</a>
                </div>
            </div>
        </header>

        <header x-data="{ isOpen: false }" class="w-full bg-sidebar py-5 px-6 sm:hidden">
            <div class="flex items-center justify-between">
                <a href="index.html" class="text-white text-3xl font-semibold uppercase hover:text-gray-300">Elecciones</a>
                <button @click="isOpen = !isOpen" class="text-white text-3xl focus:outline-none">
                    <i x-show="!isOpen" class="fas fa-bars"></i>
                    <i x-show="isOpen" class="fas fa-times"></i>
                </button>
            </div>

            <nav :class="isOpen ? 'flex': 'hidden'" class="flex flex-col pt-4">
                <a href="RegistrarVotanteController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    <i class="fas fa-user mr-3"></i>
                    Registrar votante
                </a>
                <a href="ListaVotanteController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    <i class="fas fa-book-open mr-3"></i>
                    Lista votantes
                </a>
                <a href="RegistrarCandidatoController" class="flex items-center active-nav-link text-white py-2 pl-4 nav-item">
                    <i class="fas fa-user-tie mr-3"></i>
                    Registrar candidato
                </a>
                <a href="ListaCandidatoController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    <i class="fas fa-book-open mr-3"></i>
                    Lista candidatos
                </a>
                <a href="RegistrarEleccionController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    <i class="fas fa-vote-yea mr-3"></i>
                    Registrar elección
                </a>
                <a href="ListaEleccionController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    <i class="fas fa-book-open mr-3"></i>
                    Lista elecciones
                </a>
                <a href="RegistrarTipodocumentoController" class="flex items-center text-white opacity-75 hover:opacity-100 py-2 pl-4 nav-item">
                    Registrar Tipo documento
                </a>
            </nav>
        </header>
</body>
</html>