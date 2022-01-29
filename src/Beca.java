import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Beca extends JFrame implements ActionListener, ItemListener, ChangeListener{
    JLabel et,nombre_et, promedio_et, direccion_et, semestre_et, regular_et, equipos_et;
    JTextField nombre, promedio;
    JTextArea direccion, mensaje;
    JComboBox semestre_lista;
    JButton enviar;
    String semestre_elegido, equipos;
    Float prom;
    JRadioButton regular, no_regular;
    ButtonGroup bg;
    JCheckBox laptop, tablet, calculadora;
    Boolean status;
    
    Beca(){
    setLayout(null);
    setTitle("Formulario para alumnos");
    setBounds(300,300,600,600);
    //Indicación
    et = new JLabel("Completa la siguiente información");
    et.setBounds(20,15,350,30);
    add(et);
    //Nombre
    nombre_et = new JLabel("Nombre completo:");
    nombre_et.setBounds(20,50,200,30);
    add(nombre_et);
    nombre = new JTextField();
    nombre.setBounds(150,50,200,30);
    add(nombre);
    //Promedio
    promedio_et = new JLabel("Promedio general:");
    promedio_et.setBounds(20,90,200,30);
    add(promedio_et);
    promedio = new JTextField();
    promedio.setBounds(150,90,50,30);
    add(promedio);
    //Dirección
     direccion_et = new JLabel("Escribe tu dirección:");
    direccion_et.setBounds(20,140,200,30);
    add(direccion_et);
    direccion = new JTextArea();
    direccion.setBounds(20,180,200,50);
    add(direccion);
    //Semestre
    semestre_et = new JLabel("Selecciona el semestre:");
    semestre_et.setBounds(20,250,200,30);
    add(semestre_et);
    semestre_lista = new JComboBox();
    semestre_lista.setBounds(20,290,200,30);
     semestre_lista.addItem("");
    semestre_lista.addItem("Primer semestre");
    semestre_lista.addItem("Segundo semestre");
    semestre_lista.addItem("Tercer semestre");
    semestre_lista.addItemListener(this);
    add(semestre_lista);
    //Botón
    enviar = new JButton("Enviar información");
    enviar.setBounds(230,350,150,40);
    enviar.addActionListener(this);
    add(enviar);
    //Mensaje final
    mensaje = new JTextArea();
    mensaje.setBounds(110,430,380,100);
    add(mensaje);
    //RadioButtons
    regular_et = new JLabel("¿Eres alumno regular?");
    regular_et.setBounds(260,140,200,20);
    add(regular_et);
    regular = new JRadioButton("Sí");
    regular.setBounds(280,170,50,20);
    regular.addChangeListener(this);
    add(regular);
    no_regular = new JRadioButton("No");
    no_regular.setBounds(330,170,50,20);
    no_regular.addChangeListener(this);
    add(no_regular);
    bg = new ButtonGroup();
    bg.add(regular);
    bg.add(no_regular);
    //Casillas de verificación
    equipos_et = new JLabel("¿Cuáles de los siguientes equipos NO cuentas?");
    equipos_et.setBounds(260,210,330,30);
    add(equipos_et);
    laptop = new JCheckBox("Laptop");
    laptop.setBounds(260,240,80,20);
    laptop.addChangeListener(this);
    add(laptop);
    tablet = new JCheckBox("Tablet");
    tablet.setBounds(340,240,80,20);
    tablet.addChangeListener(this);
    add(tablet);
    calculadora = new JCheckBox("Calculadora");
    calculadora.setBounds(420,240,110,20);
    calculadora.addChangeListener(this);
    add(calculadora);
    

    
      
    
    }
    
    public static void main(String[] args) {
        Beca marco = new Beca();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prom = Float.parseFloat(promedio.getText());
       if(prom>8 && semestre_elegido.equals("Tercer semestre")&&status==true){
           mensaje.setText("El alumno "+nombre.getText()+" obtuvo la \nbeca,la cual se enviará a la dirección:\n"+direccion.getText()+"\n"+equipos);
       }else{
          mensaje.setText("El alumno"+nombre.getText()+"\nno obtuvo la beca");
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      semestre_elegido = (String)semestre_lista.getSelectedItem();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       if(regular.isSelected()) status = true;
       else status = false;
       
     equipos = "También recibirá los sig. equipos: ";
    if(laptop.isSelected()) equipos+="laptop/";
    if(tablet.isSelected()) equipos+="tablet/";
    if(calculadora.isSelected()) equipos+="calculadora";
       
    }

    
}
