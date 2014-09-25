import java.awt.*;
import java.awt.event.*;

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
        p1.add(botonjugar);
        p1.add(botonsalir);
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
        } else {
            new MensajeTxt("chao");
            System.out.println("Boton exit Presionado");
            System.exit(0);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

        if (e.getSource() instanceof Imagen) {

            numero++;
            switch (numero) {
                case 1: {
                    im = (Imagen) e.getSource();
                    im.verCara();
                    im.repaint();
                    break;
                }


                case 2: {
                    im2 = (Imagen) e.getSource();
                    if (im2.getTapada() == false) {
                        numero--;
                    }
                    if (im2.getTapada() == true) {
                        im2.verCara();
                        im2.repaint();
                        if (win == 5) {
                            win++;
                        }
                        if (win == 6) {
                            win = 0;
                            mensaje = new MensajeTxt("You Win");
                            mensaje.show();
                            iniciar();
                        }
                    }
                    break;
                }


                case 3: {
                    if (im.getNombre().equals(im2.getNombre())) {
                        im.verCara();
                        im.repaint();
                        im2.verCara();
                        im2.repaint();
                        numero = 0;
                        win++;
                        if (win == 6) {
                            win = 0;
                        }
                        break;
                    } else {
                        im.verReverso();
                        im.repaint();
                        im2.verReverso();
                        im2.repaint();
                        numero = 0;
                        lose++;
                        if (lose == err) {
                            lose = 0;
                            mensaje = new MensajeTxt("You Lose");
                            mensaje.show();
                            iniciar();
                        }
                        break;

                    }
                }

            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String args[]) {
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

