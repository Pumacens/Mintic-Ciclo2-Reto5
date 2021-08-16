package view;

import controller.ControladorRequerimientos;

import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;


import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    private static JFrame frame = new JFrame("Mi primera GUI");
    private static JButton button1 = new JButton("Requisito 1 - Por Estrato");
    private static JButton button2 = new JButton("Requisito 2 - Por Tipo");
    private static JButton button3 = new JButton("Requisito 3 - Por Apartaestudios");
    private static JTextArea area = new JTextArea(10, 10);

    public static void requerimiento1(){
        area.setText(null);

        //System.out.println("*** Proyectos por Estrato ***");
        area.append("*** Proyectos por Estrato ***\n");

        try{

            ArrayList<Requerimiento1> rankingProyectosPorEstratos = controlador.consultarRequerimiento_1();

            for (Requerimiento1 proyectosPorEstrato : rankingProyectosPorEstratos){
/*                System.out.printf("El proyecto de ID_Tipo %d de codigo: %d de Area Maxima %d, tiene un estrato %d \n",
                    proyectosPorEstrato.getIdTipo(),
                    proyectosPorEstrato.getCodigoTipo(),
                    proyectosPorEstrato.getAreaMaxima(),
                    proyectosPorEstrato.getEstrato()
                );*/

                area.append(String.format("El proyecto de ID_Tipo %d de codigo: %d de Area Maxima %d, tiene un estrato %d \n",
                        proyectosPorEstrato.getIdTipo(),
                        proyectosPorEstrato.getCodigoTipo(),
                        proyectosPorEstrato.getAreaMaxima(),
                        proyectosPorEstrato.getEstrato()
                ));
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){
        area.setText(null);
        //System.out.println("*** Proyectos por Tipo ***");
        area.append("*** Proyectos por Tipo ***\n");

        try{
            // su codigo
            ArrayList<Requerimiento2> rankingProyectosPorTipo = controlador.consultarRequerimiento_2();

            for (Requerimiento2 proyectosPorTipo : rankingProyectosPorTipo){
/*                System.out.printf("El proyecto de ID_Proyecto %d de la constructora: %s de la ciudad %s, tiene un estrato asignado de %d \n",
                        proyectosPorTipo.getIdProyecto(),
                        proyectosPorTipo.getConstructora(),
                        proyectosPorTipo.getCiudad(),
                        proyectosPorTipo.getEstrato()
                );*/

                area.append(String.format("El proyecto de ID_Proyecto %d de la constructora: %s de la ciudad %s, tiene un estrato asignado de %d \n",
                        proyectosPorTipo.getIdProyecto(),
                        proyectosPorTipo.getConstructora(),
                        proyectosPorTipo.getCiudad(),
                        proyectosPorTipo.getEstrato()
                ));
            }

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        area.setText(null);
        //System.out.println("*** Proyectos de Tipo Apartaestudio en Quibdo ***");
        area.append("*** Proyectos de Tipo Apartaestudio en Quibdo ***\n");

        try{
            // su codigo
            ArrayList<Requerimiento3> rankingProyectosQuibdoApartaestudio = controlador.consultarRequerimiento_3();

            for (Requerimiento3 proyectosQuibdoApartaestudio : rankingProyectosQuibdoApartaestudio){
/*                System.out.printf("El proyecto de ID_Proyecto %d de la constructora: %s tiene un porcentaje de cuota inicial de %.1f, y %s tiene acabados \n",
                        proyectosQuibdoApartaestudio.getIdProyecto(),
                        proyectosQuibdoApartaestudio.getConstructora(),
                        proyectosQuibdoApartaestudio.getPorcentajeCuotaInicial(),
                        proyectosQuibdoApartaestudio.getAcabados()
                );*/

                area.append(String.format("El proyecto de ID_Proyecto %d de la constructora: %s tiene un porcentaje de cuota inicial de %.1f, y %s tiene acabados \n",
                        proyectosQuibdoApartaestudio.getIdProyecto(),
                        proyectosQuibdoApartaestudio.getConstructora(),
                        proyectosQuibdoApartaestudio.getPorcentajeCuotaInicial(),
                        proyectosQuibdoApartaestudio.getAcabados()
                ));
            }
        
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void main(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 330);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        JLabel titulo = new JLabel("Grupo 82 | Reto 5   -   Java GUI   -   Daniel Florez");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont (titulo.getFont().deriveFont(24.0f));

        frame.getContentPane().add(titulo);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));

        p.add(button1, BorderLayout.NORTH);
        p.add(button2, BorderLayout.NORTH);
        p.add(button3, BorderLayout.NORTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });

        frame.getContentPane().add(p);

        area.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        frame.add(Box.createRigidArea(new Dimension(0, 10)));

        JScrollPane scroll = new JScrollPane (area,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scroll);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}
