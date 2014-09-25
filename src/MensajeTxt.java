import java.awt.*;
import java.awt.event.*;

class MensajeTxt extends Dialog implements ActionListener {

    public MensajeTxt(String texto) {
        super(new Frame(), "Pregunta??????", true);
        Button b = new Button("cerrar");
        setLayout(new BorderLayout());
        setBackground(Color.white);
        b.addActionListener(this);
        add("Center", new Label(texto));
        add("South", b);
        setSize(200, 200);
        show();
    }

    public void actionPerformed(ActionEvent evt) {
        setVisible(false);
    }

}