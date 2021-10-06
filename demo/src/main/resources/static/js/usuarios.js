// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();// cuando carga la pagina llama al usuario
  $('#usuarios').DataTable();
});
//

async function cargarUsuarios(){

  const request = await fetch('api/usuarios', { // LO QUE HAGO ACA ES LLAMAR AL listado DE LOS CONTROLADORES "UsuarioController" es como un link que genero el controlador
    method: 'GET', //metodo GET porque solicita
    headers:getHeaders()
  });


  const usuarios = await request.json(); // de la respuesta del fetch lo convierte en json y lo pone en la variable

  console.log(usuarios);

    let listadoHtml = '';



    for (let usuario of usuarios){
          let botonEliminar ='<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

          let usuariosHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+botonEliminar+'</td></tr>';

          listadoHtml += usuariosHtml;
    }


document.querySelector('#usuarios tbody').outerHTML= listadoHtml;

}

function getHeaders(){

return {
                         'Accept': 'application/json',
                         'Content-Type': 'application/json',
                         'Authorization': localStorage.token


                       }
}

async function eliminarUsuario(id){ //esta funcion la voy a meter en onclick en el boton
    if(confirm ('¿Desea eliminar este usuario?')){
         const request = await fetch('api/usuarios/'+id, { // LO QUE HAGO ACA ES LLAMAR AL listado DE LOS CONTROLADORES "UsuarioController" es como un link que genero el controlador
                method: 'DELETE',
                headers: getHeaders()
              });
    }

    location.reload()

};
