import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Juego extends Frame implements MouseListener, ActionListener {
    Panel p1 = new Panel();
    Imagen[] foto = new Imagen[12];
    Imagen im, im2;
    int lose = 0;
    int win = 0;
    TextField maxerr = new TextField("5");
    int err;
    int numero = 0;
    MensajeTxt mensaje;
    Button botonjugar = new Button("Jugar");
    Button botonsalir = new Button("Exit");
    Button botonAyuda = new Button("Ayuda");

    public Juego() {
        foto[0] = new Imagen("img\\uno.jpeg");
        foto[1] = new Imagen("img\\dos.jpeg");
        foto[2] = new Imagen("img\\tres.jpeg");
        foto[3] = new Imagen("img\\cuatro.jpeg");
        foto[4] = new Imagen("img\\cinco.jpeg");
        foto[5] = new Imagen("img\\seis.jpeg");
        foto[6] = new Imagen("img\\uno.jpeg");
        foto[7] = new Imagen("img\\dos.jpeg");
        foto[8] = new Imagen("img\\tres.jpeg");
        foto[9] = new Imagen("img\\cuatro.jpeg");
        foto[10] = new Imagen("img\\cinco.jpeg");
        foto[11] = new Imagen("img\\seis.jpeg");
        botonsalir.addActionListener(this);
        botonjugar.addActionListener(this);
        botonAyuda.addActionListener(this);
        p1.add(botonjugar);
        p1.add(botonsalir);
        p1.add(botonAyuda);
        p1.add(new Label("Max.Errores"));
        p1.add(maxerr);
        err = Integer.parseInt(maxerr.getText());

        Panel centerPanel = new Panel();
        centerPanel.setLayout(new GridLayout(3, 4));
        setBackground(Color.orange);
        for (int i = 0; i < 12; i++) {
            foto[i].addMouseListener(this);
            centerPanel.add(foto[i]);
        }

        setLayout(new BorderLayout());
        add("South", p1);
        add("Center", centerPanel);

    }

    public void iniciar() {
        for (int i = 0; i < 12; i++) {
            foto[i].verReverso();
            foto[i].repaint();
        }
    }

    public void actionPerformed(ActionEvent evt1) {
        if (evt1.getSource() == botonjugar) {
            iniciar();
            err = Integer.parseInt(maxerr.getText());
            System.out.print(err);
            System.out.println("Boton Jugar Presionado");
        } else if(evt1.getSource() == botonsalir ) {
            new MensajeTxt("chao");
            System.out.println("Boton exit Presionado");
            System.exit(0);
        }
        else {
            if (Desktop.isDesktopSupported()) {
                try {
                    File userManualFile = new File("doc\\ManualUsuario.pdf");
                    Desktop.getDesktop().open(userManualFile);
                } catch (IOException ex) {
                    System.out.println("No se puede abrir el manual de ayuda");
                    new MensajeTxt("No se puede abrir el manual de ayuda");
                }
            }
        }

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

        if (e.getSource() instanceof Imagen) {      // Nodo 1

            numero++;                               //
            switch (numero) {                       // Nodo 2

                case 1: {                           //
                    im = (Imagen) e.getSource();    //
                    im.verCara();                   // Nodo 3
                    im.repaint();                   //
                    break;                          //
                }


                case 2: {                           // Nodo 4
                    im2 = (Imagen) e.getSource();   //

                    if (im2.getTapada() == false) { // Nodo 5
                        numero--;                   // Nodo 6
                    }

                    if (im2.getTapada() == true) {  // Nodo 7

                        im2.verCara();              //
                        im2.repaint();              // Nodo 8

                        if (win == 5) {             // Nodo 9
                            win++;                  // Nodo 10
                        }

                        if (win == 6) {             // Nodo 11
                            win = 0;                                // Nodo 12
                            mensaje = new MensajeTxt("You Win");    //
                            mensaje.show();                         //
                            iniciar();                              //
                        }
                    }
                    break;
                }


                case 3: {                           // Nodo 13
                    if (im.getNombre().equals(im2.getNombre())) { // Nodo 14

                        im.verCara();               //
                        im.repaint();               //
                        im2.verCara();              // Nodo 15
                        im2.repaint();              //
                        numero = 0;                 //
                        win++;                      //

                        if (win == 6) {             // Nodo 16

                            win = 0;                // Nodo 17
                        }
                        break;

                    } else {

                        im.verReverso();            //
                        im.repaint();               //
                        im2.verReverso();           // Nodo 18
                        im2.repaint();              //
                        numero = 0;                 //
                        lose++;                     //
                                                    //
                        if (lose == err) {          //

                            lose = 0;                               //
                            mensaje = new MensajeTxt("You Lose");   // Nodo 19
                            mensaje.show();                         //
                            iniciar();                              //
                        }

                        break;

                    }
                }

            }
        }
    }           // Nodo 21

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String args[]) {

        PasswordBox passwordBox = new PasswordBox();

        passwordBox.show();

        Juego window = new Juego();
        window.setTitle("Juego Cartas");
        window.setSize(500, 500);
        window.show();

    }


    public boolean handleEvent(Event evt) {
        switch (evt.id) {
            case Event.WINDOW_DESTROY: {
                System.exit(0);
                return true;
            }
            default:
                return false;
        }
    }
}

