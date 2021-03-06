
import java.awt.*;
import java.awt.event.*;

/**
 * Created by FernandoDamian on 02/12/2014.
 */
public class PasswordBox extends Dialog implements ActionListener{

    private TextField mPassfowrdField;

    public PasswordBox() {
        super(new Frame(), "Ingrese la contraseña", true);
        Button b = new Button("Aceptar");
        mPassfowrdField = new TextField(6);
        mPassfowrdField.setEchoChar('*');

        setLayout(new BorderLayout());
        setBackground(Color.white);
        b.addActionListener(this);

        // Add controls to window
        add("North", mPassfowrdField);
        add("South", b);

        setSize(350, 100);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = mPassfowrdField.getText();
        if( password.equals( "abc123" ) )
            setVisible(false);
        else
            new MensajeTxt("Contraseña incorrecta");
    }


}
