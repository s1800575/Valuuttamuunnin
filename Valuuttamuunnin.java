/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valuuttamuunnin;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
/**
 *
 * @author s1800575
 */
public class Valuuttamuunnin extends JFrame {
    
    private static double Arvo1 = 0.0; 
    //kun ostetaan valuttaa
    private static double Arvo2 = 0.0;
    //kun myydään valuttaa
    
    double Osto = 0.0;
    double Myynti = 0.0;
    
    double Yhteensa1 = 0.0;  // kun ostetaan valuttaa
    double Yhteensa2 = 0.0;  // kun myydään valuttaa
    
  private JPanel paPohja = new JPanel(new GridLayout(2,1)); //uusi
  private JPanel paYla = new JPanel(new FlowLayout(FlowLayout.LEFT));// uusi
  private JPanel paAla = new JPanel(new FlowLayout(FlowLayout.LEFT));//uusi
    // alkuperäinen   private JPanel paPohja = new JPanel(new FlowLayout(FlowLayout.LEFT));
    // uusi paneeli = uusi Windows ikkuna
  
    private JLabel lbOhje1 = new JLabel("Kirjaa summa, jolla haluat ostaa tai myydä valuuttaa."); //tekti OSTAN
    private JLabel lbOhje2 = new JLabel("Valitse valuutta valikosta."); //tekti OSTAN
    
    private JLabel lbOstan = new JLabel("ostan"); //tekti OSTAN
    private JTextField tfArvo1 = new JTextField(5); //Ostettava valuuta määrä ostettavana valuuttana
    private JComboBox cbOsto = new JComboBox(); // ostettavan valuutan tunnus ks. alempaa Comboboxin valikko mitä sinne tehdään
    private JLabel lbMaksan = new JLabel("maksan"); //tekti 
    private JTextField tfYhteensa1 = new JTextField(5); //Montako euroa maksan
    private JLabel lbEuroa = new JLabel("euroa"); //tekti 
    private JButton btTyhjaaOsto = new JButton("TYHJENNÄ");
    
    private JLabel lbMyyn = new JLabel("myyn"); //tekti Myyn
    private JTextField tfArvo2 = new JTextField(5); //Myyntäbän valuuta määrä myytävänä valuuttana
    private JComboBox cbMyynti = new JComboBox(); // Myytävän valuutan tunnus ks. alempaa Comboboxin valikko mitä sinne tehdään
    private JLabel lbMaksan2 = new JLabel("saan       "); //tekti saan
    private JTextField tfYhteensa2 = new JTextField(5); //Montako euroa maksan
    private JLabel lbEuroa2 = new JLabel("euroa"); //tekti 
    private JButton btTyhjaaMyynti = new JButton("TYHJENNÄ");
    private JMenuBar YlaValikko = new JMenuBar();
         
   
   // tehdään konstruktori
   public Valuuttamuunnin(){
       
       this.setTitle("Valuuttamuunnin 2.0 R&H ti 25.9. 10:30");
       this.setSize(490, 200);
       this.setLocation(100, 200);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
               //edelliset 4 määrittää ikkunan koon, sijainnin ja ruksipainikkeen toiminnon
               //seuraavaksi tehdään valikko kahdella teksitllä
               
       this.setJMenuBar(YlaValikko);
            JMenu Tiedosto = new JMenu("Tiedosto");
            JMenu Tietoja = new JMenu("Tietoja ohjelmasta");
               
            YlaValikko.add(Tiedosto);
                    JMenuItem ohjeAction = new JMenuItem("Käyttöohje");
                    Tiedosto.add(ohjeAction);
                    
                                    
                    
                    
                    JMenuItem exitAction = new JMenuItem("Exit");
                    Tiedosto.add(exitAction);
                    exitAction.addActionListener(new ActionListener() { // Listätty tiistaina 
                        public void actionPerformed(ActionEvent e) {  // tehtiin siis Valikon Exit "painikkeesta" actionlistener, j
                            System.exit(0);                             // oka kutsuu oliota Exit, joka suoritta toiminnon Exit
                        }
                    });
                                                                                                        
                YlaValikko.add(Tietoja);
                    JMenuItem newAction = new JMenuItem("Tietoja ohjelmasta");
                    Tietoja.add(newAction);
                                
       asetteleKomponentit();
       }

            
   
   private void asetteleKomponentit() // ei lisätä ;
           
