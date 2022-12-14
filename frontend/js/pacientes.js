const corpoTabela = document.querySelector(".tabelinha")
const tabelaInicial = () =>{
    const url = `http://localhost:8080/paciente`
    fetch(url)
    .then(response =>response.json())
    .then((teste) =>  
        teste.content.map((test,indice)=> {
            
            const linha = document.createElement('tr')

            const nome  = document.createElement('td')
            const endereco = document.createElement('td')
            const email  = document.createElement('td')
            const genero = document.createElement('td')
            const estado = document.createElement('td')
            const cidade = document.createElement('td')
            const botoes = document.createElement('td')
            const editarA  = document.createElement("a")
            const excluirE = document.createElement("a")
            const botaoEditar = document.createElement('button')
            const botaoExcluir  = document.createElement('button')

            nome.innerHTML = test.nome
            endereco.innerHTML = test.endereco
            email.innerHTML = test.email
            genero.innerHTML = test.genero.nome
            estado.innerHTML = test.estado
            cidade.innerHTML = test.cidade

            botaoEditar.innerHTML = "editar"
            botaoExcluir.innerHTML = "excluir"

            botaoExcluir.setAttribute('onclick', "deletar(" + test.id + ")")
            botaoEditar.setAttribute('onclick','aparecerEditar('+test.id+')')

            editarA.appendChild(botaoEditar)
            excluirE.appendChild(botaoExcluir)

            botoes.appendChild(editarA)
            botoes.appendChild(excluirE)

            linha.appendChild(nome)
            linha.appendChild(endereco)
            linha.appendChild(email)
            linha.appendChild(genero)
            linha.appendChild(estado)
            linha.appendChild(cidade)
            linha.appendChild(botoes)

            corpoTabela.appendChild(linha)

        }))   
}

function deletar(id){
    const url = ` http://localhost:8080/paciente/${id}`;
    fetch(url,
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "DELETE"
            
        }) 
}

function aparecerCadastro(){
    const aparecer = document.querySelector(".login")
    aparecer.style.display = 'flex'
}

function aparecerEditar(id){
    const aparecer = document.querySelector(".login1")
    aparecer.style.display = 'flex'
}


function salvarCadastro(){

    const Inome = document.querySelector("#nomeCadastro")
    const IdataNascimento = document.querySelector("#dataCadastro")
    const Icpf = document.querySelector("#cpfCadastro")
    const Iendereco = document.querySelector("#enderecoCadastro")
    const Igenero = document.querySelector("#generoCadastro")
    const Iestado = document.querySelector("#estadoCadastro")
    const Imunicipio = document.querySelector("#municipioCadastro")
    const Iemail = document.querySelector("#emailCadastro")
    const Itelefone = document.querySelector("#telefoneCadastro")

    const valor = 0
    if(genero.value=="masculino"){
        valor  = 1
    }
    else{
        valor=2
    }
    

    fetch("http://localhost:8080/paciente",
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            dataNascimento: IdataNascimento.value,
            cpf: Icpf.value,
            endereco: Iendereco.value,
            email: Iemail.value,
            cidade: Imunicipio.value,
            stado: Iestado.value,
            telefone: Itelefone.value,
            genero:{
                id:valor
            }
        })
    }) 
}


function salvarEditar(){
    fecharEditar()
}

function fecharEditar(){
    const aparecer = document.querySelector(".login1")
    aparecer.style.display = 'none'
}
function fecharCadastro(){
    const aparecer = document.querySelector(".login")
    aparecer.style.display = 'none'
}


tabelaInicial()



function exibirAlerta() {
    alert("Cadastrado com sucesso!")
}