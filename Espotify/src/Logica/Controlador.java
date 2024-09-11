package Logica;

import Datatypes.DTAlbum;
import Datatypes.DTArtista;
import Datatypes.DTTema;
import Datatypes.DTUsuario;
import Persis.ControladoraPersistencia;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.tree.TreeModel;

public class Controlador {

    ControladoraPersistencia controlpersis = new ControladoraPersistencia();

    public void crearUsuario(DTUsuario user) throws Exception {

        if (user instanceof DTArtista) {
            Artista nuevoUsuario;
            DTArtista artista = (DTArtista) user;
            nuevoUsuario = new Artista(
                    artista.getNickname(),
                    artista.getNombre(),
                    artista.getApellido(),
                    artista.getContrasenia(),
                    artista.getFechaNac(),
                    artista.getCorreo(),
                    artista.getBiografia(),
                    artista.getSitioWeb()
            );
            controlpersis.AddArtista((Artista) nuevoUsuario);
        } else {
            Cliente nuevoUsuario;
            nuevoUsuario = new Cliente(
                    user.getNickname(),
                    user.getNombre(),
                    user.getApellido(),
                    user.getContrasenia(),
                    user.getCorreo(),
                    user.getFechaNac()
            );
            controlpersis.AddCliente((Cliente) nuevoUsuario);
        }
    }

    public boolean verificarExistenciaArtista(String correo) throws Exception {

        return controlpersis.findArtista(correo);
    }

    public void CrearGenero(String nombre, String nombrePadre) throws Exception {
        // Buscar el género padre en la base de datos
        Genero padre = null;
        if (nombrePadre != null && !nombrePadre.isEmpty()) {
            padre = controlpersis.findGenerobynombre(nombrePadre);
            if (padre == null) {
                throw new Exception("El género padre no existe: " + nombrePadre);
            }
        }

        // Crear el nuevo género
        Genero nuevoGenero = new Genero(nombre, padre);

        // Añadir el nuevo género a la base de datos
        controlpersis.AddGenero(nuevoGenero);
    }

    public TreeModel buildGeneroTree() {
        return controlpersis.buildGeneroTree();
    }

