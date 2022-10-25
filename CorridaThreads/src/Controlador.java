import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

public class Controlador extends JFrame implements Runnable {
    private JPanel panel1;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JButton GOButton;

    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar5;
    private JProgressBar progressBar6;
    private JProgressBar progressBar7;
    private JProgressBar progressBar8;
    private JProgressBar progressBar9;
    private JProgressBar progressBar10;
    private JProgressBar progressBar11;
    private JProgressBar progressBar12;
    private JProgressBar progressBar13;
    private JProgressBar progressBar14;
    private JProgressBar progressBar15;

    public ArrayList<Corredor> listaCorredores = new ArrayList<>();

    public static Controlador controlador;

    public int distancia;
    public int tempo;

    public Controlador() {
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        slider1.addComponentListener(new ComponentAdapter() {
        });

        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comecarCorrida();
            }
        });
    }

    public void criarCorredores(int qtdCorredores) {
        for (int i = 0; i < slider1.getValue(); i++) {
            Corredor corredor = new Corredor(i, slider2.getValue(), atualizarProgessao(i));
            listaCorredores.add(corredor);
            corredor.start();
        }
    }

    public void comecarCorrida() {
        tempo = slider2.getValue();
        distancia = slider3.getValue();

        criarCorredores(slider1.getValue());
    }

    public JProgressBar atualizarProgessao(Integer i) {
        switch (i) {
            case 0:
                return progressBar1;
            case 1:
                return progressBar2;
            case 2:
                return progressBar3;
            case 3:
                return progressBar4;
            case 4:
                return progressBar5;
            case 5:
                return progressBar6;
            case 6:
                return progressBar7;
            case 7:
                return progressBar8;
            case 8:
                return progressBar9;
            case 9:
                return progressBar10;
            case 10:
                return progressBar11;
            case 11:
                return progressBar12;
            case 12:
                return progressBar13;
            case 13:
                return progressBar14;
            case 14:
                return progressBar15;
        }
        return null;
    }

    public static void main(String[] args) {
        controlador = new Controlador();
    }

    public void terminarCorrida(){
        for (Corredor corredor : listaCorredores) {
            corredor.setParar(false);
        }
        
        System.exit(0);
    }

    @Override
    public void run() { }

}
