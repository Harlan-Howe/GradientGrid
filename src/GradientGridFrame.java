import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradientGridFrame extends JFrame implements ActionListener
{
    private GradientGridPanel mainPanel;

    private String[] modeNames = {"Mode 0", "Mode 1", "Mode 2"}; // TODO: pick better names than this.
    private JComboBox modePopup;
    private JLabel stateLabel;

    public GradientGridFrame()
    {
        super("Gradient Grid!");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        mainPanel = new GradientGridPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        modePopup = new JComboBox(modeNames);
        getContentPane().add(modePopup, BorderLayout.NORTH);
        modePopup.addActionListener(this);
        stateLabel = new JLabel();
        stateLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(stateLabel,BorderLayout.SOUTH);
        updateStateLabel();
    }

    public void actionPerformed(ActionEvent actEvt)
    {
        if (actEvt.getSource() == modePopup)
        {
            int choice = modePopup.getSelectedIndex();
            mainPanel.setMode(choice);
            updateStateLabel();
        }
    }

    public void updateStateLabel()
    {
        if (mainPanel.confirmGridMeetsSpecifications())
        {
            stateLabel.setText("Meets Specifications.");
            stateLabel.setForeground(new Color(0, 128, 0));
        }
        else
        {
            stateLabel.setText("Does not meet Specifications.");
            stateLabel.setForeground(new Color(192,0,0));
        }
    }
}
