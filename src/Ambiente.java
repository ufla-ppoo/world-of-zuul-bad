import java.util.HashMap;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
public class Ambiente  {
    // descrição do ambiente
    private String descricao;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;

    /*
     * Retorna o ambiente cuja saída é na direção passada
     * 
     * @param direcao A direção da saída
     */
    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao)  {
        this.descricao = descricao;
        saidas = new HashMap<>();
    }

    /**
     * Define uma saída do ambiente: uma direção leva a outro ambiente.
     *
     * @param direcao A direção da saída
     * @param ambiente O ambiente que a direção leva
     */
    public void ajustarSaida(String direcao, Ambiente ambiente)  {
        if (ambiente != null) {
            saidas.put(direcao, ambiente);
        }
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    /*
     * Retorna uma string com as direções de saída possíveis do ambiente
     */
    public String getTextoSaidas() {
        String texto = "";
        for (String direcao : saidas.keySet()) {
            texto += direcao + " ";
        }
        return texto;
    }

}
