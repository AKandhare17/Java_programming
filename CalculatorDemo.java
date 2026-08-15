import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class Calculator implements ActionListener
{
    JFrame fobj;
    JLabel numlabel1,numlabel2,result;
    JTextField jt1,jt2;
    JButton addb,subb,mulb,divb;


    public Calculator(String title,int Height,int Width)
    {
        fobj = new JFrame(title);
        fobj.getContentPane().setBackground(Color.GRAY);
        fobj.setLayout(null);
        fobj.setSize(Width,Height);
        numlabel1 = new JLabel("Number 1:");
        fobj.add(numlabel1);
        numlabel1.setBounds(50,50,100,30);
        jt1 = new JTextField();
        fobj.add(jt1);
        jt1.setBounds(150,50,120,30);
        numlabel2 = new JLabel("Number 2:");
        fobj.add(numlabel2);
        numlabel2.setBounds(50,100,100,30);
          jt2 = new JTextField();
        fobj.add(jt2);
        jt2.setBounds(150,100,120,30);
        addb = new JButton("ADD");
        fobj.add(addb);
        addb.addActionListener(this);
        addb.setBounds(20,150,100,30);
        subb = new JButton("SUB");
         fobj.add(subb);
        subb.addActionListener(this);
        subb.setBounds(130,150,100,30);
        mulb = new JButton("MUL");
         fobj.add(mulb);
        mulb.addActionListener(this);
        mulb.setBounds(240,150,100,30);
        divb = new JButton("DIV");
         fobj.add(divb);
        result = new JLabel("");
        fobj.add(result);
        result.setBounds(240,200,150,30);

        divb.addActionListener(this);
        divb.setBounds(350,150,100,30);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    public void actionPerformed(ActionEvent aobj)
    {
        int Num1 = Integer.parseInt(jt1.getText());
        int Num2 = Integer.parseInt(jt2.getText());
        
        if(aobj.getSource()==addb)
        {
            
            result.setText("Result=Addition:"+(Num1+Num2));
        }
        else if(aobj.getSource()==subb)
        {
             
            result.setText("Result=Substraction:"+(Num1-Num2));
        }
       else if(aobj.getSource()==mulb)
        {
             
            result.setText("Result=Multiplication:"+(Num1*Num2));
        }
        else if(aobj.getSource()==divb)
        {
             
             result.setText("Result=Division:"+(Num1/Num2));
        }



    }
}
public class CalculatorDemo
{
    public static void main(String sargs[])
    {
        Calculator cobj = new Calculator("Demo Calculator:",300,600);

    }
    
}