    public void CrearAlbum(String correoArtista, DTAlbum nuevoAlbum, List<DTTema> listaTemas) throws Exception {

        try {
            Artista artista = buscarArtistaPorCorreo(correoArtista);
            if (artista == null) {
                throw new Exception("Artista no encontrado con el correo proporcionado.");
            }
            boolean albumExiste = false;
            for (Album album : artista.getAlbumes()) {
                if (album.getNombre().equals(nuevoAlbum.getNombre())) {
                    albumExiste = true;
                    break;
                }
            }

            if (albumExiste) {
                throw new Exception("El nombre del álbum seleccionado ya existe para este artista");
            }
            // Convertir DTAlbum a Album
            Album album = new Album();
            album.setNombre(nuevoAlbum.getNombre());
            album.setAnioCreacion(nuevoAlbum.getAnioCreacion());
            album.setImagen(nuevoAlbum.getImagen());
            album.setArtista(artista); // Asociar el álbum con el artista

            List<Genero> generos = new ArrayList<>();  // Lista para almacenar los géneros encontrados

            for (String nombreGenero : nuevoAlbum.getListaGeneros()) {
                try {
                    Genero genero = buscarGeneroPorNombre(nombreGenero);
                    generos.add(genero);  // Agrega el género a la lista si se encuentra correctamente
                } catch (Exception e) {

                    throw new Exception(e.getMessage());
                }
            }

            album.setListaGeneros(generos);  // Asigna la lista de géneros al álbum

            // Persistir el álbum primero
            controlpersis.crearAlbum(album);

            // Contador para el orden de los temas
            final int[] maxOrden = {0};

           // Verificación de nombres de temas duplicados dentro del álbum
        Set<String> nombresTemasUnicos = new HashSet<>();
        
        // Ahora convertir y asociar los temas al álbum
        List<Tema> temas = listaTemas.stream().map(dtTema -> {
            if (!nombresTemasUnicos.add(dtTema.getNombre())) {
                // Si el nombre ya existe, lanza una excepción
                throw new RuntimeException("Insertaste temas  con nombre duplicados para este album.");
            }
            
            Tema tema = new Tema();
            tema.setNombre(dtTema.getNombre());
            tema.setDuracion(Duration.ofMinutes(dtTema.getMinutos()).plusSeconds(dtTema.getSegundos()));
            tema.setDireccion(dtTema.getDirectorio());
            tema.setAlbum(album); // Establecer la relación con el álbum
            tema.setOrden(++maxOrden[0]); // Asignar el orden e incrementar maxOrden
            return tema;
        }).collect(Collectors.toList());


            // Persistir los temas
            for (Tema tema : temas) {
                controlpersis.crearTema(tema);
            }

            // Actualizar el álbum con la lista de temas
            album.setListaTemas(temas);

            // Persistir el álbum con los temas asociados (si es necesario)
            controlpersis.actualizarAlbum(album);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Artista buscarArtistaPorCorreo(String correo) throws Exception {
        // Implementa la lógica para buscar al artista por correo en tu base de datos.
        // Aquí se muestra un ejemplo, pero deberías usar tu controlador de persistencia.
        return controlpersis.findArtistaByCorreo(correo);
    }

    @SuppressWarnings("empty-statement")
    private Genero buscarGeneroPorNombre(String nombreGenero) throws Exception {
        try {
            Genero genero = controlpersis.findGenerobynombre(nombreGenero);
            if (genero == null) {
                throw new Exception();
            }
            return genero;
        } catch (Exception e) {
            throw new Exception("No se encontró el género con nombre: " + nombreGenero, e);
        }
    }

    public void CrearListaRepGeneral(String nombreLista, String imagen) {
// Encuentra al cliente por su correo
        try {
            // Crear una nueva instancia de ListaRep
            ListaRep nuevaLista = new ListaRepGeneral();
            nuevaLista.setNombre(nombreLista);  // Asigna el nombre de la lista
            nuevaLista.setImagen(imagen);  // Asigna la imagen a la lista (si la propiedad existe)

            // Guardar la nueva lista en la base de datos
            controlpersis.createListaRep(nuevaLista);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void CrearListaRepParticular(String nombreLista, String correoCliente, String imagen, boolean privada) throws Exception {
        // Encuentra al cliente por su correo
        try {
            Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);

            if (cliente != null) {
                // Crear una nueva instancia de ListaRep
                ListaRepParticular nuevaLista = new ListaRepParticular();
                nuevaLista.setNombre(nombreLista);  // Asigna el nombre de la lista
                nuevaLista.setPrivada(privada);  // Configura si la lista es privada o no
                nuevaLista.setImagen(imagen);  // Asigna la imagen a la lista (si la propiedad existe)

                // Añadir la lista de reproducción a la lista del cliente
                cliente.getListaReproduccion().add(nuevaLista);

                // Guardar la nueva lista en la base de datos
                controlpersis.createListaRep(nuevaLista);

                // Actualizar el cliente en la base de datos si es necesario
                controlpersis.editCliente(cliente);
            } else {
                System.out.println("Cliente no encontrado con el correo proporcionado.");
                // O lanzar una excepción personalizada si prefieres
                throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void GuardarTemaFavorito(String correoCliente, String correoArtista, String nombreAlbum, String nombreTema) throws Exception {
        try {
            // Buscar el cliente por correo
            Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
            if (cliente == null) {
                throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
            }

            // Buscar el artista por correo
            Artista artista = controlpersis.findArtistaByCorreo(correoArtista);
            if (artista == null) {
                throw new Exception("Artista no encontrado con el correo: " + correoArtista);
            }

            // Buscar el álbum por nombre dentro del artista
            Album albumEncontrado = null;
            for (Album album : artista.getAlbumes()) {
                if (album.getNombre().equals(nombreAlbum)) {
                    albumEncontrado = album;
                    break;
                }
            }
            
            if (albumEncontrado == null) {
                throw new Exception("Álbum no encontrado con el nombre: " + nombreAlbum + " para el artista: " + correoArtista);
            }
            
            

            // Buscar el tema por nombre dentro del álbum
            Tema temaEncontrado = null;
            for (Tema tema : albumEncontrado.getListaTemas()) {
                if (tema.getNombre().equals(nombreTema)) {
                    temaEncontrado = tema;
                    break;
                }
            }

            if (temaEncontrado == null) {
                throw new Exception("Tema no encontrado con el nombre: " + nombreTema + " en el álbum: " + nombreAlbum);
            }
            
            if (cliente.getTemas().contains(temaEncontrado)) {
            throw new Exception("El tema ya está marcado como favorito.");
        }
            // Agregar el tema al cliente
            cliente.getTemas().add(temaEncontrado);

            // Guardar los cambios en la base de datos
            controlpersis.editCliente(cliente);

        } catch (Exception e) {
            // Lanza la excepción para que sea gestionada en un nivel superior
            throw new Exception(e.getMessage());
        }
    }

    public void GuardarAlbumFavorito(String correoCliente, String correoArtista, String nombreAlbum) throws Exception {
        try {
            // Buscar el cliente por correo
            Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
            if (cliente == null) {
                throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
            }

            // Buscar el artista por correo
            Artista artista = controlpersis.findArtistaByCorreo(correoArtista);
            if (artista == null) {
                throw new Exception("Artista no encontrado con el correo: " + correoArtista);
            }

            // Buscar el álbum por nombre dentro del artista
            Album albumEncontrado = null;
            for (Album album : artista.getAlbumes()) {
                if (album.getNombre().equals(nombreAlbum)) {
                    albumEncontrado = album;
                    break;
                }
            }
            
            if (cliente.getAlbums().contains(albumEncontrado)) {
            throw new Exception("El álbum ya está marcado como favorito.");
        }

            if (albumEncontrado == null) {
                throw new Exception("Álbum no encontrado con el nombre: " + nombreAlbum + " para el artista: " + correoArtista);
            }
            
            // Agregar el álbum al cliente
            cliente.getAlbums().add(albumEncontrado);

            // Guardar los cambios en la base de datos
            controlpersis.editCliente(cliente);

        } catch (Exception e) {
            // Lanza la excepción para que sea gestionada en un nivel superior
            throw new Exception(e.getMessage());
        }
    }

    public void GuardarListaFavorito(String correoCliente, String correo_Cliente_Con_Lista, String nombreLista) throws Exception {
        try {
            // Buscar el cliente que quiere guardar la lista como favorita
            Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
            if (cliente == null) {
                throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
            }

            // Buscar el cliente que posee la lista
            Cliente clienteConLista = controlpersis.findClienteByCorreo(correo_Cliente_Con_Lista);
            if (clienteConLista == null) {
                throw new Exception("Cliente no encontrado con el correo: " + correo_Cliente_Con_Lista);
            }

            // Buscar la lista por nombre dentro del cliente que posee la lista
            ListaRepParticular listaEncontrada = null;
            for (ListaRep lista : clienteConLista.getListaReproduccion()) {
                // Verificar si la lista es una instancia de ListaRepParticular
                if (lista instanceof ListaRepParticular) {
                    ListaRepParticular listaParticular = (ListaRepParticular) lista;
                      
                    // Comparar el nombre de la lista
                    if (listaParticular.getNombre().equals(nombreLista)) {
                        listaEncontrada = listaParticular;
                        break;
                    }
                }
            }
             
            if (listaEncontrada == null) {
                throw new Exception("Lista no encontrada con el nombre: " + nombreLista + " para el cliente: " + correo_Cliente_Con_Lista);
            }
            if(listaEncontrada.isPrivada()==true){
                       
                       throw new Exception("Intentas acceder  a una lista privada");
                }

            // Agregar la lista al cliente que la quiere guardar como favorita
            cliente.getListaRepFavoritos().add(listaEncontrada);

            // Guardar los cambios en la base de datos
            controlpersis.editCliente(cliente);

        } catch (Exception e) {
            // Lanza la excepción para que sea gestionada en un nivel superior
            throw new Exception(e.getMessage());
        }
    }

       public void GuardarLista_Por_Defecto_Favorito(String correoCliente, String nombreLista) throws Exception {
    try {
        // Buscar el cliente que quiere guardar la lista por defecto como favorita
        Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
        }

        // Buscar la lista por defecto (ListaRepGeneral) por nombre directamente desde la base de datos
        ListaRepGeneral listaPorDefecto = controlpersis.findListaRep_Por_Defecto_ByNombre(nombreLista);
        if (listaPorDefecto == null) {
            throw new Exception("Lista por defecto no encontrada con el nombre: " + nombreLista);
        }

        // Verificar si la lista ya está marcada como favorita por el cliente
        if (cliente.getListaRepFavoritos().contains(listaPorDefecto)) {
            throw new Exception("La lista ya está marcada como favorita.");
        }

        // Agregar la lista por defecto al cliente como favorita
        cliente.getListaRepFavoritos().add(listaPorDefecto);

        // Guardar los cambios en la base de datos
        controlpersis.editCliente(cliente);

    } catch (Exception e) {
        // Lanza la excepción para que sea gestionada en un nivel superior
        throw new Exception(e.getMessage());
    }
}

       
     public void EliminarAlbumFavorito(String correoCliente, String correoArtista, String nombreAlbum) throws Exception{
        try {
        // Buscar el cliente por correo
        Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
        }

        // Buscar el artista por correo
        Artista artista = controlpersis.findArtistaByCorreo(correoArtista);
        if (artista == null) {
            throw new Exception("Artista no encontrado con el correo: " + correoArtista);
        }

        // Buscar el álbum por nombre dentro del artista
        Album albumEncontrado = null;
        for (Album album : artista.getAlbumes()) {
            if (album.getNombre().equals(nombreAlbum)) {
                albumEncontrado = album;
                break;
            }
        }

        if (albumEncontrado == null) {
            throw new Exception("Álbum no encontrado con el nombre: " + nombreAlbum + " para el artista: " + correoArtista);
        }

        // Verificar si el álbum está en los favoritos del cliente
        if (!cliente.getAlbums().contains(albumEncontrado)) {
            throw new Exception("El álbum no está marcado como favorito.");
        }

        // Eliminar el álbum de los favoritos del cliente
        cliente.getAlbums().remove(albumEncontrado);

        // Guardar los cambios en la base de datos
        controlpersis.editCliente(cliente);

    } catch (Exception e) {
        // Lanza la excepción para que sea gestionada en un nivel superior
        throw new Exception(e.getMessage());
    }
    }
    
    
    
     public void EliminarTemaFavorito(String correoCliente, String correoArtista, String nombreAlbum, String nombreTema) throws Exception {
           try {
        // Buscar el cliente por correo
        Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
        }

        // Buscar el artista por correo
        Artista artista = controlpersis.findArtistaByCorreo(correoArtista);
        if (artista == null) {
            throw new Exception("Artista no encontrado con el correo: " + correoArtista);
        }

        // Buscar el álbum por nombre dentro del artista
        Album albumEncontrado = null;
        for (Album album : artista.getAlbumes()) {
            if (album.getNombre().equals(nombreAlbum)) {
                albumEncontrado = album;
                break;
            }
        }

        if (albumEncontrado == null) {
            throw new Exception("Álbum no encontrado con el nombre: " + nombreAlbum + " para el artista: " + correoArtista);
        }

        // Buscar el tema por nombre dentro del álbum
        Tema temaEncontrado = null;
        for (Tema tema : albumEncontrado.getListaTemas()) {
            if (tema.getNombre().equals(nombreTema)) {
                temaEncontrado = tema;
                break;
            }
        }

        if (temaEncontrado == null) {
            throw new Exception("Tema no encontrado con el nombre: " + nombreTema + " en el álbum: " + nombreAlbum);
        }

        // Verificar si el tema está en los favoritos del cliente
        if (!cliente.getTemas().contains(temaEncontrado)) {
            throw new Exception("El tema no está marcado como favorito.");
        }

        // Eliminar el tema de los favoritos del cliente
        cliente.getTemas().remove(temaEncontrado);

        // Guardar los cambios en la base de datos
        controlpersis.editCliente(cliente);

    } catch (Exception e) {
        // Lanza la excepción para que sea gestionada en un nivel superior
        throw new Exception(e.getMessage());
    }
    }
     
       public void EliminarListaFavorito(String correoCliente, String correo_Cliente_Con_Lista, String nombreLista) throws Exception {
            try {
        // Buscar el cliente que tiene la lista marcada como favorita
        Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
        }

        // Buscar el cliente que posee la lista original
        Cliente clienteConLista = controlpersis.findClienteByCorreo(correo_Cliente_Con_Lista);
        if (clienteConLista == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correo_Cliente_Con_Lista);
        }

        // Buscar la lista por nombre dentro del cliente que posee la lista
        ListaRepParticular listaEncontrada = null;
        for (ListaRep lista : clienteConLista.getListaReproduccion()) {
            if (lista instanceof ListaRepParticular) {
                ListaRepParticular listaParticular = (ListaRepParticular) lista;
                if (listaParticular.getNombre().equals(nombreLista)) {
                    listaEncontrada = listaParticular;
                    break;
                }
            }
        }

        if (listaEncontrada == null) {
            throw new Exception("Lista no encontrada con el nombre: " + nombreLista + " para el cliente: " + correo_Cliente_Con_Lista);
        }

        // Verificar si la lista está en los favoritos del cliente
        if (!cliente.getListaRepFavoritos().contains(listaEncontrada)) {
            throw new Exception("La lista no está marcada como favorita.");
        }

        // Eliminar la lista de los favoritos del cliente
        cliente.getListaRepFavoritos().remove(listaEncontrada);

        // Guardar los cambios en la base de datos
        controlpersis.editCliente(cliente);

    } catch (Exception e) {
        // Lanza la excepción para que sea gestionada en un nivel superior
        throw new Exception(e.getMessage());
    }
    }
    
public void EliminarLista_Por_Defecto_Favorito(String correoCliente, String nombreLista) throws Exception {
    try {
        // Buscar el cliente que quiere eliminar la lista por defecto de sus favoritos
        Cliente cliente = controlpersis.findClienteByCorreo(correoCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con el correo: " + correoCliente);
        }

        // Buscar la lista por defecto (ListaRepGeneral) por nombre directamente desde la base de datos
        ListaRepGeneral listaPorDefecto = controlpersis.findListaRep_Por_Defecto_ByNombre(nombreLista);
        if (listaPorDefecto == null) {
            throw new Exception("Lista por defecto no encontrada con el nombre: " + nombreLista);
        }

        // Verificar si la lista está marcada como favorita por el cliente
        if (!cliente.getListaRepFavoritos().contains(listaPorDefecto)) {
            throw new Exception("La lista no está marcada como favorita.");
        }

        // Eliminar la lista por defecto de los favoritos del cliente
        cliente.getListaRepFavoritos().remove(listaPorDefecto);

        // Guardar los cambios en la base de datos
        controlpersis.editCliente(cliente);

    } catch (Exception e) {
        // Lanza la excepción para que sea gestionada en un nivel superior
        throw new Exception(e.getMessage());
    }
}

    public List<String> MostrarNombreClientes() {
        List<Cliente> listaClientes = listaClientes(); // Supongamos que este método devuelve todos los clientes
        List<String> listaCorreos = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            listaCorreos.add(cliente.getMail()); // Añades el correo de cada cliente a la lista
        }

        return listaCorreos; // Devuelves la lista de correos
    }

