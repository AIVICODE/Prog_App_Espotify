<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión - Espotify</title>
    <link rel="stylesheet" href="css/login.css"> <!-- Asegúrate de que la ruta sea correcta -->
</head>
<body>
    <nav class="navbar">
        <div class="container">
            <a href="index.jsp" class="logo">
                <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 496 512">
                    <path fill="currentColor" d="M248 8C111.1 8 0 119.1 0 256s111.1 248 248 248 248-111.1 248-248S384.9 8 248 8zm100.7 364.9c-4.2 0-6.8-1.3-10.7-3.6-62.4-37.6-135-39.2-206.7-24.5-3.9 1-9 2.6-11.9 2.6-9.7 0-15.8-7.7-15.8-15.8 0-10.3 6.1-15.2 13.6-16.8 81.9-18.1 165.6-16.5 237 26.2 6.1 3.9 9.7 7.4 9.7 16.5s-7.1 15.4-15.2 15.4zm26.9-65.6c-5.2 0-8.7-2.3-12.3-4.2-62.5-37-155.7-51.9-238.6-29.4-4.8 1.3-7.4 2.6-11.9 2.6-10.7 0-19.4-8.7-19.4-19.4s5.2-17.8 15.5-20.7c27.8-7.8 56.2-13.6 97.8-13.6 64.9 0 127.6 16.1 177 45.5 8.1 4.8 11.3 11 11.3 19.7-.1 10.8-8.5 19.5-19.4 19.5zm31-76.2c-5.2 0-8.4-1.3-12.9-3.9-71.2-42.5-198.5-52.7-280.9-29.7-3.6 1-8.1 2.6-12.9 2.6-13.2 0-23.3-10.3-23.3-23.6 0-13.6 8.4-21.3 17.4-23.9 35.2-10.3 74.6-15.2 117.5-15.2 73 0 149.5 15.2 205.4 47.8 7.8 4.5 12.9 10.7 12.9 22.6 0 13.6-11 23.3-23.2 23.3z"/>
                </svg>
                Espotify
            </a>
        </div>
    </nav>

    <main>
        <div class="login-form">
            <h2>Iniciar sesión</h2>
            <!-- El formulario debe enviar los datos al servlet -->
            <form id="loginForm" action="SvIniciarSesion" method="POST">
                <div class="form-group">
                    <label for="usuario">Correo electrónico o Nickname</label>
                    <!-- Cambié type="usuario" por type="text" -->
                    <input type="text" id="usuario" name="usuario" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="submit-btn">Iniciar sesión</button>
                                <div class="form-check">
                    <input type="checkbox" id="remember" name="remember" class="form-check-input">
                    <label class="form-check-label" for="remember">Recordar credenciales</label>
                </div>
            </form>
            <!-- Mensaje de error en caso de que se presente -->
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
                <p style="color: red;"><%= errorMessage %></p>
            <% 
                } 
            %>
            <a href="index.jsp" class="back-link">Volver a la página de inicio</a>
        </div>
    </main>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Carga las credenciales si están guardadas
        const savedUser = localStorage.getItem("savedUser");
        const savedPassword = localStorage.getItem("savedPassword");

        if (savedUser) {
            document.getElementById("usuario").value = savedUser;
            document.getElementById("remember").checked = true;
        }

        if (savedPassword) {
            document.getElementById("password").value = savedPassword;
        }

        // Guarda las credenciales cuando se envía el formulario
        document.getElementById("loginForm").addEventListener("submit", function () {
            const rememberMe = document.getElementById("remember").checked;
            const user = document.getElementById("usuario").value;
            const password = document.getElementById("password").value;

            if (rememberMe) {
                localStorage.setItem("savedUser", user);
                localStorage.setItem("savedPassword", password); // No recomendado guardar contraseñas en localStorage
            } else {
                localStorage.removeItem("savedUser");
                localStorage.removeItem("savedPassword");
            }
        });
    });
</script>

</html>