   {
        paYla.add(lbOhje1);
        paYla.add(lbOhje2);
        
        
        paAla.add(lbOstan);
        paAla.add(tfArvo1);
        paAla.add(cbOsto);
        paAla.add(lbMaksan);
        paAla.add(tfYhteensa1);
        paAla.add(lbEuroa);
        paAla.add(btTyhjaaOsto);
        // = osto rivin komponentit
       
        paAla.add(lbMyyn);
        paAla.add(tfArvo2);
        paAla.add(cbMyynti);
        paAla.add(lbMaksan2);
        paAla.add(tfYhteensa2);
        paAla.add(lbEuroa2);
        paAla.add(btTyhjaaMyynti);
        // = myyntirivin komponentit
        
        paPohja.add(paYla);
	paPohja.add(paAla);
                
        cbOsto.addItem("<VALITSE>");
        cbOsto.addItem("USD");
        cbOsto.addItem("YEN");
        cbOsto.addItem("GBP");
        cbOsto.addItem("RUB");
        cbOsto.addItem("EUR");
        // ostorivin vetovalikon valikko muodostuu näistä
        
        cbMyynti.addItem("<VALITSE>");
        cbMyynti.addItem("USD");
        cbMyynti.addItem("YEN");
        cbMyynti.addItem("GBP");
        cbMyynti.addItem("RUB");
        cbMyynti.addItem("EUR");

        
        cbOsto.addActionListener(new AlsOsto());
        cbMyynti.addActionListener(new AlsMyynti());
        btTyhjaaOsto.addActionListener(new AlsTyhjaaOsto());
        btTyhjaaMyynti.addActionListener(new AlsTyhjaaMyynti());
        
        this.add (paPohja);
        
        // lisää kaikki ylläolevat (myyntirivi, ostorivi ja molemmat valikkojen sisällöt pohjaan
        // lisätty kaikki komponentit pohjaan JFrame
        // tehdän Comboboxistat uusi acrion listener AlsOsto
   }   
   
   class AlsOsto implements ActionListener{
   public void actionPerformed(ActionEvent tapahtuma)
   {
       double Yhteensa1 = 0.0;
       double Valinta = cbOsto.getSelectedIndex();
       Arvo1 = Double.parseDouble(tfArvo1.getText());
       double USD = 0.91;
       double YEN = 0.009;
       double GBP = 1.2;
       double RUB = 0.02;
       double EUR = 1.0;
                 
       if (Valinta == 1){
           Yhteensa1 = USD * Arvo1;
       } else if (Valinta == 2){
           Yhteensa1 = YEN * Arvo1;
       } else if (Valinta == 3){
           Yhteensa1 = GBP * Arvo1;
       } else if (Valinta == 4){
           Yhteensa1 = RUB * Arvo1;
       } else {
           Yhteensa1 = EUR * Arvo1;
                       }
        
        int ValiYhteensa1 = (int)(Yhteensa1*100.00);
        double LyhytYhteensa1 = ((double)ValiYhteensa1)/100.00;
        // desimaalit lyhyemmäksi lopputulksesta
    tfYhteensa1.setText(""+LyhytYhteensa1);
    }}
   class AlsTyhjaaOsto implements ActionListener
	 {
	  public void actionPerformed(ActionEvent tapahtuma)
	   {
		 
	    tfArvo1.setText("");
		 tfYhteensa1.setText("");
		 
		 }
	 }
 
   class AlsMyynti implements ActionListener{
    public void actionPerformed(ActionEvent tapahtuma2)
        {
        
       double Yhteensa2 = 0.0;
       double Valinta2 = cbMyynti.getSelectedIndex();
       Arvo2 = Double.parseDouble(tfArvo2.getText());
       double USDo = 0.83;
       double YENo = 0.0071;
       double GBPo = 1.072;
       double RUBo = 0.0115;
       double EURo = 1.0;
           
       
       if (Valinta2 == 1){
           Yhteensa2 = Arvo2 * USDo;
       } else if (Valinta2 == 2){
           Yhteensa2 = Arvo2 * YENo;
       } else if (Valinta2 == 3){
           Yhteensa2 = Arvo2 * GBPo;
       } else if (Valinta2 == 4){
           Yhteensa2 = Arvo2 * RUBo;
       } else {
           Yhteensa2 = Arvo2 * EURo;
                       }
        
        int ValiYhteensa2 = (int)(Yhteensa2*100.00);
        double LyhytYhteensa2 = ((double)ValiYhteensa2)/100.00;
        // desimaalit lyhyemmäksi lopputulksesta
        tfYhteensa2.setText(""+LyhytYhteensa2);
   }
   }
      class AlsTyhjaaMyynti implements ActionListener
	 {
	  public void actionPerformed(ActionEvent tapahtuma)
	   {
		 
	    tfArvo2.setText("");
		 tfYhteensa2.setText("");
		 
		 }
	 }
 
   }
     
   
   
   
   

