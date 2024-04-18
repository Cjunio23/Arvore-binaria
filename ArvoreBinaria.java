package Item;

public class ArvoreBinaria {

    private static class No {

        Item reg;
        No esq, dir;
    }
    private No raiz;

    public static int comparacoes = 0;

    private Item pesquisa(Item reg, No p) { 
        if (p == null) {//caso alguma posicao for nula, o item não existe
            return null; // 
        } else if (reg.compara(p.reg) < 0) {
            return pesquisa(reg, p.esq);
        } else if (reg.compara(p.reg) > 0) {
            return pesquisa(reg, p.dir);
        } else {
            return p.reg;
        }
    }

    private No insere(Item reg, No p) {//esse metodo serve para inserir algum item na arvore

        if (p == null) {
            p = new No();
            p.reg = reg;
            p.esq = null;
            p.dir = null;
        } else if (reg.compara(p.reg) < 0) {
            p.esq = insere(reg, p.esq);
        } else if (reg.compara(p.reg) > 0) {
            p.dir = insere(reg, p.dir);
        } else {
            System.out.println("Erro: Ja existente");
        }
        return p;
    }

    public void insere(Item reg) {
        this.raiz = this.insere(reg, this.raiz);
    }

    public Item pesquisa(Item reg) {
        return this.pesquisa(reg, this.raiz);
    }

}