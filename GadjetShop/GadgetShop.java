import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame
{
    private JTextField modelField,priceField,weightField,sizeField;
    private JTextField creditField,memoryField;
    private JTextField phoneField,durationField,downloadField,displayField;

    private ArrayList<Gadget> gadgets;

    public GadgetShop()
    {
        gadgets = new ArrayList<>();

        setTitle("Gadget Shop");
        setSize(750,250);
        setLayout(new GridLayout(5,4));

        add(new JLabel("Model:"));
        modelField = new JTextField();
        add(modelField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Weight:"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Size:"));
        sizeField = new JTextField();
        add(sizeField);

        add(new JLabel("Credit:"));
        creditField = new JTextField();
        add(creditField);

        add(new JLabel("Memory:"));
        memoryField = new JTextField();
        add(memoryField);

        JButton addMobile = new JButton("Add Mobile");
        JButton addMP3 = new JButton("Add MP3");
        add(addMobile);
        add(addMP3);

        JButton clear = new JButton("Clear");
        JButton displayAll = new JButton("Display All");
        add(clear);
        add(displayAll);

        add(new JLabel("Phone No:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Duration:"));
        durationField = new JTextField();
        add(durationField);

        add(new JLabel("Download:"));
        downloadField = new JTextField();
        add(downloadField);

        add(new JLabel("Display Number:"));
        displayField = new JTextField();
        add(displayField);

        JButton makeCall = new JButton("Make A Call");
        JButton downloadMusic = new JButton("Download Music");
        add(makeCall);
        add(downloadMusic);

        // Add Mobile
        addMobile.addActionListener(e->{
            try{
                Mobile m = new Mobile(
                        modelField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(weightField.getText()),
                        sizeField.getText(),
                        Integer.parseInt(creditField.getText())
                );
                gadgets.add(m);
                JOptionPane.showMessageDialog(this,"Mobile Added");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid Mobile Input");
            }
        });

        // Add MP3
        addMP3.addActionListener(e->{
            try{
                MP3 p = new MP3(
                        modelField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(weightField.getText()),
                        sizeField.getText(),
                        Integer.parseInt(memoryField.getText())
                );
                gadgets.add(p);
                JOptionPane.showMessageDialog(this,"MP3 Added");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid MP3 Input");
            }
        });

        // Clear Fields
        clear.addActionListener(e->{
            modelField.setText("");
            priceField.setText("");
            weightField.setText("");
            sizeField.setText("");
            creditField.setText("");
            memoryField.setText("");
            phoneField.setText("");
            durationField.setText("");
            downloadField.setText("");
            displayField.setText("");
        });

        // Display All Gadgets
        displayAll.addActionListener(e->{
            if(gadgets.size()==0){
                JOptionPane.showMessageDialog(this,"No gadgets added yet");
                return;
            }

            JFrame window = new JFrame("All Gadgets");
            JTextArea area = new JTextArea(15,30);

            String output="";
            for(int i=0;i<gadgets.size();i++)
            {
                output += "Gadget " + i + "\n";
                output += gadgets.get(i).display() + "\n\n";
            }

            area.setText(output);
            area.setEditable(false);

            window.add(new JScrollPane(area));
            window.pack();
            window.setVisible(true);
        });

        // Make Call
        makeCall.addActionListener(e->{
            try{
                int index = Integer.parseInt(displayField.getText());
                String number = phoneField.getText();
                int duration = Integer.parseInt(durationField.getText());

                if(!(gadgets.get(index) instanceof Mobile))
                {
                    JOptionPane.showMessageDialog(this,"Selected gadget is not a Mobile");
                    return;
                }

                Mobile m = (Mobile) gadgets.get(index);
                String result = m.makeCall(number,duration);
                JOptionPane.showMessageDialog(this,result);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid Call Input");
            }
        });

        // Download Music
        downloadMusic.addActionListener(e->{
            try{
                int index = Integer.parseInt(displayField.getText());
                int size = Integer.parseInt(downloadField.getText());

                if(!(gadgets.get(index) instanceof MP3))
                {
                    JOptionPane.showMessageDialog(this,"Selected gadget is not an MP3 player");
                    return;
                }

                MP3 p = (MP3) gadgets.get(index);
                String result = p.downloadMusic(size);
                JOptionPane.showMessageDialog(this,result);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid Download Input");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GadgetShop();
    }
}