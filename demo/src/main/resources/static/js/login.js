// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});
//

async function iniciarSesion(){

    let datos = {};

    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPass').value;

  const request = await fetch('api/login', { // LO QUE HAGO ACA ES LLAMAR AL listado DE LOS CONTROLADORES "UsuarioController" es como un link que genero el controlador
    method: 'POST',// metodo para insertar o crear en la base de datos
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

     body: JSON.stringify(datos) // lo que hago en esta linea es convertir los datos de HTML en un string de JSON
  });


  const respuesta = await request.text();

  if(respuesta == "OK"){

  window.location.href = 'usuarios.html';
  }
  else{
  alert('las credenciales son incorrectas');
  };




}

