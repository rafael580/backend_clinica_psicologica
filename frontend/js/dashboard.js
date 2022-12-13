const sessoesDoDiaAgendadas = ()=>{

const sessoesAD = document.querySelector(".sessoesAgendadasDia")
const url = `http://localhost:8080/Dashborad/sessoesdia`

fetch(url)
.then(response =>response.json())
.then((teste)=>{
    sessoesAD.innerHTML = 'teste32332'
})

}

sessoesDoDiaAgendadas()