import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorUI extends JFrame implements ActionListener {

    JLabel displayLabel;
    public CalculatorUI() {
        //Sets JFrame Title
        super("Calculator");

        //Create container with a GridBagLayout for Buttons and Label to go in to.
        //A GridBagLayout is potentially the most complicated layout manager to use, but it will allow us to
        //create a calculator that can be dynamically resized, that actually looks like a calculator
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setAlignmentX(CENTER_ALIGNMENT);
        //setContentPane is called by the constructor to create the GUI
        //here we simply tell it to generate the things we put into the panel
        setContentPane(panel);

        //Make display window for calculator
        displayLabel = new JLabel("");
        var displayLabelConstraints = new GridBagConstraints(1, 0, 4, 1, 1, .5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        displayLabel.setText(" ");
        displayLabel.setOpaque(true);
        displayLabel.setBackground(new Color(210,210,220));
        displayLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        displayLabel.setFont((new Font("Sans-Serif", Font.PLAIN, 25)));
        /*Constraints are where things get a little convoluted, but I will explain what it all means in case IntelliJ doesn't give you the nice labels explaining the arguments
        the first argument is what component (Label or Button for our uses) we are putting in the panel, second is how it goes in the panel
        in this case we are putting an empty label in that we will write to, to display the current values being typed in or calculated
        GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady)
        gridx,gridy - specify where in the grid this component will sit. Grid operates as a two dimensional array with the top left
        value being 0, and increasing in value as you move down and to the right
        gridwidth,gridheight - specify the number of columns or rows the component displays in. in this case, the label stretches across
        three columns and only takes up one row, the 0th row
        ***NOTE: that to put a component (Label or Button) next to another component with a value of more than one, you need to add its gridx,gridy
        ***value to it, to get the next grid value able to be placed. In this instance, if we wanted to place something next to the label we
        ***would use a gridx value of 3, since the label takes up columns 0-2 on the 0th row of the panel
        weightx,weighty - specifies weight used to determine how to distribute space among columns and rows when resizing. The easiest thing
        to do is simply set every value to 1 so as to have all components receive an equal amount of space during resizing
        anchor - used when component is smaller than its display area to determine where to place it. .Center is the default and I have yet to
        make an application that doesn't use Center as the anchor
        fill - used when components display area is larger than its requested size. .Both makes the component resize to fit width and height
        instead of just one or the other
        insets(top, bottom, left, right) - specifies external padding of the component, I set it at 20 for almost every component to give them a
        tiny bit of a buffer between it and the next component (also with an inset of 20 for a combined padding of 40 between components)
        ipadx,ipady - specifies internal padding, how much to add to the size of the component. Default is 0, setting it to 1 gives
        each component an extra 2 pixels in internal size on each side, func to determine size (of the component's width) is
        gridwidth + (ipadx * 2)
        */

        //add the label to the panel with it's constraints
        panel.add(displayLabel, displayLabelConstraints);


        /*Let's add a button
        Buttons are fun because they need to implement a feature called ActionListener, which listens for the button to be pressed to then
        perform a block of code */

        //Make 0 Button and its constraints and add it to the panel
        JButton button0 = new JButton("0");
        var button0constraints = new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button0.setBorder(BorderFactory.createRaisedBevelBorder());
        button0.setBackground(new Color(210,225,240));
        button0.setRolloverEnabled(true);
        button0.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        panel.add(button0, button0constraints);
        /* ***NOTE we add the zero button under the display, in row 1, column 0, and it will only take up a single row and column
         ***HOWEVER since at this point we have a grid that is 3 columns wide and 2 rows deep, and the fill method is set to BOTH
         ***the button will fill the lower portion of the screen entirely. This will be fixed by adding new components around it. */
        button0.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                button0.setBackground(new Color(200,215,230));
            }
        });
        button0.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                button0.setBackground(new Color(210,225,240));
            }
        });
        /*Create the listener using lambda notation to execute the code block when the button is pressed
        I have literally no idea how lambda notation works, it just yells at me when I do it the old way and automatically puts this
        code in there instead, so I guess read the documentation or copy/paste the .addActionListener() bit every time
         Lambda notation is available as of JDK12 so this shouldn't pose a problem for us since we use JDK16 */
        button0.addActionListener(e -> {
            //This is dummy code that will be replaced later, but this is how we write to the labels
            //similarly, to get the displayLabel's current text the function is displayLabel.getText() which returns a String
            displayLabel.setText(displayLabel.getText()+"0");
        });

        //I'm going to create one more button without a bunch of paragraph comments so y'all can see a more concise declaration
        //Make 1 button
        JButton button1 = new JButton("1");
        var button1constraints = new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
        button1.setBackground(new Color(210,225,240));
        button1.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        button1.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                button1.setBackground(new Color(200,215,230));
            }
        });
        button1.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                button1.setBackground(new Color(210,225,240));
            }
        });
        button1.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"1");
        });
        panel.add(button1, button1constraints);

        //Make 2 Button
        JButton button2 = new JButton("2");
        var button2constraints = new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button2.setBorder(BorderFactory.createRaisedBevelBorder());
        button2.setBackground(new Color(210,225,240));
        button2.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        button2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                button2.setBackground(new Color(200,215,230));
            }
        });
        button2.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                button2.setBackground(new Color(210,225,240));
            }
        });
        button2.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"2");
        });
        panel.add(button2, button2constraints);

        //Make 3 button
        JButton button3 = new JButton("3");
        var button3constraints = new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button3.setBorder(BorderFactory.createRaisedBevelBorder());
        button3.setBackground(new Color(210,225,240));
        button3.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        button3.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                button3.setBackground(new Color(200,215,230));
            }
        });
        button3.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                button3.setBackground(new Color(210,225,240));
            }
        });
        button3.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"3");
        });
        panel.add(button3, button3constraints);

        //Make Addition button
        JButton buttonAdd = new JButton("+");
        var buttonAddconstraints = new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonAdd.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonAdd.setBackground(new Color(160,160,200));
        buttonAdd.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        buttonAdd.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonAdd.setBackground(new Color(150,150,190));
            }
        });
        buttonAdd.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonAdd.setBackground(new Color(160,160,200));
            }
        });
        buttonAdd.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"+");
        });
        panel.add(buttonAdd, buttonAddconstraints);

        //Make subtraction button
        JButton buttonSub = new JButton("-");
        var buttonSubconstraints = new GridBagConstraints(4, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonSub.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonSub.setBackground(new Color(160,160,200));
        buttonSub.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        buttonSub.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonSub.setBackground(new Color(150,150,190));
            }
        });
        buttonSub.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonSub.setBackground(new Color(160,160,200));
            }
        });
        buttonSub.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"-");
        });
        panel.add(buttonSub, buttonSubconstraints);

        //Make Multiplication button
        JButton buttonMult = new JButton("x");
        var buttonMultconstraints = new GridBagConstraints(3, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonMult.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonMult.setBackground(new Color(160,160,200));
        buttonMult.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        buttonMult.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonMult.setBackground(new Color(150,150,190));
            }
        });
        buttonMult.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonMult.setBackground(new Color(160,160,200));
            }
        });
        buttonMult.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"x");
        });
        panel.add(buttonMult, buttonMultconstraints);

        //Make division button
        JButton buttonDiv = new JButton("/");
        var buttonDivconstraints = new GridBagConstraints(4, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonDiv.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonDiv.setBackground(new Color(160,160,200));
        buttonDiv.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        buttonDiv.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonDiv.setBackground(new Color(150,150,190));
            }
        });
        buttonDiv.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonDiv.setBackground(new Color(160,160,200));
            }
        });
        buttonDiv.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"/");
        });
        panel.add(buttonDiv, buttonDivconstraints);

        //Make equal button
        JButton buttonEqual = new JButton("=");
        var buttonEqualconstraints = new GridBagConstraints(1, 3, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonEqual.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonEqual.setFont((new Font("Sans-Serif", Font.BOLD, 40)));
        buttonEqual.setBackground(new Color(90,250,90));
        buttonEqual.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonEqual.setBackground(new Color(75,235,75));
            }
        });
        buttonEqual.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonEqual.setBackground(new Color(90,250,90));
            }
        });
        buttonEqual.addActionListener(e -> {
            displayLabel.setText(displayLabel.getText()+"=");
        });
        panel.add(buttonEqual, buttonEqualconstraints);

        //Make clear button
        JButton buttonClear = new JButton("Clear");
        var buttonClearconstraints = new GridBagConstraints(3, 3, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        buttonClear.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonClear.setFont((new Font("Sans-Serif", Font.BOLD, 20)));
        buttonClear.setBackground(new Color(255,90,90));
        buttonClear.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent M){
                buttonClear.setBackground(new Color(245,80,80));
            }
        });
        buttonClear.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent M){
                buttonClear.setBackground(new Color(255,90,90));
            }
        });
        buttonClear.addActionListener(e -> {
            displayLabel.setText(" ");
        });
        panel.add(buttonClear, buttonClearconstraints);
        //Voila now you can type binary numbers

        //Closing thoughts, final window creation
        setPreferredSize(new Dimension(400, 600));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
