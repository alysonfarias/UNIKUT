package sistema;

import java.util.GregorianCalendar;

public class Usuario implements Comparable<Usuario> {

    private String login;
    private String senha;
    private String nome;
    private String[] listaAmigos;
    private String[] listaAmigosPendentes;
    private int qtdListaAmigos;
    private int qtdListaAmigosPendentes;
    private String[][] mensagens;
    private int[] qtdMensagens;
    private int[][] horaMensagens;

    public Usuario(String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.mensagens = new String[100][1000];
        this.qtdMensagens = new int[100];
        this.horaMensagens = new int[100][1000];
    }
    
    public String getMensagem(int amigo, int mensagem) {
        return mensagens[amigo][mensagem];
    }

    public void setMensagens(int amigo, String mensagem) {
        if (this.qtdMensagens[amigo] == 100) {
            System.err.println("Mensagem NÃO enviada, memória cheia!!!");
        } else {
            GregorianCalendar calendar = new GregorianCalendar();
            int hora = calendar.HOUR_OF_DAY;
            this.mensagens[amigo][this.qtdMensagens[amigo]] = mensagem;
            this.qtdMensagens[amigo]++;
            this.horaMensagens[amigo][this.qtdMensagens[amigo]] = hora;
            System.out.println("Mensagem enviada!");
        }
    }
    
    public int getHoraMensagens(int amigo, int mensagem) {
        return horaMensagens[amigo][mensagem];
    }

    public int getQtdMensagens(int pessoa) {
        return qtdMensagens[pessoa];
    }

    public Usuario(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdListaAmigos() {
        return this.qtdListaAmigos;
    }

    public int getQtdListaAmigosPendentes() {
        return this.qtdListaAmigosPendentes;
    }

    public String getListaAmigos(int amigo) {
        return this.listaAmigos[amigo];
    }

    public void setListaAmigos(String login) {
        listaAmigos[qtdListaAmigos] = login;
        qtdListaAmigos++;
        for (int i = 0; i < qtdListaAmigosPendentes; i++) {
            if (listaAmigosPendentes[i].compareTo(login) == 0) {
                for (; i < qtdListaAmigosPendentes; i++) {
                    listaAmigosPendentes[i] = listaAmigosPendentes[i + 1];
                }
                break;
            }
        }
        qtdListaAmigosPendentes--;
    }

    public String getListaAmigosPendentes(int amigo) {
        return this.listaAmigosPendentes[amigo];
    }

    public void setListaAmigosPendentes(String login) {
        listaAmigosPendentes[qtdListaAmigosPendentes] = login;
        qtdListaAmigosPendentes++;
    }

    public void alterarNome(String n) {
        this.nome = n;
    }

    public void alterarSenha(String s) {
        this.senha = s;
    }

    public void alterarNomeSenha(String n, String s) {
        setNome(n);
        setSenha(s);
    }

    @Override
    public String toString() {
        String nome, login, dados;
        nome = "Nome: " + this.getNome() + "\n";
        login = "Login: " + this.getLogin() + "\n";
        dados = nome + login;
        return dados;
    }

    @Override
    public int compareTo(Usuario u) {
        return this.login.compareTo(u.login);
    }

}
