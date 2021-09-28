// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();
  $('#usuarios').DataTable();
});
//

async function cargarUsuarios(){

  const request = await fetch('usuarios', { // LO QUE HAGO ACA ES LLAMAR AL listado DE LOS CONTROLADORES "UsuarioController" es como un link que genero el controlador
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });


  const usuarios = await request.json(); // de la respuesta del fetch lo convierte en json y lo pone en la variable

  console.log(usuarios);

    let listadoHtml = '';

    for (let usuario of usuarios){

          let usuariosHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></tr>';

          listadoHtml += usuariosHtml;
    }


document.querySelector('#usuarios tbody').outerHTML= listadoHtml;

}