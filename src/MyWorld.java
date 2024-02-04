import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWorld extends JFrame{
    private JTextField textField1;
    private JButton predchoziBtn;
    private JButton dalsiBtn;
    private JButton ulozitBtn;
    private JCheckBox koupenoCheckBox;
    private JRadioButton oblibenost1;
    private JRadioButton oblibenost2;
    private JRadioButton oblibenost3;
    private JPanel panelMain;

    ButtonGroup g = new ButtonGroup();
    private int indexAktualniDeskovky = 0;
    EvidenceDeskovek evidenceDeskovek = new EvidenceDeskovek();
    public MyWorld() {
        g.add(oblibenost1);
        g.add(oblibenost2);
        g.add(oblibenost3);
        setContentPane(panelMain);
        predchoziBtn.addActionListener(e -> predchoziNastaveni());
        dalsiBtn.addActionListener(e -> dalsiNastaveni());
        zobrazDeskovku();
        pack();

    }

        public void predchoziNastaveni() {
            indexAktualniDeskovky--;
            zobrazDeskovku();
        }

        public void dalsiNastaveni() {
            indexAktualniDeskovky++;
            zobrazDeskovku();
        }

    public void zobrazDeskovku(){
        Deskovka aktualniDeskovka = evidenceDeskovek.vratDeskovku(indexAktualniDeskovky);
        textField1.setText(aktualniDeskovka.getNazevDeskovky());
        koupenoCheckBox.setSelected(aktualniDeskovka.isKoupeno());
        if (aktualniDeskovka.getOblibenost() == 1){
            oblibenost1.setSelected(true);
        }
        else if (aktualniDeskovka.getOblibenost() == 2){
            oblibenost2.setSelected(true);
        }
        else if (aktualniDeskovka.getOblibenost() == 3){
            oblibenost3.setSelected(true);
        }
    }
}
