import javax.swing.*;

public class Corredor extends Thread {
    private int idCorredor;
    public static int TEMPO_MAXIMO = 0;
    public JProgressBar progressBar;
    private boolean parar = true;

    public Corredor() {
    }

    public Corredor(int idCorredor, int TEMPO_MAXIMO, JProgressBar progressBar) {
        this.idCorredor = idCorredor;
        this.TEMPO_MAXIMO = TEMPO_MAXIMO;
        this.progressBar = progressBar;
    }

    public void setParar(boolean verificacaoParada){
        this.parar = verificacaoParada;
    }

    public void correr(int tempo) {
        try {
            int distancia = (int) (Math.random() * 1000) / Controlador.controlador.distancia;
            progressBar.setValue(distancia + progressBar.getValue());
            if (progressBar.getValue() >= 100) {
                Controlador.controlador.terminarCorrida();
            }
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (parar) {
            correr(TEMPO_MAXIMO);
        }
    }

}
