const tabelaInicial = () =>{
    const url = `http://localhost:8080/paciente`
    fetch(url)
    .then(response =>response.json())
    .then((teste) =>  

        teste.content.map((test,indice)=> console.log(indice))
    
    )
    
}
tabelaInicial()