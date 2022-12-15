const sessoesDoDiaAgendadas = ()=>{

const sessoesAD = document.querySelector(".sessoesAgendadasDia")
const url = `http://localhost:8080/Dashborad/sessoesdia`

fetch(url)
.then(response =>response.json())
.then((teste)=>{
   sessoesAD.innerHTML = teste
})

}    

const sessoesDoMesAgendadas = ()=>{

    const sessoesAD = document.querySelector(".sessoesAgendadasMes")
    const url = `http://localhost:8080/Dashborad/sessoesmes`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
}    
const sessoesCanceladasMes = ()=>{

    const sessoesAD = document.querySelector(".sessoesCanceladasMes")
    const url = `http://localhost:8080/Dashborad/sessoesmescanceladas`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
} 
const totalSessoes = ()=>{

    const sessoesAD = document.querySelector(".totalsessoes")
    const url = `http://localhost:8080/Dashborad/totalDeSessoes`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
} 
const sessoesIndividual = ()=>{

    const sessoesAD = document.querySelector(".individual")
    const url = `http://localhost:8080/Dashborad/sessoesindividuaistotal`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
} 

const sessoesDupla = ()=>{

    const sessoesAD = document.querySelector(".dupla")
    const url = `http://localhost:8080/Dashborad/sessoesduplatotal`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
} 

const sessoesGrupo = ()=>{

    const sessoesAD = document.querySelector(".grupo")
    const url = `http://localhost:8080/Dashborad/sessoesgrupototal`
    
    fetch(url)
    .then(response =>response.json())
    .then((teste)=>{
       sessoesAD.innerHTML = teste
    })
    
} 
    

sessoesDoDiaAgendadas()
sessoesDoMesAgendadas()
sessoesCanceladasMes()
totalSessoes()

sessoesIndividual()
sessoesDupla()
sessoesGrupo()