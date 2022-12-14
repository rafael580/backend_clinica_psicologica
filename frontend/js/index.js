function verificar(){

    fetch("http://localhost:8080/usuario/rafael")
    .then(res=> console.log(res.json))
    .then(res=>console.log(res))

}

verificar()