    public List<Cliente> listaClientes() {
        return controlpersis.listaClientes();//retorno la lista de personas de la BD
    }

    public Cliente encontrarCliente(String mail) {
        return controlpersis.encontrarCliente(mail);//la persis me manda el cliente encontrado
    }

    public List<Artista> listaArtistas() {
        return controlpersis.listaArtistas();//retorno la lista de personas de la BD
    }

    public Artista encontrarArtista(String mail) {
        return controlpersis.encontrarArtista(mail);//la persis me manda el cliente encontrado
    }

    
    
    public void seguirUsuario (String correoSeguidor, String correoSeguido) throws Exception{
        Cliente seguidor = encontrarCliente(correoSeguidor);
        Cliente cSeguido = encontrarCliente(correoSeguido);
        Artista aSeguido = encontrarArtista(correoSeguido);
        if(seguidor != null){
            if(cSeguido != null){
                seguidor.seguirCliente(cSeguido);
                controlpersis.editCliente(seguidor);
            }else if (aSeguido != null){
                seguidor.seguirArtista(aSeguido);
                controlpersis.editCliente(seguidor);
            }else{
                throw new IllegalArgumentException("No se encontró Cliente o Artista con el correo: " + correoSeguido);
            }
        }else{
            throw new IllegalArgumentException("No se encontró el seguidor con el correo: " + correoSeguidor);
        }
    }
    public void dejarSeguirUsuario (String correoSeguidor, String correoSeguido) throws Exception{
        try{
        Cliente seguidor = encontrarCliente(correoSeguidor);
        Cliente cSeguido = encontrarCliente(correoSeguido);
        Artista aSeguido = encontrarArtista(correoSeguido);
        if(seguidor != null){
            if(cSeguido != null){
                seguidor.dejarDeSeguirCliente(cSeguido);
                controlpersis.editCliente(seguidor);
            }else if (aSeguido != null){
                seguidor.dejarDeSeguirArtista(aSeguido);
                controlpersis.editCliente(seguidor);
            }else{
                throw new IllegalArgumentException("No se encontró Cliente o Artista con el correo: " + correoSeguido);
            }
        }else{
            throw new IllegalArgumentException("No se encontró el seguidor con el correo: " + correoSeguidor);
        }
        }
        catch(Exception e){
            throw new IllegalArgumentException("Error ");
        }
    }
    
    
    
    
    public void Cargar_Datos_Prueba() throws Exception {
        //Cargar_Perfiles();
         //Cargar_Generos();
         //Cargar_Albumes();
        //CrearListaRepParticular("Musica2", "cli2", "txt.png", false);
//       CrearListaRepParticular("Musica para Correr", "cli1", "xd.png", false);
//       CrearListaRepParticular("Musica para mi cumple", "cli1", "cumpleanos.png", false);
//       CrearListaRepParticular("Musica", "cli1", "mejor musica para bailar.png", false);

//CrearListaRepGeneral("Musica lista rep", "gatitobailando.png");
//      
//       GuardarListaFavorito("cli1", "Musica");

    }

