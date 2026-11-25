'use strict';
const cadastro = document.querySelector('#cadastro');
const busca = document.querySelector('#busca');
const aviso = document.querySelector('#aviso');
const lista = document.querySelector('#lista');
const cancelar = document.querySelector('#cancelar');
const salvar = document.querySelector('#salvar');
let emEdicao = null;
async function api(caminho = '', metodo = 'GET', dados) {
  const resposta = await fetch('/api/alunos' + caminho, {
    method: metodo, headers: dados ? {'Content-Type':'application/json'} : {},
    body: dados ? JSON.stringify(dados) : undefined
  });
  if (!resposta.ok) {
    const erro = await resposta.json().catch(() => ({}));
    const mensagens = {400:'Confira os campos, a data de nascimento e o ID.', 404:'Aluno não encontrado.', 409:'Esta matrícula já existe nesta escola.'};
    throw new Error(mensagens[resposta.status] || erro.detail || 'Falha ao acessar o cadastro.');
  }
  return resposta.status === 204 ? null : resposta.json();
}
async function executar(acao) {
  aviso.textContent = '';
  try { await acao(); } catch (erro) { aviso.textContent = erro.message; }
}
function texto(tipo, valor) {
  const elemento = document.createElement(tipo);
  elemento.textContent = valor;
  return elemento;
}
function novo() {
  emEdicao = null;
  cadastro.reset();
  cancelar.hidden = true;
  document.querySelector('#titulo').textContent = 'Novo aluno';
  salvar.textContent = 'Cadastrar aluno';
}
function apresentar(alunos) {
  lista.replaceChildren();
  if (!alunos.length) lista.append(texto('p', 'Nenhum aluno cadastrado.'));
  for (const {id, dados} of alunos) {
    const item = document.createElement('article');
    const editar = texto('button', 'Editar');
    const excluir = texto('button', 'Excluir');
    editar.onclick = () => executar(async () => {
      const atual = await api('/' + id);
      for (const [campo, valor] of Object.entries(atual.dados)) cadastro.elements[campo].value = valor;
      emEdicao = id;
      cancelar.hidden = false;
      document.querySelector('#titulo').textContent = 'Editar aluno #' + id;
      salvar.textContent = 'Salvar alterações';
      cadastro.elements.nome.focus();
    });
    excluir.onclick = () => executar(async () => {
      if (!confirm('Excluir o cadastro de ' + dados.nome + '?')) return;
      await api('/' + id, 'DELETE');
      if (emEdicao === id) novo();
      await listar();
      aviso.textContent = 'Cadastro excluído.';
    });
    item.append(texto('h3', dados.nome), texto('p', 'ID ' + id + ' · Escola ' + dados.escola + ' · Matrícula ' + dados.matricula),
      texto('p', [dados.serie, 'Turma ' + dados.turma, cadastro.elements.turno.querySelector('[value="' + dados.turno + '"]').text,
        cadastro.elements.status.querySelector('[value="' + dados.status + '"]').text, 'Nascimento ' + dados.nascimento.split('-').reverse().join('/')].join(' · ')), editar, excluir);
    lista.append(item);
  }
}
async function listar() { apresentar(await api()); }
cadastro.onsubmit = evento => {
  evento.preventDefault();
  executar(async () => {
    salvar.disabled = true;
    try {
      const dados = Object.fromEntries(new FormData(cadastro));
      dados.escola = Number(dados.escola);
      const aluno = await api(emEdicao === null ? '' : '/' + emEdicao, emEdicao === null ? 'POST' : 'PUT', dados);
      novo();
      busca.reset();
      await listar();
      aviso.textContent = 'Cadastro salvo. ID do aluno: ' + aluno.id;
    } finally { salvar.disabled = false; }
  });
};
cancelar.onclick = novo;
busca.onsubmit = evento => {
  evento.preventDefault();
  executar(async () => { lista.replaceChildren(); apresentar([await api('/' + busca.elements.id.value)]); });
};
document.querySelector('#todos').onclick = () => executar(async () => { busca.reset(); await listar(); });
executar(listar);
