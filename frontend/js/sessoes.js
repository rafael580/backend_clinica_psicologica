const corpoTabela = document.querySelector(".tabelinha")
const tabelaInicial = () =>{
    const url = `http://localhost:8080/paciente`
    fetch(url)
    .then(response =>response.json())
    .then((teste) =>  
        teste.content.map((test,indice)=> {
            const linha = document.createElement('tr')

            const nome  = document.createElement('td')
            const dataAgendamento = document.createElement('td')
            const status  = document.createElement('td')
            const temaAbordado = document.createElement('td')
            const duracao = document.createElement('td')
            const tipoSessao = document.createElement('td')
            const botoes = document.createElement('td')
            const editarA  = document.createElement("a")
            const excluirE = document.createElement("a")
            const botaoEditar = document.createElement('button')
            const botaoExcluir  = document.createElement('button')

            nome.innerHTML = test.nome
            dataAgendamento.innerHTML = test.sessaoSet[0].dataAgendamento
            status.innerHTML = test.sessaoSet[0].status[0].nome
            temaAbordado.innerHTML = test.sessaoSet[0].temaSessao
            duracao.innerHTML = test.sessaoSet[0].duracao
            tipoSessao.innerHTML = test.sessaoSet[0].tipoSessao.nome

            botaoEditar.innerHTML = "editar"
            botaoExcluir.innerHTML = "editar status"

            botaoExcluir.setAttribute('onclick', "aparecerStatus(" + test.id + ")")
            botaoEditar.setAttribute('onclick','aparecerEditar('+test.id+')')

            editarA.appendChild(botaoEditar)
            excluirE.appendChild(botaoExcluir)

            botoes.appendChild(editarA)
            botoes.appendChild(excluirE)

            linha.appendChild(nome)
            linha.appendChild(dataAgendamento)
            linha.appendChild(status)
            linha.appendChild(temaAbordado)
            linha.appendChild(duracao)
            linha.appendChild(tipoSessao)
            linha.appendChild(botoes)

            corpoTabela.appendChild(linha)

        }))   
}
tabelaInicial()


function aparecerCadastro(){
    const aparecer = document.querySelector(".login")
    aparecer.style.display = 'flex'
  
}

function aparecerEditar(id){
    const aparecer = document.querySelector(".login1")
    aparecer.style.display = 'flex'
}

function aparecerStatus(){
    const aparecer = document.querySelector(".modal")
    aparecer.style.display = 'block'
}


function fecharCadastro(){
    const aparecer = document.querySelector(".login")
    aparecer.style.display = 'none'
}
function fecharEditar(){
    const aparecer = document.querySelector(".login1")
    aparecer.style.display = 'none'
}

function fecharStatus(){
    const aparecer = document.querySelector(".modal")
    aparecer.style.display = 'none'
}