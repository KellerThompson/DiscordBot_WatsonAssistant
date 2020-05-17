package Consola;

import javax.swing.*;

public class Consola extends JFrame//
{
    private JScrollPane scrollPane;
    private JTextArea jTextArea;
    private JPanel panel1;
    private boolean primerMsg;

    public Consola(int piWidth, int piHeight, String psTitulo)
    {
        this.setSize(piWidth,piHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(psTitulo);
        this.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0,0,piWidth-5,piHeight-27);
        this.panel1.setLayout(null);
        this.add(panel1);

        jTextArea = new JTextArea();
        jTextArea.setEditable(false);

        this.scrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.scrollPane.setBounds(0,0,piWidth-5,piHeight-27);
        this.scrollPane.setVisible(true);
        this.panel1.add(this.scrollPane);

        this.panel1.revalidate();
        this.panel1.repaint();

        primerMsg = false;
    }

    public void addText(String text)
    {
        if(!primerMsg)
        {
            this.jTextArea.setText(text);
            primerMsg = true;
        }
        else
        {
            this.jTextArea.setText(jTextArea.getText() + "\n" + text);
        }
    }
}
