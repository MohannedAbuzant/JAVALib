/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booklib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Dr.Abuzant
 */
class BS{
    private String IS;
    private String ti;
    private String auth;
    private int edi;
    private int yr;
    private boolean bw;

    BS(String i, String t, String w, int e, int y, boolean b) {
        setIS(i);
        setTi(t);
        setAuth(w);
        setEdi(e);
        setYr(y);
        setBw(b);
    }
    
   

    /**
     * @return the IS
     */
    public String getIS() {
        return IS;
    }

    /**
     * @param IS the IS to set
     */
    public void setIS(String IS) {
        this.IS = IS;
    }

    /**
     * @return the ti
     */
    public String getTi() {
        return ti;
    }

    /**
     * @param ti the ti to set
     */
    public void setTi(String ti) {
        this.ti = ti;
    }

    /**
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * @return the edi
     */
    public int getEdi() {
        return edi;
    }

    /**
     * @param edi the edi to set
     */
    public void setEdi(int edi) {
        this.edi = edi;
    }

    /**
     * @return the yr
     */
    public int getYr() {
        return yr;
    }

    /**
     * @param yr the yr to set
     */
    public void setYr(int yr) {
        this.yr = yr;
    }

    /**
     * @return the bw
     */
    public boolean isBw() {
        return bw;
    }

    /**
     * @param bw the bw to set
     */
    public void setBw(boolean bw) {
        this.bw = bw;
    }
        
}
class Book{
    private String ISBN;
    private String title;
    private String author;
    private int edition;
    private int year;
    private boolean borrowed;
    private ArrayList<BS>books;
    public Book(){
        books=new ArrayList<BS>();
        setISBN("00000000000");
        setTitle("BOOK TITLE");
        setAuthor("BOOK WRITER");
        setEdition(1);
        setYear(2000);
        setBorrowed(false);

    }
    public  Book(String i,String t,String w,int e,int y,boolean b){
        books=new ArrayList<BS>();
        setISBN(i) ;
        setTitle(t) ;
        setAuthor(w) ;
        setEdition(e);
        setYear(y);
        setBorrowed(b);
        
    }
     public void addInfo(String i,String t,String w,int e,int y,boolean b){
         BS l = new BS(i,t,w,e,y,false);
         books.add(l);
    }
   
    public void setISBN(String i){
        ISBN=i;
    }
    public String getISBN(int i){
        return books.get(i).getIS();
    }

