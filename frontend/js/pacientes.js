const corpoTabela = document.querySelector(".corpoTabela")
const bode = document.createElement('tbody')
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
            const cidade = document.createElement('td')
            const municipio = document.createElement('td')

            nome.innerHTML = test.nome
            endereco.innerHTML = test.endereco
            console.log(test.endereco)
            linha.appendChild(nome)
            linha.appendChild(endereco)
            bode.appendChild(linha)
            console.log(corpoTabela)
            corpoTabela.appendChild(linha)

        }))   
}
tabelaInicial()