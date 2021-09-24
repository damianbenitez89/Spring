// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();

  console.log(usuarios);

  let usuariosHtml = '<tr><td>123</td><td>Carlos Damian Benitez</td><td>damianbenitez8928@gmail.com</td><td>1141764794</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></tr>';

document.querySelector('#usuarios tbody').outerHTML= usuariosHtml;

}