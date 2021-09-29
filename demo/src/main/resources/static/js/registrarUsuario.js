// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});
//

async function registrarUsuarios(){

    let datos = {};

    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPass').value;

    let repetirPassword = document.getElementById('txtRepetirPass').value;

    console.log(datos);

    if (repetirPassword != datos.password){
        alert('la contraceña que escribiste es diferente');
        return;
    };

  const request = await fetch('api/usuarios', { // LO QUE HAGO ACA ES LLAMAR AL listado DE LOS CONTROLADORES "UsuarioController" es como un link que genero el controlador
    method: 'POST',// metodo para insertar o crear en la base de datos
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

     body: JSON.stringify(datos) // lo que hago en esta linea es convertir los datos de HTML en un string de JSON
  });


  const usuarios = await request.json(); // de la respuesta del fetch lo convierte en json y lo pone en la variable



}