    /**
     * @return the title
     */
    public String getTitle(int i) {
        return books.get(i).getTi();
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor(int i) {
        return books.get(i).getAuth();
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the edition
     */
    public int getEdition(int i) {
        return books.get(i).getEdi();
    }
    

    /**
     * @param edition the edition to set
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * @return the year
     */
    public int getYear(int i) {
        return books.get(i).getYr();
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the borrowed
     */
     
    public boolean isBorrowed(int i) {
        
      return books.get(i).isBw();
    }
   

    /**
     * @param borrowed the borrowed to set
     */
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    public void setBorrowed(boolean borrowed,int i) {
        books.get(i).setBw(borrowed);
    }
    public int getSize(){
        return books.size();
    }
    
}
public class BookLib extends JFrame implements ActionListener,ItemListener{
    private JLabel h1=new JLabel("NEW BOOK");
    private JLabel h2= new JLabel("ISBN");
    private JLabel h3=new JLabel("Title");
    private JLabel h4=new JLabel("Author");
    private JLabel h5=new JLabel("Edition");
    private JLabel h6=new JLabel("Published Year");
    private JLabel h7=new JLabel("Search BY");  
    private JLabel h8=new JLabel("Borrow BOOK");
    private JLabel h9=new JLabel("ISBN");
    private JTextField m1=new JTextField(10);
    private JTextField m2=new JTextField(10);
    private JTextField m3=new JTextField(10);
    private JTextField m4 =new JTextField(10);
    private JTextField m5 =new JTextField(10);    
    private JTextField m6 =new JTextField(10);
    private JTextField m7 = new JTextField(10);
    private JButton b1= new JButton("Insert");
    private JButton b2=new JButton("Clear");
    private JButton b3=new JButton("Find");
    private JButton b4=new JButton("Borrow");
    private JButton b5=new JButton("Return");
    private JButton b6=new JButton("Find");
    private JRadioButton r1= new JRadioButton("ISBN",true);
    private JRadioButton r2= new JRadioButton("Title");
    private JRadioButton r3=new JRadioButton("Author");
    private JRadioButton r4=new JRadioButton("Published Year");
    private ButtonGroup rButton= new ButtonGroup();
    private Book MyBook= new Book();
    private JTextArea l= new JTextArea();
    private JTextArea l1= new JTextArea();

  public BookLib(){
     super("BOOK LIBRARY");
     b6.setEnabled(false);
     b3.setEnabled(false);
     l.setEditable(false);
     l1.setEditable(false);
      setLayout(new GridLayout(4,1));
    b1.setEnabled(false);
    h1.setFont(new Font ("arial",Font.BOLD,20));
    h1.setForeground(Color.RED);
    JPanel north=new JPanel(new BorderLayout(10, 10));
    JPanel center = new JPanel(new BorderLayout(10,10));
    h7.setFont(new Font ("arial",Font.BOLD,20));
    h7.setForeground(Color.RED);
    center.add(h7,BorderLayout.NORTH);
    JPanel radioB= new JPanel();
    radioB.add(r1);
    radioB.add(r2);
    radioB.add(r3);
    radioB.add(r4);
    center.add(radioB,BorderLayout.CENTER);
     JPanel find= new JPanel();
     find.add(b3);
     find.add(m6);
     center.add(find,BorderLayout.SOUTH);
    JPanel one= new JPanel();
    JPanel k= new JPanel(new GridLayout(2,5));
    one.add (b1);
    one.add(b2);
       
     k.add(h2);
     k.add(h3);
     k.add(h4);
     k.add(h5);
     k.add(h6);
     k.add(m1);
     k.add(m2);
     k.add(m3);
     k.add(m4);
     k.add(m5);
    north.add(h1,BorderLayout.NORTH);
    north.add(one,BorderLayout.SOUTH);
    north.add(k,BorderLayout.CENTER);
    add(north);
    add(center);
    JPanel label = new JPanel();
    JPanel o=new JPanel(new GridLayout(2,6));
    o.add(new JLabel(" ISBN                             Title                                       Edition                                                        Author                Year                                           Status"));
    o.add(new JScrollPane(l));
    add(o);
    JPanel south = new JPanel(new BorderLayout());
    JPanel pp= new JPanel();
    JPanel gg= new JPanel(new GridLayout(2,1));
    JPanel ss= new JPanel();
    ss.add(h9);
    ss.add(m7);
    ss.add(b6);
    gg.add(ss);
    gg.add(l1);
    pp.add(b4);
    pp.add(b5);
     h8.setFont(new Font ("arial",Font.BOLD,20));
     h8.setForeground(Color.RED);
    south.add(h8,BorderLayout.NORTH);
    south.add(pp,BorderLayout.SOUTH);
    south.add(gg,BorderLayout.CENTER);
    add(south);
    setSize(900,900);
    setVisible(true);
    

    setDefaultCloseOperation(EXIT_ON_CLOSE);
      m1.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent ke) {
              
               if (m1.getText().isEmpty() ||m2.getText().isEmpty()|| m3.getText().isEmpty()|| m4.getText().isEmpty()
                       || m5.getText().isEmpty()){
                   b1.setEnabled(false );
               }
               else
                   b1.setEnabled(true);
                if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
           }
           
        // compiled code
    });

      m2.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent ke) {
               if (m1.getText().isEmpty() ||m2.getText().isEmpty()|| m3.getText().isEmpty()|| m4.getText().isEmpty()
                       || m5.getText().isEmpty()){
                   b1.setEnabled(false);
               }
               else
                   b1.setEnabled(true);
               
          }
          
});
      m3.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent ke) {
               if (m1.getText().isEmpty() ||m2.getText().isEmpty()|| m3.getText().isEmpty()|| m4.getText().isEmpty()
                       || m5.getText().isEmpty()){
                   b1.setEnabled(false);
               }
               else
                   b1.setEnabled(true);
                if (!((ke.getKeyChar()>='a' && ke.getKeyChar()<='z')||
                       (ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')))
                   ke.consume();
          }
});
      m4.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent ke) {
              
               if (m1.getText().isEmpty() ||m2.getText().isEmpty()|| m3.getText().isEmpty()|| m4.getText().isEmpty()
                       || m5.getText().isEmpty()){
                   b1.setEnabled(false);
               }
               else
                   b1.setEnabled(true);
                if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
          }
});
      m5.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent ke) {
               if (m1.getText().isEmpty() ||m2.getText().isEmpty()|| m3.getText().isEmpty()|| m4.getText().isEmpty()
                       || m5.getText().isEmpty()){
                   b1.setEnabled(false);
               }
               else
                   b1.setEnabled(true);
                if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
                
          }
});
      m6.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent ke) {
               if (m6.getText().isEmpty()){
                   b3.setEnabled(false);
               }
               else
                   b3.setEnabled(true);
               if(r1.isSelected()){
               if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
               }
               if(r2.isSelected()){
                   if (!((ke.getKeyChar()>='a' && ke.getKeyChar()<='z')||
                       (ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')))
                   ke.consume();
               }
               if(r3.isSelected()){
                     if (!((ke.getKeyChar()>='a' && ke.getKeyChar()<='z')||
                       (ke.getKeyChar()>='A' && ke.getKeyChar()<='Z')))
                   ke.consume();
               }
               if(r4.isSelected()){
                   if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
               }
               
          }
});
      m7.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent ke) {
               if (m7.getText().isEmpty()){
                   b6.setEnabled(false);
               }
               else
                   b6.setEnabled(true);
                if (!(ke.getKeyChar()>='0' && ke.getKeyChar()<='9'))
                   ke.consume();
                
          }          
});
    
      b1.addActionListener(this);
      b2.addActionListener(this);
      rButton.add(r1);
      rButton.add(r2);
      rButton.add(r3);
      rButton.add(r4);
      r1.addItemListener(this);
      r2.addItemListener(this);
      r3.addItemListener(this);
      r4.addItemListener(this);
      b4.addActionListener(this);
      b5.setEnabled(false);
      b3.addActionListener(this);
      b5.addActionListener(this);
      b6.addActionListener(this);
      
     
      
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BookLib();
        // TODO code application logic here
         }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
       if(ae.getSource()== b1){
           for(int i=0;i<MyBook.getSize();i++){
        if(MyBook.getISBN(i).compareToIgnoreCase(m1.getText())==0
        ||(MyBook.getAuthor(i).compareToIgnoreCase(m2.getText())==0)){
            JOptionPane.showMessageDialog(null,"This book is already registred in the Library,please Try again with diffrent Book","Notice",INFORMATION_MESSAGE);
           return; 
        }
           } 
          MyBook.addInfo(m1.getText(),m2.getText(),m3.getText(), Integer.parseInt(m4.getText()), Integer.parseInt(m5.getText()),true);
          
       }
      if(ae.getSource()==b2){
          m1.setText("");
          m2.setText("");
          m3.setText("");
          m4.setText("");
          m5.setText("");
          b1.setEnabled(false);
      }
      if(ae.getSource()==b6)
          if(!(m7.getText().isEmpty())){
               for(int i=0;i<MyBook.getSize();i++){ 
               if(m7.getText().equals(MyBook.getISBN(i))){
                   String message= MyBook.isBorrowed(i)?"Not Available":" Available";
                   l1.selectAll();
                   l1.replaceSelection("");
                   l1.append(MyBook.getTitle(i)+"             "+ Integer.toString(MyBook.getEdition(i))+"th             " +MyBook.getAuthor(i)+"             "+Integer.toString(MyBook.getYear(i))+"             "+message+"\n");
                  }
              }
          }
      
      if(ae.getSource()==b4){
           if(!(m7.getText().isEmpty())){
               for(int i=0;i<MyBook.getSize();i++){ 
               if(m7.getText().equals(MyBook.getISBN(i))){
                   MyBook.setBorrowed(true,i);
                 String message= MyBook.isBorrowed(i)?"Not Available":" Available";
                   l1.selectAll();
                   l1.replaceSelection("");
                    l1.append(MyBook.getTitle(i)+"             "+ Integer.toString(MyBook.getEdition(i))+"th             " +MyBook.getAuthor(i)+"             "+Integer.toString(MyBook.getYear(i))+"             "+message+"\n");

                   b4.setEnabled(false);
                   b5.setEnabled(true);
               }
               }    
      }
      }
           if(ae.getSource()==b5){
               for(int i=0;i<MyBook.getSize();i++){
       if(m7.getText().equals(MyBook.getISBN(i))){
           MyBook.setBorrowed(false,i);
                 String message= MyBook.isBorrowed(i)?"Not Available":" Available";
                   l1.selectAll();
                   l1.replaceSelection("");
                    l1.append(MyBook.getTitle(i)+"             "+ Integer.toString(MyBook.getEdition(i))+"th             " +MyBook.getAuthor(i)+"             "+Integer.toString(MyBook.getYear(i))+"             "+message+"\n");

                   b4.setEnabled(true);
                   b5.setEnabled(false);

    }
               }
       }
           if(ae.getSource()== b3){
               if(r1.isSelected()){
                   for(int i=0;i<MyBook.getSize();i++){
                     String message= MyBook.isBorrowed(i)?"Not Available":"Available";

                if(MyBook.getISBN(i).indexOf(m6.getText())!=-1){
                        l.append(MyBook.getISBN(i) +"                               " + MyBook.getTitle(i)+ "                                          " + MyBook.getEdition(i)+"                                                                 " + MyBook.getAuthor(i)+"                       " + MyBook.getYear(i)+"                                             " +message+"\n");
                        
                }
               
                b3.setEnabled(false);
            }
                   
               }
               if(r2.isSelected()){
                               for(int i=0;i<MyBook.getSize();i++){
                     String message= MyBook.isBorrowed(i)?"Not Available":" Available";

                if(MyBook.getTitle(i).indexOf(m6.getText())!=-1){
                        l.append(MyBook.getISBN(i) +"                               " + MyBook.getTitle(i)+ "                                          " + MyBook.getEdition(i)+"                                                                 " + MyBook.getAuthor(i)+"                       " + MyBook.getYear(i)+"                                             " +message+"\n");

               }
                                b3.setEnabled(false);

             }
           }
               if(r3.isSelected()){
                       for(int i=0;i<MyBook.getSize();i++){
                     String message= MyBook.isBorrowed(i)?"Not Available":" Available";

                if(MyBook.getAuthor(i).indexOf(m6.getText())!=-1){
                        l.append(MyBook.getISBN(i) +"                               " + MyBook.getTitle(i)+ "                                          " + MyBook.getEdition(i)+"                                                                 " + MyBook.getAuthor(i)+"                       " + MyBook.getYear(i)+"                                             " +message+"\n");
                        
                }
                                b3.setEnabled(false);

            }
    }
               if(r4.isSelected()){
                    for(int i=0;i<MyBook.getSize();i++){
                         String message= MyBook.isBorrowed(i)?"Not Available":" Available";

                if(m6.getText().equals(Integer.toString(MyBook.getYear(i)))){
                        l.append(MyBook.getISBN(i) +"                               " + MyBook.getTitle(i)+ "                                          " + MyBook.getEdition(i)+"                                                                 " + MyBook.getAuthor(i)+"                       " + MyBook.getYear(i)+"                                             " +message+"\n");
                    }
                                b3.setEnabled(false);

           }
           }
    }
    }
    
   
    @Override
    public void itemStateChanged(ItemEvent ie) {

        if(ie.getSource()== r1){ 
            
             l.selectAll();
             l.replaceSelection("");
             m6.setText("");
             b3.setEnabled(false);
            
        }
        if(ie.getSource()== r2){ 
         
             l.selectAll();
             l.replaceSelection("");
              m6.setText("");
              b3.setEnabled(false);

                }
            
        
        if(ie.getSource()== r3){ 
             l.selectAll();
             l.replaceSelection("");
              m6.setText("");
              b3.setEnabled(false);


        }
        if(ie.getSource()== r4){ 
            l.selectAll();
             l.replaceSelection("");
              m6.setText("");
              b3.setEnabled(false);

           
        }
    }
}
    
