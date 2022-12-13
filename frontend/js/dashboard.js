function sessoesDoDiaAgendadas(){

const sessoesAD = document.querySelector(".sessoesAgendadasDia")
const url = `http://localhost:8080/Dashborad/sessoesdia`

fetch(url)
.then((retorno)=>{
    console.log(retorno)
})
}
function sessoesDoMesAgendadas(){

    const sessoesAD = document.querySelector(".sessoesAgendadasMes")
    const url = `http://localhost:8080/Dashborad/sessoesmes`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })
}  
function sessoesDoMesCanceladas(){

    const sessoesAD = document.querySelector(".sessoesCanceladasMes")
    const url = `http://localhost:8080/Dashborad/sessoesmescanceladas`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })
}
function totalSessoesAll(){

    const sessoesAD = document.querySelector(".totalsessoes")
    const url = `http://localhost:8080/Dashborad/totalDeSessoes`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })
}

function sessoesIndividual(){

    const sessoesAD = document.querySelector(".individual")
    const url = `http://localhost:8080/Dashborad/sessoesindividuaistotal`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })
}

function sessoesDupla(){

    const sessoesAD = document.querySelector(".dupla")
    const url = `http://localhost:8080/Dashborad/sessoesduplatotal`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })


    
}

function sessoesGrupo(){

    const sessoesAD = document.querySelector(".grupo")
    const url = `http://localhost:8080/Dashborad/sessoesduplatotal`
    
    fetch(url)
    .then((retorno)=>{
        console.log(retorno)
    })
    
}
  

sessoesDoDiaAgendadas()
sessoesDoMesAgendadas()
sessoesDoMesCanceladas()
totalSessoesAll()

sessoesIndividual()
sessoesDupla()
sessoesGrupo()