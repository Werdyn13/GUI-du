import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWorld extends JFrame{
    private JTextField textField1;
    private JButton predchoziBtn;
    private JButton dalsiBtn;
    private JButton ulozitBtn;
    private JCheckBox koupenoCheckBox;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu souborMenu = new JMenu("Soubor");
    private JMenu akceMenu = new JMenu("Akce");
    private JMenu souhrnMenu = new JMenu("Souhrn");
    private JMenuItem nactiMenuItem = new JMenuItem("Načti");
    private JMenuItem ulozMenuItem = new JMenuItem("Ulož");
    private JMenuItem pridejMenuItem = new JMenuItem("Přidej novou hru");
    private JMenuItem odeberMenuItem = new JMenuItem("Odeber aktuální hru");
    private JMenuItem seradMenuItem = new JMenuItem("Seřaď podle názvu");
    private JMenuItem zobrazMenuItem = new JMenuItem("Zobrazit statistiku");
    private JRadioButton oblibenost1;
    private JRadioButton oblibenost2;
    private JRadioButton oblibenost3;
    private JPanel panelMain;

    ButtonGroup g = new ButtonGroup();
    //private boolean checkboxState = false;
    private int indexAktualniDeskovky = 0;
    EvidenceDeskovek evidenceDeskovek = new EvidenceDeskovek();
    public MyWorld() {
        g.add(oblibenost1);
        g.add(oblibenost2);
        g.add(oblibenost3);
        setContentPane(panelMain);
        predchoziBtn.addActionListener(e -> predchoziNastaveni());
        dalsiBtn.addActionListener(e -> dalsiNastaveni());
        ulozitBtn.addActionListener(e -> ulozitNastaveni());
        //koupenoCheckBox.setSelected(checkboxState);
        zobrazDeskovku();
        pack();

        initMenu();
        pack();
    }

        private void initMenu() {
        nactiMenuItem.addActionListener(e -> provedNacteni());
        ulozitBtn.addActionListener(e -> provedUlozeni());
        souborMenu.add(nactiMenuItem);
        souborMenu.add(ulozMenuItem);
        akceMenu.add(pridejMenuItem);
        akceMenu.add(odeberMenuItem);
        akceMenu.add(seradMenuItem);
        souhrnMenu.add(zobrazMenuItem);
        menuBar.add(souborMenu);
        menuBar.add(akceMenu);
        menuBar.add(souhrnMenu);

        setJMenuBar(menuBar);
        }

        private void provedNacteni() {
        JOptionPane.showMessageDialog(this, "Ahoj!");
        }

        private void provedUlozeni() {

        }

        public void predchoziNastaveni() {
            indexAktualniDeskovky--;
            zobrazDeskovku();
        }

        public void dalsiNastaveni() {
            indexAktualniDeskovky++;
            zobrazDeskovku();
        }

        public void ulozitNastaveni() {
            //checkboxState = koupenoCheckBox.isSelected();
            for (int i = 0; i < 1; i++) {
                JOptionPane.showMessageDialog(this, "Údaje jsou uloženy!");
            }
        }

    public void zobrazDeskovku(){
        if (indexAktualniDeskovky == 0) {
            predchoziBtn.setEnabled(false);
        }
        else
        {predchoziBtn.setEnabled(true);}

        if (indexAktualniDeskovky == evidenceDeskovek.getPocetDeskovek() - 1) {
            dalsiBtn.setEnabled(false);
        }
        else
        {dalsiBtn.setEnabled(true);}

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
