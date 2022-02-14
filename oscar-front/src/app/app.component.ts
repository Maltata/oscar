import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AppService } from './app.service';
import { Calcado } from './model/CalcadoModel';
import { FiltroBuscaCalcado } from './model/FiltroBuscaCalcadoModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'oscar-front';

  exibeTelaBusca: boolean;
  exibeTelaCadastro: boolean;
  exibeTelaHome = true;

  exibeTabelaBusca: boolean;
  exibeTelaAlteracao: boolean;

  filtroBuscaCalcado = new FiltroBuscaCalcado();

  cadastroCalcado = new Calcado();
  alterarCalcado = new Calcado();

  validaTamanho = true;
  validaCategoria = true;
  validaCor = true;
  validaPreco = true;
  validaMarca = true;
  validaQtd = true;

  calcados: Calcado;

  constructor(
    private appService: AppService,
    private toastr: ToastrService
  ) { }

  telaBusca() {
    this.exibeTelaBusca = true;
    this.exibeTelaCadastro = false;
    this.exibeTelaHome = false;
    this.exibeTelaAlteracao = false;

    this.zeraCadastro();
  }

  telaCadastro() {
    this.exibeTelaCadastro = true;
    this.exibeTelaBusca = false;
    this.exibeTelaHome = false;
    this.exibeTelaAlteracao = false;
  }

  telaHome() {
    this.exibeTelaHome = true;
    this.exibeTelaCadastro = false;
    this.exibeTelaBusca = false;
    this.exibeTelaAlteracao = false;

    this.zeraCadastro();
  }

  adicionarCalcado() {
    if (this.camposValidos()) {
      this.cadastroCalcado.categoriaCalcado = this.cadastroCalcado.categoriaCalcado.toLowerCase();
      this.cadastroCalcado.corCalcado = this.cadastroCalcado.corCalcado.toLowerCase();
      this.cadastroCalcado.marcaCalcado = this.cadastroCalcado.marcaCalcado.toLowerCase();
      this.cadastroCalcado.descricaoCalcado = this.cadastroCalcado.descricaoCalcado.toLowerCase();

      this.appService.cadastraCalcado(this.cadastroCalcado).then(calcadoCad => {
        this.toastr.success('Calçado adicionado com sucesso', 'Sucesso');
        this.zeraCadastro();
      });
    } else {
      this.toastr.warning('Preencha todos os campos Obrigatórios.');
    }

  }

  camposValidos() {
    let retorno = true;

    if (this.cadastroCalcado.tamanhoCalcado == null || this.cadastroCalcado.tamanhoCalcado == '') {
      retorno = false;
      this.validaTamanho = false;
    }
    if (this.cadastroCalcado.categoriaCalcado == null || this.cadastroCalcado.categoriaCalcado == '') {
      retorno = false;
      this.validaCategoria = false;
    }
    if (this.cadastroCalcado.corCalcado == null || this.cadastroCalcado.corCalcado == '') {
      retorno = false;
      this.validaCor = false;
    }
    if (this.cadastroCalcado.precoCalcado == null) {
      retorno = false;
      this.validaPreco = false;
    }
    if (this.cadastroCalcado.marcaCalcado == null || this.cadastroCalcado.marcaCalcado == '') {
      retorno = false;
      this.validaMarca = false;
    }
    if (this.cadastroCalcado.quantidadeEstoqueCalcado == null) {
      retorno = false;
      this.validaQtd = false;
    }

    return retorno;
  }

  zeraCadastro() {
    this.cadastroCalcado.categoriaCalcado = null;
    this.cadastroCalcado.corCalcado = null;
    this.cadastroCalcado.dataCadCalcado = null;
    this.cadastroCalcado.descricaoCalcado = null;
    this.cadastroCalcado.idCalcado = null;
    this.cadastroCalcado.marcaCalcado = null;
    this.cadastroCalcado.precoCalcado = null;
    this.cadastroCalcado.quantidadeEstoqueCalcado = null;
    this.cadastroCalcado.tamanhoCalcado = null;

    this.validaTamanho = true;
    this.validaCategoria = true;
    this.validaCor = true;
    this.validaPreco = true;
    this.validaMarca = true;
    this.validaQtd = true;
  }

  deletarCalcado(idCodigo: number) {
    this.appService.deletaCalcado(idCodigo).then(resposta => {
      this.exibeTabelaBusca = false;
      this.toastr.success('Calçado excluído com sucesso', 'Sucesso');
    });
  }

  editarCalcado(calcadoParaAlteracao: Calcado) {
    this.exibeTelaBusca = false;
    this.exibeTelaAlteracao = true;

    this.alterarCalcado = calcadoParaAlteracao;
  }

  salvarEdicao() {
    this.appService.editaCalcado(this.alterarCalcado.idCalcado, this.alterarCalcado).then(retorno => {
      this.toastr.success('Calçado alterado com sucesso', 'Sucesso');
      this.exibeTelaAlteracao = false;
      this.exibeTelaBusca = true;
    });
  }

  buscarCalcado() {
    if (this.filtroBuscaCalcado.categoria_calcado == '') {
      this.filtroBuscaCalcado.categoria_calcado = null;
    }
    if (this.filtroBuscaCalcado.cor_calcado == '') {
      this.filtroBuscaCalcado.cor_calcado = null;
    }
    if (this.filtroBuscaCalcado.data_cadastro_calcado == '') {
      this.filtroBuscaCalcado.data_cadastro_calcado = null;
    }
    if (this.filtroBuscaCalcado.descricao_calcado == '') {
      this.filtroBuscaCalcado.descricao_calcado = null;
    }
    if (this.filtroBuscaCalcado.marca_calcado == '') {
      this.filtroBuscaCalcado.marca_calcado = null;
    }
    if (this.filtroBuscaCalcado.tamanho_calcado == '') {
      this.filtroBuscaCalcado.tamanho_calcado = null;
    }

    this.appService.buscaComposta(this.filtroBuscaCalcado).then((calcado: Calcado) => {
      console.log(calcado);
      this.calcados = calcado;
      console.log(this.calcados);
      this.exibeTabelaBusca = true;

    }).catch();
  }
}
