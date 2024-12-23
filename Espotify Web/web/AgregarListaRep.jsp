<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Lista de Reproducción - Estilo Spotify</title>
    <link rel="stylesheet" href="css/AgregarListaRep.css?v=1.2"> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        :root {
            --spotify-green: #1DB954;
            --spotify-black: #191414;
            --spotify-white: #FFFFFF;
            --spotify-grey: #535353;
        }

        body {
            background-color: var(--spotify-black);
            color: var(--spotify-white);
            font-family: 'Circular', Arial, sans-serif;
            
        }

        .spotify-card {
            background-color: #121212;
            border-radius: 8px;
            padding: 24px;
            box-shadow: 0 4px 60px rgba(0, 0, 0, 0.5);
        }

        .spotify-title {
            color: var(--spotify-white);
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 24px;
        }

        .spotify-input {
            background-color: #282828;
            border: none;
            border-radius: 4px;
            color: var(--spotify-white);
            padding: 10px 15px;
            margin-bottom: 16px;
        }

        .spotify-input:focus {
            outline: none;
            box-shadow: 0 0 0 2px var(--spotify-green);
        }

        .spotify-btn {
            background-color: var(--spotify-green);
            color: var(--spotify-black);
            border: none;
            border-radius: 30px;
            padding: 12px 24px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
        }

        .spotify-btn:hover {
            background-color: #1ed760;
            transform: scale(1.05);
        }

        .spotify-footer {
            color: var(--spotify-grey);
            font-size: 12px;
            margin-top: 24px;
        }

        .mensajeExito, .mensajeError {
              
                color: white; /* Color del texto */
                background-color: #000000; /* Fondo negro */
                padding: 10px; /* Espaciado interno */
                border-radius: 4px; /* Esquinas ligeramente curvas */
                text-align: center; /* Centrar texto */
                position: fixed; /* Fijar en la parte superior */
                top: 90px; /* Espacio desde la parte superior */
                left: 50%; /* Centrar horizontalmente */
                transform: translateX(-50%); /* Ajustar posición centrada */
                z-index: 1000; /* Asegurar que esté por encima de otros elementos */
                display: none; /* Oculto por defecto */
            }
            .mensajeError {
                background-color: #c53030; /* Fondo rojo para error */
            }
    </style>
</head>
<jsp:include page="header.jsp" />
<body class="d-flex align-items-center min-vh-100">

    <div class="container d-flex justify-content-center">
                    
        <div class="spotify-card">
<div id="mensajeExito" class="mensajeExito"></div>
            <div id="mensajeError" class="mensajeError"></div>
            <h1 class="spotify-title text-center">
                <i class="fas fa-music me-2"></i>Crear Nueva Lista
            </h1>
            
            <form id="playlistForm" onsubmit="handleFormSubmit(event)" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="nombreLista" class="form-label">
                        <i class="fas fa-list me-2"></i>Nombre de la Lista
                    </label>
                    <input type="text" class="form-control spotify-input" id="nombreLista" required>
                </div>
                
                <div class="mb-3">
                    <label for="imagenLista" class="form-label">
                        <i class="fas fa-image me-2"></i>Imagen (opcional)
                    </label>
                    <input type="file" class="form-control spotify-input" id="imagenLista" accept="image/*">
                </div>
                
                <button type="submit" class="btn spotify-btn w-100">
                    <i class="fas fa-plus-circle me-2"></i>Crear Lista
                </button>
            </form>
            <div class="spotify-footer text-center">
                <i class="fas fa-lock me-2"></i>La lista se creará como privada con la fecha actual del sistema.
            </div>
        </div>
    </div>

    <!-- Bootstrap JS y Font Awesome -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>
    
    <script>
        function handleFormSubmit(event) {
            event.preventDefault(); // Evita que el formulario se envíe de la forma tradicional

            // Capturar los valores del formulario
            const nombreLista = document.getElementById('nombreLista').value;
            const imagenLista = document.getElementById('imagenLista').files[0];

            // Crear un objeto FormData
            const formData = new FormData();
            formData.append('nombreLista', nombreLista);
            if (imagenLista) {
                formData.append('imagenLista', imagenLista);
            }

            // Enviar los datos al servlet
            fetch('SvAgregarListaRep', {
                method: 'POST',
                body: formData // Enviar el FormData
            }).then(response => {
                if (!response.ok) {
                    return response.json().then(error => {
                        throw new Error(error.message || 'Error al agregar la lista');
                    });
                }
                return response.json();
            })
            .then(data => {
                if (data.success) {
                    mostrarMensaje('mensajeExito', data.message); // Mostrar mensaje de éxito
                } else {
                    throw new Error(data.message);
                }
            })
            .catch(error => {
                mostrarMensaje('mensajeError', 'Error: ' + error.message); // Mostrar mensaje de error
            });
        }

        // Función para mostrar mensajes
        function mostrarMensaje(id, mensaje) {
            const contenedor = document.getElementById(id);
            contenedor.textContent = mensaje;
            contenedor.style.display = 'block'; // Mostrar el contenedor
            setTimeout(() => {
                contenedor.style.display = 'none'; // Ocultar después de 5 segundos
            }, 5000);
        }
    </script>
</body>
</html>