    private void Cargar_Perfiles() {
        try {
            // Artistas
            Artista artista1 = new Artista(
                    "vpeople", "Village", "People", "pass123",
                    new Date(), "vpeople@tuta.io",
                    "Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.",
                    "www.officialvillagepeople.com",
                    "bit.ly/vpeople"
            );
            Artista artista2 = new Artista(
                    "dmode", "Depeche", "Mode", "pass456",
                    new Date(1980, 6, 14), "dmode@tuta.io",
                    "",
                    "www.depechemode.com",
                    "bit.ly/depecheMode"
            );
            Artista artista3 = new Artista(
                    "clauper", "Cyndi", "Lauper", "pass789",
                    new Date(1953, 6, 22), "clauper@hotmail.com",
                    "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical Blue Angel, en 1983 firmó con Portrait Records y lanzó su exitoso álbum debut *She's So Unusual* a finales de ese mismo año.",
                    "cyndilauper.com",
                    "bit.ly/cLauper"
            );
            Artista artista4 = new Artista(
                    "bruceTheBoss", "Bruce", "Springsteen", "pass101",
                    new Date(1949, 9, 23), "bruceTheBoss@gmail.com",
                    "",
                    "brucespringsteen.net",
                    "bit.ly/bruceTheBoss"
            );
            Artista artista5 = new Artista(
                    "tripleNelson", "La Triple", "Nelson", "pass202",
                    new Date(1998, 1, 1), "tripleNelson@tuta.io",
                    "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998.",
                    "", // No tiene página web
                    "bit.ly/tripleNelson"
            );
            Artista artista6 = new Artista(
                    "la_ley", "La", "Ley", "pass303",
                    new Date(1987, 2, 14), "la_ley@tuta.io",
                    "", "", // No hay biografía ni sitio web provisto
                    "bit.ly/laLey"
            );
            Artista artista7 = new Artista(
                    "tigerOfWales", "Tom", "Jones", "pass404",
                    new Date(1940, 6, 7), "tigerOfWales@tuta.io",
                    "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.",
                    "www.tomjones.com",
                    "bit.ly/tigerOfWales"
            );
            Artista artista8 = new Artista(
                    "chaiko", "Piotr", "Tchaikovsky", "pass505",
                    new Date(1840, 4, 25), "chaiko@tuta.io",
                    "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo.",
                    "", // No tiene página web
                    "" // No tiene imagen provista
            );
            Artista artista9 = new Artista(
                    "nicoleneu", "Nicole", "Neumann", "pass606",
                    new Date(1980, 10, 31), "nicoleneu@hotmail.com",
                    "", // No hay biografía provista
                    "", // No tiene página web
                    "bit.ly/nicoleneu"
            );
            Artista artista10 = new Artista(
                    "lospimpi", "Pimpinela", "", "pass707",
                    new Date(1981, 8, 13), "lospimpi@gmail.com",
                    "",
                    "www.pimpinela.net",
                    "bit.ly/losPimpinela"
            );
            Artista artista11 = new Artista(
                    "dyangounchained", "Dyango", "", "pass808",
                    new Date(1940, 3, 5), "dyangounchained@gmail.com",
                    "José Gómez Romero, conocido artísticamente como Dyango, es un cantante español de música romántica.",
                    "", // No tiene página web
                    "" // No tiene imagen provista
            );
            Artista artista12 = new Artista(
                    "alcides", "Alcides", "", "pass909",
                    new Date(1952, 7, 17), "alcides@tuta.io",
                    "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano.",
                    "", // No tiene página web
                    "" // No tiene imagen provista
            );

            // Clientes con imágenes
            Cliente cliente1 = new Cliente(
                    "cel_padrino", "Vito", "Corleone", "pass789",
                    "el_padrino@tuta.io", new Date(1972, 3, 8),
                    "bit.ly/vitoCorleone"
            );
            Cliente cliente2 = new Cliente(
                    "scarlettO", "Scarlett", "O’Hara", "pass101",
                    "scarlettO@tuta.io", new Date(1984, 11, 27),
                    "bit.ly/scarlettO"
            );
            Cliente cliente3 = new Cliente(
                    "ppArgento", "Pepe", "Argento", "pass202",
                    "ppArgento@hotmail.com", new Date(1955, 2, 14),
                    "bit.ly/ppArgento"
            );
            Cliente cliente4 = new Cliente(
                    "Heisenberg", "Walter", "White", "pass303",
                    "Heisenberg@tuta.io", new Date(1956, 3, 7),
                    "bit.ly/heisenbergWW"
            );
            Cliente cliente5 = new Cliente(
                    "benKenobi", "Obi-Wan", "Kenobi", "pass404",
                    "benKenobi@gmail.com", new Date(1914, 4, 2),
                    "bit.ly/benKenobi"
            );
            Cliente cliente6 = new Cliente(
                    "lachiqui", "Mirtha", "Legrand", "pass505",
                    "lachiqui@hotmail.com.ar", new Date(1927, 2, 23),
                    "bit.ly/laChiqui"
            );
            Cliente cliente7 = new Cliente(
                    "cbochinche", "Cacho", "Bochinche", "pass606",
                    "cbochinche@vera.com.uy", new Date(1937, 5, 8),
                    "bit.ly/cbochinche"
            );
            Cliente cliente8 = new Cliente(
                    "Eleven11", "Eleven", "", "pass707",
                    "Eleven11@gmail.com", new Date(1971, 12, 31),
                    "bit.ly/11Eleven11"
            );

            // Agregar Artistas
            controlpersis.AddArtista(artista1);
            controlpersis.AddArtista(artista2);
            controlpersis.AddArtista(artista3);
            controlpersis.AddArtista(artista4);
            controlpersis.AddArtista(artista5);
            controlpersis.AddArtista(artista6);
            controlpersis.AddArtista(artista7);
            controlpersis.AddArtista(artista8);
            controlpersis.AddArtista(artista9);
            controlpersis.AddArtista(artista10);
            controlpersis.AddArtista(artista11);
            controlpersis.AddArtista(artista12);

            // Agregar Clientes
            controlpersis.AddCliente(cliente1);
            controlpersis.AddCliente(cliente2);
            controlpersis.AddCliente(cliente3);
            controlpersis.AddCliente(cliente4);
            controlpersis.AddCliente(cliente5);
            controlpersis.AddCliente(cliente6);
            controlpersis.AddCliente(cliente7);
            controlpersis.AddCliente(cliente8);

            System.out.println("Perfiles cargados correctamente con biografías, sitios web e imágenes.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Cargar_Generos() throws Exception {
        CrearGenero("Rock", "");
        CrearGenero("Rock Clásico", "Rock");
        CrearGenero("Rock Latino", "Rock");
        CrearGenero("Rock & Roll", "Rock");
        CrearGenero("Clásica", "");
        CrearGenero("Disco", "");
        CrearGenero("Pop", "");
        CrearGenero("Electropop", "Pop");
        CrearGenero("Dance-pop", "Pop");
        CrearGenero("Pop Clásico", "Pop");
        CrearGenero("Balada", "");
        CrearGenero("Cumbia", "");
    }

    private void Cargar_Albumes() throws Exception {

        Album1();
        //Album2();

    }

    private void Album1() throws Exception {
        try {
            // Crear lista de géneros para el álbum
            List<Genero> generos = new ArrayList<>();
            try {
                generos.add(buscarGeneroPorNombre("Disco"));
                generos.add(buscarGeneroPorNombre("Dance-pop"));
                generos.add(buscarGeneroPorNombre("Pop Clásico"));
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }

            // Crear el álbum
            Album nuevoAlbum = new Album();
            nuevoAlbum.setNombre("Live and Sleazy");
            nuevoAlbum.setImagen("Imagen");
            nuevoAlbum.setAnioCreacion(new SimpleDateFormat("dd/MM/yyyy").parse("12/02/2003"));
            nuevoAlbum.setListaGeneros(generos);
            nuevoAlbum.setArtista(buscarArtistaPorCorreo("vpeople@tuta.io"));

            // Persistir el álbum primero
            controlpersis.crearAlbum(nuevoAlbum);

            // Crear lista de temas para el álbum
            List<Tema> temas = new ArrayList<>();
            temas.add(new Tema("YMCA", 4, 28, "bit.ly/SCvpymca"));
            temas.add(new Tema("Macho Man", 3, 28, ""));
            temas.add(new Tema("In the Navy", 3, 13, "bit.ly/SCvpinthenavy"));

            // Asociar los temas con el álbum
            for (Tema tema : temas) {
                tema.setAlbum(nuevoAlbum);  // Asocia cada tema con el álbum
            }
            nuevoAlbum.setListaTemas(temas);

            // Persistir los temas
            for (Tema tema : temas) {
                controlpersis.crearTema(tema);
            }

            // Actualizar el álbum con la lista de temas
            controlpersis.actualizarAlbum(nuevoAlbum);

        } catch (Exception e) {
            throw new Exception("Error al cargar datos de prueba: " + e.getMessage());
        }
    }

    private void Album2() throws Exception {
        try {
            // Crear lista de géneros para el álbum
            List<Genero> generos = new ArrayList<>();
            try {
                generos.add(buscarGeneroPorNombre("Synth-pop"));
                generos.add(buscarGeneroPorNombre("New Wave"));
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }

            // Crear el álbum
            Album nuevoAlbum = new Album();
            nuevoAlbum.setNombre("Violator");
            nuevoAlbum.setImagen("Imagen_Violator");
            nuevoAlbum.setListaGeneros(generos);
            nuevoAlbum.setArtista(buscarArtistaPorCorreo("dmode@tuta.io"));

            // Persistir el álbum primero
            controlpersis.crearAlbum(nuevoAlbum);

            // Crear lista de temas para el álbum
            List<Tema> temas = new ArrayList<>();
            temas.add(new Tema("World in My Eyes", 4, 26, "Ubicación_WorldInMyEyes"));
            temas.add(new Tema("Personal Jesus", 4, 56, "Ubicación_PersonalJesus"));
            temas.add(new Tema("Enjoy the Silence", 6, 12, "Ubicación_EnjoyTheSilence"));
            temas.add(new Tema("Policy of Truth", 4, 55, "Ubicación_PolicyOfTruth"));

            // Asociar los temas con el álbum
            for (Tema tema : temas) {
                tema.setAlbum(nuevoAlbum);  // Asocia cada tema con el álbum
            }
            nuevoAlbum.setListaTemas(temas);

            // Persistir los temas
            for (Tema tema : temas) {
                controlpersis.crearTema(tema);
            }

            // Actualizar el álbum con la lista de temas
            controlpersis.actualizarAlbum(nuevoAlbum);

        } catch (Exception e) {
            throw new Exception("Error al cargar el álbum 'Violator': " + e.getMessage());
        }
    }

    public List<String> MostrarNombreArtistas() {
        List<Artista> listaArtista = listaArtistas(); // Supongamos que este método devuelve todos los clientes

        List<String> listaCorreos = new ArrayList<>();

        for (Artista artista : listaArtista) {
            listaCorreos.add(artista.getMail()); // Añades el correo de cada cliente a la lista
        }

        return listaCorreos; // Devuelves la lista de correos
    }

    

 

 

   

   

}