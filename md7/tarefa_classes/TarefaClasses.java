/**
 * Classe que representa um computador.
 */
public class Computador {
  
  private String marca;
  private String modelo;
  private int anoFabricacao;
  private double preco;
  private boolean ligado;
  
  /**
   * Construtor da classe Computador.
   * 
   * @param marca A marca do computador.
   * @param modelo O modelo do computador.
   * @param anoFabricacao O ano de fabricação do computador.
   * @param preco O preço do computador.
   */
  public Computador(String marca, String modelo, int anoFabricacao, double preco) {
    this.marca = marca;
    this.modelo = modelo;
    this.anoFabricacao = anoFabricacao;
    this.preco = preco;
    this.ligado = false;
  }
  
  /**
   * Método que retorna a marca do computador.
   * 
   * @return A marca do computador.
   */
  public String getMarca() {
    return marca;
  }
  
  /**
   * Método que altera a marca do computador.
   * 
   * @param marca A nova marca do computador.
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  /**
   * Método que retorna o modelo do computador.
   * 
   * @return O modelo do computador.
   */
  public String getModelo() {
    return modelo;
  }
  
  /**
   * Método que altera o modelo do computador.
   * 
   * @param modelo O novo modelo do computador.
   */
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }
  
  /**
   * Método que retorna o ano de fabricação do computador.
   * 
   * @return O ano de fabricação do computador.
   */
  public int getAnoFabricacao() {
    return anoFabricacao;
  }
  
  /**
   * Método que altera o ano de fabricação do computador.
   * 
   * @param anoFabricacao O novo ano de fabricação do computador.
   */
  public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
  }
  
  /**
   * Método que retorna o preço do computador.
   * 
   * @return O preço do computador.
   */
  public double getPreco() {
    return preco;
  }
  
  /**
   * Método que altera o preço do computador.
   * 
   * @param preco O novo preço do computador.
   */
  public void setPreco(double preco) {
    this.preco = preco;
  }
  
  /**
   * Método que retorna se o computador está ligado ou não.
   * 
   * @return true se o computador está ligado, false caso contrário.
   */
  public boolean isLigado() {
    return ligado;
  }
  
  /**
   * Método que liga o computador.
   */
  public void ligar() {
    if (ligado) {
      System.out.println("O computador já está ligado!");
    } else {
      System.out.println("Ligando o computador...");
      ligado = true;
    }
  }
  
    /**
   * Método que desliga o computador.
   */
  public void desligar() {
    if (!ligado) {
      System.out.println("O computador já está desligado!");
    } else {
      System.out.println("Desligando o computador...");
      ligado = false;
    }
  }
}

